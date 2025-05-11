package org.example.lab05_testngAnnotations;

import org.testng.annotations.Test;

public class API20_Enable {

    //Enable = false - skips the execution of the method.

    @Test
    public void hello1() {
        System.out.println("Hello1");
    }

    @Test
    public void hello2() {
        System.out.println("Hello2");
    }

    @Test(enabled = false)
    public void hello3() {
        System.out.println("Hello3");
    }

}
