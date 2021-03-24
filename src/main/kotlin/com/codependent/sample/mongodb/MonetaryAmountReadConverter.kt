package com.codependent.sample.mongodb

import org.javamoney.moneta.Money
import org.slf4j.LoggerFactory
import org.springframework.core.convert.converter.Converter
import java.math.BigDecimal
import javax.money.Monetary
import javax.money.MonetaryAmount

/**
 * @author José A. Íñigo
 */
class MonetaryAmountReadConverter : Converter<String, MonetaryAmount> {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun convert(mongoMoney: String): MonetaryAmount? {
        logger.trace("MonetaryAmountReadConverter.convert({})", mongoMoney)
        val split = mongoMoney.split("#")
        val result = Money.of(BigDecimal(split[0]), Monetary.getCurrency(split[1]))
        logger.trace("MonetaryAmountReadConverter.convert({}) - Finished")
        return result
    }
}
