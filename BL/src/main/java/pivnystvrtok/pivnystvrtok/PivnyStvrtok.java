package pivnystvrtok.pivnystvrtok;

import java.util.List;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import pivnystvrtok.common.BaseEntity;

public class PivnyStvrtok extends BaseEntity{
	
	@JsonProperty
	private DateTime date;
	
	@JsonProperty
	private ObjectId restaurant;
	
	@JsonProperty
	private List<Vote> votes;
	
	@JsonProperty
	private State state;
	
	//TODO blog?
	
}
