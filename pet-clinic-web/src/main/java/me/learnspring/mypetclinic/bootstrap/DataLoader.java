package me.learnspring.mypetclinic.bootstrap;

import me.learnspring.mypetclinic.model.Owner;
import me.learnspring.mypetclinic.model.Vet;
import me.learnspring.mypetclinic.services.OwnerService;
import me.learnspring.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Margareta");
        owner1.setLastName("Conforonko");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Giginel");
        owner2.setLastName("Amariei");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ion");
        vet1.setLastName("Popescu");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Gheorghe");
        vet2.setLastName("Scar");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
