
public class Scholar {
	
	protected Login login;
	protected String firstName;
	protected String lastName;
	protected String fullName;
	protected String username;
	protected String password;
	protected long id;
	
	public Scholar(String firstName, String lastName, String username, String password, long id){
		this.login = new Login(username, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = this.firstName + " " + this.lastName;
		this.username = username;
		this.password = password;
		this.id = id;
	}
	
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(!(obj instanceof Scholar)){
			return false;
		}
		Scholar scholar = (Scholar) obj;
		return this.fullName.equals(scholar.fullName) && this.username.equals(scholar.username) && 
				this.password.equals(scholar.password) && (this.id == scholar.id);
	}
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
