package com.bfz.demo_thymeleaf.infrastructure.adapter.out.repository.jpa.specification;


import com.bfz.demo_thymeleaf.infrastructure.adapter.out.repository.jpa.entity.RoleEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author bruferper
 */

public interface IRoleEntitySpecification {

    // Find role by name
    static Specification<RoleEntity> hasNameLike(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

}
