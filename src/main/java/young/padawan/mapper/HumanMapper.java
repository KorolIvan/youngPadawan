package young.padawan.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import young.padawan.models.dto.HumanDTO;
import young.padawan.models.entity.Human;

import java.util.Collection;
import java.util.List;

/**
 * @author Ivan Korol on 6/6/2018
 */
@Mapper(componentModel = "spring")
public interface HumanMapper {
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "firstName", source = "firstName"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "age", source = "age")
    })
    HumanDTO humanToHumanDTO(Human human);
    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "firstName", source = "firstName"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "age", source = "age")
    })
    Human humanDTOToHuman(HumanDTO humanDTO);


}
