package api.tests.graphql.announcement;

import api.body.graphql.announcement.AnnouncementPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AnnouncementTest {

    @Test
    public void testGraphQL_LoginValid() {
        // 1. DIKUNCI PENUH: Menggunakan URL API GraphQL resmi dari instruksi Anda (TANPA strip)
        RestAssured.baseURI = "https://lmsb2b.do.dibimbing.id";

        // 2. DIKUNCI PENUH: Memasukkan user & password server yang baru Anda berikan
        Map<String, Object> payload = AnnouncementPayload.getLoginPayload(
                "b2bserveruser",
                "ENAcA3Sog22681sAKvih8KkpDKvF2aQ6"


        );

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/graphql") // Menembak tepat sasaran ke target https://lmsb2b.do.dibimbing.id/graphql
                .then()
                .log().all() // Mencetak log lengkap response token di konsol jika sukses
                .statusCode(200) // Memastikan server membalas dengan status HTTP 200 OK
                .body("data.login.token", notNullValue()); // Memastikan token otentikasi berhasil digenerate
    }
}
