package com.catcoderdev.Posts.Services;

import com.catcoderdev.Posts.Entity.PostEntity;
import com.catcoderdev.Posts.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostEntity findBySeo(String seo) {
        return this.postRepository.findBySeo(seo);
    }

    public Optional<PostEntity> findById(int id) {
        return this.postRepository.findById(id);
    }

    public PostEntity save(PostEntity postEntity) {
        return this.postRepository.save(postEntity);
    }

    public Iterable<PostEntity> findAll() {
        return this.postRepository.findAll();
    }

    public Iterable<PostEntity> findAll(org.springframework.data.domain.Pageable pageable) {
        return this.postRepository.findAll(pageable);
    }

    public Iterable<PostEntity> findAll(Sort sort) {
        return this.postRepository.findAll(sort);
    }

}
