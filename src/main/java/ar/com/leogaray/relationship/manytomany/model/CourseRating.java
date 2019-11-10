package ar.com.leogaray.relationship.manytomany.model;

import javax.persistence.*;

@Entity
@Table(name = "course_rating")
public class CourseRating {

    @EmbeddedId
    private CourseRatingId id;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "rating")
    private int rating;

    public CourseRating() {
    }

    public CourseRating(Student student, Course course, int rating) {
        this.student = student;
        this.course = course;
        this.rating = rating;
    }

    public CourseRatingId getId() {
        return id;
    }

    public void setId(CourseRatingId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}