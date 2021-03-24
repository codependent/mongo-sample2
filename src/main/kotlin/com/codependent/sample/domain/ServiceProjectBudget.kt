package com.codependent.sample.domain

import com.fasterxml.jackson.annotation.JsonTypeName
import org.springframework.data.annotation.TypeAlias
import java.time.LocalDate
import javax.money.MonetaryAmount

@JsonTypeName("serviceProjectBudget")
@TypeAlias("serviceProjectBudget")
class ServiceProjectBudget(val budgetPeriods: MutableList<BudgetPeriod> = mutableListOf()) : ProjectBudget() {

    override fun getCurrentBudget(): MonetaryAmount? {
        return budgetPeriods.firstOrNull {
            val now = LocalDate.now()
            now in it.periodStartDate..it.periodEndDate
        }?.amount
    }

}

data class BudgetPeriod(var periodStartDate: LocalDate, var periodEndDate: LocalDate, var amount: MonetaryAmount) {

    fun isOverlayPeriod(periodStartDate: LocalDate, periodEndDate: LocalDate) =
        (this.periodStartDate in periodStartDate..periodEndDate || this.periodEndDate in periodStartDate..periodEndDate) ||
                (periodStartDate in this.periodStartDate..this.periodEndDate) || (periodEndDate in this.periodStartDate..this.periodEndDate)

}
