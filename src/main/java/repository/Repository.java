package repository;

import moduls.BaseClass;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T extends BaseClass> {
    void add(T t) throws SQLException;
    List<T> AllElement() throws SQLException;
    T show(int id) throws SQLException;
    void delete(int id) throws SQLException;
    void modify(T t) throws SQLException;

}
