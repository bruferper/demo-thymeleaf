package com.bfz.demo_thymeleaf.core.domain.model;

import lombok.*;

/**
 * @author bruferper
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {

    @EqualsAndHashCode.Include
    private Integer id;
    private String name;

}
