package ar.com.leogaray.relationship.manytomany.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "likedCourses")
    private List<Student> likes;

    @OneToMany(mappedBy = "course")
    private Set<CourseRating> ratings;
/*
    @OneToMany(mappedBy = "course")
    private Set<CourseRegistration> registrations;*/

    // additional properties

    public Course() {
    }

    public Course(String name) {
        this.name=name;
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

    public List<Student> getLikes() {
        return likes;
    }

    public void setLikes(List<Student> likes) {
        this.likes = likes;
    }

    public Set<CourseRating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<CourseRating> ratings) {
        this.ratings = ratings;
    }
}
