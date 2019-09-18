package com.chadmarthinussen.repository;

import com.chadmarthinussen.domain.AccessTypes.Date;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */

public interface DateRepository extends IRepository<Date,String> {
    Set<Date> getAll();
}
