package br.com.ada.adatask.repository;

public interface Repository<T> {
    void save(T t);
    void edit(T t);
    void delete(T t);
    void list(T t);
}
