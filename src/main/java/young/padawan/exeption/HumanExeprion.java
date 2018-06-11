package young.padawan.exeption;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ivan Korol on 6/5/2018
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HumanExeprion extends RuntimeException {
    @Getter
    String id;
    @Getter
    String message;

    public HumanExeprion(String message) {
        this.message = message;
    }

    public HumanExeprion(String id, String message) {
        super(String.format("Human with id = %s not fount, reason is: %s", id, message ));
        this.id = id;
        this.message = message;
    }

}
