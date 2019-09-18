package com.chadmarthinussen.repository;

import com.chadmarthinussen.domain.UserlType.Guest;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */
public interface GuestRepository extends IRepository<Guest,String> {
    Guest retrieveByDesc(String genderDesc);
    Set<Guest> getAll();

}
