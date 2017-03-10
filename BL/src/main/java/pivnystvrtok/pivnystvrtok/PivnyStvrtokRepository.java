package pivnystvrtok.pivnystvrtok;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import pivnystvrtok.user.User;


@RepositoryRestResource(path = "ps")
public interface PivnyStvrtokRepository extends MongoRepository<PivnyStvrtok, String>{
	final static String CURRENT = "{ $or: [ { state: 'VOTING' }, { state: 'VOTED' } ] ";
	
	@RestResource(path = "currentSimple", rel = "current")
	@Query(value=CURRENT +"}", fields="{ 'restaurant' : 1, 'date' : 1, 'state' : 1}")
	PivnyStvrtok findCurrentSimple();
	
	@RestResource(path = "vote")
	@Query(value=CURRENT + ", 'votes.user': ?0}",fields="{'votes.$':1}")
	PivnyStvrtok findVoteByUser(User id);
	
	@Query(value=CURRENT +"}")
	List<PivnyStvrtok> findCurrent();
	
	Page<PivnyStvrtok> findByState(States state, Pageable pageable);
}		
