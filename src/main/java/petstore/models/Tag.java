package petstore.models;

import lombok.*;

/**
 * Created by Daniel on 4/17/2021.
 */

@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Builder(toBuilder = true, builderClassName = "builder")
public class Tag {

    int id;
    String name;
}
