package DTO_CURD.demo.repository;

import DTO_CURD.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Students, Long> {



}
