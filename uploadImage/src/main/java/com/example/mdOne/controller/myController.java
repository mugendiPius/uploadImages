package com.example.mdOne.controller;

import com.example.mdOne.entity.Employee;
import com.example.mdOne.entity.EmployeeModel;
import com.example.mdOne.entity.ImageData;
import com.example.mdOne.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping ("mdau/api/v1/images")
public class myController {

    @Autowired
   private EmployeeService employeeService;

    @CrossOrigin
    @PostMapping(value = "/file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImage(@RequestParam("file")MultipartFile file) throws IOException {
        String res= employeeService.uploadImage(file);

        return ResponseEntity.status(HttpStatus.OK)
                .body(res);
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> downloadImage(
            @PathVariable("id") long id) throws IOException {
        byte[] image= employeeService.downloadImage(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/jpg"))
                .body(image);
    }
    @CrossOrigin
    @PostMapping("/new_employee")
    public ResponseEntity<String> uploadEmployee(@RequestBody EmployeeModel model){

        employeeService.save(model);
        return ResponseEntity.ok("Employee saved"+model.getF_name()+" "+model.getM_name());
    }

    @CrossOrigin
    @GetMapping("/all_employees")
    public List<Employee> findALlEmployees(){
        return employeeService.findAll();
    }



    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable ("id")long id){
        employeeService.deleteCustomer(id);
        return "Delete successful"+id;
    }
    @CrossOrigin
    @PutMapping("edit/{id}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable ("id")long id,@RequestBody EmployeeModel model){
        employeeService.updateEmployee(id,model);
        return ResponseEntity.ok("Employee Update Successful");
    }
}
