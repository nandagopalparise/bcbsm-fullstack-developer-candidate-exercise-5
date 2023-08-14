package com.demo.interview.entites;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "email")
public class Email {

    @Id
    private String id;

    public String toEmail;

    public String fileName;

    public String fromEmail;

    public String date;
}

