package responceValidators;

import io.restassured.response.Response;
import org.json.JSONObject;

public class ResponseMetadataValidator implements IBaseResponseValidator
{
    private final Response response;

    public ResponseMetadataValidator (Response _response)
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
                .getString(field)
                .equals(value);
    }
}
