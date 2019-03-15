package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidDriverManager {

    private static AndroidDriver<AndroidElement> androidDriver;

    public static void setDriver(AndroidDriver<AndroidElement> driver) {
        androidDriver = driver;
    }

    public static AndroidDriver<AndroidElement> getDriver() {
        return androidDriver;
    }
}