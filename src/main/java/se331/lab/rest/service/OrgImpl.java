package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.OrgDao;
import se331.lab.rest.entity.Organizer;

import java.util.List;

@Service
public class OrgImpl implements OrganizerService{
    @Autowired
    OrgDao orgDao;

    @Override
    public Integer GetOrgSize() {
        return orgDao.getOrgSize();
    }

    @Override
    public List<Organizer> getOrgs(Integer pageSize, Integer page) {
        return orgDao.getOrgs(pageSize, page);
    }

    @Override
    public Organizer getOrg(Long id) {
        return orgDao.getOrg(id);
    }
}
