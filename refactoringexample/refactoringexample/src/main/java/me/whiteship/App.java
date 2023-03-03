package me.whiteship;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws ClassNotFoundException {
        // 타입을 이용할때는 클래스 접근할때는 .class
        Class<Book> bookClass = Book.class;

        Book book = new Book();
        //인스턴스를 이용하여 클래스 접근할 때는 getClass()
        Class<? extends Book> aClass = book.getClass();

        //문자열을 이용하여 클래스 접근할 때는 .foName
        Class<?> aClass1 = Class.forName("me.whiteship.Book");

        // .getFields() public 한것만 가져옴
        System.out.println("===== 선언된 필드 가져오기(public만) ======");
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        System.out.println("===== 선언된 필드 가져오기(접근제어자 상관없이) ======");
        // .getDeclaredFields() 접근제어자 상관없이 다 가져옴, 특정한걸 가져오고 싶으면 이름을 주면됨(.getDeclaredField("a"))
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        System.out.println("===== 선언된 필드와 값 가져오기 =====");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            //값을 가져올때는 인스턴스가 있어야함
            try {
                f.setAccessible(true); //접근제어자 상관없이 접근 가능(true)
                System.out.printf("%s %s \n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("===== 메소드 확인 =====");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        System.out.println("===== 생성자 확인 =====");
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        System.out.println("===== 상위 클래스 확인 =====");
        System.out.println(MyBook.class.getSuperclass());

        System.out.println("===== 인터페이스 확인  =====");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        System.out.println("===== 필드 확인 =====");
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isPublic(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });

        System.out.println("===== 메소드 확인 =====");
        Arrays.stream(Book.class.getMethods()).forEach(m -> {
            int modifiers = m.getModifiers();
            System.out.println(m);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isPublic(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });

    }
}
