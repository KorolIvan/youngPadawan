package young.padawan.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import young.padawan.exeption.HumanExeprion;
import young.padawan.mapper.HumanMapper;
import young.padawan.models.dto.HumanDTO;
import young.padawan.models.entity.Human;
import young.padawan.services.HumanService;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Ivan Korol on 6/1/2018
 */
@RestController
public class HumanController {
    @Autowired
    private HumanService humanService;
    @Autowired
    private HumanMapper mapper;

    @RequestMapping(method = RequestMethod.POST, value = "/human")
    @ResponseStatus(value = HttpStatus.CREATED)
    public HumanDTO addHuman(@RequestBody HumanDTO humanDTO) {
        if(humanDTO == null){
            return null;
        }
        Human human = new Human(humanDTO.getFirstName(), humanDTO.getLastName(), humanDTO.getAge());
        humanService.addHuman(human);
       return mapper.humanToHumanDTO(human);
    }
    //todo need fix this implementation because this method save new model and not update
    @RequestMapping(method = RequestMethod.PUT, value = "/human/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public HumanDTO updateHuman(@RequestBody HumanDTO humanDTO, @PathVariable String id) {
        if(humanService.getHumanById(id) == null)
            throw new HumanExeprion(id, "human hot found");
        Human fromStore = humanService.getHumanById(id);
        Human human = new Human(fromStore.getId(), humanDTO.getFirstName(), humanDTO.getLastName(), humanDTO.getAge());
        humanService.updateHuman(human, id);
        return mapper.humanToHumanDTO(human);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/human/{id}")
    public void deleteHumanById(@PathVariable String id) {
        if(humanService.getHumanById(id) == null)
            throw new HumanExeprion(id, "human hot found");
        humanService.deleteHuman(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/human/{id}")
    public HumanDTO getHumanById(@PathVariable String id) {
        if(humanService.getHumanById(id)==null)
            throw new HumanExeprion(id, "human not found");
        return mapper.humanToHumanDTO(humanService.getHumanById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/human")
    public List<HumanDTO> getAllHumans() {
        List<HumanDTO> humanDTOList = new ArrayList<>();
        for (Human h:
                humanService.getListOfHumans()) {
            humanDTOList.add(mapper.humanToHumanDTO(h));
        }
        return humanDTOList;
    }

}
