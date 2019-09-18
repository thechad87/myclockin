package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.UserlType.Administrator;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class AdministratorFactory {


    public static Administrator buildAdministrator(String administratorID, boolean isAdministrator, boolean canEdit) {
        return new Administrator.Builder().administratorID(administratorID).isAdministrator(isAdministrator).canEdit(canEdit).build();
    }
}



