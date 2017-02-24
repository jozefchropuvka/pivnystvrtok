package pivnystvrtok.pivnystvrtok;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;

import pivnystvrtok.statemachine.States;

public interface PivnyStvrtokRepository extends MongoRepository<PivnyStvrtok, String>{
	PivnyStvrtok findByState(States state);
	List<PivnyStvrtok> findByDate(DateTime dateTime);
}		
