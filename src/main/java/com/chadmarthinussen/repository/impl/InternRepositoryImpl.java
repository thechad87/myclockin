package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.UserlType.Intern;
import com.chadmarthinussen.repository.InternRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
@Repository("InternRepositoryImpl")
public class InternRepositoryImpl implements InternRepository {

    private static InternRepositoryImpl repository = null;
    private Set<Intern> interns;

    private InternRepositoryImpl(){
        this.interns = new HashSet<>();
    }

    private Intern findIntern(String internID) {
        return this.interns.stream()
                .filter(intern -> intern.getInternID().trim().equals(internID))
                .findAny()
                .orElse(null);
    }

    public static InternRepositoryImpl getRepository(){
        if (repository == null) repository = new InternRepositoryImpl();
        return repository;
    }


    public Intern create(Intern intern){
        this.interns.add(intern);
        return intern;
    }

    public Intern read(final String internID){
        Intern intern = findIntern(internID);
        return intern;
    }

    public void delete(String internID) {
        Intern intern = findIntern(internID);
        if (intern != null) this.interns.remove(intern);
    }

    public Intern update(Intern intern){
        Intern toDelete = findIntern(intern.getInternID());
        if(toDelete != null) {
            this.interns.remove(toDelete);
            return create(intern);
        }
        return null;
    }


    public Set<Intern> getAll(){
        return this.interns;
    }
}
