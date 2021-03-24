package com.codependent.sample.mongodb

import org.springframework.core.convert.converter.Converter
import java.time.LocalDate

/**
 * @author José A. Íñigo
 */
class LocalDateWriteConverter : Converter<LocalDate, String> {
    override fun convert(localDate: LocalDate): String {
        return localDate.toString()
    }

}
