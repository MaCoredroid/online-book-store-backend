package com.macoredroid.onlinebookstore.info;

public class Userinfo {
    public int userID;
    public String email;
    public String username;
    public boolean  state;
    public Userinfo(int userID,String email,String username,boolean state)
    {
        this.email=email;
        this.userID=userID;
        this.username=username;
        this.state=state;
    }

}
