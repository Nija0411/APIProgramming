package org.example.Lab02_concepts;

class NonBuilderPattern {
    //Non-Builder Pattern Example
    public static void main(String[] args) {
        NonBuilderPattern np = new NonBuilderPattern();
        np.step1();
        np.step2();
        np.step3("Nikhita");
    }
    // NoDesignPattern

    public void step1() {
        System.out.println("Step 1");
    }

    public void step2() {
        System.out.println("Step 2");
    }

    public void step3(String param1) {
        System.out.println("Step 3");
    }


}

class BuilderPatternExample {
    //Builder pattern example
    public static void main(String[] args) {
        BuilderPatternExample builder = new BuilderPatternExample();
        builder.step1().step2().step3("Nikhita");

    }

    public BuilderPatternExample step1() {
        System.out.println("Step1");
        return this;
    }

    public BuilderPatternExample step2() {
        System.out.println("Step2");
        return this;
    }

    public BuilderPatternExample step3(String param1) {
        System.out.println("Step3");
        return this;
    }

}
