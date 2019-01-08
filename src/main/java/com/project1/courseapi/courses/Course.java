package com.project1.courseapi.courses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.project1.courseapi.topic.Topic;

@Entity
public class Course {

	@Id // to tell ki Id is the primary key
	private String id;
	private String name;

	private String description;
	@ManyToOne
	private Topic topic;
	//this topic is like a foreign key..
	//course table is mapping to the topic table's primary key 
	

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Course() {

	}

	public Course(String id, String name, String description,String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic=new Topic(topicId,"","");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
