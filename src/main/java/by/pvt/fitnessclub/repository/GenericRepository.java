package by.pvt.fitnessclub.repository;


import java.util.List;

public interface GenericRepository<T> {
    void add(T t);

    void delete(Long id);

    T findById(Long id);

    List<T> getAll();
}
