package com.project1.courseapi.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository <Topic, String>
{

	
	//CrudRepository - extend this as it has all common methods
	// just implement special methods
	
	//getAllTopics
	//getTopic(String id)
	//updateTopic(Topic t)
	//deleteTopic(String id)
}
