package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BookingCRUD extends TestBase {

    static String firstName = "Prime" + TestUtils.getRandomValue();
    static String lastName = "Testing" + TestUtils.getRandomValue();
    static int totalPrice;
    static boolean depositPaid;
  //  static HashMap<Object, Object> bookingdates;

    static String additionalNeeds = "Breakfast";
    static String username = "admin";
    static String password = "password123";
    static int userId;
    static String token ;
    static String updatedFirstName = "Nikunja" + TestUtils.getRandomValue();


    @Test
    public void test001() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setUsername(username);
        bookingPojo.setPassword(password);
        ValidatableResponse response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(bookingPojo)
                .post("/auth")
                .then().log().all().statusCode(200);
        token = response.extract().path("token");
    }

    @Test
    public void test002(){
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName(firstName);
        bookingPojo.setLastName(lastName);
        bookingPojo.setTotalPrice(111);
        bookingPojo.setDepositPaid(true);
       //bookingPojo.setBookingdates(checkIn,"2013-02-23");
        bookingPojo.setDepositPaid(true);
        bookingPojo.setCheckIn("2023-01-01");
        bookingPojo.setCheckOut("2023-12-01");
        bookingPojo.setAdditionalneeds(additionalNeeds);
        ValidatableResponse response = given().log().all()
                .headers("Content-Type", "application/json","Cookie", "token=" + token)
               // .header("Connection", "keep-alive")
                .when()
                .body(bookingPojo)
                .post("/booking")
                .then().log().all().statusCode(200);
        userId = response.extract().path("id");

    }

    @Test
    public void test003() {

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstName(updatedFirstName);
        bookingPojo.setLastName(lastName);
        bookingPojo.setTotalPrice(111);
        bookingPojo.setDepositPaid(true);
        bookingPojo.setCheckIn("2023-01-02");
        bookingPojo.setCheckOut("2023-12-02");
        bookingPojo.setAdditionalneeds(additionalNeeds);
        Response response = given().log().all()
                .headers("Content-Type", "application/json","Cookie", "token=" + token)
               // .header("Connection", "keep-alive")
                .when()
                .body(bookingPojo)
                .put("/booking/"+userId);
        response.then().log().all().statusCode(200);

    }

    @Test
    public void test004() {

        given().log().all()
                .headers("Content-Type", "application/json", "Cookie", "token=" + token)
                .header("Connection", "keep-alive")
                .pathParam("id", userId)
                .when()
                .get("/booking/{id}")
                .then()
                .statusCode(200);

    }

    @Test
    public void test005() {

        given()
                .headers("Content-Type", "application/json","Cookie", "token=" + token)
                //.header("Connection", "keep-alive")
                .pathParam("id", userId)
                .when()
                .delete("/booking/{id}")
                .then()
                .statusCode(201);

        given()
                .pathParam("id", userId)
                .when()
                .get("/{id}")
                .then().statusCode(404);

    }

}
