package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.AccessTypes.Date;
import com.chadmarthinussen.repository.DateRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */

@Repository("DateRepositoryImpl")
public class DateRepositoryImpl implements DateRepository {

    private static DateRepositoryImpl repository = null;
    private Set<Date> dates;

    private DateRepositoryImpl(){
        this.dates = new HashSet<>();
    }

    private com.chadmarthinussen.Domain.AccessTypes.Date findDate(String dateID) {
        return this.dates.stream()
                .filter(date -> date.getDateID().trim().equals(dateID))
                .findAny()
                .orElse(null);
    }

    public static DateRepositoryImpl getRepository(){
        if (repository == null) repository = new DateRepositoryImpl();
        return repository;
    }

    @Override
    public Date create(Date date){
        this.dates.add(date);
        return date;
    }

//    @Override
//    public com.chadmarthinussen.Domain.AccessTypes.Date create(com.chadmarthinussen.Domain.AccessTypes.Date date) {
//        return null;
//    }

//    @Override
//    public com.chadmarthinussen.Domain.AccessTypes.Date update(com.chadmarthinussen.Domain.AccessTypes.Date date) {
//        return null;
//    }

    public Date read(final String dateID){
        Date date = findDate(dateID);
        return date;
    }

    public void delete(String dateID) {
        Date date = findDate(dateID);
        if (date != null) this.dates.remove(date);
    }

    @Override
    public Date update(Date date){
        Date toDelete = findDate(date.getDateID());
        if(toDelete != null) {
            this.dates.remove(toDelete);
            return create(date);
        }
        return null;
    }


    public Set<Date> getAll(){
        return this.dates;
    }
}