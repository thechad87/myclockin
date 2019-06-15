package com.chadmarthinussen.repository;

import com.chadmarthinussen.Domain.AccessTypes.Time;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */

public interface TimeRepository extends IRepository<Time,String> {
    Set<Time> getAll();
}
