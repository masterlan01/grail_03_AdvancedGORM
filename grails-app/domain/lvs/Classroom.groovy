package lvs

import java.sql.Timestamp

class Classroom {

    String  name
    Date    dateCreated
    Date    lastUpdated
    Timestamp version

    static constraints = {
        name    blank: false, nullable: false, unique: true
    }
    @Override
    public String toString() {
        return name
    }
}
