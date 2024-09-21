package com.SWP391.SWP391.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PetUpdateRequest {

    String petName;
    int petAge;
    String petBreed;
    String petDescription;
    String petSize;
    String petGender;
    String petVaccin;
    String petStatus;

}
