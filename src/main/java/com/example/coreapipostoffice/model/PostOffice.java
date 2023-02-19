package com.example.coreapipostoffice.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostOffice {
    @NotNull(message = "Id cannot be empty")
    private String postId;
    @NotNull(message = "Id cannot be empty")
    private String clientId;
    @NotNull(message = "Id cannot be empty")
    private String postRecipientId;
    @NotNull
    private String postItem;
    private String status;

}
