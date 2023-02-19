package com.example.coreapipostoffice.service;

import com.example.coreapipostoffice.model.PostOffice;

import java.util.List;

public interface PostOfficeService {
    void sendPost(PostOffice postOffice);
    List<PostOffice> getAllPost();
    PostOffice getPostById(String postId);
    void updatePostById(String postId, PostOffice postOfficeModel);
    void deletePostById(String postId);


}
