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

    public User() {

    }

    public User(String uid, String skills, String bio, String type) {
        this.uid = uid;
        this.skills = skills;
        this.bio = bio;
        this.type = type;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("skills", skills);
        result.put("bio", bio);
        result.put("type", type);

        return result;
    }



}
