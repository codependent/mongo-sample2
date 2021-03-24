package com.codependent.sample.mongodb

import org.springframework.core.convert.converter.Converter
import java.time.OffsetDateTime
import java.util.*

/**
 * @author José A. Íñigo
 */
class OffsetDateTimeWriteConverter : Converter<OffsetDateTime, Date> {
    override fun convert(offsetDateTime: OffsetDateTime): Date? {
        return Date.from(offsetDateTime.toInstant())
    }

}
