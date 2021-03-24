package com.codependent.sample

import com.codependent.sample.domain.*
import com.codependent.sample.repository.ProjectRepository
import org.javamoney.moneta.Money
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.time.LocalDate
import java.time.OffsetDateTime


//@Component
class CommandLineAppStartupRunner(private val projectRepository: ProjectRepository) : CommandLineRunner {

    override fun run(vararg args: String) {
        Flux.zip(
            projectRepository.save(Project(null, ProjectProjectBudget(mutableListOf(BudgetRegistry(OffsetDateTime.now(), Money.of(100, "EUR")))))),
            projectRepository.save(Project(null, ServiceProjectBudget(mutableListOf(BudgetPeriod(LocalDate.now(), LocalDate.now(), Money.of(100, "EUR"))))))
        ).flatMap { p ->
            projectRepository.findAll()
                .doOnNext { println(it) }
        }.subscribe()
    }
}
