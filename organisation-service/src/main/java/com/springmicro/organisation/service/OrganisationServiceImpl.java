package com.springmicro.organisation.service;

import com.springmicro.organisation.entity.Organisation;
import com.springmicro.organisation.dto.OrganisationDto;
import com.springmicro.organisation.mapper.OrganisationMapper;
import com.springmicro.organisation.repository.OrganisationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements  OrganisationService{
   private OrganisationRepository organisationRepository;
    @Override
    public OrganisationDto saveOrganisation(OrganisationDto organisationDto) {

        Organisation organisation= OrganisationMapper.mapToOrganisation(organisationDto);
        Organisation saveOrganisation=organisationRepository.save(organisation);
        OrganisationDto organisationDto1=OrganisationMapper.mapToOrganisationDto(saveOrganisation);
        return organisationDto1;
    }

    @Override
    public OrganisationDto getOrganisationByCode(String organitionCode) {
       Organisation organisation=organisationRepository.findByOrganisationCode(organitionCode);
        OrganisationDto organisationDto=OrganisationMapper.mapToOrganisationDto(organisation);
        return organisationDto;
    }
}
