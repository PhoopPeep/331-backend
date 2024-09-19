package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizeDaoImpl implements OrganizeDao {
    List<Organizer> organizeList;

    @PostConstruct
    public void init() {
        organizeList = new ArrayList<>();
        organizeList.add(Organizer.builder()
                .id(123L)
                .title("Cat Adoption Day")
                .location("Meow Town")
                .organizer("Kat Laydee")
                .build());
        organizeList.add(Organizer.builder()
                .id(456L)
                .title("Community Gardening")
                .location("Flora City")
                .organizer("Fern Pollin")
                .build());
        organizeList.add(Organizer.builder()
                .id(789L)
                .title("Beach Cleanup")
                .location("Playa Del Carmen")
                .organizer("Carey Wales")
                .build());
        organizeList.add(Organizer.builder()
                .id(111L)
                .title("Book fair")
                .location("Mars")
                .organizer("Minions")
                .build());
        organizeList.add(Organizer.builder()
                .id(112L)
                .title("Eating Day")
                .location("Food land")
                .organizer("Eats ma ru owi")
                .build());
        organizeList.add(Organizer.builder()
                .id(113L)
                .title("Sleep")
                .location("your bed")
                .organizer("Fossil")
                .build());
    }

    @Override
    public Integer getOrganizeSize() {
        return organizeList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizeList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Organizer>(organizeList.subList(firstIndex, firstIndex + pageSize),
                PageRequest.of(page, pageSize), organizeList.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizeList.stream().filter(organizer
                -> organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizeList.get(organizeList.size() - 1).getId() + 1);
        organizeList.add(organizer);
        return organizer;
    }
}
