package com.sparkpost;

/**
 * Created by Steven on 4/8/2017.
 */

import com.sparkpost.exception.SparkPostException;

public class SparkPost {
    public static void sendEmail() throws SparkPostException {
        String API_KEY = "8e8029826802dac4b399e086b763b967eb16b67d";
        Client client = new Client(API_KEY);

        client.sendMessage(
                "admin@bitell.com",
                "steven.tra6@gmail.com",
                "The subject of the message",
                "The text part of the email",
                "<b>The HTML part of the email</b>");
    }
}
