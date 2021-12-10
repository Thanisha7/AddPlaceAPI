import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Tests {
    @Test
    public void addPlace()
    {
        AddPlace a=new AddPlace();
        a.setAccuracy(50);
        a.setName("Frontline house");
        a.setAddress("29, side layout, cohen 09");
        a.setPhone_number("(+91) 983 893 3937");
        a.setWebsite("http://google.com");
        a.setLanguage("French-IN");
        List<String> list=new ArrayList<>();
        list.add("shoe park");
        list.add("shop");
        a.setTypes(list);
        Location l=new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        a.setLocation(l);
        RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addQueryParam("key","qaclick123").setContentType(ContentType.JSON).build();
        ResponseSpecification resp=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        Response res=given().spec(req)
                .body(a)
                .post("maps/api/place/add/json").then().spec(resp).extract().response();
        System.out.println(res.asString());
    }
}
