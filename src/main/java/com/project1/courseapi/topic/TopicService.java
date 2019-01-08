package com.project1.courseapi.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service		/* marks the class as Spring Business service */
public class TopicService {

	//Best way to get an instance into a spring boot service class is 
	//autowiring it 
	@Autowired
	private TopicRepository topicRepository;
	
	//Ye autowiring se ye hua ki jb Spring Topicservice ki instance bnaega toh wo
	//inject krega instance of a topic repository into it
	

	public List<Topic>	getAllTopics()
	{
	
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		
		//findAll() is an iterable so convert it into a list coz the return type is a list
		//topics array list bnadi 
		//fir find all bs iterate krega ab from the topic repository
		//ek ek element tumko list mei add krna hai
		//toh woh topics::add se add krwado 
		return topics;
	}
	public Optional<Topic> getTopic(String id)
	{
		//return topics.stream().filter(t->	t.getId().equals(id)).findFirst().get();
		 return topicRepository.findById(id);
		//return topicRepository.findOne(id);
	}
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
		
	}
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
