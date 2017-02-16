package com.erikcarlsten.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();

        courseRepository.findByTopicId(topicId)
                       .forEach(courses::add);

        return courses;
    }

    Course getCourse(String id) {
        return courseRepository.findOne(id);
    }

    void addCourse(Course course) {
        courseRepository.save(course);
    }

    void updateCourse(Course course) {
        courseRepository.save(course);
    }

    void deleteCourse(String id) {
        courseRepository.delete(id);
    }
}
