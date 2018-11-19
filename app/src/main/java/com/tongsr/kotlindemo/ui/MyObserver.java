package com.tongsr.kotlindemo.ui;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {

    private String name;

    public MyObserver(String name) {
        this.name = name;
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("hi," + name + "DevTechFrontier 更新啦，内容：" + arg);
    }
}
