package com.example.android.bluetoothchat;

public class BagWord {
    private int rating;
    private String word;
    private String translation;
    private boolean currentSession;

    public BagWord(String word, String translation) {
        this.rating = 0;
        this.word = word;
        this.translation = translation;
        this.currentSession = false;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return this.translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public boolean getCurrentSession() {
        return this.currentSession;
    }

    public void setCurrentSession(boolean currentSession) {
        this.currentSession = currentSession;
    }

    public String toString() {
        return "\"" + word + "\"" + " --  " + rating + "/5";
    }
}
