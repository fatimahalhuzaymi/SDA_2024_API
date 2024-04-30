package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class deleteurl21 {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com/todos/198")
                .setContentType(ContentType.JSON)
                .build();
    }
}
