package org.example.lab05_testngAnnotations;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class API19_Parameters {

    @Parameters("browser")
    @Test
    public void paramDemo1(String value) {
        System.out.println("Demo Method");
        System.out.println("Parameters Demo");

        if (value.equalsIgnoreCase("Chrome")) {
            System.out.println("Start the Chrome: ");
        }
        if (value.equalsIgnoreCase("Edge")) {
            System.out.println("Start the Edge: ");
        }
    }
}
