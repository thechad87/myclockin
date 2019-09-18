package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.AccessTypes.TurnStileAccess;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface TurnStileAccessService extends IService<TurnStileAccess, String> {
        Set<TurnStileAccess> getAll();
}
