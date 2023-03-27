package me.learnspring.mypetclinic.bootstrap;

import me.learnspring.mypetclinic.model.*;
import me.learnspring.mypetclinic.services.OwnerService;
import me.learnspring.mypetclinic.services.PetTypeService;
import me.learnspring.mypetclinic.services.SpecialityService;
import me.learnspring.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int  count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Margareta");
        owner1.setLastName("Conforonko");
        owner1.setAddress("Nicolae Balcescu 123");
        owner1.setCity("Cucuietii de sus");
        owner1.setTelephone("456486946416");

        Pet margaretaPet  =  new Pet();
        margaretaPet.setPetType(savedDogPetType);
        margaretaPet.setOwner(owner1);
        margaretaPet.setBirthDay(LocalDate.now());
        margaretaPet.setName("Rex ");
        owner1.getPets().add(margaretaPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Giginel");
        owner2.setLastName("Amariei");
        owner2.setAddress("Casalotu Stelar 13");
        owner2.setCity("Coscova Veche");
        owner2.setTelephone("654656513541");

        Pet gigelPet = new Pet();
        gigelPet.setName("Panda");
        gigelPet.setPetType(savedCatPetType);
        gigelPet.setOwner(owner2);
        gigelPet.setBirthDay(LocalDate.now());
        owner2.getPets().add(gigelPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Ion");
        vet1.setLastName("Popescu");
        vet1.getSpecialities().add(savedSurgery);
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Gheorghe");
        vet2.setLastName("Scar");
        vet2.getSpecialities().add(savedDentistry);
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
