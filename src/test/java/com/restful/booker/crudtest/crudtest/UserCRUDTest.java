package com.restful.booker.crudtest.crudtest;

import com.restful.booker.crudtest.testbase.TestBase;
import com.restful.booker.model.AuthPojo;
import com.restful.booker.model.BookingDates;
import com.restful.booker.model.RestPojo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
    static String token ="2df27fc2f35a042";

    @Test
    public void verifyUserCreatedSuccessfully() {

        RestPojo restPojo = new RestPojo();
        restPojo.setFirstname("Shaif");
        restPojo.setLastname("Coco");
        restPojo.setTotalprice("1000");
        restPojo.setDepositpaid("false");
        BookingDates bd = new BookingDates();
        bd.setCheckin("8-12-2023");
        bd.setCheckout("12-12-2023");
        restPojo.setBookingdates(bd);
        restPojo.setAdditionalneeds("M & M");
        Response response = given()
                .headers("Content-Type", "application/json", "Authorization", "Bearer " + token)
                .when()
                .body(restPojo)
                .post();
//To fetch response from server
        String responseBody = response.getBody().asString();
        response.then().log().all().statusCode(200);
        JsonPath jsonPath = new JsonPath(responseBody);
        String bookingId = jsonPath.getString("bookingid");
        System.out.println("bookingid " + bookingId);
        }
    @Test
    public void getAllBookingId() {
        Response response = given()
                .basePath("/booking")
                .header("Content-Type", "application/json")
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test()
    public void verifyUserAuthSuccessfully() {
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUserName("admin");
        authPojo.setPassword("password123");

        Response response = given()
                .basePath("/auth")
                .header("Content-Type", "application/json")
                .when()
                .body(authPojo)
                .post();
        String responseBody = response.getBody().asString();
        response.then().log().all().statusCode(200);
    }
    @Test
    public void verifyUserUpdateBookingSuccessfully() {
        RestPojo restPojo = new RestPojo();
        restPojo.setFirstname("shaif");
        restPojo.setLastname("coco");
        restPojo.setTotalprice("1000");
        restPojo.setDepositpaid("true");
        BookingDates bd = new BookingDates();
        bd.setCheckin("12-12-2023");
        bd.setCheckout("10-12-2023");
        restPojo.setBookingdates(bd);
        restPojo.setAdditionalneeds("B & B");
        Response response = given()
                .basePath(RestAssured.basePath + "/2911")
                .headers("Content-Type", "application/json", "Authorization", "Basic " + "YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .body(restPojo)
                .put();

        response.prettyPrint();
        response.then().statusCode(200);

        response.then().log().all().statusCode(200);
        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        //    int userId = jsonPath.getInt("id");
        //    System.out.println("user id " + userId);
    }
    @Test
    public void VerifyUserDeleteBookingSuccessfully() {
        //   PostsPojo postsPojo = new PostsPojo();
        Response response = given()
                .headers("Content-Type", "application/json", "Authorization", "Basic " + "YWRtaW46cGFzc3dvcmQxMjM=")
                .basePath(RestAssured.basePath + "/1")
                .when()
                .body("")
                .delete();

        response.prettyPrint();
        response.then().statusCode(201);


    }


}
