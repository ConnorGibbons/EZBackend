package EZFile.EZBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
class DemoApplication{
  public static void main(String[] args) {
    //jdbc:mysql://<dbhost>:<dbport>/<dbname>...
	// Reference: https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/java-rds.html
	SpringApplication.run(DemoApplication.class, args);

	String dbName = "cs320";
	String userName = "cs320_admin";
	String password = "ilovemybf123#";
	String hostname = "cs-320-db-instance.csi8lngf1agb.us-east-2.rds.amazonaws.com";
	String port = "3306";
    String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
    try (Connection conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement()) {

      try {
        ResultSet rs = stmt.executeQuery("SELECT\r\n" + //
        		"     ci.customer_name,\r\n" + //
        		"     af.file_name,\r\n" + //
        		"     REGEXP_REPLACE(af.file_name, '.*\\.(.*)$', '\\1') AS file_type,\r\n" + //
        		"     af.create_date,\r\n" + //
        		"     at.description AS file_type_description,\r\n" + //
        		"     at.application_category_type,\r\n" + //
        		"     pi.auction_id\r\n" + //
        		" FROM\r\n" + //
        		"     ATTACHMENT_FILE af\r\n" + //
        		" JOIN\r\n" + //
        		"     ATTACH_PROPOSAL ap ON ap.attachment_id = af.attachment_id\r\n" + //
        		" JOIN\r\n" + //
        		"     ATTACH_TYPE at ON at.attachment_type = ap.attachment_type\r\n" + //
        		" JOIN\r\n" + //
        		"     PROPOSAL_INFO pi ON pi.proposal_id = ap.proposal_id\r\n" + //
        		" JOIN\r\n" + //
        		"     CUST_INFO ci ON ci.customer_id = pi.customer_id\r\n" + //
        		" JOIN\r\n" + //
        		"     AUC_INFO ai ON ai.auction_id = pi.auction_id;");
		int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
		  String name = "";
		  for (int i = 1; i <= columnCount; i++) {
			name += rs.getString(i) + ", ";          
		  }
          System.out.println(name);
        }
      } catch (SQLException e ) {
            throw new Error("Problem Executing Query:", e);
      } 

    } catch (SQLException e) {
      throw new Error("Problem Connecting to DB:", e);
    } 
  }
}