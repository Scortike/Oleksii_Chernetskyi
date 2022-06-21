package requestBuilders;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.net.URI;

public class DeleteFileRequest implements IBaseRequestBuilder{
    private final RequestSpecBuilder builder = new RequestSpecBuilder();
    protected final URI DELETE_FILE_URI = URI.create("https://api.dropboxapi.com/2/files/delete_v2");

    public DeleteFileRequest(String accessToken, String path)
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

    private DeleteFileRequest setUrl()
    {
        this.builder.setBaseUri(DELETE_FILE_URI);
        return this;
    }

    private DeleteFileRequest setAuthorizationHeader(String authorizationHeader)
    {
        this.builder.addHeader("Authorization", "Bearer " + authorizationHeader);
        return this;
    }

    private JSONObject createArgJson(String path) {
        JSONObject dataJson = new JSONObject();
        dataJson.put("path", path);
        return dataJson;
    }

    private DeleteFileRequest setData(String path)
    {
        this.builder.setBody(createArgJson(path).toString());
        return this;
    }

    private void setContentType() {
        this.builder.setContentType(ContentType.JSON);
    }
}
