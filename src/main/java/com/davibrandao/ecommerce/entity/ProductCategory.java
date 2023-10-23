package com.davibrandao.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "product_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "category_name")
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

}
