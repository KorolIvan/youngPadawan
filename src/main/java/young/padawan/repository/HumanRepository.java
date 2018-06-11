package young.padawan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import young.padawan.models.entity.Human;

/**
 * @author Ivan Korol on 6/1/2018
 */
@Repository
public interface HumanRepository extends MongoRepository<Human, String>{
     Human getHumanById(String id);
}
