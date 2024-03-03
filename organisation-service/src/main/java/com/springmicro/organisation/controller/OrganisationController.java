package com.springmicro.organisation.controller;

import com.springmicro.organisation.dto.OrganisationDto;
import com.springmicro.organisation.service.OrganisationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organisations")
@AllArgsConstructor
public class OrganisationController {
    private OrganisationService organisationService;
    @PostMapping
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto){
        OrganisationDto organisationDto1=organisationService.saveOrganisation(organisationDto);
    return new ResponseEntity<>(organisationDto1,HttpStatus.CREATED);
    }
    @GetMapping("/{code}")
    public ResponseEntity<OrganisationDto> geByCode(@PathVariable String code){
        OrganisationDto organisationDto1=organisationService.getOrganisationByCode(code);
        return new ResponseEntity<>(organisationDto1,HttpStatus.OK);
    }

}
