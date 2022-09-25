package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDto;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.service.PropertyService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("${pms.dummy:}")
    private String dummy;
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/property")
    public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto) {
        propertyDto = propertyService.saveProperty(propertyDto);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/property")
    public ResponseEntity<List<PropertyDto>> getAllProperty() {
        System.out.println(dummy);
        List<PropertyDto> dto = propertyService.getAllProperty();
        ResponseEntity<List<PropertyDto>> listofprop = new ResponseEntity<>(dto, HttpStatus.OK);
        return listofprop;

    }

    @PutMapping("/property/{propertyId}")
    public ResponseEntity<PropertyDto> updateProperty(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId) {
        propertyDto = propertyService.updateProperty(propertyDto, propertyId);
        ResponseEntity<PropertyDto> rp = new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return rp;
    }

    @PatchMapping("/property/update-description/{propertyId}")
    public ResponseEntity<PropertyDto> updatePropertyDescription(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId) {
        propertyDto = propertyService.updatePropertyDescription(propertyDto, propertyId);
        ResponseEntity<PropertyDto> rp = new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return rp;
    }

    @PatchMapping("/property/update-price/{propertyId}")
    public ResponseEntity<PropertyDto> updatePropertyPrice(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId) {
        propertyDto = propertyService.updatePropertyPrice(propertyDto, propertyId);
        ResponseEntity<PropertyDto> rp = new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return rp;
    }
    @DeleteMapping("/property/{propertyId}")
    public ResponseEntity<Void>  deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void> rp = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return rp;
    }

}


