package ui.locators;

import org.openqa.selenium.By;

public class LoginLocator {
    public static final By emailField = By.xpath("//*[@id='input-username-or-email']");
    public static final By passwordField = By.xpath("//*[@id='input-password']");
    public static final By signInButton = By.xpath("//*[@id='button-sign-in']");

    //  Mencari teks galat secara universal di semua jenis elemen web tag (//*)
    public static final By errorMessage = By.xpath("//*[contains(text(),'wrong') or contains(text(),'Wrong') or contains(text(),'password')]");
}
