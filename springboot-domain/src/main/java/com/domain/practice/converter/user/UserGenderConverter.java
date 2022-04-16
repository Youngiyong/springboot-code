package com.domain.practice.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserGenderConverter implements AttributeConverter<EUserGenderFlag, String> {

    @Override
    public String convertToDatabaseColumn(EUserGenderFlag attribute) {
        return attribute.getCode();
    }

    @Override
    public EUserGenderFlag convertToEntityAttribute(String dbData) {
        return EUserGenderFlag.ofCode(dbData);
    }
}
