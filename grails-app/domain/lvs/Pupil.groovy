package lvs

import java.sql.Timestamp

class Pupil {

    String  firstName
    String  lastName
    Squad group
    Date    dateCreated
    Date    lastUpdate
    Timestamp version

    static constraints = {
        firstName   blank: false, nullable: false, unique: ['firstName','lastName']
        lastName    blank: false, nullable: false
        group       blank: false, nullable: false
    }
}
