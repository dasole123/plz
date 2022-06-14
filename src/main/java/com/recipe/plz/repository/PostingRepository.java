package com.recipe.plz.repository;

import com.recipe.plz.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {

    List<Posting> findAllByOrderByCreatedAtDesc();

    List<Posting> findAllByUserId(Long userId);
}