package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.AccessTypes.Authorization;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface AuthorizationService extends IService<Authorization, String> {
        Set<Authorization> getAll();

}
