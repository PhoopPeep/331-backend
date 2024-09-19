package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizeDaoImpl implements OrganizeDao {
    List<Organizer> organizeList;

    @PostConstruct
    public void init() {
        organizeList = new ArrayList<>();
        organizeList.add(Organizer.builder()
                .id(123L)
                .location("Meow Town")
                .organizer("Kat Laydee")
                .build());
        organizeList.add(Organizer.builder()
                .id(456L)
                .location("Flora City")
                .organizer("Fern Pollin")
                .build());
        organizeList.add(Organizer.builder()
                .id(789L)
                .location("Playa Del Carmen")
                .organizer("Carey Wales")
                .build());
        organizeList.add(Organizer.builder()
                .id(111L)
                .location("Mars")
                .organizer("Minions")
                .build());
        organizeList.add(Organizer.builder()
                .id(112L)
                .location("Food land")
                .organizer("Eats ma ru owi")
                .build());
        organizeList.add(Organizer.builder()
                .id(113L)
                .location("your bed")
                .organizer("Fossil")
                .build());
    }

    @Override
    public Integer getOrganizeSize() {
        return organizeList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizeList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return organizeList.subList(firstIndex, firstIndex + pageSize);
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizeList.stream().filter(organizer
                -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
