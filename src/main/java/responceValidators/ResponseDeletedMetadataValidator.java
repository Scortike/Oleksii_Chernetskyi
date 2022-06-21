package responceValidators;

import io.restassured.response.Response;
import org.json.JSONObject;

public class ResponseDeletedMetadataValidator implements IBaseResponseValidator
{
    private final Response response;

    public ResponseDeletedMetadataValidator(Response _response)
    {
        this.response = _response;
    }

    @Override
    public Boolean validateCode(Integer code)
    {
        return this.response.getStatusCode() == code;
    }

    @Override
    public Boolean validateField(String field, String value)
    {
        return new JSONObject(this.response.getBody().asPrettyString())
                .getJSONObject("metadata")
                .getString(field)
                .equals(value);
    }
}
