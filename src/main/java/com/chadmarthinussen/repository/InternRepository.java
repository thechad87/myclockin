package com.chadmarthinussen.repository;

import com.chadmarthinussen.Domain.UserlType.Intern;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
public interface InternRepository extends IRepository<Intern,String>  {
    Set<Intern> getAll();

}
