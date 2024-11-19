package vehicles;

import java.sql.SQLException;

public interface Vehicle {
    boolean saveToDB() throws SQLException;
}
