package org.example.lab05_testngAnnotations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class API16_TestNGPriority {

    @Test(priority = 4)
    public void test4() {
        System.out.println(4);
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println(2);
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println(1);
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println(3);
    }

    // @BeforeTest (priority = 5) not allowed
    @BeforeTest
    public void test5(){
        System.out.println(5);
    }
}
