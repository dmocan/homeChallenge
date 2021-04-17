package test;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import petstore.RestAssuredClient;
import petstore.models.Category;
import petstore.models.Pet;
import petstore.models.Status;
import petstore.models.Tag;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

/**
 * Created by Daniel on 4/17/2021.
 */
public class SanityTests {
    private static final String PHOTO_URL = "https://pisicutesicaini.ro/wp-content/upsloads/2019/07/258861-1600x1067-dog-in-water1.jpg";
    RestAssuredClient restAssuredClient;

    @BeforeClass
    public void prepareData() {
        restAssuredClient = new RestAssuredClient();
    }

    Pet pet = Pet.builder()
            .id(RandomStringUtils.randomNumeric(1))
            .name("New Pet")
            .category(new Category(1, "Dogs"))
            .photoUrls(Collections.singletonList(PHOTO_URL))
            .tags(Collections.singletonList(new Tag(1, "Husky")))
            .status(Status.available)
            .build();


    @Test(priority = 0)
    public void addPet() {
        Pet petResponse = restAssuredClient.addPet(pet);
        assertThat(petResponse, is(samePropertyValuesAs(pet)));
    }

    @Test(priority = 1)
    public void updatePet() {
        pet.setName("New pet name added");
        Pet petResponse = restAssuredClient.updatePet(pet);
        assertThat(petResponse, is(samePropertyValuesAs(pet)));
    }

    @Test(priority = 2)
    public void deletePetAndCheckIfDeleted() {
        restAssuredClient.deletePet(pet);
        restAssuredClient.verifyPetDeleted(pet);
    }
}
