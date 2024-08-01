package com.bfz.demo_thymeleaf.core.application.port.in.usecase;

import com.bfz.demo_thymeleaf.core.domain.model.PaginatedData;
import com.bfz.demo_thymeleaf.core.domain.model.Role;
import com.bfz.demo_thymeleaf.core.domain.model.RoleFilter;

/**
 * @author bruferper
 */

public interface IRoleService {

    PaginatedData<Role> findAll(RoleFilter filter);
    Role findById(Integer id);
    void create(Role role);
    void update(Integer id, Role role);
    void deleteById(Integer id);
    
}
