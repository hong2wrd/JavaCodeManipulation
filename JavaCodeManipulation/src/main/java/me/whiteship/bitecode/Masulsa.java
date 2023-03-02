package me.whiteship.bitecode;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa {
    public static void main(String[] args) {
        /**
         * 바이트 코드 조작 (실행순서 1 이후에 2를 사용하면(같이 실행하면 안됨), class 파일의 값이 변경, 객체를 다시 생성하지 않는한 유지)
         */
        // 1
        try {
            new ByteBuddy().redefine(Moja.class)
                    .method(named("pullOut")).intercept(FixedValue.value("Rabbit!!"))
                    .make().saveIn(new File("C:\\Java\\Test\\Study\\JavaCodeManipulation\\target\\classes\\"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2
        System.out.println(new Moja().pullOut());
    }
}
