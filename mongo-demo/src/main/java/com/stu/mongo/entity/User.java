package com.stu.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 86177
 */
@Data
@Document("user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String username;

    private String password;

}
