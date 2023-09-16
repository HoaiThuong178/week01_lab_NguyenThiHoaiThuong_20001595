package vn.edu.iuh.fit.entities;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<Status, Short> {
    @Override
    public Short convertToDatabaseColumn(Status attribute) {
        if (attribute.equals(Status.active))
            return 1;
        if (attribute.equals(Status.deactive))
            return 0;
        return -1;

    }

    @Override
    public Status convertToEntityAttribute(Short dbData) {
        if(dbData==1)
            return Status.active;
        if(dbData==0)
            return Status.deactive;
        return Status.delete;
    }
}
