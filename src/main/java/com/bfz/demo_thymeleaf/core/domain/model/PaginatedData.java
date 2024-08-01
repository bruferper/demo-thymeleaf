package com.bfz.demo_thymeleaf.core.domain.model;

import lombok.Builder;

import java.util.List;

/**
 * @author bruferper
 */

@Builder
public record PaginatedData<T>(
        List<T> data,
        PageInfo page
) { }
