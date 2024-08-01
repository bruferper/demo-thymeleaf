package com.bfz.demo_thymeleaf.core.application.port.in.usecase.impl;

import com.bfz.demo_thymeleaf.core.application.port.in.usecase.IRoleService;
import com.bfz.demo_thymeleaf.core.application.port.out.repository.IRoleRepository;
import com.bfz.demo_thymeleaf.core.domain.exception.RecordNotFoundException;
import com.bfz.demo_thymeleaf.core.domain.model.PaginatedData;
import com.bfz.demo_thymeleaf.core.domain.model.Role;
import com.bfz.demo_thymeleaf.core.domain.model.RoleFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bruferper
 */

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public PaginatedData<Role> findAll(RoleFilter filter) {
        return roleRepository.findAll(filter);
    }

    @Override
    @Transactional(readOnly = true)
    public Role findById(Integer id) {
        return roleRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Role not found"));
    }

    @Override
    @Transactional
    public void create(Role role) {
        roleRepository.create(role);
    }

    @Override
    @Transactional
    public void update(Integer id, Role role) {
        Role roleToUpdate = findById(id);
        roleToUpdate.setName(role.getName());
        roleRepository.update(roleToUpdate);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
    }

}
