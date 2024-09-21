package com.SWP391.SWP391.Service;

import com.SWP391.SWP391.DTO.Request.PetCreationRequest;
import com.SWP391.SWP391.DTO.Request.PetUpdateRequest;
import com.SWP391.SWP391.Entity.Pet;
import com.SWP391.SWP391.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    //CREATE PET
    public Pet createPet(PetCreationRequest request){
        if(petRepository.existsByPetName(request.getPetName()))
            throw new RuntimeException("PetName has been Used");
        Pet pet = new Pet();

        pet.setPetName(request.getPetName());
        pet.setPetAge(request.getPetAge());
        pet.setPetBreed(request.getPetBreed());
        pet.setPetDescription(request.getPetDescription());
        pet.setPetSize(request.getPetSize());
        pet.setPetGender(request.getPetGender());
        pet.setPetVaccin(request.getPetVaccin());
        pet.setPetStatus(request.getPetStatus());

         return petRepository.save(pet);
    }
    //Get Pets
    public List<Pet> getPets(){
        return petRepository.findAll();
    }
    public Pet getPet(String petId){
        return petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not existed"));
    }
    public Pet updatePet(String petId, PetUpdateRequest request){
        Pet pet = getPet(petId);

        pet.setPetName(request.getPetName());
        pet.setPetAge(request.getPetAge());
        pet.setPetBreed(request.getPetBreed());
        pet.setPetDescription(request.getPetDescription());
        pet.setPetSize(request.getPetSize());
        pet.setPetVaccin(request.getPetVaccin());
        pet.setPetGender(request.getPetGender());
        pet.setPetStatus(request.getPetStatus());

        return petRepository.save(pet);
    }

    public void deletePet(String petId){
        petRepository.deleteById(petId);
    }

}
