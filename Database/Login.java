
public class Login {
	private String username;
	private String password;
	
	public Login(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(!(obj instanceof Login)){
			return false;
		}
		Login log = (Login) obj;
		
		return this.username.equals(log.username) && this.password.equals(log.password);
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(this.username);
		builder.append(" : ");
		builder.append(this.password);
		return builder.toString();
	}
	
	public String getUserName(){
		return this.username;
	}
	
	public String getPassWord(){
		return this.password;
	}
	
	public void setUserName(String username){
		this.username = username;
	}
	
	public void setPassWord(String password){
		this.password = password;
	}
}
