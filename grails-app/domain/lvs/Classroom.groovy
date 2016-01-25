package lvs

import java.sql.Timestamp

class Classroom {

    String  name
    Date    dateCreated
    Date    lastUpdate
    Timestamp version

    static constraints = {
        name    blank: false, nullable: false, unique: true
    }
}
