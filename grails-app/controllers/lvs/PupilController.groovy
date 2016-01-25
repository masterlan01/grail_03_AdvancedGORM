package lvs

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PupilController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pupil.list(params), model: [pupilCount: Pupil.count()]
    }

    def show(Pupil pupil) {
        respond pupil
    }

    def create() {
        respond new Pupil(params)
    }

    @Transactional
    def save(Pupil pupil) {
        if (pupil == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pupil.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pupil.errors, view: 'create'
            return
        }

        pupil.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pupil.label', default: 'Pupil'), pupil.id])
                redirect pupil
            }
            '*' { respond pupil, [status: CREATED] }
        }
    }

    def edit(Pupil pupil) {
        respond pupil
    }

    @Transactional
    def update(Pupil pupil) {
        if (pupil == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pupil.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pupil.errors, view: 'edit'
            return
        }

        pupil.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pupil.label', default: 'Pupil'), pupil.id])
                redirect pupil
            }
            '*' { respond pupil, [status: OK] }
        }
    }

    @Transactional
    def delete(Pupil pupil) {

        if (pupil == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        pupil.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pupil.label', default: 'Pupil'), pupil.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pupil.label', default: 'Pupil'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
