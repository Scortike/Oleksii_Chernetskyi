package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import requestBuilders.DeleteFileRequest;
import requestBuilders.GetFileMetadataRequest;
import requestBuilders.IBaseRequestBuilder;
import requestBuilders.UploadFileRequest;
import responceValidators.IBaseResponseValidator;
import responceValidators.ResponseDeletedMetadataValidator;
import responceValidators.ResponseMetadataValidator;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APITestsDropboxSteps {
    private static final String ACCESS_TOKEN = "sl.BJ8GayMZv34IdPoSJX-yJ4qE5lZ5q-uCVfkEd01-8Q-uSm_qSxG-2NOXtxFJLxEbah1Muugue94flgm-HwUH-iOYpPHjt4_hujVPKGSEyhuEW238xX_Ve_rUtoxfV8jW4mzgop8";
    private static final Integer SUCCESS_CODE = 200;
    private static IBaseRequestBuilder builder;
    private static RequestSpecification request;
    private static IBaseResponseValidator validator;

    @Given("^User place file \"([^\"]*)\" to root directory of the app$")
    public void userPlaceFileToRootDirectoryOfTheApp(String fileName) throws IOException
    {
        new File(fileName).createNewFile();
        builder = new UploadFileRequest(ACCESS_TOKEN, "/"+fileName);
        request = given().spec(builder.build());
    }

    @When("User upload file to app storage using API")
    public void userUploadFileToAppStorageUsingAPI()
    {
        validator = new ResponseMetadataValidator(request.when().post());
    }

    @Then("API response with file {string} metadata")
    public void apiResponseWithFileMetadata(String fileName)
    {
        Assert.assertTrue(validator.validateCode(SUCCESS_CODE));
        Assert.assertTrue(validator.validateField("name",fileName));
    }

    @Given("User has uploaded file {string} to the app")
    public void userHasUploadedFileToTheApp(String fileName) throws IOException
    {
        if (request == null)
        {
            new File(fileName).createNewFile();
            builder = new UploadFileRequest(ACCESS_TOKEN, "/"+fileName);
            given().spec(builder.build()).post();
        }
        builder = new GetFileMetadataRequest(ACCESS_TOKEN, "/"+fileName);
        request = given().spec(builder.build());
    }

    @When("User get file metadata using API")
    public void userGetFileMetadataUsingAPI()
    {
        validator = new ResponseMetadataValidator(request.when().post());
    }


    @Given("User has file {string} in app storage")
    public void userHasFileInAppStorage(String fileName) throws IOException
    {
        if (request == null)
        {
            new File(fileName).createNewFile();
            builder = new UploadFileRequest(ACCESS_TOKEN, "/"+fileName);
            given().spec(builder.build()).post();
        }
        builder = new DeleteFileRequest(ACCESS_TOKEN, "/" + fileName);
        request = given().spec(builder.build());
    }

    @When("User delete file from app storage using API")
    public void userDeleteFileFromAppStorageUsingAPI()
    {
        validator = new ResponseDeletedMetadataValidator(request.when().post());
    }

    @Then("API response with deleted file {string} metadata")
    public void apiResponseWithDeletedFileMetadata(String fileName)
    {
        Assert.assertTrue(validator.validateCode(SUCCESS_CODE));
        Assert.assertTrue(validator.validateField("name", fileName));
    }
}
