package me.whiteship.jvm.classloadersystem;

public class Whiteship2 {

    public void work() {
        Class<Whiteship2> whiteship2Class = Whiteship2.class;
        Whiteship2 whiteship2 = new Whiteship2();
        whiteship2.getClass();
    }

    public static void main(String[] args) {
        //클래스로더는 계층형 구조
        ClassLoader classLoader = Whiteship2.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());

//        ClassNotFoundException
    }
}
