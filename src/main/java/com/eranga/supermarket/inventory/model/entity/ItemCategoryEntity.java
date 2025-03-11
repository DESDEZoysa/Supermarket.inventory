package com.eranga.supermarket.inventory.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "item_category")
public class ItemCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_category_id_seq")
    @SequenceGenerator(name = "item_category_id_seq", sequenceName = "item_category_id_seq", allocationSize = 1)
    private Integer id;
    @Version
    private Long version;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "itemCategoryEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> itemEntityList;
}
