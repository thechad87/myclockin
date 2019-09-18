package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.domain.UserlType.Guest;
import com.chadmarthinussen.repository.GuestRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */

@Repository("GuestRepositoryImpl")
public class GuestRepositoryImpl implements GuestRepository {

    private static GuestRepositoryImpl repository = null;
    private Set<Guest> guests;

    private GuestRepositoryImpl(){
        this.guests = new HashSet<>();
    }

    private Guest findGuest(String guestID) {
        return this.guests.stream()
                .filter(guest -> guest.getGuestAssignedID().trim().equals(guestID))
                .findAny()
                .orElse(null);
    }

    public static GuestRepositoryImpl getRepository(){
        if (repository == null) repository = new GuestRepositoryImpl();
        return repository;
    }


    public Guest create(Guest guest){
        this.guests.add(guest);
        return guest;
    }

    public Guest read(final String guestID){
        Guest guest = findGuest(guestID);
        return guest;
    }

    public void delete(String guestID) {
        Guest guest = findGuest(guestID);
        if (guest != null) this.guests.remove(guest);
    }
    @Override
    public Guest retrieveByDesc(String guestID) {
        return this.guests.stream().filter(guest -> guest.getGuestAssignedID().equalsIgnoreCase(guestID)).findAny().orElse(null);
    }

    public Guest update(Guest guest){
        Guest toDelete = findGuest(guest.getGuestAssignedID());
        if(toDelete != null) {
            this.guests.remove(toDelete);
            return create(guest);
        }
        return null;
    }


    public Set<Guest> getAll(){
        return this.guests;
    }
}