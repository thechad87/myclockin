package com.chadmarthinussen.domain.AccessTypes;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/06/09.
 */
@Entity
public class LevelOfAccess {

    @Id
    private int levleOfAccessId;
    private int userLevelAccess;
    private int requiredLevelAccess;


}
