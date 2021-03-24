package com.codependent.sample.repository

import com.codependent.sample.domain.Project
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ProjectRepository : ReactiveCrudRepository<Project, String>
