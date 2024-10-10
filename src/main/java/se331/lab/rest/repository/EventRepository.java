package se331.lab.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
    Page<Event> findByTitle(String title, Pageable pageRequest);
    Page<Event> findByTitleContaining(String title, Pageable pageRequest);
}
