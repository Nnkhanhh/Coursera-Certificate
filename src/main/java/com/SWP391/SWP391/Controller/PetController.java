package com.SWP391.SWP391.Controller;

import com.SWP391.SWP391.DTO.Request.PetCreationRequest;
import com.SWP391.SWP391.DTO.Request.PetUpdateRequest;
import com.SWP391.SWP391.Entity.Pet;
import com.SWP391.SWP391.Service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    Pet createPets(@RequestBody @Valid PetCreationRequest request){
         return petService.createPet(request);
    }
    @GetMapping
    List<Pet> getPets(){
         return petService.getPets();
    }

    //GET PET BY ID
    @GetMapping("/{petId}")
    Pet getPet(@PathVariable("petId") String petId){
        return petService.getPet(petId);
    }

    //UPDATE PET
    @PutMapping("/{petId}")
    Pet updatePet(@PathVariable("petId") String petId ,@RequestBody PetUpdateRequest request){
        return petService.updatePet(petId, request);
    }
    //DELETE PET
    @DeleteMapping("/{petId}")
    String deletePet(@PathVariable("petId") String petId){
        petService.deletePet(petId);
        return "Pet has been deleted";

    }
}
