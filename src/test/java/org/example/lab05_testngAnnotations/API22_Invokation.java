package org.example.lab05_testngAnnotations;

import org.testng.annotations.Test;

public class API22_Invokation {

    @Test
    public void hello1() {
        System.out.println("Hello1");
    }

    @Test (invocationCount = 3)
    public void hello2() {
        System.out.println("Hello2");
    } //this method will run 3 times

    @Test(invocationCount = 2)
    public void hello3() {
        System.out.println("Hello3");
    } //this will run 2 times
}
