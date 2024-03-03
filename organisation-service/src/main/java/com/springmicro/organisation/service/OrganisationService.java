package com.springmicro.organisation.service;

import com.springmicro.organisation.dto.OrganisationDto;

public interface OrganisationService {
    OrganisationDto saveOrganisation(OrganisationDto organisationDto);
    OrganisationDto getOrganisationByCode(String organisationCode);
}
