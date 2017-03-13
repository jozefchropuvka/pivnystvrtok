package pivnystvrtok.pivnystvrtok;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/ps"})
@ResponseBody
public class PivnyStvrtokController {
	@Autowired
	PivnyStvrtokService service;
	
	@PostMapping(value="/vote")
	public Vote submitVote(@RequestBody Resource<Vote> resource){
		Vote vote = resource.getContent();
		return service.submitVote(vote);
	}
	
	@GetMapping(value="/vote")
	public Vote vote(){
		return service.getVote();
	}
	
	@GetMapping(value="/allowedDates")
	public List<DateTime> allowedDates(){
		return service.allowedDates();
	}
	
	@MessageMapping("/posts")
	@SendTo("/topic/posts")
	public List<Post> greeting(Post post) throws Exception {
	    return service.submitPost(post);
	}
	
}
