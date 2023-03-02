package me.whiteship.jvm;

import java.util.List;

public class JVMApp {

    static String myName;

    static {
        myName = "hong";
    }

    private String foo = "bar";

    public static void main(String[] args) {
        //클래스 상속 알아보기
        System.out.println(JVMApp.class.getSuperclass());

        //객체는 힙 영역에 생성
        JVMApp jvmApp = new JVMApp();

        System.out.println(JVMApp.class.getClassLoader());
        System.out.println(List.class.getClassLoader());

        //currantThread 는 java 로 구현된게 아니라 C 로 구현되어 있음, native 키워드를 사용
        Thread.currentThread();
    }
}
