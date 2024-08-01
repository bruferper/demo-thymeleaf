package com.bfz.demo_thymeleaf.infrastructure.adapter.out.repository.jpa.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(nullable = false, length = 50)
    private String name;

}
