package com.chadmarthinussen.services;

import com.chadmarthinussen.Domain.UserlType.Intern;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface InternService extends IService<Intern, String> {
        Set<Intern> getAll();
}
