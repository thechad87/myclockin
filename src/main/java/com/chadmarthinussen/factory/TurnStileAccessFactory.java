package com.chadmarthinussen.factory;

import com.chadmarthinussen.Domain.AccessTypes.Time;
import com.chadmarthinussen.Domain.AccessTypes.TurnStileAccess;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
public class TurnStileAccessFactory {

    public static TurnStileAccess buildTurnStileAccess(String turnStileAccessID, boolean validUserAccess, Time clockingTimes){
        return new TurnStileAccess.Builder().turnStileAccessID(turnStileAccessID).validUserAccess(validUserAccess).clockingTimes(clockingTimes).build();
    }
}
