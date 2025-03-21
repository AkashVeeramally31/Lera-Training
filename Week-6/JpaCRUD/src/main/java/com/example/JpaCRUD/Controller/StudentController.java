package com.example.JpaCRUD.Controller;

import com.example.JpaCRUD.Model.Student;
import com.example.JpaCRUD.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CRUD operations

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentRepository repo;

//    // Create (C)
//    @PostMapping
//    public String addStudent(@RequestBody Student student){
//        repo.save(student);
//        return "Student added successfully";
//    }
//
//    // Read (R)
//    @GetMapping
//    public List<Student> getStudents(){
//        return repo.findAll();
//    }
//
//    // Get by I'd
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable int id){
//        return repo.findById(id).orElse(null);
//    }
//
//    // Update (U)
//    @PutMapping("/{id}")
//    public String updateStudent(@RequestBody Student student,@PathVariable int id){
//        List<Student> students=repo.findAll();
//        for(Student stu:students){
//            if(id==stu.getId()){
//                stu.setName(student.getName());
//                stu.setEmail(student.getEmail());
//                stu.setAge(student.getAge());
//                repo.save(stu);
//            }
//        }
//        return "Student with Id:"+id+" updated successfully";
//    }
//
//    // Delete (D)
//    @DeleteMapping("/{id}")
//    public String deleteStudent(@PathVariable int id){
//        repo.deleteById(id);
//        return "Student with Id:"+id+" deleted successfully";
//    }

    // Using ResponseEntity<>()

    @PostMapping
    public String addStudent(@RequestBody Student student){
        repo.save(student);
        return "Student added successfully";
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student=repo.findById(id).orElse(null);
        if(student!=null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Student(0,"No student",null,0),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student,@PathVariable int id){
        Student student1=repo.findById(id).orElse(null);
        if(student1!=null) {
            List<Student> students = repo.findAll();
            for (Student stu : students) {
                if (id == stu.getId()) {
                    stu.setName(student.getName());
                    stu.setEmail(student.getEmail());
                    stu.setAge(student.getAge());
                    repo.save(stu);
                }
            }
            return new ResponseEntity<>("Student with Id:"+id+" updated successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Student with Id:"+id+" not found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        Student student=repo.findById(id).orElse(null);
        if(student!=null){
            repo.deleteById(id);
            // return ResponseEntity.ok("Student with Id:"+id+" Deleted successfully");
            // Also written as
            return new ResponseEntity<>("Student with Id:"+id+" Deleted successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Student with Id:"+id+" not found",HttpStatus.NOT_FOUND);
        }
    }
}
