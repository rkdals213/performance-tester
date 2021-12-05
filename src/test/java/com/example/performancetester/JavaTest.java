package com.example.performancetester;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaTest {

    private List<String> texts = new ArrayList<>();

    @BeforeEach
    void init() {
        for (int i = 0; i < 10_000; i++) {
            texts.add("text");
        }
    }

    @Test
    void forI_forEach_stream() {
        long forIStart = System.currentTimeMillis();
        for (int i = 0; i < texts.size(); i++) {
            System.out.println(texts.get(i));
        }
        long forIPerformance = System.currentTimeMillis() - forIStart;

        long forEachStart = System.currentTimeMillis();
        for (String text : texts) {
            System.out.println(text);
        }
        long forEachPerformance = System.currentTimeMillis() - forEachStart;

        long forEachStreamStart = System.currentTimeMillis();
        texts.forEach(System.out::println);
        long forEachStreamPerformance = System.currentTimeMillis() - forEachStreamStart;

        System.out.println("forIPerformance = " + forIPerformance);
        System.out.println("forEachPerformance = " + forEachPerformance);
        System.out.println("forEachStreamPerformance = " + forEachStreamPerformance);
    }

    @Test
    void forI() {
        int temp = 0;
        long forAStart = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100_000; j++) {
                temp++;
            }
        }
        long forAPerformance = System.currentTimeMillis() - forAStart;

        long forBStart = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            for (int j = 0; j < 100; j++) {
                temp++;
            }
        }
        long forBPerformance = System.currentTimeMillis() - forBStart;

        System.out.println("forAPerformance = " + forAPerformance);
        System.out.println("forBPerformance = " + forBPerformance);
    }

    @Test
    void string_stringBuilder_stringBuffer() {
        long stringStart = System.currentTimeMillis();
        String a = "";
        for (int i = 0; i < 100_000; i++) {
            a += "a";
        }
        long stringPerformance = System.currentTimeMillis() - stringStart;

        long stringBuilderStart = System.currentTimeMillis();
        String b = "";
        StringBuilder builder = new StringBuilder(b);
        for (int i = 0; i < 100_000; i++) {
            builder.append("b");
        }
        long stringBuilderPerformance = System.currentTimeMillis() - stringBuilderStart;

        long stringBufferStart = System.currentTimeMillis();
        String c = "";
        StringBuffer buffer = new StringBuffer(c);
        for (int i = 0; i < 100_000; i++) {
            buffer.append("c");
        }
        long stringBufferPerformance = System.currentTimeMillis() - stringBufferStart;

        System.out.println("stringPerformance = " + stringPerformance);
        System.out.println("stringBuilderPerformance = " + stringBuilderPerformance);
        System.out.println("stringBufferPerformance = " + stringBufferPerformance);
    }

    @Test
    void integerTest() {
        Integer i1 = Integer.valueOf(100);
        Integer i2 = Integer.valueOf(100);

        System.out.println(i1 == i2);

        Integer i3 = Integer.valueOf(100000);
        Integer i4 = Integer.valueOf(100000);

        System.out.println(i3 == i4);
    }
}
