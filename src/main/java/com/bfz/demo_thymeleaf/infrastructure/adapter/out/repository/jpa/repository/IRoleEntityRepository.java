package com.bfz.demo_thymeleaf.infrastructure.adapter.out.repository.jpa.repository;

import com.bfz.demo_thymeleaf.infrastructure.adapter.out.repository.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author bruferper
 */

@Repository
public interface IRoleEntityRepository extends JpaRepository<RoleEntity, Integer>, JpaSpecificationExecutor<RoleEntity> { }
