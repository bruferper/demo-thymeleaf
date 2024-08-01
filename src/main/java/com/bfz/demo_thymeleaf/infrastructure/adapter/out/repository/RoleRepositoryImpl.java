package com.bfz.demo_thymeleaf.infrastructure.adapter.out.repository;

import com.bfz.demo_thymeleaf.core.application.port.out.repository.IRoleRepository;
import com.bfz.demo_thymeleaf.core.domain.model.PageInfo;
import com.bfz.demo_thymeleaf.core.domain.model.PaginatedData;
import com.bfz.demo_thymeleaf.core.domain.model.Role;
import com.bfz.demo_thymeleaf.core.domain.model.RoleFilter;
import com.bfz.demo_thymeleaf.infrastructure.adapter.out.repository.jpa.entity.RoleEntity;
import com.bfz.demo_thymeleaf.infrastructure.adapter.out.repository.jpa.repository.IRoleEntityRepository;
import com.bfz.demo_thymeleaf.infrastructure.adapter.out.repository.jpa.specification.IRoleEntitySpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author bruferper
 */

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements IRoleRepository {

    private final IRoleEntityRepository roleEntityRepository;

    @Override
    public PaginatedData<Role> findAll(RoleFilter filter) {
        Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize());

        Page<RoleEntity> rolePage = roleEntityRepository.findAll(getRoleEntitySpecification(filter), pageable);

        PageInfo pageInfo = PageInfo.builder()
                .number(rolePage.getNumber())
                .size(rolePage.getSize())
                .totalPages(rolePage.getTotalPages())
                .totalElements(rolePage.getTotalElements())
                .url("roles")
                .build();

        List<Role> roleList = rolePage.getContent().stream()
                .map(roleEntity -> Role.builder().id(roleEntity.getId()).name(roleEntity.getName()).build())
                .toList();

        return PaginatedData.<Role>builder()
                .data(roleList)
                .page(pageInfo)
                .build();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleEntityRepository.findById(id)
                .map(roleEntity -> Role.builder().id(roleEntity.getId()).name(roleEntity.getName()).build())
                .or(Optional::empty);
    }

    @Override
    public void create(Role role) {
        RoleEntity roleEntity = RoleEntity.builder().name(role.getName()).build();
        roleEntityRepository.save(roleEntity);
    }

    @Override
    public void update(Role role) {
        RoleEntity roleEntity = RoleEntity.builder().id(role.getId()).name(role.getName()).build();
        roleEntityRepository.save(roleEntity);
    }

    @Override
    public void deleteById(Integer id) {
        roleEntityRepository.deleteById(id);
    }

    private Specification<RoleEntity> getRoleEntitySpecification(RoleFilter filter) {
        Specification<RoleEntity> spec = Specification.where(null);
        if(Objects.nonNull(filter.getName())) {
            spec = spec.and(IRoleEntitySpecification.hasNameLike(filter.getName()));
        }
        return spec;
    }

}
