package com.example.springproject.repos;

import com.example.springproject.models.AdvertModel;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<AdvertModel,Long> {
    AdvertModel findById(long id);

   List<AdvertModel> findAllByType(String type);
    }

