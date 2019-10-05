package corp.evil

class Student {

    private lateinit var name: String

    fun init(name: String) {
        this.name = name

        println("Your name is $name")
    }
}