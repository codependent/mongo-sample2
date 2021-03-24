package com.codependent.sample.domain

import com.fasterxml.jackson.annotation.JsonTypeName
import org.springframework.data.annotation.TypeAlias
import java.time.OffsetDateTime
import javax.money.MonetaryAmount

@JsonTypeName("projectProjectBudget")
@TypeAlias("projectProjectBudget")
class ProjectProjectBudget(val budgetHistory : MutableList<BudgetRegistry> = mutableListOf() ) : ProjectBudget() {

    override fun getCurrentBudget(): MonetaryAmount? {
        return budgetHistory.map { it.amount }.reduceOrNull { acc, monetaryAmount -> acc.add(monetaryAmount) }
    }

}


data class BudgetRegistry(var dateTime: OffsetDateTime, var amount: MonetaryAmount)
