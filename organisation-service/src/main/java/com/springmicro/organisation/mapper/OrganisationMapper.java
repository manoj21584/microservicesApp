package com.springmicro.organisation.mapper;

import com.springmicro.organisation.dto.OrganisationDto;
import com.springmicro.organisation.entity.Organisation;

public class OrganisationMapper {
   public static OrganisationDto mapToOrganisationDto(Organisation organisation){
    OrganisationDto organisationDto= new OrganisationDto();
    organisationDto.setId(organisation.getId());
    organisationDto.setOrganisationName(organisation.getOrganisationName());
    organisationDto.setOrganisationDescription(organisation.getOrganisationDescription());
    organisationDto.setOrganisationCode(organisation.getOrganisationCode());
    organisationDto.setCreatedDate(organisation.getCreatedDate());
    return organisationDto;
    }

    public static Organisation mapToOrganisation(OrganisationDto organisationDto){
        return new Organisation(
               organisationDto.getId(),
               organisationDto.getOrganisationName(),
               organisationDto.getOrganisationDescription(),
               organisationDto.getOrganisationCode(),
               organisationDto.getCreatedDate()
       );
    }
}
