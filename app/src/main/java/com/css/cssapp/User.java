package com.css.cssapp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Steven on 4/9/2017.
 */

public class User {

    private String uid;
    private String skills;
    private String bio;
    private String type;
    private Projects project;

    public User() {

    }

    public User(String uid, String skills, String bio, String type) {
        this.uid = uid;
        this.skills = skills;
        this.bio = bio;
        this.type = type;
        this.project = null;
    }

    public String getSkills() {
        return skills;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("skills", skills);
        result.put("bio", bio);
        result.put("type", type);
        result.put("project", project);

        return result;
    }



}
