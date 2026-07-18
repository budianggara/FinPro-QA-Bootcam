package ui.stepdefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ui.driver.DriverFactory;
import ui.locators.LoginLocator;
import ui.pages.BasePage;

public class LoginSteps extends BasePage {

    public LoginSteps() {
        super(DriverFactory.getDriver());
    }

    @Given("User membuka halaman login LMS Dibimbing")
    public void userMembukaHalamanLoginLmsDibimbing() {
        driver.get("https://lms-b2b.do.dibimbing.id/dibimbingqa/login");
    }

    @When("User memasukkan email {string} dan password {string}")
    public void userMemasukkanEmailDanPassword(String email, String password) {
        sendKeys(LoginLocator.emailField, email);
        sendKeys(LoginLocator.passwordField, password);
    }

    @And("User klik tombol Sign In")
    public void userKlikTombolSignIn() {
        click(LoginLocator.signInButton);
    }


    @Then("User berhasil diarahkan ke dashboard")
    public void userBerhasilDiarahkanKeDashboard() {
        boolean isDashboardUrl = wait.until(ExpectedConditions.urlContains("dashboard"))
                || wait.until(ExpectedConditions.urlContains("class"));

        // Melakukan validasi akhir setelah halaman terbukti sudah berpindah
        Assert.assertTrue(isDashboardUrl, "Gagal masuk ke dashboard! URL saat ini: " + driver.getCurrentUrl());
    }

    @Then("Sistem menampilkan pesan kesalahan {string}")
    public void sistemMenampilkanPesanKesalahan(String expectedError) {
        String actualError = getText(LoginLocator.errorMessage);
        Assert.assertTrue(actualError.toLowerCase().contains(expectedError.toLowerCase()));
    }
}
