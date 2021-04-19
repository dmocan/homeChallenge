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
import static petstore.Constants.PHOTO_URL;

/**
 * Created by Daniel on 4/17/2021.
 */
public class SanityTests {
    RestAssuredClient restAssuredClient;

    @BeforeClass
    public void setup() {
        restAssuredClient = new RestAssuredClient();
    }

    Pet item = Pet.builder()
            .id(RandomStringUtils.randomNumeric(1))
            .name("Add new item")
            .category(new Category(1, "Dogs"))
            .photoUrls(Collections.singletonList(PHOTO_URL))
            .tags(Collections.singletonList(new Tag(1, "Husky")))
            .status(Status.available)
            .build();


    @Test(priority = 0)
    public void addPet() {
        Pet petResponse = restAssuredClient.addPet(item);
        assertThat(petResponse, is(samePropertyValuesAs(item)));
    }

    @Test(priority = 1)
    public void updatePet() {
        item.setName("New item name added");
        Pet petResponse = restAssuredClient.updatePet(item);
        assertThat(petResponse, is(samePropertyValuesAs(item)));
    }

    @Test(priority = 2)
    public void deletePetAndCheckIfDeleted() {
        restAssuredClient.deletePet(item);
        restAssuredClient.verifyPetDeleted(item);
    }
}
