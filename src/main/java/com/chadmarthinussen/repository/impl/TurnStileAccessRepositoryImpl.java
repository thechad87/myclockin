package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.AccessTypes.TurnStileAccess;
import com.chadmarthinussen.repository.TurnStileAccessRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@Repository("TurnStileAccessRepositoryImpl")
public class TurnStileAccessRepositoryImpl implements TurnStileAccessRepository {

    private static TurnStileAccessRepositoryImpl repository = null;
    private Set<TurnStileAccess> turnStileAccesss;

    private TurnStileAccessRepositoryImpl(){
        this.turnStileAccesss = new HashSet<>();
    }

    private TurnStileAccess findTurnStileAccess(String turnStileAccessID) {
        return this.turnStileAccesss.stream()
                .filter(turnStileAccess -> turnStileAccess.getTurnStileAccessID().trim().equals(turnStileAccessID))
                .findAny()
                .orElse(null);
    }

    public static TurnStileAccessRepositoryImpl getRepository(){
        if (repository == null) repository = new TurnStileAccessRepositoryImpl();
        return repository;
    }


    public TurnStileAccess create(TurnStileAccess turnStileAccess){
        this.turnStileAccesss.add(turnStileAccess);
        return turnStileAccess;
    }

    public TurnStileAccess read(final String turnStileAccessID){
        TurnStileAccess turnStileAccess = findTurnStileAccess(turnStileAccessID);
        return turnStileAccess;
    }

    public void delete(String turnStileAccessID) {
        TurnStileAccess turnStileAccess = findTurnStileAccess(turnStileAccessID);
        if (turnStileAccess != null) this.turnStileAccesss.remove(turnStileAccess);
    }

    public TurnStileAccess update(TurnStileAccess turnStileAccess){
        TurnStileAccess toDelete = findTurnStileAccess(turnStileAccess.getTurnStileAccessID());
        if(toDelete != null) {
            this.turnStileAccesss.remove(toDelete);
            return create(turnStileAccess);
        }
        return null;
    }


    public Set<TurnStileAccess> getAll(){
        return this.turnStileAccesss;
    }
}