package com.catcoderdev.Posts.Controller;

import com.catcoderdev.Posts.Model.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @GetMapping("/all/{id}")
    public ResponseEntity<ResponseHandler> get(
            @PathVariable(value = "id", required = true) int id
    ) {
        ResponseEntity<ResponseHandler> response;
        ResponseHandler responseHandler = new ResponseHandler();
        if (id != 0) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("test", "hello");
            data.put("test2", new ArrayList<>());
            responseHandler.setError(false);
            responseHandler.setMessage("OK");
            responseHandler.setStatusCode(200);
            responseHandler.setData(data);
            response = new ResponseEntity<ResponseHandler>(responseHandler, HttpStatus.valueOf(responseHandler.getStatusCode()));
        } else {
            responseHandler.notFound();
            response = new ResponseEntity<ResponseHandler>(responseHandler, HttpStatus.valueOf(responseHandler.getStatusCode()));
        }
        return response;
    }
}
