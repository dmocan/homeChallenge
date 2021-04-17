package petstore.models;

import lombok.*;

/**
 * Created by Daniel on 4/17/2021.
 */

public enum Status {

    available("available"),
    pending("pending"),
    sold("sold");

    private String value;

    Status (String value) {
        this.value = value;
    }
}
