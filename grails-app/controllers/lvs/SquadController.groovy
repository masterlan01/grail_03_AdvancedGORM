package lvs

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SquadController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Squad.list(params), model: [squadCount: Squad.count()]
    }

    def show(Squad squad) {
        respond squad
    }

    def create() {
        respond new Squad(params)
    }

    @Transactional
    def save(Squad squad) {
        if (squad == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (squad.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond squad.errors, view: 'create'
            return
        }

        squad.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'squad.label', default: 'Squad'), squad.id])
                redirect squad
            }
            '*' { respond squad, [status: CREATED] }
        }
    }

    def edit(Squad squad) {
        respond squad
    }

    @Transactional
    def update(Squad squad) {
        if (squad == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (squad.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond squad.errors, view: 'edit'
            return
        }

        squad.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'squad.label', default: 'Squad'), squad.id])
                redirect squad
            }
            '*' { respond squad, [status: OK] }
        }
    }

    @Transactional
    def delete(Squad squad) {

        if (squad == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        squad.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'squad.label', default: 'Squad'), squad.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'squad.label', default: 'Squad'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
