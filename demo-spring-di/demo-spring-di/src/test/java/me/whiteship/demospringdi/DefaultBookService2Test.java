package me.whiteship.demospringdi;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class DefaultBookService2Test {

    // cglib를 이용한 프록시
    @Test
    public void di() {
        MethodInterceptor handler = new MethodInterceptor() {
            DefaultBookService bookService = new DefaultBookService();
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("rent")) {
                    System.out.println("aaaa");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("bbbb");
                    return invoke;
                }
                return method.invoke(bookService, args);
            }
        };
        DefaultBookService bookService = (DefaultBookService) Enhancer.create(DefaultBookService.class, handler);

        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }

    // bytebuddy를 이용한 프록시
    @Test
    public void di2() throws Exception {
        Class<? extends DefaultBookService> proxyClass = new ByteBuddy().subclass(DefaultBookService.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    DefaultBookService bookService = new DefaultBookService();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("aaaa");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("bbbb");
                        return invoke;
                    }
                }))
                .make().load(DefaultBookService.class.getClassLoader()).getLoaded();
        DefaultBookService bookService = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }

}