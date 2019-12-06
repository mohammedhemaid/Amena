package com.app.wihack.amina.chatting;

import java.util.ArrayList;

public class Messages {


    private String from, message;


    public Messages() {
    }

    public Messages(String from, String message) {
        this.from = from;
        this.message = message;
    }

    public static ArrayList<Messages> getListMessages() {

        ArrayList<Messages> listOfMessages = new ArrayList<>();
        listOfMessages.add(new Messages("1", "hello"));
        listOfMessages.add(new Messages("2", "hello"));
        listOfMessages.add(new Messages("1", "can you help me?"));
        listOfMessages.add(new Messages("2", "yes, of course"));

        return listOfMessages;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
