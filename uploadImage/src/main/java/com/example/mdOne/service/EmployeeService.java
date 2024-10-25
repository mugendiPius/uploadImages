package com.example.mdOne.service;

import com.example.mdOne.dao.EmployeeRepository;
import com.example.mdOne.dao.ImageStoreRepository;
import com.example.mdOne.entity.Employee;
import com.example.mdOne.entity.EmployeeModel;
import com.example.mdOne.entity.ImageData;
import com.example.mdOne.util.CompressDecompress;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {


    private final ImageStoreRepository storeRepository;

    private final EmployeeRepository repository;

    public EmployeeService(ImageStoreRepository storeRepository, EmployeeRepository repository) {
        this.storeRepository = storeRepository;
        this.repository = repository;
    }


    @Transactional
    public String uploadImage(MultipartFile file) throws IOException {

        ImageData data=new ImageData(file.getOriginalFilename(),file.getContentType(),
                CompressDecompress.compressImage(file.getBytes()));
        storeRepository.save(data);
        return "Image upload successful : "+file.getOriginalFilename()+" "+data.getUuid();
    }
    @Transactional
    public byte[] downloadImage(long id){

        Optional<ImageData> imageData=storeRepository.findById(id);
        return imageData.map(data -> CompressDecompress.decompressImage(
                data.getImageData()
        )).orElse(null);
    }


    public List<Employee> findAll() {
        return repository.findAll();
    }

    public void save(EmployeeModel model) {
        Employee employee=new Employee();
        employee.setF_name(model.getF_name());
        employee.setM_name(model.getM_name());
        employee.setSalary(model.getSalary());
        employee.setRank(model.getRank());
        employee.setResponsibilities(model.getResponsibilities());
        employee.setImage_Id(employee.getId());

        repository.save(employee);
    }

    public void deleteCustomer(long id) {
        Optional<Employee> exist=repository.findById(id);
        if (exist.isEmpty()){
            throw new IllegalArgumentException(String.format("The employee of id %s does not exist",id));
        }
        repository.deleteById(id);
    }

    @Transactional
    public void updateEmployee(long id, EmployeeModel model) {
        Employee employee=repository.findEmployeeById(id);
        if(employee==null){
            throw new IllegalStateException(String.format("The USER OF ID %s COULD NOT BE FOUND",id));
        }
        if(model.getF_name()!=null&& !model.getF_name().isEmpty() &&
                !Objects.equals(model.getF_name(),employee.getF_name())){
            employee.setF_name(model.getF_name());
        }
        if(model.getM_name()!=null&& !model.getM_name().isEmpty() &&
                !Objects.equals(model.getM_name(),employee.getM_name())){
            employee.setM_name(model.getM_name());
        }
        if(model.getSalary()!=null &&
                !Objects.equals(model.getSalary(),employee.getSalary())){
            employee.setSalary(model.getSalary());
        }
        if(model.getRank()!=null && !model.getRank().isEmpty()&&
                !Objects.equals(model.getRank(),employee.getRank())){
            employee.setRank(model.getRank());
        }
        if(model.getResponsibilities()!=null && !model.getResponsibilities().isEmpty()&&
                !Objects.equals(model.getResponsibilities(),employee.getResponsibilities())){
            employee.setResponsibilities(model.getResponsibilities());
        }
        if(model.getEmail()!=null && !model.getEmail().isEmpty()&&
                !Objects.equals(model.getEmail(),employee.getEmail())){
            Optional<Employee> existsByEmail=repository.findEmployeeByEmail(model.getEmail());
            if (existsByEmail.isPresent()){
                throw new IllegalStateException(String.format("The email %s is already used",model.getEmail()));
            }
            employee.setEmail(model.getEmail());
        }
        repository.save(employee);
    }
}
