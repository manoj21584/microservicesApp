package com.springmicro.organisation.repository;

import com.springmicro.organisation.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation,Long> {
    Organisation findByOrganisationCode(String organisationCode);
}
