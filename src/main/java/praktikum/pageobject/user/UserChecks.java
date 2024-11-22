package praktikum.pageobject.user;

import io.restassured.response.ValidatableResponse;

import static org.junit.Assert.*;

public class UserChecks {
    public void checkCreated(ValidatableResponse response){
        boolean created = response
                .assertThat()
                .statusCode(200)
                .extract()
                .path("success");

        assertTrue(created);
    }

    public String checkLoggedIn(ValidatableResponse loginResponse){
        String token = loginResponse
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");
        assertNotNull(token);
        return token;
    }
    public String check401ErrorLoggedIn(ValidatableResponse loginResponse){
        String token = loginResponse
                .assertThat()
                .statusCode(401)
                .extract()
                .path("token");
        assertNull(token);
        return token;
    }

    public void deleteUser(ValidatableResponse loginResponse){
        String message = loginResponse
                .assertThat()
                .statusCode(202)
                .extract()
                .path("message");
        assertEquals(message,"User successfully removed");
    }


}
