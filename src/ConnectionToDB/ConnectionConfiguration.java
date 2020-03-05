package ConnectionToDB;

import java.sql.Connection;
import java.sql.DriverManager;

// Service name OA_READ_ONLY_SERVICE.int.thomsonreuters.com
public class ConnectionConfiguration {
    private static final String DB_URL = "oastbydb.int.thomsonreuters.com";
    private static final String DB_PASS = "TR_USER";
    private static final String DB_NAME = "TR_USER";
    private static final String DB_LOCALHOST = "OA_READ_ONLY_SERVICE.int.thomsonreuters.com";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@OA_READ_ONLY_SERVICE.int.thomsonreuters.com:1521:"+DB_NAME+"",DB_URL,DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

}
