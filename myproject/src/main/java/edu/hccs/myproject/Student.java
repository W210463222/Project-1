package edu.hccs.myproject;
package edu.hccs.myspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {
    private int id;
    private String first_name;
    private String email;
    private String gender;
    private List<Course> course;

    public Student(int id, String first_name, String email, String gender, List<Course> course) {
        this.id = id;
        this.first_name = first_name;
        this.email = email;
        this.gender = gender;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourse() {return course;}



    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", first_name=" + first_name +
                ", email=" + email +
                ", gender=" + gender +
                '}';
    }
}
