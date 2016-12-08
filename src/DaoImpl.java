import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DaoImpl implements PatientDao {
	
    private Connection conn;
    public DaoImpl() {
    	try {
			conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-JA5ASAC;databaseName=Hospital", "sa", "MedStreaming77");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
	public void insert_patient(Patient patient) throws PatientDaoException{
		try {	
			PreparedStatement psmt = conn.prepareStatement("insert into Patient values (?,?,?,?,?)");
			psmt.setString(1, patient.getSSN());
			psmt.setString(2, patient.getlname());
			psmt.setString(3, patient.getfname());
			psmt.setString(4, "any address");
			psmt.setString(5, patient.getPhNum());
			psmt.executeUpdate();
			
		}
		catch (SQLException e) {
			throw new PatientDaoException(e);
			
		}
	}
}
