package com.bfz.demo_thymeleaf.core.domain.model;

import lombok.Builder;

/**
 * @author bruferper
 */

@Builder
public record PageInfo(
        Integer size,
        Integer number,
        Integer totalPages,
        Long totalElements,
        String url
) { }
