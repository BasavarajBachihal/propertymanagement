package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDto;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity convertDtoToEntity(PropertyDto propertyDto){
        PropertyEntity pe = new PropertyEntity();
        pe.setAddress(propertyDto.getAddress());
        pe.setOwnerEmail(propertyDto.getOwnerEmail());
        pe.setOwnerName(propertyDto.getOwnerName());
        pe.setDescription(propertyDto.getDescription());
        pe.setPrice(propertyDto.getPrice());
        pe.setTitle(propertyDto.getTitle());
        return pe;
    }
    public PropertyDto convertEntityToDto(PropertyEntity propertyEntity){
        PropertyDto pd = new PropertyDto();
        pd.setId(propertyEntity.getId());
        pd.setAddress(propertyEntity.getAddress());
        pd.setOwnerEmail(propertyEntity.getOwnerEmail());
        pd.setOwnerName(propertyEntity.getOwnerName());
        pd.setDescription(propertyEntity.getDescription());
        pd.setPrice(propertyEntity.getPrice());
        pd.setTitle(propertyEntity.getTitle());
        return pd;

    }

}
