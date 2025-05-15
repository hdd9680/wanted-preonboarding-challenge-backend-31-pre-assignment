package com.hsy.preonboarding_backend31.api.categories.repository;

import com.hsy.preonboarding_backend31.api.categories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
