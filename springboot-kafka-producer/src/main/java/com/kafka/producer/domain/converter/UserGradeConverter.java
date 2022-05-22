package com.kafka.producer.domain.converter;

import com.kafka.producer.domain.enums.EUserGradeFlag;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserGradeConverter implements AttributeConverter<EUserGradeFlag, String> {

    @Override
    public String convertToDatabaseColumn(EUserGradeFlag attribute) {
        return attribute.getCode();
    }

    @Override
    public EUserGradeFlag convertToEntityAttribute(String dbData) {
        return EUserGradeFlag.ofCode(dbData);
    }
}
