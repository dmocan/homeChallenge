package petstore;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import petstore.models.Pet;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static petstore.Constants.PET_ENDPOINT;
import static petstore.Constants.baseURI;

/**
 * Created by Daniel on 4/17/2021.
 */


public class RestAssuredClient {
    private RequestSpecification requestSpec;

    public RestAssuredClient() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpec = requestSpecBuilder.build();
    }


    public Pet addPet(Pet pet) {
        return given(requestSpec)
                .body(pet)
                .post(PET_ENDPOINT).as(Pet.class);
    }

    public Pet updatePet(Pet pet) {
        return given(requestSpec)
                .body(pet)
                .put(PET_ENDPOINT).as(Pet.class);
    }

    public void deletePet(Pet pet) {
        given(requestSpec)
                .pathParam("petId", pet.getId())
                .delete(PET_ENDPOINT + "/{petId}")
                .then()
                .body(containsString("Pet deleted"));
    }

    public void verifyPetDeleted(Pet pet) {
        given(requestSpec)
                .pathParam("petId", pet.getId())
                .get(PET_ENDPOINT + "/{petId}")
                .then()
                .body(containsString("Pet not found"));
    }
}