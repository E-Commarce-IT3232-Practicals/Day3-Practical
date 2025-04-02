package lk.ac.vau.fas.ict.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {
	@GetMapping("/msg")
	public String myMessage() {
		return "Hello SpringBoot";
	}
	@GetMapping("/name")
	public String myName() {
		return "My name is SpringBoot";
	}
	
	@GetMapping("/age/{ag}")
	public String MyAge (@PathVariable("ag") int age) {
		return "My age is " + age;
	}
	
	//Create some student objects
	Student s1 = new Student("2020ICT01","Sara",25,"IT",3.5);
	Student s2 = new Student("2020ICT02","Liza",23,"AMC",3.0);
	Student s3 = new Student("2020ICT03","Ben",19,"IT",3.4);
	Student s4 = new Student("2020ICT04","Harry",25,"BIO",2.9);
	Student s5 = new Student("2020ICT05","Tom",18,"IT",3.6);
	
	private static List<Student> students = new ArrayList<Student>();
	
	public AppController() {
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
	}
	
	//Method to return object
	@GetMapping("/student")
	public Student getStudent() {
		return s1;
	}
	
	//Return multiple students
	@GetMapping("/students")
	public List<Student> getStudents() {
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		return students;
	}
	
	//Find a student from the list by regNo
	@GetMapping("/student/{id}")
	public Student getStudent (@PathVariable("id")String regno) {
		for(Student student : students) {
			if(student.getRegNo().equals(regno)) {
				return student;
			}
		}
		return null;
	}
	
	//Find the students whose age is between 20 and 23
	List<Student> studentbetweenAge  = new ArrayList<Student>();
	@GetMapping("/students/age-between")
	public List<Student> getStudentBetween() {
		for(Student student:students) {
			if(20<student.getAge() && student.getAge()<30) {
				studentbetweenAge.add(student);
			}
		}
		return studentbetweenAge;
	}
	
	//sort the students by their GPA
	@GetMapping("/students/sort-by-gpa")
    public List<Student> sortStudentsByGPA() {
        return students.stream()
                       .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()))
                       .collect(Collectors.toList());
    }
	
	//Create CRUD operations for students
	
	// Create a new student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		students.add(student);
		return student;
	}
	
	//Update
	@PutMapping("/students/{id}")
	    public Student updateStudent(@PathVariable("id") String regno, @RequestBody Student updatedStudent) {
	        for (int i = 0; i < students.size(); i++) {
	            Student student = students.get(i);
	            if (student.getRegNo().equals(regno)) {
	 
	                student.setName(updatedStudent.getName());
	                student.setAge(updatedStudent.getAge());
	                student.setCourse(updatedStudent.getCourse());
	                student.setGpa(updatedStudent.getGpa());
	                return student;
	            }
	        }
	        return null; 
	    }
	
	//Delete 
	@DeleteMapping("/students/{id}")
	    public boolean deleteStudent(@PathVariable("id") String regno) {
	        return students.removeIf(student -> student.getRegNo().equals(regno));
	    }
	
}
