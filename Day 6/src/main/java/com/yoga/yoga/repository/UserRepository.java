package com.yoga.yoga.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yoga.yoga.model.enumerate.Role;
import com.yoga.yoga.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    Optional<User> findByEmail(String username);

    User findByUid(Long uid);

    void deleteByUid(Long uid);

    List<User> findByRole(Role role);

    long countByAcademy_AcademyId(Long academyId);
}
