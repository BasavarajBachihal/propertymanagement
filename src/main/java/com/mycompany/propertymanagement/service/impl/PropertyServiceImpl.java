package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDto;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDto saveProperty(PropertyDto propertyDto) {
       PropertyEntity pe=propertyConverter.convertDtoToEntity(propertyDto);
        propertyRepository.save(pe);


        PropertyDto dto =propertyConverter.convertEntityToDto(pe);

        return dto;






    }

    @Override
    public List<PropertyDto> getAllProperty() {
        List<PropertyEntity> pe=(List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDto> listofprop= new ArrayList<>();
        for(PropertyEntity pd : pe) {
            PropertyDto dto = propertyConverter.convertEntityToDto(pd);
            listofprop.add(dto);
        }
        return listofprop;
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> opt =propertyRepository.findById(propertyId);
        PropertyDto dto=null;
        if(opt.isPresent()) {
            PropertyEntity pe = opt.get();
            pe.setAddress(propertyDto.getAddress());
            pe.setOwnerEmail(propertyDto.getOwnerEmail());
            pe.setOwnerName(propertyDto.getOwnerName());
            pe.setDescription(propertyDto.getDescription());
            pe.setPrice(propertyDto.getPrice());
            pe.setTitle(propertyDto.getTitle());
            dto=propertyConverter.convertEntityToDto(pe);
            propertyRepository.save(pe);
        }


        return dto;
    }

    @Override
    public PropertyDto updatePropertyDescription(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> opt =propertyRepository.findById(propertyId);
        PropertyDto dto=null;
        if(opt.isPresent()) {
            PropertyEntity pe = opt.get();

            pe.setDescription(propertyDto.getDescription());
            pe.setPrice(propertyDto.getPrice());

            dto=propertyConverter.convertEntityToDto(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDto updatePropertyPrice(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> opt =propertyRepository.findById(propertyId);
        PropertyDto dto=null;
        if(opt.isPresent()) {
            PropertyEntity pe = opt.get();


            pe.setPrice(propertyDto.getPrice());

            dto=propertyConverter.convertEntityToDto(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }


}





