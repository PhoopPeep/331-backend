package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.OrganizeDao;
import se331.lab.rest.entity.Organizer;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {
    final OrganizeDao organizeDao;
    @Override
    public Integer getOrganizerSize() {
        return organizeDao.getOrganizeSize();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        return organizeDao.getOrganizers(pageSize, page);
    }

    @Override
    public Organizer getOrganize(Long id) {
        return organizeDao.getOrganizer(id);
    }
}
