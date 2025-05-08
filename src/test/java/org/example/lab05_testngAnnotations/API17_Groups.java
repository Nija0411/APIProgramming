package org.example.lab05_testngAnnotations;

import org.testng.annotations.Test;

public class API17_Groups {

    //use sanitytestng.xml to run this

    @Test(groups = {"sanity", "regression"}, priority = 1)
    public void test_sanity() {
        System.out.println("Sanity");
    }

    @Test(groups = {"regression"})
    public void test_reg() {
        System.out.println("Regression");
    }

    @Test(groups = {"smoke", "sanity"})
    public void test_smoke() {
        System.out.println("Smoke");
    }
}
