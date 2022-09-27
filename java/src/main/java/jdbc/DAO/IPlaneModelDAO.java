package jdbc.DAO;

import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPlaneModelDAO<T> {

    //@Select("SELECT model_id,model_name,manufacturer FROM plane_models WHERE model_id=#{id}")
    //@ResultMap("PlaneModelMap")
    T getPlaneModelById(int id) throws SQLException;

    ArrayList<T> getAllModels() throws SQLException;

    void insertModel(T object) throws SQLException;

    void deleteModelById(int id) throws SQLException;

    void updateModel(@Param("id") int id, @Param("object") T object) throws SQLException;

    void deleteAllModels() throws SQLException;
}
