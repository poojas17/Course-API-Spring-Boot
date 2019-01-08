package com.project1.courseapi.topic;

//import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		/*return Arrays.asList(
				new Topic("Spring","SF","Kool"),
				new Topic("Math","Trigo","Jan"),
				new Topic("Comp","Accoo","Jun")
				
				); */
		return topicService.getAllTopics();
		
		/* This topic object will be converted to a JSON object by Spring Boot and 
		 * will be shown in the URL localhost:8811/topics
		 * 
		 */
	}
/*	@RequestMapping("/topics/Comp") This would just map when the id ='Comp' */
	@RequestMapping("/topics/{id}")	/* id is a token*/
	/* the id passed is case sensitive */
	public Optional<Topic> getTopic(@PathVariable String id)
	{
		/* PathVariable annotation will tell spring ki ye jo url mei pass hoga 
		 * wo argument jaega iss function mei
		 */
	return topicService.getTopic(id);	
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
		/* For POST, you will not use browser to make a request */
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id)
	{
		topicService.updateTopic(id,topic);
		/* For POST, you will not use browser to make a request */
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
	
	 topicService.deleteTopic(id);	
	}
}
