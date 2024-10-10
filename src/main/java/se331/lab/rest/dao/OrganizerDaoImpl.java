package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrganizerDaoImpl implements OrganizerDao {
    final OrganizerRepository organizerRepository;

    @Override
    public Integer getOrganizerSize(){
        return Math.toIntExact(organizerRepository.count());
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page){
        return organizerRepository.findAll(PageRequest.of(page - 1,pageSize));
    }

    @Override
    public Organizer getOrganizer(long id){
        return organizerRepository.findById(id).orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer){
        return organizerRepository.save(organizer);
    }

    @Override
    public Optional<Organizer> findById(long id) {
        return organizerRepository.findById(id);
    }

    @Override
    public Page<Organizer> getOrganizer(Pageable pageRequest) {
        return organizerRepository.findAll(pageRequest);
    }
}
