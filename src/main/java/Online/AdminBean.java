package Online;

import java.io.Serializable;

public class AdminBean implements Serializable
{
	private String aUsername,aPassword,aFname,aLname,aAddress,aMailid,aPhoneNo;

	public String getaUsername() {
		return aUsername;
	}

	public void setaUsername(String aUsername) {
		this.aUsername = aUsername;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	public String getaFname() {
		return aFname;
	}

	public void setaFname(String aFname) {
		this.aFname = aFname;
	}

	public String getaLname() {
		return aLname;
	}

	public void setaLname(String aLname) {
		this.aLname = aLname;
	}

	public String getaAddress() {
		return aAddress;
	}

	public void setaAddress(String aAddress) {
		this.aAddress = aAddress;
	}

	public String getaMailid() {
		return aMailid;
	}

	public void setaMailid(String aMailid) {
		this.aMailid = aMailid;
	}

	public String getaPhoneNo() {
		return aPhoneNo;
	}

	public void setaPhoneNo(String aPhoneNo) {
		this.aPhoneNo = aPhoneNo;
	}
	public AdminBean() {}
}
