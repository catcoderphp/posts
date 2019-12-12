package com.catcoderdev.Posts.Repository;

import com.catcoderdev.Posts.Entity.PostEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<PostEntity, Integer> {
    PostEntity findBySeo(String seo);
}