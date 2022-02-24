package repository;

import moduls.BaseClass;

import java.util.List;

public interface Respository <T extends BaseClass> {
    void add(T t);
    List<T> AllElement();
    void show(T t);
    void delete(T t);
    void modify(T t);

}
