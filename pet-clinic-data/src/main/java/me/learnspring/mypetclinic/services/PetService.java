package me.learnspring.mypetclinic.services;

import me.learnspring.mypetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();

}
