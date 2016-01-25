package lvs

import java.sql.Timestamp

class Teacher {

    String  firstName
    String  lastName
    Date    dateCreated
    Date    lastUpdate
    Timestamp version

    static constraints = {
        firstName   blank: false, nullable: false, unique: ['firstName','lastName']
        lastName    blank: false, nullable: false
    }
}
