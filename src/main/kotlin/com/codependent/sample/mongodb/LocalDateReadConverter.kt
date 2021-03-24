package com.codependent.sample.mongodb

import org.springframework.core.convert.converter.Converter
import java.time.LocalDate

/**
 * @author José A. Íñigo
 */
class LocalDateReadConverter : Converter<String, LocalDate> {
    override fun convert(date: String): LocalDate {
        return LocalDate.parse(date)
    }
}
