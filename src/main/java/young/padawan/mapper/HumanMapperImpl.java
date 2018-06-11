package young.padawan.mapper;

import org.springframework.stereotype.Component;
import young.padawan.models.dto.HumanDTO;
import young.padawan.models.entity.Human;

import javax.validation.constraints.NotNull;

/**
 * @author Ivan Korol on 6/6/2018
 */
@Component
public class HumanMapperImpl implements HumanMapper {

    @Override
    public HumanDTO humanToHumanDTO(@NotNull Human human) {
        if(human == null){
            return null;
        }
        HumanDTO humanDto = new HumanDTO();
        if(human.getId() != null){
            humanDto.setId(human.getId());
        }
        if(human.getFirstName()!=null){
            humanDto.setFirstName(human.getFirstName());
        }
        if(human.getLastName()!=null){
            humanDto.setLastName(human.getLastName());
        }
        if(human.getAge()!=0) {
            humanDto.setAge(human.getAge());
        }
        return humanDto;
    }

    @Override
    public Human humanDTOToHuman(HumanDTO humanDTO) {
        if(humanDTO == null) {
            return null;
        }
        Human human = new Human();
        if(humanDTO.getId()!=null){
            human.setId(humanDTO.getId());
        }
        if(humanDTO.getFirstName()!=null){
           human.setFirstName(humanDTO.getFirstName());
        }
        if(humanDTO.getLastName()!=null){
            human.setLastName(humanDTO.getLastName());
        }
        if(humanDTO.getAge()!=0) {
            human.setAge(humanDTO.getAge());
        }
        return human;
    }
}
