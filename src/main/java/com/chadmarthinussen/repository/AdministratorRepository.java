package com.chadmarthinussen.repository;

import com.chadmarthinussen.domain.UserlType.Administrator;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
public interface AdministratorRepository extends IRepository<Administrator,String> {
    Set<Administrator> getAll();
}
