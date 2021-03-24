package com.codependent.sample.domain

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@Document("projects")
@TypeAlias("project")
data class Project(
    @Id val id: String? = null,
    val budget: ProjectBudget
)
