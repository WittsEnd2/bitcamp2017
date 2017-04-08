import java.util.ArrayList;
import java.util.List;

public class TeamLeader extends Scholar {
	private List<Scholar> mentees;
	private int numberOfMentees;
	
	public TeamLeader(String firstName, String lastName, String username, String password, long id) {
		super(firstName, lastName, username, password, id);
		this.mentees = new ArrayList<Scholar>();
		this.numberOfMentees = 0;
	}
	
	public void addMentee(Scholar scholar){
		this.mentees.add(scholar);
		this.numberOfMentees++;
	}
	
	public void removeScholar(Scholar scholar){
		this.mentees.remove(scholar);
		this.numberOfMentees--;
	}
	
	public String toString(){
		int menteeCount = 0;
		StringBuilder builder = new StringBuilder();
		builder.append(fullName);
		builder.append(" : ");
		for(Scholar mentee : mentees){
			builder.append(mentee.fullName);
			if(this.numberOfMentees != menteeCount){
				builder.append(", ");
			}
		}
		return builder.toString();
	}

	public List<Scholar> getMentees() {
		return mentees;
	}

	public void setMentees(List<Scholar> mentees) {
		this.mentees = mentees;
	}

	public int getNumberOfMentees() {
		return numberOfMentees;
	}

	public void setNumberOfMentees(int numberOfMentees) {
		this.numberOfMentees = numberOfMentees;
	}
	
	
}
