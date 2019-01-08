package com.project1.courseapi.courses;

//import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project1.courseapi.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		/*
		 * return Arrays.asList( new Course("Spring","SF","Kool"), new
		 * Course("Math","Trigo","Jan"), new Course("Comp","Accoo","Jun")
		 * 
		 * );
		 */
		return courseService.getAllCourses(id);

		/*
		 * This course object will be converted to a JSON object by Spring Boot
		 * and will be shown in the URL localhost:8811/courses
		 * 
		 */
	}

	/*
	 * @RequestMapping("/courses/Comp") This would just map when the id ='Comp'
	 */
	@RequestMapping("/topics/{topicId}/courses/{id}") /* id is a token */
	/* the id passed is case sensitive */
	public Optional<Course> getCourse(@PathVariable String id) {
		/*
		 * PathVariable annotation will tell spring ki ye jo url mei pass hoga
		 * wo argument jaega iss function mei
		 */
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		//ye topic id k corresponding name and description ko blank ni krega
		//just assigning the course to that topic id coz we have used setTopic
		
		courseService.addCourse(course);
		/* For POST, you will not use browser to make a request */
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse( course);
		/* For POST, you will not use browser to make a request */
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		
		courseService.deleteCourse(id);
	}
}
