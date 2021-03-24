package com.codependent.sample.mongodb

import org.springframework.core.convert.converter.Converter
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*

/**
 * @author José A. Íñigo
 */
class OffsetDateTimeReadConverter : Converter<Date, OffsetDateTime> {
    override fun convert(date: Date): OffsetDateTime {
        return date.toInstant().atOffset(ZoneOffset.UTC)
    }
}
