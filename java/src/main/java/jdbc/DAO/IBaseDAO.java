package jdbc.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBaseDAO<T> {

    T getById(int id) throws SQLException;

    ArrayList<T> getAll() throws SQLException;

    void insertRow(T object) throws SQLException;

    void deleteById(int id) throws SQLException;

    void updateRow(int id, T object) throws SQLException;

    void deleteAll() throws SQLException;
}
