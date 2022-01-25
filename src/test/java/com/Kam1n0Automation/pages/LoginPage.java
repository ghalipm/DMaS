package com.Kam1n0Automation.pages;

import com.Kam1n0Automation.utilities.BrowserUtils;
import com.Kam1n0Automation.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class LoginPage extends BasePage {

    Random random = new Random();


    //@FindBy(id="username")
    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameBox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//a")
    public WebElement signUpLink;

    @FindBy(xpath = "//a[.='Create an Application']")
    public WebElement creatingApplicationTab;

    //@FindBy(id="applicationType")
    @FindBy(xpath = "//select[@id='applicationType']")
    public WebElement applicationType;


    @FindBy(xpath = "//input[@id='name']")
    public WebElement applicationName;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement applicationDescription;

    @FindBy(xpath = "//button[@id='btn_submit']")
    public WebElement createButton;

    @FindBy(xpath = "//span[@class='check']")
    public WebElement privateApplicationCheckBox;

    @FindBy(xpath = "//select[@id='normlv']")
    public WebElement normalizationLevel;

    @FindBy(xpath = "//select[@id='arch']")
    public WebElement instructionsSet;

    @FindBy(xpath = "//a[@href='#messages']")
    public WebElement classificationTab;

    @FindBy(xpath = "//a[@href='#messages']")
    //@FindBy(xpath="(//li[@class])[6]")
    //@FindBy(xpath="(//a[@data-toggle='tab'])[2]")
    //@FindBy(xpath="(//ul/li)[18]")
    public WebElement binaryCompositionTab;


    @FindBy(xpath = "(//div[@class='modal-header information'])[2]")
    public WebElement classificationCompletedMessage;


    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement dropDownToggle;

    @FindBy(xpath = "//div[@id='index-drop-zone']")
    public WebElement dropFileZone;

    @FindBy(xpath = "//div[@id='search-drop-zone']")
    public WebElement dropFileZoneForBinaryComposition;

    @FindBy(xpath = "//div[@id='search-drop-zone']")
    public WebElement dropFileZoneForExecClassClassification;


    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//h3")
    public List<WebElement> applicationNameList; // for Apps and Result Files: for all, mixed.

    @FindBy(xpath = "//a[.='Edit']")
    public List<WebElement> editButton; //List for All Edit Buttons including App and ResultFiles

    //@FindBy(xpath = "//a[@class='btn btn-primary pull-right btn-sm href-file-edit editFilenameButton']")
    @FindBy(xpath = "//a[@data-target='#modalStop']")
    public List<WebElement> editButtonListForResultFiles;

    @FindBy(xpath = "//a[@class='btn btn-primary pull-right  btn-sm']")
    public List<WebElement> editButtonListForApplicationFiles;


    @FindBy(xpath = "//a[.='Delete']")
    public List<WebElement> deleteButton; // for all types of deleting: Applications and ResultFiles

    @FindBy(xpath = "//a[@id='file-delete']")
    public List<WebElement> deleteButtonForResultFiles;

    @FindBy(xpath = "//a[@data-target='#myModal']")
    public List<WebElement> deleteButtonForAppFiles;

    @FindBy(xpath = "//input[@name='appName']")
    public WebElement applicationNameFieldForDeleting;

    //@FindBy(xpath = "//input[@id='name']")
    //@FindBy(xpath = "(//input)[1]")
    @FindBy(xpath = "//div/input[@name='name']")
    public WebElement applicationNameFieldForEditing;


    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordFieldForDeleting;

    @FindBy(xpath = "//button[@id='btn-conf-delete']")
    public WebElement confirmButtonForDeleting;

    @FindBy(xpath = "//button[@id='btn-conf-file-del-tmp']")
    public WebElement confirmButtonForDeletingTmpFiles;

    @FindBy(xpath = "(//button[.='Close'])[1]")
    public WebElement closeButtonForDeleting;

    @FindBy(xpath = "//p[.='Failed to delete the application.']")
    public WebElement messageForFailedDeleting;

    @FindBy(xpath = "//p[.='You entered the wrong application name. Please retry.']")
    public WebElement wrongCredentialMessageForDeleting;


    @FindBy(xpath = "//input[@id='access-username']")
    public WebElement userNameFieldForEditing;

    @FindBy(xpath = "//select[@id='access-right']")
    public WebElement userRightsDropdownForEditing;

    @FindBy(xpath = "//button[@id='access-btn']")
    public WebElement rightsAccessButton;

    @FindBy(xpath = "//button[@id='btn_submit']")
    public WebElement editApplication_UpdateButton;

    @FindBy(xpath = "//h2/a")
    public List<WebElement> applicationPermanentLinks;

    //@FindBy(xpath = "(//div[@class='ripple-container'])[3]") // works
    @FindBy(xpath = "(//i[@class='material-icons'])[2]") // works
    public WebElement searchFunctionButton;

    @FindBy(xpath = "//a[@href='#profile']")
    public WebElement functionSearchTab;

    @FindBy(xpath = "//select[@id='clone-func-example']")
    public WebElement functionSearchExamples;

    @FindBy(xpath = "//button[@id='func-clone-btn']")
    public WebElement functionSearch_SearchButton;

    @FindBy(xpath = "//i[@class='jstree-icon jstree-ocl']")
    public WebElement functionSearchGraphNode;

    @FindBy(xpath = "(//ul/li/i[@role='presentation'])[2]")
    public WebElement functionSearchGraphSubNode;

    @FindBy(xpath = "(//h4)[1]")
    public WebElement functionSearchCloneGraphNote;

    @FindBy(xpath = "(//span[@title='Flow Graph View'])[1]")
    public WebElement asm2vecFunctionSearchGraphView;

    @FindBy(css = "h4.title")
    public WebElement asm2vecFunctionSearchFlowGraphViewTitle;

    @FindBy(xpath = "(//span[@title='Flow Graph View'])[1]")
    public WebElement asmCloneFunctionSearchGraphView;

    @FindBy(xpath = "//h4[@class='title']")
    public WebElement asmCloneFunctionSearchGraphViewTitle;



    @FindBy(xpath = "(//span[@title='Textual Difference View'])[1]")
    public WebElement asmCloneFunctionSearchTextView;

    @FindBy(xpath = "(//span[@title='Clone Group View'])[1]")
    public WebElement asmCloneFunctionSearchCloneGroupView;


    //@FindBy(css = "h4.title")
    @FindBy(xpath = "//h4[@class='title']")
    public WebElement sym1n0FunctionSearchFlowGraphViewTitle;


    @FindBy(xpath = "(//span[@title='Textual Difference View'])[1]")
    public WebElement asm2vecFunctionSearchTextView;


    @FindBy(xpath = "(//span[@title='Flow Graph View'])[1]")
    public WebElement sym1n0FunctionSearchFlowGraphView;

    //@FindBy(xpath = "(//a)[17]")
    @FindBy(xpath = "//a[@href='#settings']")
    //@FindBy(xpath = "//li[@class='active']")
    public WebElement indexingTab; // For Type1,2,3,4

    //@FindBy(xpath = "//a[@href='#deleteTmp']")
    @FindBy(xpath = "//li/a[@href='#deleteTmp']")
    public WebElement deleteTmpFilesTab; // For Type1,2,3

    @FindBy(xpath = "//span[@class='fnspan']")
    public WebElement filesAreaDeleteTmpFilesTab; // For Type1,2,3

    @FindBy(xpath = "//button[@id='btn-file-del-tmp']")
    public WebElement deleteButtonForDeleteTmpFilesTab; // For Type1,2,3

    @FindBy(xpath = "//ul[@id='tmpFilesContainer']")
    public WebElement tmpFilesContainerForDeleteTmpFiles;

    @FindBy(xpath = "//button[@id='btn-conf-file-del-tmp']")
    public WebElement confirmButtonForDeleteTmpFilesAlert; // For Type1,2,3

    @FindBy(xpath = "(//tr/td[.='1'])[2]")
    public WebElement indexOfSecondDownloadedFile; // For Type1,2,3


    //for asm2vec-clone Indexing
    @FindBy(xpath = "//button[@id='reindex-btn']")
    public WebElement rebuildIndexButton;

    //for asm2vec-clone Indexing
    @FindBy(xpath = "//button[@id='reindex-btn']")
    public WebElement runButtonForIndexingExecutableClassification;

    // common for asm-clone and sym1n0-clone Indexing
    @FindBy(xpath = "//button[@id='index-btn']")
    public WebElement indexButton;

    //for asm2vec-clone Indexing
    @FindBy(xpath = "//button[@id='reindex-btn']")
    public WebElement reindexButton;

    //for ExecutableClassification Indexing
    @FindBy(xpath = "//button[@id='reindex-btn']")
    public WebElement runButtonExecClass;

    @FindBy(xpath = "//h4[.='Index Binary Files']")
    public WebElement indexingMessage;

    //@FindBy(xpath = "(//div[@class='ripple-container'])[6]")
    @FindBy(xpath = "//a[@href='#deleteTmp']")
    public WebElement deleteTemporaryFilesButton;

    @FindBy(xpath = "(//span[@class='btn btn-default btn-file'])[1]") // works with click()
    //@FindBy(xpath = "//input[@id='search-upload-input']") // does not work
    //@FindBy(xpath = "(//*[@id='appForm']/div/div/span)[1]") // works with click()
    //@FindBy(xpath = "(//span)[34]") // works with click()
    public WebElement browserButtonToOpenFolder;


    //for asm2vec-clone or type1 app indexing completed message
    @FindBy(xpath = "(//h4[@id='modalStopLabel'])[2]")
    public WebElement indexingCompletedMessage;

    //for ExecClass or Type4 app indexing completed message
    @FindBy(xpath = "(//h4[@id='modalStopLabel'])[1]")
    public WebElement indexingCompletedMessageForExecClass;


    // @FindBy(xpath = "(//a)[17]")
    //@FindBy(xpath = "(//div[@class='ripple-container'])[4]")
    @FindBy(xpath = "//a[@href='#messages']")
    public WebElement binaryCompositionButton;

    @FindBy(xpath = "//textarea[@id='file_result']")
    public WebElement classFilesUploadField;

    @FindBy(xpath = "//p[@class='text-right']")
    public List<WebElement> marginFilesUnderApp;

    @FindBy(xpath = "//a/span")
    public List<WebElement> permanentLinks;

    @FindBy(xpath = "//button[@id='btn_submit']")
    public WebElement Type4Application_CreateButton;

    @FindBy(xpath = "//div[@id='index-drop-zone']")
    public WebElement fileDropZoneForExecClass_Indexing;

    @FindBy(xpath = "//button[@id='search-btn-binary']")
    public WebElement analyzeButton;

    @FindBy(xpath = "(//span[@class='progress-label'])[1]")
    public WebElement progressLabel;

    @FindBy(xpath = "//button[@id='btn-conf-index-close']")
    public WebElement indexingCompleteCloseButton;

    @FindBy(xpath = "(//button[@class='close'])[5]")
    public WebElement indexingAlertCloseX;

    @FindBy(xpath = "(//button[.='Close'])[3]")
    public WebElement indexingAlertCloseButton;



    @FindBy(xpath = "//p[@id='comp-warning-words']")
    public WebElement binaryCompositionCommandingMessage;
    //h4[.='Analyze a Binary File']

    @FindBy(xpath = "//p[@id='comp-warning-words']")
    public WebElement binaryCompositionCompletionMessage;

    @FindBy(xpath = "(//h4[@id='modalStopLabel'])[3]")
    public WebElement binaryCompositionAnalysisCompletedMessage;


    @FindBy(xpath = "(//h4[@id='modalStopLabel'])[2]")
    public WebElement classificationCompletionMessage;

    @FindBy(xpath = "//button[@id='btn-conf-comp-close']")
    public WebElement classificationCompletionCloseButton;


    @FindBy(xpath = "//button[@id='btn-conf-comp-close']")
    public WebElement binaryCompositionAnalysisCompletedCloseButton;

    @FindBy(xpath = "(//button[@type='button'])[9]")
    public WebElement indexingCompleteCloseButtonExecClass;

    @FindBy(xpath = "//select[@id='softwareClass']")
    public WebElement softwareClass;

    @FindBy(xpath = "//input[@class='form-control editabletextbox']")
    public WebElement editableTextBoxForResultsFileEditing;

    @FindBy(xpath = "//i[@class='fa fa-fw fa-check']")
    public WebElement checkBoxEditableTextBoxForResultsFileEditing;

    @FindBy(xpath = "//span[@class='editable-clear-x']")
    public WebElement clearXForResultsFileEditing;


    @FindBy(xpath = "//button[@id='btn-conf-file-del']")
    public WebElement confirmButtonForResultsFileDeleting;

    @FindBy(xpath = "//h3/a[@id='filename-change']")
    public List<WebElement> permanentLinksListForResultFiles; // only for ResultFiles, not for AppFiles.

    //@FindBy(xpath = "//small[.='Permanent Link:']")
    @FindBy(xpath = "//h2/a/span")
    public List<WebElement> permanentLinksListForApplicationFiles; // only for Applications, not for ResultFiles.


    @FindBy(xpath = "//h3/small[@style='font-size: 10pt']")
    public List<WebElement> fileTypesListForResultFiles;  // only for ResultFiles, not for AppFiles.

    //@FindBy(xpath = "//div[@class='header header-danger']")
    @FindBy(xpath = "//ul[@class='nav nav-tabs pull-left']")
    public WebElement headerForPermanentLinkResultFiles;  // only for ResultFiles

    @FindBy(xpath = "//a[@href='#details']")
    public WebElement detailsInHeaderForPermanentLinkResultFiles;  // only for ResultFiles

    @FindBy(xpath = "(//span[@class='fnspan'])[1]")
    public WebElement rowOneOfDetailsForPermanentLinkResultFiles;  // only for ResultFiles

    @FindBy(xpath = "(//a[@class='jstree-anchor'])[2]")
    public WebElement treeAnchorOfRowOfDetailsForPermanentLinkResultFiles;  // only for ResultFiles

    @FindBy(xpath = "(//i[@class='fa fa-fw  fa-object-ungroup'])[1]")
    public WebElement firstFrameUnderTreeAnchorOfRowOfDetailsResultFiles;  // only for ResultFiles

    @FindBy(xpath = "(//button[.='Close'])[3]")
    public WebElement closeButtonForFaileMessdageExecClassIndexing;


    public void login() {
        usernameBox.sendKeys(ConfigurationReader.getProperty("username"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        signInButton.click();
    }

    public void logout() throws InterruptedException {
        BrowserUtils.waitForVisibility(dropDownToggle, 1);
        dropDownToggle.click();
        Thread.sleep(2000); // must be taken out later
        logoutButton.click();
    }


    //selecting application type by index: (correct!)
    public void selectingApplicationTypeByIndex(int index) {
        Select selectingApplicationType = new Select(applicationType);

        //since, selectingApplicationType.getOptions().size() = 5;
        //I do not want to have element with index 0 (title) or 4;
        // so 5-1=4, 4+1=5, thus I get  elements indexed by 1,2,3 from [1,5).

        // selecting the application with respect to applicationIndex
        selectingApplicationType.selectByIndex(index);
        // printing options size, applicationIndex/application type info:
        System.out.println("====================Application Type Info=======================");
        System.out.println("Application type options = " + selectingApplicationType.getOptions().size());
        System.out.println(" Chosen application type index = " + index);
        System.out.println("Name of the selected application type = " + selectingApplicationType.getOptions().get(index).getText());

    }

    // choosing applicationTypeIndex:
    public int getApplicationTypeIndex() {
        BrowserUtils.waitForClickability(applicationType, 1);
        Select selectingApplicationType = new Select(applicationType);
        int applicationTypeIndex = random.nextInt(selectingApplicationType.getOptions().size() - 1) + 1;
        System.out.println("getApplicationTypeIndex() = " + applicationTypeIndex);
        return applicationTypeIndex;
    }

    // provide name and description by applicationIndex
    // 2<ApplicationName length<17: it was not written anywhere, but required!
    // Told by a developer after many applications are created.
    public void provideNameAndDescriptionByApplicationTypeIndex(int applicationTypeIndex) {

        BrowserUtils.waitForClickability(applicationType, 2);
        Select selectingApplicationType = new Select(applicationType);

        //applicationName.sendKeys(""+ selectingApplicationType.getOptions().get(applicationTypeIndex).getText() + "TestApplication" + applicationTypeIndex);
        applicationName.sendKeys("Type" + applicationTypeIndex + "TestApp");
        System.out.println("Application name: " + "Type" + applicationTypeIndex + "TestApp");
        applicationDescription.sendKeys("Type" + applicationTypeIndex + " " + selectingApplicationType.getOptions().get(applicationTypeIndex).getText() + " Test application" + " description");
    }

    // change the name of the application
    public void changingTheNameOfTheApplication(int applicationTypeIndex) {
        //original application name before change
        BrowserUtils.waitForClickability(applicationName, 1);
        System.out.println("Name of the application before editing: " + applicationName.getAttribute("value"));

        if (!applicationName.getAttribute("value").contains("Type")) {
            System.out.println("The name of the application is already changed once!");
        } else {
            // delete the old name
            BrowserUtils.waitForClickability(applicationName, 1);
            applicationName.clear();
            // provide new name and keep applicationTypeIndex
            BrowserUtils.waitForClickability(applicationName, 1);
            applicationNameFieldForEditing.sendKeys("T" + applicationTypeIndex + "TestAppModify");
            BrowserUtils.waitForClickability(applicationName, 1);
            System.out.println("New name of the application: " + applicationName.getAttribute("value"));
        }

    }


    public void choosingInstructionSet() {
        Select selectingInstructionSet = new Select(instructionsSet);
        int instructionSetIndex = random.nextInt(selectingInstructionSet.getOptions().size());

        // selecting the instructionSet with respect to instructionSetIndex
        selectingInstructionSet.selectByIndex(instructionSetIndex);

        // printing options size, instructionSetIndex/instructionSet name info:
        System.out.println("=====================choosingInstructionSet=====================");
        System.out.println("InstructionSet options = " + selectingInstructionSet.getOptions().size());
        System.out.println("Selected InstructionSet index = " + instructionSetIndex);
        System.out.println("Selected InstructionSet name = " + selectingInstructionSet.getOptions().get(instructionSetIndex).getText());

    }

    public void choosingNormalizationLevel() {
        Select selectingNormalizationLevel = new Select(normalizationLevel);
        int normalizationLevelIndex = random.nextInt(selectingNormalizationLevel.getOptions().size());

        // selecting the instructionSet with respect to instructionSetIndex
        selectingNormalizationLevel.selectByIndex(normalizationLevelIndex);

        // printing options size, instructionSetIndex/instructionSet name info:
        System.out.println("====================choosingNormalizationLevel==================");
        System.out.println("NormalizationLevel size() = " + selectingNormalizationLevel.getOptions().size());
        System.out.println("normalizationLevelIndex = " + normalizationLevelIndex);
        System.out.println("NormalizationLevel name = " + selectingNormalizationLevel.getOptions().get(normalizationLevelIndex).getText());

    }


    public void checkingPrivateApplicationCheckBox() {
        //int privateAppCheckIndex=random.nextInt(2); // 0,1;
        int privateAppCheckIndex = 0;
        // 0 not checking; 1 check
        System.out.println("================checkingPrivateApplicationCheckBox==============");
        System.out.println("privateAppCheckIndex = " + privateAppCheckIndex);
        if (privateAppCheckIndex == 1) {
            System.out.println(" 'Private Application' Box is checked");
            privateApplicationCheckBox.click();
        } else {
            System.out.println(" 'Private Application' Box is not checked");
            // Box is not checked;
        }

    }

    public void assigningUserRights() throws InterruptedException {
        Select selectingRights = new Select(userRightsDropdownForEditing);
        int rightsIndex = random.nextInt(selectingRights.getOptions().size());
        System.out.println("selectingRights - number of options = " + selectingRights.getOptions().size());
        System.out.println("rightsIndex = " + rightsIndex);
        //size=2, so index should be 0 or 1: read or write
        System.out.println("selected rights = " + selectingRights.getOptions().get(rightsIndex).getText());
        Thread.sleep(500);// must be taken out later
        selectingRights.selectByIndex(rightsIndex);
        Thread.sleep(500);// must be taken out later
        rightsAccessButton.click();

    }

    public void finishEditing() {
        //Thread.sleep(500);// must be taken out later
        BrowserUtils.waitForClickability(editApplication_UpdateButton, 1);
        editApplication_UpdateButton.click();
    }

    public void finishDeleting(int applicationIndex) throws InterruptedException {
        //confirmButtonForDeleting.click();
        //BrowserUtils.hover(confirmButtonForDeleting);
        BrowserUtils.waitForClickability(confirmButtonForDeleting, 2);
        // Thread.sleep(500);
        //confirmButtonForDeleting.sendKeys(Keys.ENTER); // work?
        //confirmButtonForDeleting.click(); // did not work
        //confirmButtonForDeleting.submit(); // did not work
        Thread.sleep(500);
        if (confirmButtonForDeleting.isDisplayed()) {
            System.out.println("confirmButtonForDeleting.isDisplayed() = " + confirmButtonForDeleting.isDisplayed());
            System.out.println("confirmButtonForDeleting.isEnabled() = " + confirmButtonForDeleting.isEnabled());

            //System.out.println("Close Button for Deleting is clicked! If you click Confirm Button, application will be deleted.");
            // to close the alarm message
            //closeButtonForDeleting.sendKeys(Keys.ENTER);

            // to confirm Delete on the alarm message
            System.out.println("Confirm Button for Deleting is clicked! ");
            confirmButtonForDeleting.sendKeys(Keys.ENTER);

        } else {
            System.out.println("Delete button did not work properly!");
        }
        // At this step, the app should have been deleted.

        BrowserUtils.waitForVisibility(applicationNameList.get(applicationIndex), 2);
        //Driver.getDriver().navigate().refresh();

    }

    public void functionSearchSelectingFile() {
        Select selectingFile = new Select(functionSearchExamples);
        selectingFile.selectByIndex(1);
        System.out.println("selected file name = " + selectingFile.getOptions().get(1).getText());

    }

    public void indexing() {
        BrowserUtils.scrollToElement(indexingTab);
        BrowserUtils.clickWithJS(indexingTab);
        Assert.assertTrue(indexingMessage.isDisplayed());
    }


    public void openTheBrowser() {
        Assert.assertTrue(browserButtonToOpenFolder.isEnabled());
        browserButtonToOpenFolder.submit();
    }

    /*
    Select selectingSoftwareClass = new Select(softwareClass);
    public int  indexForClasses=selectingSoftwareClass.getOptions().size();

     */


    public void selectingSoftwareClassByIndex(int index) {
        Select selectingSoftwareClass = new Select(softwareClass);
        selectingSoftwareClass.selectByIndex(index);

    }


}
