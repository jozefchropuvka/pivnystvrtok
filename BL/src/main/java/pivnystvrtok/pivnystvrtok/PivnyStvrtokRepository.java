package pivnystvrtok.pivnystvrtok;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PivnyStvrtokRepository extends MongoRepository<PivnyStvrtok, String>{
	
	PivnyStvrtokSimple findByState(State state);
	List<PivnyStvrtok> findByDate(DateTime dateTime);
}		
