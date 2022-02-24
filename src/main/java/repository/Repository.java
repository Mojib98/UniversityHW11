package repository;

import moduls.BaseClass;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T extends BaseClass> {
    void add(T t) throws SQLException;
    List<T> AllElement();
    void show(T t);
    void delete(T t);
    void modify(T t);

}
