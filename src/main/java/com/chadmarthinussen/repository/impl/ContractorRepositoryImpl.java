package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.UserlType.Contractor;
import com.chadmarthinussen.repository.ContractorRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/04/30.
 */


@Repository("ContractorRepositoryImpl")
public class ContractorRepositoryImpl implements ContractorRepository {

    private static ContractorRepositoryImpl repository = null;
    private Set<Contractor> contractors;

    private ContractorRepositoryImpl(){
        this.contractors = new HashSet<>();
    }

    private Contractor findContractor(String contractorID) {
        return this.contractors.stream()
                .filter(contractor -> contractor.getContractorID().trim().equals(contractorID))
                .findAny()
                .orElse(null);
    }

    public static ContractorRepositoryImpl getRepository(){
        if (repository == null) repository = new ContractorRepositoryImpl();
        return repository;
    }


    public Contractor create(Contractor contractor){
        this.contractors.add(contractor);
        return contractor;
    }

    public Contractor read(final String contractorID){
        Contractor contractor = findContractor(contractorID);
        return contractor;
    }

    public void delete(String contractorID) {
        Contractor contractor = findContractor(contractorID);
        if (contractor != null) this.contractors.remove(contractor);
    }

    public Contractor update(Contractor contractor){
        Contractor toDelete = findContractor(contractor.getContractorID());
        if(toDelete != null) {
            this.contractors.remove(toDelete);
            return create(contractor);
        }
        return null;
    }

    public Set<Contractor> getAll(){
        return this.contractors;
    }
}