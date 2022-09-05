package factories;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestFactory {

    private static final ThreadLocal<ExtentTest> tlTest = new ThreadLocal<ExtentTest>();
    private static ExtentTestFactory instance = new ExtentTestFactory();

    private ExtentTestFactory() {
    }

    public static ExtentTestFactory getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ExtentTestFactory Instance is null! Please create instance of ExtentTestFactory using setExtent!");
        }
        return instance;
    }



    public ExtentTest getExtent() {
        if (tlTest.get() == null) {
            throw new IllegalStateException("ExtentTestFactory Instance is null! Please create instance of ExtentTestFactory using setExtent!");
        }
        return tlTest.get();
    }
    public void setExtent(ExtentTest test) {
        tlTest.set(test);

    }

    public void disposeExtent() {
        tlTest.remove();
    }

}
