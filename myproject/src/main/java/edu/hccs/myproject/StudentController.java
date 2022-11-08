package edu.hccs.myproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    /**
     *   URL :  http://localhost:8080/students
     * @return all students
     * @throws IOException
     */
    @GetMapping("/students")
    public List<Student>  students() throws IOException {
        return readData();
    }

    /***
     * http://localhost:8080/student/Caleb
     * @param first_name
     * @return Student
     * @throws IOException
     */
    @GetMapping("/student/{first_name}")
    public Student  student(@PathVariable String first_name) throws IOException {
        System.out.println("search student by name : "+first_name);
        List<Student>  students = readData();
        for(Student student : students){
            if( student.getFirst_name().equalsIgnoreCase(first_name)){
                System.out.println("found "+student);
                return student;
            }
        }
        System.out.println(" Student not found "+first_name);
        return null;
    }
    //  http://localhost:8080/student?first_name=Caleb&course=courseNo
    @GetMapping("/student")
    public Student student(@RequestParam String first_name, @RequestParam String course) throws IOException {
        System.out.println("search student by first_name : "+first_name+" course : "+course);
        List<Student>  students = readData();
        for(Student student : students){
            if( student.getFirst_name().equalsIgnoreCase(student) & student.getCourses().get(0).getName().equalsIgnoreCase(course)){
                System.out.println("student found "+student);
                return student;
            }
        }
        System.out.println(" Student not found "+first_name);
        return null;
    }

    /***
     * Read the student.txt file
     * @return all the students
     * @throws IOException
     */
    public List<Student> readData() throws IOException {
        FileReader fileReader = new FileReader("/Users/Kevin/Desktop/myproject/src/main/resources/student.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Student> studentList = new ArrayList();
        List<Course> courses = new ArrayList();

        String header = bufferedReader.readLine(); // read the header
        String line = bufferedReader.readLine(); // read the first line

        while ( line != null){
            String[] data = line.split(",");// split each read line by comma
            Course course = new Course(data[2]);
            courses.add(course);
            Student student = new Student(data[0],Integer.parseInt(data[1]),courses, null);
            studentList.add(student);
            line = bufferedReader.readLine();
            course = new ArrayList();
        }
        return studentList;
    }
}
