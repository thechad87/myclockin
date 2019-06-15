package com.chadmarthinussen.services;

import com.chadmarthinussen.Domain.AccessTypes.PasswordCredential;

import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */

public interface PasswordCredentialService extends IService<PasswordCredential, String> {
        Set<PasswordCredential> getAll();
}
