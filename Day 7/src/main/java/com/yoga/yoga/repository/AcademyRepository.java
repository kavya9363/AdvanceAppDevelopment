package com.yoga.yoga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoga.yoga.model.Academy;

public interface AcademyRepository extends JpaRepository<Academy,Integer>{

    Optional<Academy> findByAcademyId(Long academyId);

    void deleteByAcademyId(Long academyId);

    boolean existsByAcademyId(Long academyId);

    Optional<Academy> findByAcademyName(String academyName);
}
