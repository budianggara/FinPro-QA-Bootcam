package ui.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ui.driver.DriverFactory;

public class Hooks {

    @Before
    public void setup() {
        // Melakukan inisialisasi browser Chrome secara segar sebelum skenario dimulai
        DriverFactory.initDriver("chrome");
    }

    @After
    public void tearDown(Scenario scenario) {
        var driver = DriverFactory.getDriver();
        try {
            if (driver != null) {

                //UNTUK SCREANSHOOT SETELAH DI EKSESKUSI
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Bukti Eksekusi: " + scenario.getName());
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil bukti gambar: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
        }
    }
}
