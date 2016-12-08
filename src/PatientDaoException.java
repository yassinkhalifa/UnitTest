
public class PatientDaoException extends Exception {
PatientDaoException(Throwable e){
	super("This exception is produced from DAO Insert Patient",e);
}
}
