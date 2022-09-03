public class UserInformation
{
	String firstName;
	String lastName;
	String email;
	String phoneNo;
	String Aadhaar;
	String address;
	String occupation;
	String sex;
	

	public UserInformation(String firstName, String lastName, String email, String phoneNo, String Aadhaar, String address,
			String occupation, String sex)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.Aadhaar = Aadhaar;
		this.address = address;
		this.occupation = occupation;
		this.sex = sex;
	}

	public String toString()
	{
		return  firstName + "\n" + lastName + "\n" + email + "\n" + phoneNo + "\n" + Aadhaar + "\n" + address + "\n" + occupation + "\n" + sex;
	}
}
