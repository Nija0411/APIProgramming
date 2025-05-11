package org.example.lab05_testngAnnotations;

import org.testng.annotations.Test;

public class API21_AlwaysRun {

    @Test
    public void hello1() {
        System.out.println("Hello1");
    }

    @Test (alwaysRun = true)
    public void hello2() {
        System.out.println("Hello2");
    }

    @Test(alwaysRun = true, enabled = false)
    public void hello3() {
        System.out.println("Hello3");
    }

}
