package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APITestsDropboxSteps {
    @Given("User place file {string} to root directory of the app")
    public void userPlaceFileToRootDirectoryOfTheApp(String arg0) {
    }

    @When("User upload file to app storage using API")
    public void userUploadFileToAppStorageUsingAPI() {
    }

    @Then("API response with file {string} metadata")
    public void apiResponseWithFileMetadata(String arg0) {
    }

    @Given("User has uploaded file {string} to the app")
    public void userHasUploadedFileToTheApp(String arg0) {
    }

    @When("User get file metadata using API")
    public void userGetFileMetadataUsingAPI() {
    }


    @Given("User has file {string} in app storage")
    public void userHasFileInAppStorage(String arg0) {
    }

    @When("User delete file from app storage using API")
    public void userDeleteFileFromAppStorageUsingAPI() {
    }

    @Then("API response with deleted file {string} metadata")
    public void apiResponseWithDeletedFileMetadata(String arg0) {
    }
}
