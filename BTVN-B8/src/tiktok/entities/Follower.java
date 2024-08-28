package tiktok.entities;

import java.util.ArrayList;

public class Follower extends Base{
    private String email;
    private int numberOfLike;

    public Follower(int id, String name) {
        super(id, name);
    }

    public Follower(int id, String name, int numberOfLike, String email) {
        super(id, name);
        this.numberOfLike = numberOfLike;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public void setNumberOfLike(int numberOfLike) {
        this.numberOfLike = numberOfLike;
    }

    @Override
    public String toString() {
        return  "Id : "+getId()+" name: "+getName()+" email: "+getName()+" numberoflke: "+getNumberOfLike();
    }
}
