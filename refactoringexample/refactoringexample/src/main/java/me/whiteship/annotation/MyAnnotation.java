package me.whiteship.annotation;

import java.lang.annotation.*;

// 로딩했을때 Annotation 의 정보는 빼고 가져와서 이 정보를 가져오고 싶으면 @Retention(RetentionPolicy.RUNTIME) 을 사용해야함
// @Retention(RetentionPolicy.class) 가 기본값
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD}) //사용할 위치를 지정할 수 있음
@Inherited //  상속이 되는 애노테이션, 상위클래스의 애노테이션을 가져옴
public @interface MyAnnotation {
    public String name() default "hong";
    int number() default 100;
    String name2(); // default 가 없으면 annotation 을 사용하는 곳에서 값을 줘야함
    String value(); // value 라는 변수 하나만 있으면 사용하는 곳에 이름 지정없이 값만 적어도 됌, 여러 속성이 있으면 안됨
}
