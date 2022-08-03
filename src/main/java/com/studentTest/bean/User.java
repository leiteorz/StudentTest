package com.studentTest.bean;

public class User {
    private int u_id;
    private String u_pwd;
    private String u_phone;
    private int u_role;
    private String u_name;

    public User(int u_id, String u_pwd, String u_phone, int u_role, int isdelete,String u_name) {
        this.u_id = u_id;
        this.u_pwd = u_pwd;
        this.u_phone = u_phone;
        this.u_role = u_role;
        this.u_name = u_name;
    }

    public User(){}

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public int getU_role() {
        return u_role;
    }

    public void setU_role(int u_role) {
        this.u_role = u_role;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_pwd='" + u_pwd + '\'' +
                ", u_phone='" + u_phone + '\'' +
                ", u_role=" + u_role +
                ", u_name='" + u_name + '\'' +
                '}';
    }
}
