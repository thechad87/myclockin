package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.UserlType.Staff;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface StaffService extends IService<Staff, String> {
        Set<Staff> getAll();
}
