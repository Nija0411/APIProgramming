package org.example.lab06_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class API26_TestNGAssertions {


    @Test(enabled = false)
    public void hardAssert_test() {
        System.out.println("Start of the Program");
        Assert.assertEquals("nik", "Nik"); //Fail here
        System.out.println("Ending of the program"); //won't execute
    }

    @Test(enabled = true)
    public void softAssert_test() {
        System.out.println("Start of the Program");
        SoftAssert soft = new SoftAssert();
        soft.assertEquals("nik", "Nik"); //Fail here
        System.out.println("Ending of the program"); //It will still execute
        soft.assertAll();
    }

}
