package com.example.mdOne.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    private String f_name;
    private String m_name;
    private String email;
    private String rank;
    private Integer salary;
    private String responsibilities;

}
