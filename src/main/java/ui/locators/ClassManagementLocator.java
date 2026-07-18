package ui.locators;

import org.openqa.selenium.By;

public class ClassManagementLocator {

    // --- NAVIGASI UTAMA SIDEBAR & HALAMAN ---
    public static final By menuClassSidebar = By.xpath("//*[@id='layout-desktop-menu-item-box-class']/div");
    public static final By addNewClassButton = By.xpath("//*[@id='__next']/div/div/div/div/div/div/a/button");

    // --- MODUL FORM STEP 1 (ADD CLASS) ---
    public static final By titleInputField = By.xpath("//*[@id='create-class-page-title-input']");
    public static final By startDateInputField = By.xpath("//*[@id='create-class-page-start-date-input']");
    public static final By endDateInputField = By.xpath("//*[@id='create-class-page-end-date-input']");
    public static final By nextStepperButton = By.xpath("//*[@id='create-class-page-next-button']");

    // --- POP-UP MODAL KALENDER CHAKRA UI ---
    public static final By selectStartDate1 = By.xpath("//*[@id='date-this-month-1']/div");
    public static final By selectEndDate31 = By.xpath("//*[@id='date-this-month-31']/div");
    public static final By applyCalendarButton = By.xpath("//*[@id='apply-button']");

    // --- FORM STEP 2 (CHECKBOX & INPUT ASESMEN) ---
    public static final By syllabusOptionCheck = By.xpath("//*[@id='__next']/div/div/div/div/div/div/div/div/label");
    public static final By avgTestCheckbox = By.xpath("//label[contains(., 'Average Test')]");
    public static final By avgProjectCheckbox = By.xpath("//label[contains(., 'Average Project')]");
    public static final By middleTestCheckbox = By.xpath("//label[contains(., 'Middle Test')]");

    public static final By avgTestScoreInputField = By.xpath("//*[@id='update-class-step2-avg-test-score-percentage-input']");
    public static final By avgProjectScoreInputField = By.xpath("//*[@id='update-class-step2-avg-project-score-percentage-input']");
    public static final By middleTestInputField = By.xpath("//*[@id='update-class-step2-mid-test-percentage-input']");
    public static final By step2NextButton = By.xpath("//*[@id='update-class-step2-next-button']");

    // --- MANAGE CLASS: SEARCH, FILTER BY ANGKATAN & DELETE CLASS ---
    public static final By deleteClassCardButton = By.xpath("//*[@id='bootcamp-card-delete-class-button']");
    public static final By confirmDeleteAlertButton = By.xpath("/html/body/div/div/div/button | //button[contains(text(),'Hapus') or contains(text(),'Delete')]");

    public static final By searchClassInputField = By.xpath("//*[@id='__next']//input[@placeholder='Search Class Name' or contains(@placeholder,'Search')]");
    public static final By searchResultContainer = By.xpath("//*[@id='__next']/div/div/div/div/div/div/div");

    // Dropdown filter & Opsi pilihan Ganjil 2025
    public static final By filterAngkatanDropdownMenu = By.xpath("//button[contains(.,'Filter by Angkatan') or contains(.,'Angkatan')]");
    public static final By optionGanjil2025 = By.xpath("//*[contains(text(),'2025 Ganjil') or contains(text(),'Ganjil 2025')]");
    public static final By classListContainer = By.xpath("//*[contains(text(),'2025 Ganjil') or contains(text(),'Ganjil 2025')]");

    // --- EDIT & DETAIL 8 CLASS TABS ---
    public static final By editManageContentButton = By.xpath("//*[@id='bootcamp-card-edit-manage-content-button']");
    public static final By editDetailClassButton = By.xpath("//*[@id='bootcamp-card-edit-detail-class-button']");

    public static final By tabAnnouncement = By.xpath("//button[contains(text(),'Announcement') or @role='tab'] | //div[@role='tablist']/button");
    public static final By tabContent = By.xpath("//button[contains(text(),'Content') or @role='tab'] | //div[@role='tablist']/button");
    public static final By tabMentor = By.xpath("//button[contains(text(),'Mentor') or @role='tab'] | //div[@role='tablist']/button");
    public static final By tabTest = By.xpath("//button[contains(text(),'Test') or @role='tab'] | //div[@role='tablist']/button");
    public static final By tabSubmission = By.xpath("//button[contains(text(),'Submission') or @role='tab'] | //div[@role='tablist']/button");
    public static final By tabAssignedEmployee = By.xpath("//button[contains(text(),'Assigned Employee') or @role='tab'] | //div[@role='tablist']/button");
    public static final By tabAttendance = By.xpath("//button[contains(text(),'Attendance') or @role='tab'] | //div[@role='tablist']/button");
    public static final By tabReport = By.xpath("//button[contains(text(),'Report') or contains(text(),'Raport') or @role='tab'] | //div[@role='tablist']/button");

    // --- EDIT DETAIL CLASS SUB-MODULE ---
    public static final By updateClassStep1AngkatanSelect = By.xpath("//*[@id='update-class-step1-angkatan-select']");
    public static final By optionAngkatan2024 = By.xpath("//*[@id='update-class-step1-angkatan-select']/option[@value='2024']");
    public static final By updateClassStep1NextButton = By.xpath("//*[@id='update-class-step1-next-button']");
    public static final By step3SaveClassButton = By.xpath("//*[@id='update-class-step3-next-button']");

    // --- NOTIFIKASI TOAST ---
    public static final By globalToastMessageText = By.xpath("//*[@id='chakra-toast-manager-top']/li/div/div/div/div/div/p");
}
