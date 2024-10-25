package com.example.mdOne.config;

import com.example.mdOne.dao.EmployeeRepository;
import com.example.mdOne.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final EmployeeRepository repository;
    @Bean
    public CommandLineRunner runner(EmployeeRepository repo){
        return args -> {



           // newEmployees(repo);
        };
    }

    private static void newEmployees(EmployeeRepository repo) {
        Employee em=new Employee("Mdau","Pius","CEO",700000,
                "Overseeing Over All Operations and Representing Org to the outside");
        Employee em1=new Employee("Mkuu","Tony","IT guy",75000,
                 "Taking care of technological needs of the organisation");
        Employee em2=new Employee("Steph","Irene","employee",100000,
                "Takes care of phychological needs of the fellow employees");
        Employee em3=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em4=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em5=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em6=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em7=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em8=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em9=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em10=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em11=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em12=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em13=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em14=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em15=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em16=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em17=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em18=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em19=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em20=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em21=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em22=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        Employee em23=new Employee("Njeri","Xtine","CEO",705000,
                "I in charge of beauty needs of the organisation landscape");
        repo.saveAll(List.of(em,em1,em2,em3,em4,em5,em6,em7,em8,em9,em10,em11,em12,em13,em14,em15,em16,em17,em18,em19,em20,em21,em22,em23));
    }
}
