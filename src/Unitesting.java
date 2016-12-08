import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class Unitesting {
@Mock 
Connection conn;
@Mock
PreparedStatement psmt;
@InjectMocks
DaoImpl newDAO = new DaoImpl();


@Test
public void testPatientCon()
{
	Patient newp = new Patient("Yassin", "Amer");
	Assert.assertTrue(newp.getfname().equals("Yassin"));
	}

@Test
public void HappyTest1() throws SQLException, PatientDaoException
{
	when(conn.prepareStatement(anyString())).thenReturn(psmt);
	//when(psmt.setString(anyInt(), anyString())).thenReturn(1);
	when(psmt.executeUpdate()).thenReturn(1);
	Patient p = new Patient("fname","lname");
	newDAO.insert_patient(p);
	}
@Test
public void HappyTest2() throws SQLException, PatientDaoException{
	when(conn.prepareStatement(anyString())).thenReturn(psmt);
	ArgumentCaptor<String> stringcaptor = ArgumentCaptor.forClass(String.class);
	Patient p = new Patient("fname","lname");
	newDAO.insert_patient(p);
	verify(psmt, times(5)).setString(anyInt(), stringcaptor.capture());
	Assert.assertTrue(stringcaptor.getAllValues().get(2).equals("fname"));
}

@Test (expected = PatientDaoException.class)
public void ExceptionCase() throws SQLException, PatientDaoException{
	when(conn.prepareStatement(anyString())).thenReturn(psmt);
	when(psmt.executeUpdate()).thenThrow(new Exception());
	Patient p = new Patient("fname","lname");
	newDAO.insert_patient(p);
}

}
