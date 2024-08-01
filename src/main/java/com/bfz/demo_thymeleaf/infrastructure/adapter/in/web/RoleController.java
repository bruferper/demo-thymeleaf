package com.bfz.demo_thymeleaf.infrastructure.adapter.in.web;

import com.bfz.demo_thymeleaf.core.application.port.in.usecase.IRoleService;
import com.bfz.demo_thymeleaf.core.domain.model.PaginatedData;
import com.bfz.demo_thymeleaf.core.domain.model.Role;
import com.bfz.demo_thymeleaf.core.domain.model.RoleFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bruferper
 */

@Controller
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    @GetMapping
    public String getRoles(RoleFilter roleFilter, Model model) {
        PaginatedData<Role> roleData = roleService.findAll(roleFilter);
        model.addAttribute("roles", roleData.data());
        model.addAttribute("pageInfo", roleData.page());
        return "feature/role/index";
    }

}
