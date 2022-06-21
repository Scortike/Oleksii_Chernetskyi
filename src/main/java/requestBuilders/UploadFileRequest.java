package requestBuilders;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.net.URISyntaxException;

import static io.restassured.config.EncoderConfig.encoderConfig;

import org.json.JSONObject;

public class UploadFileRequest extends URIDefinition implements IBaseRequestBuilder {
    private final RequestSpecBuilder builder = new RequestSpecBuilder();

    public UploadFileRequest(String accessToken, String apiArg)
    {
        this.setUrl()
                .setAuthorizationHeader(accessToken)
                .setApiArgHeader(apiArg)
                .setContentType();
    }

    @Override
    public RequestSpecification build()
    {
        return this.builder.build();
    }

    private UploadFileRequest setUrl()
    {
        this.builder.setBaseUri(UPLOAD_FILE_URI);
        return this;
    }

    private UploadFileRequest setAuthorizationHeader(String authorizationHeader)
    {
        this.builder.addHeader("Authorization", "Bearer "+authorizationHeader);
        return this;
    }

    private JSONObject createApiArgJson(String path) {
        JSONObject apiArgJson = new JSONObject();
        apiArgJson.put("path", path);
        return apiArgJson;
    }

    private UploadFileRequest setApiArgHeader(String path) {
        this.builder.addHeader("Dropbox-API-Arg",  createApiArgJson(path).toString());
        return this;
    }

    private void setContentType() {
        this.builder.setConfig(RestAssured.config()
                        .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .setContentType(ContentType.BINARY);
    }
}
