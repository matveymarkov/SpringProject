package com.example.springproject.repos;

import com.example.springproject.models.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestModel,Long> {
}
