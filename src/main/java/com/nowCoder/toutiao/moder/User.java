package com.nowCoder.toutiao.moder;

public class User {




    public String name;
    public String salt;
    public String password;

    public String getSalt() {
        return salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }

}
