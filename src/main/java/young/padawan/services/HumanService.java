package young.padawan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import young.padawan.models.entity.Human;
import young.padawan.repository.HumanRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Korol on 6/1/2018
 */
@Service
public class HumanService {
    @Autowired
    private HumanRepository humanRepository;

    public Human addHuman(Human human) {
        return humanRepository.save(human);
    }

    public Human updateHuman(Human human, String id) {
//        humanRepository.findById(id);
//        Human update = human;
        return humanRepository.save(human);
    }

    public void deleteHuman(String id) {
        humanRepository.deleteById(id);
    }

    public Human getHumanById(String id) {
        return humanRepository.getHumanById((id));
    }

    public List<Human> getListOfHumans() {
        List<Human> humanList = new ArrayList<>();
        humanList.addAll(humanRepository.findAll());
        return humanList;
    }
}
