package com.chadmarthinussen.repository;

import com.chadmarthinussen.Domain.AccessTypes.TurnStileAccess;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public interface TurnStileAccessRepository extends IRepository<TurnStileAccess,String> {
    Set<TurnStileAccess> getAll();
}
