package com.codependent.sample.mongodb

import org.springframework.core.convert.converter.Converter
import java.math.BigDecimal
import javax.money.MonetaryAmount


/**
 * @author José A. Íñigo
 */
class MonetaryAmountWriteConverter : Converter<MonetaryAmount, String> {
    override fun convert(monetaryAmount: MonetaryAmount): String {
        return "${monetaryAmount.number.numberValue(BigDecimal::class.java)}#${monetaryAmount.currency.currencyCode}"
    }
}
