package me.whiteship.bitecode;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Masulsa2 {
    public static void main(String[] args) {
//        ClassLoader classLoader = Masulsa2.class.getClassLoader();
//        TypePool typePool = TypePool.Default.of(classLoader);
//        try {
//            new ByteBuddy().redefine(typePool.describe("me.whiteship.bitecode.Moja2").resolve(),
//                            ClassFileLocator.ForClassLoader.of(classLoader))
//                    .method(named("pullOut")).intercept(FixedValue.value("Rebbit2!"))
//                    .make().saveIn(new File("C:\\Java\\Test\\Study\\JavaCodeManipulation\\target\\classes\\"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(new Moja2().pullOut());
    }
}
