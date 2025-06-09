package Online;

import java.io.Serializable;

public class CustomerBean implements Serializable
{
    

    private String Username, Password, Fname, Lname, Address, Mailid, Mobile;

    public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMailid() {
		return Mailid;
	}

	public void setMailid(String mailid) {
		Mailid = mailid;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public CustomerBean() {}

}
