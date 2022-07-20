package models;

import org.junit.jupiter.api.extension.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule implements AfterEachCallback, BeforeEachCallback {
    @Override
    public void afterEach(ExtensionContext context){
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", null);
    }

    @Override
    public void beforeEach(ExtensionContext context){
        try(Connection con = DB.sql2o.open()) {
            String deleteRangerQuery = "DELETE FROM ranger *;";
            con.createQuery(deleteRangerQuery).executeUpdate();
        }
    }
}
