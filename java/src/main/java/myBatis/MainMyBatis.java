package myBatis;

import jdbc.DAO.IBaseDAO;
import jdbc.DAO.IPlaneModelDAO;
import jdbc.model.Plane;
import jdbc.model.PlaneModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainMyBatis {
    private static final Logger LOGGER = LogManager.getLogger(MainMyBatis.class);

    public static void main(String[] args) throws IOException, SQLException {
        try {

            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();

            IBaseDAO<Plane> planeMapper = session.getMapper(IBaseDAO.class);
            Plane plane = planeMapper.getById(1);

            LOGGER.info("plane: " + plane);

            Plane testPlane = new Plane();
            testPlane.setModelId(3);
            testPlane.setYear((int) (Math.random() * (100) + 4000));

            planeMapper.insertRow(testPlane);

            testPlane.setYear(2025);

            planeMapper.updateRow(63, testPlane);

            ArrayList<Plane> planes = planeMapper.getAll();

            for (Plane planeT : planes) {
                LOGGER.info(planeT);
            }

            IPlaneModelDAO<PlaneModel> planeModelMapper = session.getMapper(IPlaneModelDAO.class);
            PlaneModel testModel = planeModelMapper.getPlaneModelById(2);

            LOGGER.info("plane model: " + testModel);

            session.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
    }
}
