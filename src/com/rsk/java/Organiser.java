package com.rsk.java;

public class Organiser {

    boolean closeMeeting(Meeting meeting){
        if(meeting.canClose) return meeting.close();
        return false;
    }


    public static void main(String[] args) {
        Organiser org = new Organiser();
        org.closeMeeting(null);
    }


    class Meeting{
        public boolean canClose;

        public boolean close(){
            return false;
        }
    }
}
