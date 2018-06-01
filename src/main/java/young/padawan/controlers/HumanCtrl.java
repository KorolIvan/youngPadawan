package young.padawan.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import young.padawan.models.Human;
import young.padawan.services.HumanService;

import java.util.List;
import java.util.Optional;

/**
 * @author Ivan Korol on 6/1/2018
 */
@RestController
public class HumanCtrl {
    @Autowired
    private HumanService humanService;

    @RequestMapping(method = RequestMethod.POST, value = "/human")
    public Optional<Human> addHuman(@RequestBody Human human) {
        humanService.addHuman(human);
        return Optional.ofNullable(human);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/human/{id}")
    public void updateHuman(@RequestBody Human human, @PathVariable String id) {
        humanService.updateHuman(human, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/human/{id}")
    public void deleteHumanById(@PathVariable String id) {
        humanService.deleteHuman(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/human/{id}")
    public Optional<Human> getHumanById(@PathVariable String id) {
        return humanService.getHumanById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/human")
    public List<Human> getAllHumans() {
        return humanService.getListOfHumans();
    }
}
