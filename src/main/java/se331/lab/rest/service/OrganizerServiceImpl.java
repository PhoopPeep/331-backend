package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.OrganizeDao;
import se331.lab.rest.entity.Organizer;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {
    final OrganizeDao organizeDao;
    @Override
    public Integer getOrganizerSize() {
        return organizeDao.getOrganizeSize();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        return organizeDao.getOrganizers(pageSize, page);
    }

    @Override
    public Organizer getOrganize(Long id) {
        return organizeDao.getOrganizer(id);
    }

    @Override
    public Organizer save(Organizer organizer) {
        return organizeDao.save(organizer);
    }
}
