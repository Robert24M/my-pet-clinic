package me.learnspring.mypetclinic.services;

import me.learnspring.mypetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
