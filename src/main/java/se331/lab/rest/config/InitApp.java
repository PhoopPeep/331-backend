package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;

    final OrganizerRepository organizerRepository;

    final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("ChiangMai").build());

        Event tepmEvent;

        Participant par1, par2, par3, par4, par5;
        par1 = participantRepository.save(Participant.builder().name("Stressed").telNo("123-456-789").build());
        par2 = participantRepository.save(Participant.builder().name("Backache").telNo("234-567-889").build());
        par3 = participantRepository.save(Participant.builder().name("Headache").telNo("345-678-901").build());
        par4 = participantRepository.save(Participant.builder().name("tried").telNo("098-765-432").build());
        par5 = participantRepository.save(Participant.builder().name("Peach").telNo("764-806-523").build());

        tepmEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tepmEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tepmEvent);

        tepmEvent.getParticipants().addAll(List.of(par1,par2,par3));
        par1.getEventHistory().add(tepmEvent);
        par2.getEventHistory().add(tepmEvent);
        par3.getEventHistory().add(tepmEvent);

        tepmEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00 am.-4.00 pm.")
                .petAllowed(false)
                .build());
        tepmEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tepmEvent);

        tepmEvent.getParticipants().addAll(List.of(par1,par2,par3,par4,par5));
        par1.getEventHistory().add(tepmEvent);
        par2.getEventHistory().add(tepmEvent);
        par3.getEventHistory().add(tepmEvent);
        par4.getEventHistory().add(tepmEvent);
        par5.getEventHistory().add(tepmEvent);

        tepmEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tepmEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tepmEvent);

        tepmEvent.getParticipants().addAll(List.of(par4,par2,par3));
        par4.getEventHistory().add(tepmEvent);
        par2.getEventHistory().add(tepmEvent);
        par3.getEventHistory().add(tepmEvent);

        tepmEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's play water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00 am.-6.00 pm.")
                .petAllowed(true)
                .build());
        tepmEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tepmEvent);

        tepmEvent.getParticipants().addAll(List.of(par1,par5,par3));
        par1.getEventHistory().add(tepmEvent);
        par5.getEventHistory().add(tepmEvent);
        par3.getEventHistory().add(tepmEvent);
    }
}
