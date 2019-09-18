package com.example.a6_4custom_sms_sender;

/**
 * 存储联系人信息
 * Created by 双双 on 2018/6/24.
 */

public class ContactBean {
    private  String phone;
    private  String name;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}
