package com.interview.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document("product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class ProductEntity {

    @Id
    public String id;

    public String name;

    public int quantity;

}
