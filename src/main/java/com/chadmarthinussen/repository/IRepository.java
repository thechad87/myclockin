package com.chadmarthinussen.repository;

/**
 * Created by ChadMarthinussen2 on 2019/04/25.
 */
public interface IRepository <T, ID > {

    T create(T t);
    T update(T t);
    T read(ID id);
    void delete(ID id);

}
