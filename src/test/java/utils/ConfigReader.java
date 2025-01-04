package utils;

public class ConfigReader {

    private static String browserType;

    public static void setBrowserType(String browser) {
        browserType = browser;
    }

    public static String getBrowserType() throws Throwable {
        if (browserType != null) {
            //System.out.println("2. ConfigReader: " + browserType);
            return browserType;
        } else {
            System.out.println("2. Browser not specified in the testng.xml, defaulting to chrome");
            return "chrome";
        }
    }
}