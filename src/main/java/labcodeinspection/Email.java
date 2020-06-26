package labcodeinspection;
import java.util.Locale;

public class Email {

	private final transient String m_firstName;
	private final transient String m_lastName;
	private transient String password;
	private transient String department;
	private final transient int defaultpasswordLength;
	private transient String email;
	
	/**.
	*
	* @param  firstName  first value
	* @param  lastName second value
	* @return none
	*/
	public Email(String firstName, String lastName) {

		this.m_firstName = firstName;
		this.m_lastName = lastName;
		this.defaultpasswordLength = 8;
	}
	
	/**.
	*Print info
	* @return print
	*/
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}
	
	/**.
	* Set Department
	* @param  depChoice
	* @return none
	*/
	public void setDeparment(int depChoice) {
		
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			this.department = "departmen";
		}
	}

	private String randomPassword(int length) {
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}
	
	/**.
	* General Email
	* @return none
	*/
	public void generateEmail() {
		this.password = this.randomPassword(this.defaultpasswordLength);
		String last_name_lc = this.m_lastName.toLowerCase(Locale.US);
		String first_name_lc = this.m_firstName.toLowerCase(Locale.US);
		this.email = first_name_lc + last_name_lc + "@" + this.department
				+ ".espol.edu.ec";
	}
}
