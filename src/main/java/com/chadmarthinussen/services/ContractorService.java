package com.chadmarthinussen.services;

import com.chadmarthinussen.domain.UserlType.Contractor;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
public interface ContractorService extends IService<Contractor, String> {
        Set<Contractor> getAll();
}
