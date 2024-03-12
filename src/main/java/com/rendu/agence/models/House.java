package com.rendu.agence.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "houses")
@AllArgsConstructor
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String thumbnailUrl;
    private String description;
    private String address;
    private String zipCode;
    private String city;
    private Integer price;
    private Boolean isActive = true;
}