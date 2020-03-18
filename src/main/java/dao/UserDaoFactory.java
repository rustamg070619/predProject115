package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class UserDaoFactory {

    public static UserDAO getUserDAO() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "db.properties";
        String catalogConfigPath = rootPath + "catalog";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String daotype = appProps.getProperty("daotype");
        UserDAO toReturn = null;
        switch (daotype) {
            case "JDBC":
                toReturn = new UserJdbcDAO();
                break;
            case "hibernate":
                toReturn = new UserHibernateDAO();
                break;
            default:
                throw new IllegalStateException();
        }
        return toReturn;
    }
}
