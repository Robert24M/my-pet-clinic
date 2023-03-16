package me.learnspring.mypetclinic.services.map;

import me.learnspring.mypetclinic.model.Owner;
import me.learnspring.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Set<Owner> owners = findAll();
        Iterator<Owner> iterator = owners.iterator();

        while (iterator.hasNext()) {
            Owner owner = iterator.next();
            if (Objects.equals(owner.getLastName(), lastName)) {
                return owner;
            }
        }
        return null;
    }
}
