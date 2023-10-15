package net.javaguides.springbootrestapi1.controller

import net.javaguides.springbootrestapi1.bean.Student
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("students")
class StudentController {


    @GetMapping("student")
    fun getStudent(): ResponseEntity<Student> {

        val student = Student(
                1,
                "Ramesh",
                "Fadatare"
        )

        return ResponseEntity.ok().header("custom-header","ramesh")
                .body(student)
    }

    @GetMapping
    fun getStudents(): ResponseEntity<List<Student>> {
        val student = Student(
                1,
                "Ramesh",
                "Fadatare"
        )

        return ResponseEntity.ok(
                listOf(
                        student,
                        student,
                        student,
                        student,
                        student
                )
        )
    }

    @GetMapping("{id}/{firstName}/{lastName}")
    fun studentPathVariable(@PathVariable id: Int,
                            @PathVariable firstName: String,
                            @PathVariable lastName: String): Student {
        return Student(id, firstName, lastName)
    }

    @GetMapping("query")
    fun studentRequestVariable(@RequestParam id: Int,
                               @RequestParam firstName: String,
                               @RequestParam lastName: String): ResponseEntity<Student> {
        return ResponseEntity.ok(Student(id, firstName, lastName))
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    fun createStudent(@RequestBody student: Student): ResponseEntity<Student> {
        return ResponseEntity<Student>(student, HttpStatus.CREATED)
    }

    @PutMapping("{studentId}/update")
    fun updateStudent(@RequestBody student: Student, @PathVariable studentId: Int): ResponseEntity<Student> {
        return ResponseEntity.ok(student)
    }

    @DeleteMapping("{studentId}/delete")
    fun deleteStudent(@PathVariable studentId: Int): ResponseEntity<String> {
        return ResponseEntity.ok("Student deleted successfully!")
    }

}