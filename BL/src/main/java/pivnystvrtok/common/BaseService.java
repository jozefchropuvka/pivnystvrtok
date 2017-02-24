package pivnystvrtok.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import pivnystvrtok.user.CurrentUserDetailsService;

public class BaseService<T extends BaseDocument> {
	@Autowired
	public CurrentUserDetailsService currentUserService;
	
	@Autowired
	private MongoTemplate mt;
	public MongoOperations mongoOps = mt;
	
	public T create(T document){
		mongoOps.insert(document);
		return document;
	}
	
	public T update(T document){
	BaseDocument oldEntity = mongoOps.findById(document.getId(), document.getClass());
	return document;
	}
}
