package com.example.mdOne.dao;

import com.example.mdOne.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageStoreRepository extends JpaRepository<ImageData,Long> {


    Optional<ImageData> findById(long id);
}
