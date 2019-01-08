package com.project1.courseapi.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

	/*
	 * Always follow CAMEL CASE CrudRepository - extend this as it has all
	 * common methods
	 * 
	 * just implement special methods
	 * 
	 * // getAllTopics // getTopic(String id) // updateTopic(Topic t) //
	 * deleteTopic(String id)
	 * 
	 * // Interface mei bs method declarations toh /* spring data JPA
	 * framework-> look at ur method name from here and woh khud he figure out
	 * krega ki kya implementation chaiye based on the name of ur method
	 * 
	 */

	/*
	 * method - tk the topic id and returns the courses list / public
	 * List<Course> getCoursesByTopic(String topicId);
	 * 
	 * public List<Course> findByTopic(String topicId); Agr "Topic" ek string
	 * hoti instead of object toh it would have been easy but it's not Toh hum
	 * we have to dig inside the Topic class and uske fields specify krne honge
	 */ public List<Course> findByTopicId(String topicId);
	
	 
	 /* Simple examples for example : You want to find the courses by name
	 * public List<Course> getCoursesByName(String name);
	 * 
	 * sare methods JPA mei jinme kch dhundhna..there'a particular naming
	 * convention start with "find" Koi condition hai to "By" Property jisse u
	 * want it to be filtered "Name"
	 */
	public List<Course> findByName(String name);
	/*
	 * Ab tumko...ye implement ni krna..tum service.java mei jao..bs function
	 * bna hua milega courseRepository.findByName(name)
	 */

	/*
	 * You want a method to return all the courses which has a particular
	 * description as a String
	 */
	public List<Course> findByDescription(String desc);
	/*
	 * Spring JPA will see ki "findBy" ke baad kya hai... it's Description
	 * here..toh woh dekhega ki kya iss naam ki field humari class mei hai ya ni
	 * jo bhi hum argument pass krenge toh woh match krega in the Description
	 * column of the database and return krdega woh courses jo match krrhe
	 * 
	 */

}
