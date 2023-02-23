package com.example.coreapipostoffice.controller;

import com.example.coreapipostoffice.model.PostOffice;
import com.example.coreapipostoffice.service.PostOfficeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostOfficeController {
    @Autowired
    private PostOfficeService postOfficeService;

    @Autowired
    Environment env;

   @GetMapping("/check")
    public String check(){
        return "postoffice-core-api is working at the port" + env.getProperty("local.server.port");

    }


    @PostMapping("/postsend")
    public ResponseEntity<String> sendPost(@Valid @PathVariable PostOffice postOffice) {
        postOfficeService.sendPost(postOffice);
        return new ResponseEntity<String>("U send post", HttpStatus.OK);
    }


    @GetMapping("/all")
    public List<PostOffice> getAllPost() {
        return postOfficeService.getAllPost();
    }

    @GetMapping("/{postId}")
    public PostOffice getPostById(@PathVariable String postId) {
        return postOfficeService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable String postId,
                                                 @Valid @RequestBody PostOffice postOffice) {
        postOfficeService.updatePostById(postId, postOffice);
        return new ResponseEntity<String>("U change details of post", HttpStatus.OK);

    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId) {
        postOfficeService.deletePostById(postId);
        return new ResponseEntity<String>("U delete post", HttpStatus.OK);
    }


}
