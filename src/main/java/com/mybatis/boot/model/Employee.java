package com.mybatis.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer empId;

    private String empName;

    private Integer empAge;

    private Date createDate;

    public Employee(String empName, Integer empAge, Date createDate) {
        this.empName = empName;
        this.empAge = empAge;
        this.createDate = createDate;
    }
}