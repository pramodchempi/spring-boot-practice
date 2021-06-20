package com.pramod.studentrestapi.repos;

import com.pramod.studentrestapi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
