package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.UserlType.Administrator;
import com.chadmarthinussen.repository.AdministratorRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */

@Repository("AdministratorRepositoryImpl")
public class AdministratorRepositoryImpl implements AdministratorRepository {

    private static AdministratorRepositoryImpl repository = null;
    private Set<Administrator> administrators;

    private AdministratorRepositoryImpl(){
        this.administrators = new HashSet<>();
    }

    private Administrator findAdministrator(String administratorID) {
        return this.administrators.stream()
                .filter(administrator -> administrator.getAdministratorID().trim().equals(administratorID))
                .findAny()
                .orElse(null);
    }


    public static AdministratorRepositoryImpl getRepository(){
        if (repository == null) repository = new AdministratorRepositoryImpl();
        return repository;
    }


    public Administrator create(Administrator administrator){
        this.administrators.add(administrator);
        return administrator;
    }

    public Administrator read(final String administratorID){
        Administrator administrator = findAdministrator(administratorID);
        return administrator;
    }

    public void delete(String administratorID) {
        Administrator administrator = findAdministrator(administratorID);
        if (administrator != null) this.administrators.remove(administrator);
    }

    public Administrator update(Administrator administrator){
        Administrator toDelete = findAdministrator(administrator.getAdministratorID());
        if(toDelete != null) {
            this.administrators.remove(toDelete);
            return create(administrator);
        }
        return null;
    }


    public Set<Administrator> getAll(){
        return this.administrators;
    }
}