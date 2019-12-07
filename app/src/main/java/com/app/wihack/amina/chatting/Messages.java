package com.app.wihack.amina.chatting;

import java.util.ArrayList;

public class Messages {


    private String from, message;
    static ArrayList<Messages> listOfMessages = new ArrayList<>();


    public Messages() {
    }

    public Messages(String from, String message) {
        this.from = from;
        this.message = message;
    }

    public static void setListOfMessages(String id , String message) {

        listOfMessages.add(new Messages(id,message));
    }

    public static ArrayList<Messages> getListMessages() {
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
