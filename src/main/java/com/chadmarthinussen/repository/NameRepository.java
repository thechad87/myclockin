package com.chadmarthinussen.repository;

import com.chadmarthinussen.Domain.PersonalDetails.Name;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/09.
 */
public interface NameRepository extends IRepository<Name, String>{
    Set<Name> getAll();

}
