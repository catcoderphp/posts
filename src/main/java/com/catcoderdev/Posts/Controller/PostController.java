package com.catcoderdev.Posts.Controller;

import com.catcoderdev.Posts.Entity.PostEntity;
import com.catcoderdev.Posts.Model.PostRequest;
import com.catcoderdev.Posts.Model.ResponseHandler;
import com.catcoderdev.Posts.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<ResponseHandler> create(@RequestBody PostRequest data) {
        ResponseEntity<ResponseHandler> response;
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            responseHandler.notFound();
            PostEntity postEntity = new PostEntity();
            postEntity.mapFromRequest(data);
            PostEntity created = this.postService.save(postEntity);
            responseHandler.setData(created);
            responseHandler.setMessage(HttpStatus.CREATED.toString());
            responseHandler.setError(false);
            responseHandler.setStatusCode(HttpStatus.CREATED.value());
            responseHandler.buildMetaData(1, 1, 1);
            return new ResponseEntity<>(responseHandler, HttpStatus.CREATED);
        } catch (Exception e) {
            responseHandler.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseHandler.setError(true);
            responseHandler.setData(e);
            responseHandler.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            responseHandler.buildMetaData(0, 0, 0);
            return new ResponseEntity<>(
                    responseHandler,
                    HttpStatus.valueOf(responseHandler.getStatusCode())
            );
        }
    }
}
