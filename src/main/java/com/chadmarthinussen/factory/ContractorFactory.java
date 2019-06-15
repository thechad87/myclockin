package com.chadmarthinussen.factory;


import com.chadmarthinussen.Domain.UserlType.Contractor;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
public class ContractorFactory {

        public static Contractor buildContractor(boolean isContactor, String timePeriodMonths, String contractorID){
            return new Contractor.Builder().isContactor(isContactor).timePeriodMonths(timePeriodMonths).contractorID(contractorID).build();
        }

}

