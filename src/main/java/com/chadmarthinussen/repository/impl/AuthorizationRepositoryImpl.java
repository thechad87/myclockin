package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.AccessTypes.Authorization;
import com.chadmarthinussen.repository.AuthorizationRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by ChadMarthinussen2 on 2019/05/01.
 */
@Repository("AuthorizationRepositoryImpl")
public class AuthorizationRepositoryImpl implements AuthorizationRepository {

    private static AuthorizationRepositoryImpl repository = null;
    private Set<Authorization> authorizations;

    private AuthorizationRepositoryImpl(){
        this.authorizations = new HashSet<>();
    }

    private Authorization findAuthorization(String authorizationID) {
        return this.authorizations.stream()
                .filter(authorization -> authorization.getUserTypeID().trim().equals(authorizationID))
                .findAny()
                .orElse(null);
    }

    public static AuthorizationRepositoryImpl getRepository(){
        if (repository == null) repository = new AuthorizationRepositoryImpl();
        return repository;
    }


    public Authorization create(Authorization authorization){
        this.authorizations.add(authorization);
        return authorization;
    }

    public Authorization read(final String authorizationID){
        Authorization authorization = findAuthorization(authorizationID);
        return authorization;
    }

    public void delete(String authorizationID) {
        Authorization authorization = findAuthorization(authorizationID);
        if (authorization != null) this.authorizations.remove(authorization);
    }

    public Authorization update(Authorization authorization){
        Authorization toDelete = findAuthorization(authorization.getUserTypeID());
        if(toDelete != null) {
            this.authorizations.remove(toDelete);
            return create(authorization);
        }
        return null;
    }


    public Set<Authorization> getAll(){
        return this.authorizations;
    }
}