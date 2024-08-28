package tiktok.entities;

import java.util.ArrayList;
import java.util.List;

public class Idol extends  Base{
    private String email,group;
    private List<Follower>followers;

    public Idol(int id, String name) {
        super(id, name);
    }

    public Idol(int id, String name, String email, List<Follower> followers, String group) {
        super(id, name);
        this.email = email;
        this.followers = followers;
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "email: "+getEmail()+" group: "+getGroup()+" follow: "+getFollowers();
    }
}
