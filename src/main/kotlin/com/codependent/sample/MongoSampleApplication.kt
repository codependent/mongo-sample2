package com.codependent.sample

import com.codependent.sample.repository.ProjectRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class MongoSampleApplication(private val projectRepository: ProjectRepository) {

    @GetMapping
    fun get() = projectRepository.findAll()

}

fun main(args: Array<String>) {
    runApplication<MongoSampleApplication>(*args)
}
