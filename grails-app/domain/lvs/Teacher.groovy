package lvs

import java.sql.Timestamp

class Teacher {

    String  firstName
    String  lastName
    Date    dateCreated
    Date    lastUpdated
    Timestamp version

    static constraints = {
        firstName   blank: false, nullable: false, unique: ['firstName','lastName']
        lastName    blank: false, nullable: false
    }

    @Override
    public String toString() {
        return firstName + " " + lastName
    }
}
