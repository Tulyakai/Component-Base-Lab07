package se331.lab.rest.service;

import se331.lab.rest.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer GetOrgSize();
    List<Organizer> getOrgs(Integer pageSize, Integer page);
    Organizer getOrg(Long id);
}
