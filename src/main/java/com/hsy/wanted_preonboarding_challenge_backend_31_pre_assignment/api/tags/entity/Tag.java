package com.hsy.wanted_preonboarding_challenge_backend_31_pre_assignment.api.tags.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="tags")
public class Tag {

    @Id
    private Long id;

    private String name;
    private String slug;
}
