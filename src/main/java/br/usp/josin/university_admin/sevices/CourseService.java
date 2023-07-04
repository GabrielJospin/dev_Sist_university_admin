package br.usp.josin.university_admin.sevices;

import br.usp.josin.university_admin.entities.inter.Course;
import br.usp.josin.university_admin.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}
