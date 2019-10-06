package corp.evil


import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    val list = listOf<Course>(
        Course(0, "info", 2),
        Course(1, "anglais", 1),
        Course(2, "musique", 0),
        Course(3, "maths", 9001)
    )
    val server = embeddedServer(Netty, 8080) {
        routing {
            getRoot()
            getTopCourses(list)
            getCourse(list)
        }
    }
    server.start(wait = true)
}



