package com.Deepak.SpringBoot.practice;

public class DevDB implements DataBase{
    @Override
    public String getData()
    {
        return "DevData";
    }
}
