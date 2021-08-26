package se331.lab.rest.dao;

import se331.lab.rest.entity.Organizer;

import java.util.List;

public interface OrgDao {
    Integer getOrgSize();
    List<Organizer> getOrgs(Integer pageSize, Integer page);
    Organizer getOrg(Long id);
}
