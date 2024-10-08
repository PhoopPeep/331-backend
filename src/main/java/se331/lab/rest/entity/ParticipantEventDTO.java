package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantEventDTO {
    Long id;
    String name;
    List<OnlyEventDTO> events;
}
