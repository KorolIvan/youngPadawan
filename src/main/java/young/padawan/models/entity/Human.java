package young.padawan.models.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author Ivan Korol on 6/1/2018
 */

@Document(collection = "human")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Human {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
