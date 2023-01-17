package com.sobresalir.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringToIntTest {
    @Test
    public void test() {
        int i = Integer.parseInt("2");
        Assertions.assertThat(i).isEqualTo(2);

    }

    @Test
    public void testNotInteger() {
        org.junit.jupiter.api.Assertions.assertThrows(NumberFormatException.class,
                () -> {
                    Integer.parseInt("가");
                });
    }

    @Test
    public void testBlank() {
        org.junit.jupiter.api.Assertions.assertThrows(NumberFormatException.class,
                () -> {
                    Integer.parseInt(" ");
                });

    }

    @Test
    public void testBreakLine() {
        org.junit.jupiter.api.Assertions.assertThrows(NumberFormatException.class,
                () -> {
                    Integer.parseInt("\n");
                });

    }
}
