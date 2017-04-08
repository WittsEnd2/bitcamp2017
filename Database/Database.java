import java.util.HashSet;
import java.util.Set;

public class Database {
	
	private Set<Scholar> allScholars;
	private Set<Login> allLogins;
	
	public Database(){
		this.allScholars = new HashSet<Scholar>();
		this.allLogins = new HashSet<Login>();
	}
	
	public boolean addScholar(Scholar scholar){
		if(allScholars.contains(scholar)){
			return false;
		} else {
			allScholars.add(scholar);
			
		}
	}

	public boolean removeScholar(Scholar scholar){
		try{
			allScholars.remove(scholar);
			return true;
		} catch (Exception e){
			return false;
		}
	}
}
