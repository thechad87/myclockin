package com.chadmarthinussen.repository;

import com.chadmarthinussen.domain.AccessTypes.Authorization;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/05/01.
 */
public interface AuthorizationRepository extends IRepository<Authorization, String> {
    Set<Authorization> getAll();
}
