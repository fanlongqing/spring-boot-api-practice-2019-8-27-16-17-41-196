package com.tw.apistackbase.controller;


import com.tw.apistackbase.model.Empolyees;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("employees")
public class EmployeesController {
    private  static List<Empolyees> employees =new ArrayList<Empolyees>(){
        {
            add(new Empolyees(1, "xiaoming", 20, "male"));
            add(new Empolyees(2, "xiaohong", 12, "female"));
            add(new Empolyees(3, "xiaobai", 13, "male"));
            add(new Empolyees(4, "xiaosheng", 42, "female"));
            add(new Empolyees(5, "xiaocui", 11, "male"));
        }
    };
    //获取男性员工
    @GetMapping("/{gender}")
    public ResponseEntity<List<Empolyees>>  getEmployees(@PathVariable String gender) {
        List <Empolyees> employees2=new ArrayList<>();
        for (Empolyees employeeItem:employees){
            if(employeeItem.getGender().equals(gender)){
                  employees2.add(employeeItem);
            }
        }
        return  ResponseEntity.ok(employees2);
    }



}
