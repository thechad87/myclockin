package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.UserlType.Guest;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface GuestService extends IService<Guest, String> {
        Guest retrieveByDesc(String genderDesc);
        Set<Guest> getAll();
}
