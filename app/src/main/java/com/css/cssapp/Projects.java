package com.css.cssapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by micha on 4/8/2017.
 */

public class Projects {
    private String projectLeader;
    private String projectName;
    private String projectDescription;
    private int numPeople;
<<<<<<< HEAD
=======
    private Map<String, Object> usersLiked = new HashMap<>();
    public Projects(String leader, String name, String description, int people) {
        projectLeader = leader;
        projectName = name;
        projectDescription = description;
        numPeople = people;
    }
    public Projects() {
>>>>>>> 3c03f9bed4f4a74df1e7fd9f96de1a615bdbd830

    public Projects(String projectName, String projectDescription, int projectId,
                    String projectLeader, int numPeople) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectId = projectId;
        this.projectLeader = projectLeader;
        this.numPeople = numPeople;
    }
    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }
    public Map<String, Object> getUsersLiked() {
        return usersLiked;
    }
    public void setUsersLiked(Map<String, Object> uLiked){
        usersLiked = uLiked;
    }
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("projectLeader", projectLeader);
        result.put("projectName", projectName);
        result.put("projectDescription", projectDescription);
        result.put("numPeople", numPeople);
        result.put("usersLiked", usersLiked);

        return result;
    }
}
