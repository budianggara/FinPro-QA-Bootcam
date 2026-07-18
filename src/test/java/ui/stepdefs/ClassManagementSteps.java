package ui.stepdefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ui.driver.DriverFactory;
import ui.locators.ClassManagementLocator;
import ui.pages.BasePage;

public class ClassManagementSteps extends BasePage {

    public ClassManagementSteps() {
        super(DriverFactory.getDriver());
    }

    @Given("User menavigasi ke halaman form Tambah Kelas")
    public void userMenavigasiKeHalamanFormTambahKelas() throws InterruptedException {
        click(ClassManagementLocator.menuClassSidebar);
        Thread.sleep(2000);
        click(ClassManagementLocator.addNewClassButton);
    }

    @When("User mengosongkan kolom Title Kelas")
    public void userMengosongkanKolomTitleKelas() {
        System.out.println("Mengeksekusi Edge Case: Judul dikosongkan");
    }

    @And("User klik tombol Selanjutnya")
    public void userKlikTombolSelanjutnya() {
        click(ClassManagementLocator.nextStepperButton);
    }

    @Then("Sistem menolak proses dan menampilkan toast alert {string}")
    public void sistemMenolakProsesDanMenampilkanToastAlert(String expectedToastText) {
        String actualToast = getText(ClassManagementLocator.globalToastMessageText);
        Assert.assertEquals(actualToast, expectedToastText);
    }

