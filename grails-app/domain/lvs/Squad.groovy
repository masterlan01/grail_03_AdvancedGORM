package lvs

import java.sql.Timestamp

class Squad {

    String  name
    Date    dateCreated
    Date    lastUpdated
    Timestamp version

    static hasMany = [pupils: Pupil]

    static constraints = {
        name    blank: false, nullable: false, unique: true
    }

    @Override
    public String toString() {
        return name
    }
}
