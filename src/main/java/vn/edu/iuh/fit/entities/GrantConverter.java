package vn.edu.iuh.fit.entities;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class GrantConverter implements AttributeConverter<Grant,Boolean> {
    @Override
    public Boolean convertToDatabaseColumn(Grant attribute) {
        if(attribute.equals(Grant.enable))
            return true;
        return false;
    }

    @Override
    public Grant convertToEntityAttribute(Boolean dbData) {
        if(dbData==true)
            return Grant.enable;
        return Grant.diasable;
    }
}
