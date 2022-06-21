package requestBuilders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class GetFileMetadataRequest extends URIDefinition implements IBaseRequestBuilder {
    private final RequestSpecBuilder builder = new RequestSpecBuilder();

    public GetFileMetadataRequest(String accessToken, String path)
    {
        this.setUrl()
                .setAuthorizationHeader(accessToken)
                .setData(path)
                .setContentType();
    }
    @Override
    public RequestSpecification build()
    {
        return this.builder.build();
    }

    private GetFileMetadataRequest setUrl()
    {
        this.builder.setBaseUri(GET_METADATA_URI);
        return this;
    }

    private GetFileMetadataRequest setAuthorizationHeader(String authorizationHeader)
    {
        this.builder.addHeader("Authorization", "Bearer " + authorizationHeader);
        return this;
    }

    private JSONObject createArgJson(String path) {
        JSONObject dataJson = new JSONObject();
        dataJson.put("path", path);
        return dataJson;
    }

    private GetFileMetadataRequest setData(String path)
    {
        this.builder.setBody(createArgJson(path).toString());
        return this;
    }

    private void setContentType() {
        this.builder.setContentType(ContentType.JSON);
    }
}
