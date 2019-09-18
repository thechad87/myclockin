package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.PersonalDetails.Name;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface NameService extends IService<Name, String> {
        Set<Name> getAll();
}
