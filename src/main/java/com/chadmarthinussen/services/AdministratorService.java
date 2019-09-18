package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.UserlType.Administrator;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface AdministratorService extends IService<Administrator, String> {
    Set<Administrator> getAll();
}
