package com.example.coreapipostoffice.service;

import com.example.coreapipostoffice.model.PostOffice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


@Service
public class PostOfficeImpl implements PostOfficeService
{
    private static final HashMap<String, PostOffice> postmap = new HashMap<>();

    static {
        PostOffice postOffice1 = new PostOffice(UUID.randomUUID().toString(),"123","2-Lamar",
                "water","доставлен" );
        PostOffice postOffice2 = new PostOffice(UUID.randomUUID().toString(),"33","123-Drake",
                "keyboard","в пути");
        PostOffice postOffice3 = new PostOffice(UUID.randomUUID().toString(),"999","777-Savage",
                "cake","посылка была утеряна");

        postmap.put(postOffice1.getPostId(), postOffice1);
        postmap.put(postOffice2.getPostId(), postOffice2);
        postmap.put(postOffice3.getPostId(), postOffice3);
    }




    @Override
    public void sendPost(PostOffice postOffice) {
       postOffice.setPostId(UUID.randomUUID().toString());
       postmap.put(postOffice.getPostId(), postOffice);
    }

    @Override
    public List<PostOffice> getAllPost() {
        return new ArrayList<>(postmap.values());
    }

    @Override
    public PostOffice getPostById(String postId) {
        return postmap.get(postId);
    }

    @Override
    public void updatePostById(String postId, PostOffice postOffice) {
      postOffice.setPostId(postId);
      postmap.put(postId, postOffice);
    }

    @Override
    public void deletePostById(String postId) {
        postmap.remove(postId);

    }
}
