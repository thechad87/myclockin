package com.chadmarthinussen.repository;

import com.chadmarthinussen.Domain.UserlType.Contractor;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/05/01.
 */
public interface ContractorRepository extends IRepository<Contractor,String> {
    Set<Contractor> getAll();
}
