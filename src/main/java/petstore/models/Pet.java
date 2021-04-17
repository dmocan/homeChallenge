package petstore.models;

import lombok.*;
import lombok.experimental.NonFinal;

import java.util.List;

/**
 * Created by Daniel on 4/17/2021.
 */


@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Builder(toBuilder = true, builderClassName = "builder")
public class Pet {
    Status status;

    Category category;

    List<String> photoUrls;

    List<Tag> tags;

    String id;

    @NonFinal
    private String name;

    public void setName(String name) {
        this.name = name;
    }


}
