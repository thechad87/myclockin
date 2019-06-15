package com.chadmarthinussen.repository;

import com.chadmarthinussen.Domain.UserlType.Staff;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/04/25.
 */
public interface StaffRepository extends IRepository<Staff,String> {
    Set<Staff> getAll();
}
