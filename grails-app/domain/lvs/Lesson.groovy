package lvs

import java.sql.Timestamp

class Lesson {

    String  science
    Date    day
    Integer itemByDay
    Teacher teacher
    Squad group
    Classroom classroom
    Date    dateCreated
    Date    lastUpdate
    Timestamp version

    static constraints = {
        science     blank: false, nullable: false, unique: ['day','itemByDay','classroom']
        day         blank: false, nullable: false
        itemByDay   blank: false, nullable: false
        teacher     blank: false, nullable: false
        group       blank: false, nullable: false
        classroom   blank: false, nullable: false
    }
}
