package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.AccessTypes.PasswordCredential;
import com.chadmarthinussen.repository.PasswordCredentialRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/05/01.
 */
public class PasswordCredentialRepositoryImpl implements PasswordCredentialRepository {

    private static PasswordCredentialRepositoryImpl repository = null;
    private Set<PasswordCredential> passwordCredentials;

    private PasswordCredentialRepositoryImpl(){
        this.passwordCredentials = new HashSet<>();
    }

    private PasswordCredential findPasswordCredential(String passwordCredentialId) {
        return this.passwordCredentials.stream()
                .filter(passwordCredential -> passwordCredential.getUserPasswordCredentials().trim().equals(passwordCredentialId))
                .findAny()
                .orElse(null);
    }

    public static PasswordCredentialRepositoryImpl getRepository(){
        if (repository == null) repository = new PasswordCredentialRepositoryImpl();
        return repository;
    }

    public PasswordCredential create(PasswordCredential passwordCredential){
        this.passwordCredentials.add(passwordCredential);
        return passwordCredential;
    }

    public PasswordCredential read(final String passwordCredentialId){
        PasswordCredential passwordCredential = findPasswordCredential(passwordCredentialId);
        return passwordCredential;
    }


    public void delete(String passwordCredentialId) {
        PasswordCredential passwordCredential = findPasswordCredential(passwordCredentialId);
        if (passwordCredential != null) this.passwordCredentials.remove(passwordCredential);
    }


    public PasswordCredential update(PasswordCredential passwordCredential){
        PasswordCredential toDelete = findPasswordCredential(passwordCredential.getUserPasswordCredentials());
        if(toDelete != null) {
            this.passwordCredentials.remove(toDelete);
            return create(passwordCredential);
        }
        return null;
    }


    public Set<PasswordCredential> getAll(){
        return this.passwordCredentials;
    }
}
