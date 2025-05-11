package com.hsy.preonboarding_backend31.api.categories.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;
    private String description;

    @Column(nullable = false)
    private Integer level;
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> children = new ArrayList<>();

    @Builder
    public Category(Long id, String name, String slug, String description, Integer level, String imageUrl
            , Category parent, List<Category> children) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.level = level;
        this.imageUrl = imageUrl;
        this.parent = parent;
        this.children = children;
    }
}
