package young.padawan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import young.padawan.models.Human;
import young.padawan.repository.HumanRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Ivan Korol on 6/1/2018
 */
@Service
public class HumanService {
    @Autowired
    private HumanRepository humanRepository;

    public Optional<Human> addHuman(Human human) {
        humanRepository.save(human);
        return Optional.ofNullable(human);
    }

    public void updateHuman(Human human, String id) {
        humanRepository.save(human);
    }

    public void deleteHuman(String id) {
        humanRepository.deleteById(id);
    }

    public Optional<Human> getHumanById(String id) {
        return humanRepository.findById(id);
    }

    public List<Human> getListOfHumans() {
        List<Human> humanList = new ArrayList<>();
        humanList.addAll(humanRepository.findAll());
        return humanList;
    }
}
