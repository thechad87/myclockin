package com.chadmarthinussen.services;

import com.chadmarthinussen.Domain.AccessTypes.Time;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface TimeService extends IService<Time, String> {
        Set<Time> getAll();
}
