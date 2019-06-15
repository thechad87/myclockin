package com.chadmarthinussen.repository;

import com.chadmarthinussen.Domain.AccessTypes.PasswordCredential;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/05/01.
 */
public interface PasswordCredentialRepository extends IRepository<PasswordCredential,String> {
    Set<PasswordCredential> getAll();
}