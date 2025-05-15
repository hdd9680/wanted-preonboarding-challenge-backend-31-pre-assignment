package com.hsy.preonboarding_backend31.api.tags.repository;

import com.hsy.preonboarding_backend31.api.tags.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
