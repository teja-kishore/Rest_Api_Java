package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long>{
}
