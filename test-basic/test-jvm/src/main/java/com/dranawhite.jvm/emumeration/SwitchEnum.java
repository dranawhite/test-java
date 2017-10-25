package com.dranawhite.jvm.emumeration;

/**
 * JDK1.7 Switch中对枚举的处理
 *
 * @author dranawhite 2017/10/25
 * @version 1.0
 */
public class SwitchEnum {

    public static void valueOf() {
        System.out.println(Season.valueOf("AUTUMN"));
    }

    public static void swit() {
        switch(Season.AUTUMN) {
            case SPRING:
                System.out.println(Season.SPRING.toString());
                break;
            case SUMMER:
                System.out.println(Season.SUMMER.toString());
                break;
            case AUTUMN:
                System.out.println(Season.AUTUMN.toString());
                break;
            case WINTER:
                System.out.println(Season.WINTER.toString());
                break;
        }
    }

    public static void values() {
        Season[] seasons = Season.values();
        for (Season season : seasons) {
            System.out.println(season);
        }
    }

    public static void main(String[] args) {
        SwitchEnum.values();
    }
}
