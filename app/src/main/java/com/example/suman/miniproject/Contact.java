package com.example.suman.miniproject;

/**
 * Created by suman on 27-09-2017.
 */

public class Contact {
   int id;
    String name,DOB,email,password;
   public void setId(int id)
    {
        this.id=id;
    }
    public int getId()
    {
        return this.id;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setDOB(String DOB)
    {
        this.DOB=DOB;
    }
    public String getDOB()
    {
        return this.DOB;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setPass(String password)
    {
        this.password=password;
    }
    public String getPass()
    {
        return this.password;
    }
}
