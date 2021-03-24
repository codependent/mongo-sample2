package com.codependent.sample.domain

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import javax.money.MonetaryAmount

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes(value = [
    JsonSubTypes.Type(value = ProjectProjectBudget::class),
    JsonSubTypes.Type(value = ServiceProjectBudget::class)
])
abstract class ProjectBudget {

    abstract fun getCurrentBudget(): MonetaryAmount?

}

