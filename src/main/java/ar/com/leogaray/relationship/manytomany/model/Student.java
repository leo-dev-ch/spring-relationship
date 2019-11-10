package ar.com.leogaray.relationship.manytomany.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "course_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> likedCourses;

    @OneToMany(mappedBy = "student", fetch=FetchType.LAZY)
    private List<CourseRating> ratings;
/*
    @OneToMany(mappedBy = "student")
    private Set<CourseRegistration> registrations;*/

    // additional properties

    public Student() {
    }

    public Student(String name) {
        this.name=name;
        likedCourses = new ArrayList<>();
        ratings = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getLikedCourses() {
        return likedCourses;
    }

    public void setLikedCourses(List<Course> likedCourses) {
        this.likedCourses = likedCourses;
    }
    public void addCourse(Course course){
        this.likedCourses.add(course);
    }

    public List<CourseRating> getRatings() {
        return ratings;
    }

    public void setRatings(List<CourseRating> ratings) {
        this.ratings = ratings;
    }
    public void addRatings(CourseRating rating){
        this.ratings.add(rating);
    }
}
