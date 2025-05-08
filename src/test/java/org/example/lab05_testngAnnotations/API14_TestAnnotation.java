package org.example.lab05_testngAnnotations;

import org.testng.annotations.Test;

public class API14_TestAnnotation {

    //Normal Method
    public void testRequest1(){
        System.out.println("Normal Method"); //will not print
    }

    //Test Method
    @Test
    public void testRequest2(){
        System.out.println("Testing Method");
    }
}
