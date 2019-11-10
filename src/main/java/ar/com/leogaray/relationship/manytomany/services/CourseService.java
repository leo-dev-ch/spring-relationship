package ar.com.leogaray.relationship.manytomany.services;

import ar.com.leogaray.relationship.manytomany.model.Course;
import ar.com.leogaray.relationship.manytomany.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }
}
