public class Patient {
	private final String fname;
	private final String lname;
	private String SSN;
	private String PhNum;
	
	public Patient(String fname, String lname){
		this.fname = fname;
		this.lname = lname;
	}
	public void setSSN(String SSN){
		this.SSN = SSN;
	}
	public void setPhNum(String PhNum){
		this.PhNum = PhNum;
	}
	public String getSSN(){
		return(this.SSN);
	}
	public String getfname(){
		return(this.fname);
	}
	public String getlname(){
		return(this.lname);
	}
	public String getPhNum(){
		return(this.PhNum);
	}
}
