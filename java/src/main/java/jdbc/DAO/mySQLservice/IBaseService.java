package jdbc.DAO.mySQLservice;

import java.sql.SQLException;
import java.util.List;

public interface IBaseService<T> {

    T getById(int id) throws SQLException;

    void insert(T t) throws SQLException;

    void delete(int id) throws SQLException;

    void update(T t) throws SQLException;

    List<T> getAll() throws SQLException;
}
