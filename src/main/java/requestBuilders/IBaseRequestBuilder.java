package requestBuilders;

import io.restassured.specification.RequestSpecification;

public interface IBaseRequestBuilder {
    RequestSpecification build();
}
