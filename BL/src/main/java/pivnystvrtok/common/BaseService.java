package pivnystvrtok.common;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;

import pivnystvrtok.pivnystvrtok.PivnyStvrtokRepository;
import pivnystvrtok.user.CurrentUserDetailsService;

public class BaseService<T extends BaseDocument> {
	@Autowired
	public CurrentUserDetailsService currentUserService;
	@Autowired
	public PivnyStvrtokRepository repository;
	
	@Autowired
	private MongoTemplate mt;
	public MongoOperations mongoOps = mt;
	
	public T create(T document){
		mongoOps.insert(document);
		return document;
	}
	
/*	public T updateFirst(String id, Model document){
		BaseDocument oldDocument = mongoOps.findById(id, document.getClass());
		mongoOps.
	return document;
	}*/
}