    // ==================== ALUR PENGISIAN LENGKAP UTUH (TC-ADD-004) ====================
    @When("User mengisi seluruh form data kelas baru secara lengkap")
    public void userMengisiSeluruhFormDataKelasBaruSecaraLengkap() throws InterruptedException {
        sendKeys(ClassManagementLocator.titleInputField, "Quality Assurance Automation Enterprise Class");
        Thread.sleep(500);

        click(ClassManagementLocator.startDateInputField);
        Thread.sleep(1000);
        click(ClassManagementLocator.selectStartDate1);
        click(ClassManagementLocator.applyCalendarButton);
        Thread.sleep(1000);

        click(ClassManagementLocator.endDateInputField);
        Thread.sleep(1000);
        click(ClassManagementLocator.selectEndDate31);
        click(ClassManagementLocator.applyCalendarButton);
        Thread.sleep(1500);

        click(ClassManagementLocator.nextStepperButton);
        Thread.sleep(3000);

        WebElement syllabusBtn = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.syllabusOptionCheck));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", syllabusBtn);
        Thread.sleep(1000);

        // 1. Average Test
        WebElement cb1 = wait.until(ExpectedConditions.presenceOfElementLocated(ClassManagementLocator.avgTestCheckbox));
        js.executeScript("arguments[0].click();", cb1);
        Thread.sleep(500);
        WebElement inputTestScore = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.avgTestScoreInputField));
        inputTestScore.click();
        inputTestScore.clear();
        inputTestScore.sendKeys("30");
        inputTestScore.sendKeys(org.openqa.selenium.Keys.TAB);
        Thread.sleep(500);

        // 2. Average Project
        WebElement cb2 = wait.until(ExpectedConditions.presenceOfElementLocated(ClassManagementLocator.avgProjectCheckbox));
        js.executeScript("arguments[0].click();", cb2);
        Thread.sleep(500);
        WebElement inputProjectScore = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.avgProjectScoreInputField));
        inputProjectScore.click();
        inputProjectScore.clear();
        inputProjectScore.sendKeys("40");
        inputProjectScore.sendKeys(org.openqa.selenium.Keys.TAB);
        Thread.sleep(500);

        // 3. Middle Test
        WebElement cb3 = wait.until(ExpectedConditions.presenceOfElementLocated(ClassManagementLocator.middleTestCheckbox));
        js.executeScript("arguments[0].click();", cb3);
        Thread.sleep(500);
        WebElement inputMiddleTest = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.middleTestInputField));
        inputMiddleTest.click();
        inputMiddleTest.clear();
        inputMiddleTest.sendKeys("30");
        inputMiddleTest.sendKeys(org.openqa.selenium.Keys.TAB);
        Thread.sleep(1500);

        WebElement nextStep2Btn = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.step2NextButton));
        nextStep2Btn.click();
        Thread.sleep(2500);
    }

    @And("User klik tombol Simpan Kelas")
    public void userKlikTombolSimpanKelas() {
        click(ClassManagementLocator.step3SaveClassButton);
    }

    @Then("Sistem berhasil menyimpan kelas dan menampilkan toast notifikasi {string}")
    public void sistemBerhasilMenyimpanKelasDanMenampilkanToastNotifikasi(String expectedSuccessToast) {
        String actualSuccessToast = getText(ClassManagementLocator.globalToastMessageText);
        Assert.assertEquals(actualSuccessToast, expectedSuccessToast, "Terjadi ketidakcocokan teks sukses!");
    }

    //------- MODUL MANAGE, FILTER & TABS --------

    @Given("User berada di halaman utama manajemen kelas")
    public void userBeradaDiHalamanUtamaManajemenKelas() throws InterruptedException {
        click(ClassManagementLocator.menuClassSidebar);
        Thread.sleep(2500);
    }

    @When("User mencari kelas kata kunci {string}")
    public void userMencariKelasKataKunci(String className) throws InterruptedException {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.searchClassInputField));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(className);
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    @When("User klik tombol Filter by Angkatan")
    public void userKlikTombolFilterByAngkatan() throws InterruptedException {
        WebElement filterDropdown = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.filterAngkatanDropdownMenu));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", filterDropdown);
        Thread.sleep(1500);
    }

    @And("User memilih opsi {string}")
    public void userMemilihOpsi(String optionText) throws InterruptedException {
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.optionGanjil2025));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", option);
        Thread.sleep(3000);
    }

    @Then("Sistem menampilkan seluruh daftar kelas yang masuk angkatan ganjil dua ribu dua puluh lima")
    public void sistemMenampilkanSeluruhDaftarKelasYangMasukAngkatanGanjil2025() {
        WebElement container = wait.until(ExpectedConditions.presenceOfElementLocated(ClassManagementLocator.classListContainer));
        Assert.assertTrue(container.isDisplayed(), "Gagal memuat hasil filter!");
    }

    @And("User klik tombol Edit dan Manage Content")
    public void userKlikTombolEditDanManageContent() throws InterruptedException {
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.editManageContentButton));
        editBtn.click();
        Thread.sleep(4000);
    }

    //---------KONFIRMASI HAPUS KELAS-----------

    @And("User melakukan hapus kelas dan konfirmasi")
    public void userMelakukanHapusKelasDanKonfirmasi() throws InterruptedException {
        // 1. Klik ikon/tombol tempat sampah (Delete) pada card bootcamp kelas
        WebElement deleteCardBtn = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.deleteClassCardButton));
        deleteCardBtn.click();
        Thread.sleep(1500);

        // 2. Ambil elemen tombol konfirmasi "Hapus" di dalam pop-up modal
        WebElement confirmBtn = wait.until(ExpectedConditions.presenceOfElementLocated(ClassManagementLocator.confirmDeleteAlertButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", confirmBtn);

        System.out.println("Otomatisasi Finpro - Sukses MEMAKSA konfirmasi hapus kelas via JavaScript!");

        Thread.sleep(2500);
    }



    //-------Skenario Edit Angkatan-------------
    @And("User melakukan perubahan detail informasi angkatan menjadi dua ribu dua puluh empat")
    public void userMelakukanPerubahanDetailInformasiAngkatanMenjadiDuaRibuDuaPuluhEmpat() throws InterruptedException {
        WebElement editDetailBtn = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.editDetailClassButton));
        editDetailBtn.click();
        Thread.sleep(2000);

        WebElement selectAngkatan = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.updateClassStep1AngkatanSelect));
        selectAngkatan.click();
        Thread.sleep(800);

        selectAngkatan.sendKeys(Keys.ARROW_DOWN); Thread.sleep(400);
        selectAngkatan.sendKeys(Keys.ARROW_DOWN); Thread.sleep(400);
        selectAngkatan.sendKeys(Keys.ENTER);
        Thread.sleep(1000);WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(ClassManagementLocator.updateClassStep1NextButton));nextBtn.click();Thread.sleep(3000);}}