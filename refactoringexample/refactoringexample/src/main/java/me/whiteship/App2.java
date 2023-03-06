package me.whiteship;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App2 {
    public static void main( String[] args ) throws Exception {
        Class<?> book2Class = Class.forName("me.whiteship.Book2");
        Constructor<?> constructor1 = book2Class.getConstructor(null);
        Book2 book1 = (Book2) constructor1.newInstance();
        System.out.println(book1);

        Constructor<?> constructor2 = book2Class.getConstructor(String.class);
        Book2 book2 = (Book2) constructor2.newInstance("myBook");
        System.out.println(book2);

        Field a = Book2.class.getDeclaredField("A");
        System.out.println(a.get(null));
        a.set(null, "AAA");
        System.out.println(a.get(null));

        Field b = Book2.class.getDeclaredField("B");
        b.setAccessible(true); // 접근제어자 무시할 수 있음
        System.out.println(b.get(book2));
        b.set(book2, "BBBBB");
        System.out.println(b.get(book2));

        Method c = Book2.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book2);

        Method sum = Book2.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(book2, 1, 2);
        System.out.println(invoke);
    }
}
