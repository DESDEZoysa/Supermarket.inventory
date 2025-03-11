package com.eranga.supermarket.inventory.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "item_brand")
public class ItemBrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_brand_id_seq")
    @SequenceGenerator(name = "item_brand_id_seq", sequenceName = "item_brand_id_seq", allocationSize = 1)
    private Integer id;
    @Version
    private Long version;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private ItemEntity itemEntity;
}
