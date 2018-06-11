package young.padawan.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Ivan Korol on 6/5/2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HumanDTO  {

    private String id;

    @NotEmpty
    @NotNull(message = "first name cannot be blank")
    @Size(min = 2, message = "first name should have at list 2 chars")
    private String firstName;

    @NotEmpty
    @NotNull(message = "last name cannot be blank")
    @Size(min = 2, message = "last name should have at list 2 chars")
    private String lastName;

    private int age;

    public HumanDTO(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
