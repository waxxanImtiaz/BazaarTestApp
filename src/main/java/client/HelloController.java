package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private StudentService studentService;
    @RequestMapping("/list")
    public List getStudentList(){
        return studentService.getStudentsList();
    }

    @RequestMapping("/student/{id}")
    public Student getStudent(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/student")
    public String saveStudent(@RequestBody Student student){
        if (studentService.addStudent(student)){
            return "Student added successfully!";
        }
        return "Student not added";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/student")
    public String updateStudent(@RequestBody Student student){
        if (studentService.updateStudent(student)){
            return "Student updated successfully!";
        }
        return "Student not updated";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/student/{id}")
    public String saveStudent(@PathVariable String id){
        if (studentService.deleteStudent(id)){
            return "Student deleted successfully!";
        }
        return "Student not deleted";
    }



}
