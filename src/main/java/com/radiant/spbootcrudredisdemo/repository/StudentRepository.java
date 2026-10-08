package com.radiant.spbootcrudredisdemo.repository;


import com.radiant.spbootcrudredisdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
