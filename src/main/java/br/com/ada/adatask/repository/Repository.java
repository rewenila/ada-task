package br.com.ada.adatask.repository;

import java.util.List;

public interface Repository<T> {

    void save(T t);
    void update(T t);
    void delete(T t);
    List<T> getAll();
    T getById(Integer id);
    Integer getIndexById(Integer id);

}
