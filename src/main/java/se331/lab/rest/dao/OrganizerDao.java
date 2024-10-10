package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Organizer;

import java.util.Optional;

public interface OrganizerDao {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(long id);
    Organizer save(Organizer organizer);
    Page<Organizer> getOrganizer(Pageable pageRequest);
    Optional<Organizer> findById(long id);
}
