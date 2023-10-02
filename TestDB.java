import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//org.apache.derby.jdbc.ClientDriver
//jdbc:derby://localhost:1527/sample
//create table teste(nome varchar(10))

public class TestDB {

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:derby://localhost:1527/sample;create=true", "app", "app");

		Statement st = con.createStatement();
//		st.executeUpdate("drop Table contatos");
		st.executeUpdate("create Table contatos (id integer primary key,nome varchar(40) not null, email varchar(30) not null)");

		st.executeUpdate("insert into contatos (id, nome, email) values (1,'Linus Torvalds', 'torvalds@osdl.org')");
		st.executeUpdate("insert into contatos (id, nome, email) values (2,'Richard Stallman', 'rms@gnu.org')");
		st.executeUpdate("insert into contatos (id, nome, email) values (3,'James Gosling', 'James.Gosling@sun.com')");

		ResultSet rs = st.executeQuery("select id, nome, email from contatos");
		while (rs.next()) {
			System.out.println(rs.getInt("id") +" "+rs.getString("nome") +" "+rs.getString("email"));
		}
		
		DatabaseMetaData db = con.getMetaData();
		System.out.println(db.getDriverName());
		System.out.println(db.getDriverVersion());
		System.out.println(db.getConnection().getClass().getName());
		System.out.println(db.getURL());
		System.out.println(db.getUserName());
		System.out.println(db.getMaxConnections());
		System.out.println(db.getMaxStatements());
		System.out.println(db.getDatabaseProductVersion());
		System.out.println(db.getSQLKeywords());
		System.out.println(db.getStringFunctions());
		System.out.println(db.getSystemFunctions());
		System.out.println(db.supportsANSI92EntryLevelSQL());
		System.out.println(db.supportsANSI92FullSQL());
		System.out.println(db.supportsBatchUpdates());

	}
}
