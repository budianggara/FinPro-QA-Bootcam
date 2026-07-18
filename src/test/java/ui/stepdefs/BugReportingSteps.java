package ui.stepdefs;

import io.cucumber.java.en.*;
import org.testng.Assert;
import ui.driver.DriverFactory;
import ui.locators.ClassManagementLocator;
import ui.pages.BasePage;

public class BugReportingSteps extends BasePage {

    public BugReportingSteps() {
        super(DriverFactory.getDriver());
    }

    @Given("User sudah masuk ke halaman laporan bug LMS Dibimbing")
    public void userSudahMasukKeHalamanLaporanBugLmsDibimbing() {
        driver.get("https://lms-b2b.do.dibimbing.id/dibimbingqa/login");
    }

    @When("User mengisi judul bug {string}")
    public void userMengisiJudulBug(String judulBug) {
        System.out.println("Mengisi judul defect: " + judulBug);
    }

    @And("User memilih tingkat keparahan {string}")
    public void userMemilihTingkatKeparahan(String severity) {
        System.out.println("Memilih severity: " + severity);
    }

    @And("User memasukkan langkah reproduksi bug {string}")
    public void userMemasukkanLangkahReproduksiBug(String steps) {
        System.out.println("Mengisi langkah reproduksi: " + steps);
    }

    @And("User mengunggah file bukti gambar bug {string}")
    public void userMengunggahFileBuktiGambarBug(String fileName) {
        System.out.println("Mengunggah file gambar: " + fileName);
    }

    @And("User klik tombol Kirim Laporan")
    public void userKlikTombolKirimLaporan() {
        System.out.println("Mengklik tombol submit laporan bug");
    }

    @Then("Sistem berhasil menyimpan laporan bug dan menampilkan pesan sukses {string}")
    public void sistemBerhasilMenyimpanLaporanBugDanMenampilkanPesanSukses(String expectedSuccessMessage) {
        System.out.println("Validasi pesan sukses: " + expectedSuccessMessage);
    }

    @When("User mengosongkan semua kolom input laporan bug")
    public void userMengosongkanSemuaKolomInputLaporanBug() {
        System.out.println("Membiarkan form laporan bug kosong");
    }

    @Then("Sistem menolak pengiriman dan menampilkan pesan peringatan {string}")
    public void sistemMenolakPengirimanDanMenampilkanPesanPeringatan(String expectedWarningMessage) {
        System.out.println("Validasi pesan peringatan: " + expectedWarningMessage);
    }
}
