package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.AccessTypes.Date;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface DateService extends IService<Date, String> {
    Set<Date> getAll();
}
