import lvs.Classroom
import lvs.Lesson
import lvs.Pupil
import lvs.Squad
import lvs.Teacher

class BootStrap {

    def init = { servletContext ->

        Squad a,b,c
        Classroom r,g
        Teacher j,f,m

        if (!Classroom.count()) {
            r=new Classroom(name: "Red room").save(failOnError: true)
            g=new Classroom(name: "Green room").save(failOnError: true)
        }

        if (!Teacher.count()) {
            j=new Teacher(firstName: "Jo", lastName: "Ra").save(failOnError: true)
            f=new Teacher(firstName: "Fe", lastName: "Da").save(failOnError: true)
            m=new Teacher(firstName: "Ma", lastName: "Sa").save(failOnError: true)
        }

        if (!Squad.count()) {
            a=new Squad(name: "1-A").save(failOnError: true)
            b=new Squad(name: "5-B").save(failOnError: true)
            c=new Squad(name: "10-C").save(failOnError: true)
        }

        if (!Pupil.count()) {
            new Pupil(firstName: "Lu", lastName: "Ci", squad: a).save(failOnError: true)
            new Pupil(firstName: "Mi", lastName: "Hu", squad: a).save(failOnError: true)
            new Pupil(firstName: "Li", lastName: "Fu", squad: b).save(failOnError: true)
            new Pupil(firstName: "Do", lastName: "Ra", squad: b).save(failOnError: true)
            new Pupil(firstName: "Vo", lastName: "Va", squad: c).save(failOnError: true)
            new Pupil(firstName: "Pe", lastName: "Ta", squad: c).save(failOnError: true)
            new Pupil(firstName: "Fi", lastName: "Ma", squad: c).save(failOnError: true)
        }

        if (!Lesson.count()) {
            new Lesson(science: "music", classroom: r, squad: a, day: new Date().parse("yyyy.MM.dd",'2016.01.10'), itemByDay: 1, teacher: j).save(failOnError: true)
            new Lesson(science: "work", classroom: r, squad: a, day: new Date().parse("yyyy.MM.dd",'2016.01.10'), itemByDay: 2, teacher: f).save(failOnError: true)
            new Lesson(science: "show", classroom: r, squad: b, day: new Date().parse("yyyy.MM.dd",'2016.01.10'), itemByDay: 3, teacher: m).save(failOnError: true)
            new Lesson(science: "art", classroom: g, squad: b, day: new Date().parse("yyyy.MM.dd",'2016.01.11'), itemByDay: 1, teacher: j).save(failOnError: true)
            new Lesson(science: "jazz", classroom: g, squad: c, day: new Date().parse("yyyy.MM.dd",'2016.01.11'), itemByDay: 2, teacher: f).save(failOnError: true)
            new Lesson(science: "draw", classroom: g, squad: c, day: new Date().parse("yyyy.MM.dd",'2016.01.11'), itemByDay: 3, teacher: m).save(failOnError: true)

        }


    }
    def destroy = {
    }
}
