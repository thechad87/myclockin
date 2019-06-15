package com.chadmarthinussen.services;

/**
 * Created by ChadMarthinussen2 on 2019/06/08.
 */
public interface IService<T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

    void delete(ID id);
}
