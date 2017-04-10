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

    private Map<String, Object> usersLiked = new HashMap<>();

    public Projects(String leader, String name, String description, int people) {
        projectLeader = leader;
        projectName = name;
        projectDescription = description;
        numPeople = people;
    }
    public Projects() {

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
