package com.example.mdOne.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.security.SecureRandom;
import java.util.UUID;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_table")
public class Employee {

    private UUID uuid;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String f_name;
    private String m_name;
    private String email;
    private String rank;
    private Integer salary;
    private String responsibilities;
    private Long image_Id;

    public Employee(String f_name, String m_name, String rank,
                    Integer salary, String responsibilities,Long image_Id) {
        this.f_name = f_name;
        this.m_name = m_name;
        this.rank = rank;
        this.salary = salary;
        this.responsibilities = responsibilities;
        this.image_Id=image_Id;
    }

    public Employee(String f_name, String m_name, String rank, Integer salary, String responsibilities) {
        this.f_name = f_name;
        this.m_name = m_name;
        this.rank = rank;
        this.salary = salary;
        this.responsibilities = responsibilities;
    }

    public UUID getUuid() {

//        SecureRandom random=new SecureRandom();
//        long id= random.nextLong();
        UUID uuid1=UUID.randomUUID();
        return uuid1;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
