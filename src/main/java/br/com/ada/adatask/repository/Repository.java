package br.com.ada.adatask.repository;

import br.com.ada.adatask.domain.BaseTask;

import java.util.List;

public interface Repository<T> {

    void save(T t);
    void edit(T t);
    void delete(T t);
    List<T> getAll();

}
