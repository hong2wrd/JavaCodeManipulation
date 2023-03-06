package me.whiteship;

import me.whiteship.annotation.AnotherAnnotation;
import me.whiteship.annotation.MyAnnotation;

@MyAnnotation(name2 = "hong2", value = "value")
public class Book {

    private static String B = "BOOK";
    private static final String C = "BOOK";
    private String a = "a";
    public String d = "d";
    @AnotherAnnotation("e")

    protected String e = "e";

    @AnotherAnnotation("h")
    public Book() {}
    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }
    public void g() {
        System.out.println("g");
    }
    public int h() {
        return 100;
    }


}
