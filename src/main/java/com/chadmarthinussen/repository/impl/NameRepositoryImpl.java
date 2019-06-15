package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.PersonalDetails.Name;
import com.chadmarthinussen.repository.NameRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/09.
 */

@Repository("NameRepositoryImpl")
public class NameRepositoryImpl implements NameRepository {

    private static NameRepositoryImpl repository = null;
    private Set<Name> names;

    private NameRepositoryImpl(){
        this.names = new HashSet<>();
    }

    private Name findName(String nameID) {
        return this.names.stream()
                .filter(name -> name.getNameID().trim().equals(nameID))
                .findAny()
                .orElse(null);
    }

    public static NameRepositoryImpl getRepository(){
        if (repository == null) repository = new NameRepositoryImpl();
        return repository;
    }


    public Name create(Name name){
        this.names.add(name);
        return name;
    }

    public Name read(final String nameID){
        Name name = findName(nameID);
        return name;
    }

    public void delete(String nameID) {
        Name name = findName(nameID);
        if (name != null) this.names.remove(name);
    }

    public Name update(Name name){
        Name toDelete = findName(name.getNameID());
        if(toDelete != null) {
            this.names.remove(toDelete);
            return create(name);
        }
        return null;
    }


    public Set<Name> getAll(){
        return this.names;
    }
}