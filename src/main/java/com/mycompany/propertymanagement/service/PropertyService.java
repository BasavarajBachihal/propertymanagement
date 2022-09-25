package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDto;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface PropertyService {
     PropertyDto saveProperty(PropertyDto propertyDto);
    List<PropertyDto> getAllProperty();
    PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId);
    PropertyDto updatePropertyDescription(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId);
    PropertyDto updatePropertyPrice(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId);
    void  deleteProperty(@PathVariable Long propertyId);
}
