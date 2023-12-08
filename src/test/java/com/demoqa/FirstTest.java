package com.demoqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FirstTest extends BaseTest {

    @Test
    public void firstTest() {
        System.out.println("First test again =D");
        Assertions.assertTrue(1==1, "Один не равно один");
    }


}
