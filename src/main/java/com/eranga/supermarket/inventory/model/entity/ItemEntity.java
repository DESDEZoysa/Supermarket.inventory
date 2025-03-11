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
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    private Integer id;
    @Version
    private Long version;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "item_category_id", nullable = false)
    private ItemCategoryEntity itemCategoryEntity;
    @OneToMany(mappedBy = "itemEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemBrandEntity> itemBrandEntityList;

}
