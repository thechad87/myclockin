package com.chadmarthinussen.repository.impl;

import com.chadmarthinussen.Domain.UserlType.Staff;
import com.chadmarthinussen.repository.StaffRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChadMarthinussen2 on 2019/04/25.
 */
@Repository("StaffRepositoryImpl")
public class StaffRepositoryImpl implements StaffRepository {

    private static StaffRepositoryImpl repository = null;
    private Set<Staff> staffs;

    private StaffRepositoryImpl(){
        this.staffs = new HashSet<>();
    }

    private Staff findStaff(String staffID) {
        return this.staffs.stream()
                .filter(staff -> staff.getStaffID().trim().equals(staffID))
                .findAny()
                .orElse(null);
    }

    public static StaffRepositoryImpl getRepository(){
        if (repository == null) repository = new StaffRepositoryImpl();
        return repository;
    }


    public Staff create(Staff staff){
        this.staffs.add(staff);
        return staff;
    }

    public Staff read(final String staffID){
        Staff staff = findStaff(staffID);
        return staff;
    }

    public void delete(String staffID) {
        Staff staff = findStaff(staffID);
        if (staff != null) this.staffs.remove(staff);
    }

    public Staff update(Staff staff){
        Staff toDelete = findStaff(staff.getStaffID());
        if(toDelete != null) {
            this.staffs.remove(toDelete);
            return create(staff);
        }
        return null;
    }


    public Set<Staff> getAll(){
        return this.staffs;
    }
}