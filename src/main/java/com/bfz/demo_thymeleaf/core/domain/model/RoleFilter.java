package com.bfz.demo_thymeleaf.core.domain.model;

import lombok.AllArgsConstructor;

import java.util.Objects;

/**
 * @author bruferper
 */

@AllArgsConstructor
public class RoleFilter {

    private Integer page;
    private Integer size;
    private String name;

    public Integer getPage() {
        return Objects.isNull(page) ? 0 : page;
    }

    public Integer getSize() {
        return Objects.isNull(size) ? 5 : size;
    }

    public String getName() {
        return name;
    }

}

