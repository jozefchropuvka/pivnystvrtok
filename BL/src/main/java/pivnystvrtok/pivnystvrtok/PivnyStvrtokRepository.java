package pivnystvrtok.pivnystvrtok;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import pivnystvrtok.statemachine.States;


@RepositoryRestResource(path = "ps")
public interface PivnyStvrtokRepository extends MongoRepository<PivnyStvrtok, String>{
	@RestResource(path = "currentSimple", rel = "current")
	@Query(value="{ $or: [ { state: 'VOTING' }, { state: 'VOTED' } ], }", fields="{ 'restaurant' : 1, 'date' : 1, 'state' : 1}")
	PivnyStvrtok findCurrentSimple();
	
	@Query(value="{ $or: [ { state: 'VOTING' }, { state: 'VOTED' } ] }")
	List<PivnyStvrtok> findCurrent();
	
	List<PivnyStvrtok> findByState(States state);
}		
