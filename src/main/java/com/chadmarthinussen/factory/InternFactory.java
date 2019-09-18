package com.chadmarthinussen.factory;

import com.chadmarthinussen.domain.UserlType.Intern;

/**
 * Created by ChadMarthinussen2 on 2019/04/23.
 */
public class InternFactory {

    public static Intern buildIntern(boolean isIntern, String internID) {
        return new Intern.Builder().isIntern(isIntern).internID(internID).build();
    }
}
