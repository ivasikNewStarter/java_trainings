package ConnectionToDB;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by u0139221 on 12/18/2019.
 */
public class ConnDB_Main {

    public static void main(String[] args) {

        Connection connection = null;

        try {

           connection = ConnectionConfiguration.getConnection();

            if (connection != null) {
                System.out.println("Connection is done");
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
