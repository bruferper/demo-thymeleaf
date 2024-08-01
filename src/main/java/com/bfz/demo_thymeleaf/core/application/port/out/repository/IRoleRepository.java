package com.bfz.demo_thymeleaf.core.application.port.out.repository;

import com.bfz.demo_thymeleaf.core.domain.model.PaginatedData;
import com.bfz.demo_thymeleaf.core.domain.model.Role;
import com.bfz.demo_thymeleaf.core.domain.model.RoleFilter;

import java.util.Optional;

/**
 * @author bruferper
 */

public interface IRoleRepository {

    PaginatedData<Role> findAll(RoleFilter filter);
    Optional<Role> findById(Integer id);
    void create(Role role);
    void update(Role role);
    void deleteById(Integer id);

}
