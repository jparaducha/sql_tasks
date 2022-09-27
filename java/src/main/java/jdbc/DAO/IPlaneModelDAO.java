package jdbc.DAO;

import jdbc.model.PlaneModel;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPlaneModelDAO {

    //@Select("SELECT model_id,model_name,manufacturer FROM plane_models WHERE model_id=#{id}")
    //@ResultMap("PlaneModelMap")
    PlaneModel getPlaneModelById(int id) throws SQLException;

    ArrayList<PlaneModel> getAllModels() throws SQLException;

    void insertModel(PlaneModel object) throws SQLException;

    void deleteModelById(int id) throws SQLException;

    void updateModel(@Param("id") int id, @Param("object") PlaneModel object) throws SQLException;

    void deleteAllModels() throws SQLException;
}
