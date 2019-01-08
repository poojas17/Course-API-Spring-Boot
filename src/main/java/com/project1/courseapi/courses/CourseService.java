package com.project1.courseapi.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service /* marks the class as Spring Business service */
public class CourseService {

	// Best way to get an instance into a spring boot service class is
	// autowiring it
	@Autowired
	private CourseRepository courseRepository;

	// Ye autowiring se ye hua ki jb Spring courseservice ki instance bnaega toh
	// wo
	// inject krega instance of a course repository into it

	public List<Course>	getAllCourses(String topicId)
	{
		
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		
		//findAll() is an iterable so convert it into a list coz the return type is a list
		//courses array list bnadi 
		//fir find all bs iterate krega ab from the course repository
		//ek ek element tumko list mei add krna hai
		//toh woh courses::add se add krwado 
		return courses;
	}

	public Optional<Course> getCourse(String id) {

		// return courses.stream().filter(t->
		// t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
		// return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);

	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
