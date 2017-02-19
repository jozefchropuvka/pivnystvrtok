package pivnystvrtok.pivnystvrtok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/svc/pivnyStvrtok"})
@ResponseBody
public class PivnyStvrtokController {
	
	@Autowired
	PivnyStvrtokService psService;
	
	@GetMapping("/simple")
	public PivnyStvrtokSimple getSimpleCurrentPivnyStvrtok(){
		return psService.getSimpleCurrent();
	}
}
