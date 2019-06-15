package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.AccessTypes.Authorization;

/**
 * Created by ChadMarthinussen2 on 2019/04/30.
 */
public class AuthorizationFactory {

    public static Authorization buildAuthorization(String userTypeID, boolean verifyUserAccess){
        return new Authorization.Builder().userTypeID(userTypeID).verifyUserAccess(verifyUserAccess).build();
    }
}

