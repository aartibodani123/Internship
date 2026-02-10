package com.example.practisecrud.repository;

import com.example.practisecrud.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface schoolRepository extends JpaRepository<School,Long> {
}
