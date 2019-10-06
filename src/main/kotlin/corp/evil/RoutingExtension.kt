package corp.evil

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get


fun Routing.getRoot() {
    get("/") {
        call.respondText("Welcome", ContentType.Text.Plain)
    }
}

fun Routing.getTopCourses(listCourse: List<Course>) {
    get("/courses/top") {
        call.respondText(listCourse
            .filter { course -> course.id < 3 }
            .joinToString("\n")
                , ContentType.Text.Plain)
    }
}

fun Routing.getCourse(listCourse: List<Course>) {
    get("/courses/{id}") {
        val id = call.parameters["id"]?.toInt() ?: -1
        if (id == -1) {
            call.respond(HttpStatusCode.BadRequest)
        }
        val course = listCourse.find { course -> course.id == id }

        call.respondText(course.toString(), ContentType.Text.Plain)
    }
}
