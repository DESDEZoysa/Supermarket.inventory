package com.eranga.supermarket.inventory.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "brand_batch")
public class BrandBatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_batch_id_seq")
    @SequenceGenerator(name = "brand_batch_id_seq", sequenceName = "brand_batch_id_seq", allocationSize = 1)
    private Integer id;
    @Version
    private Long version;
    @Column(name = "made_in_date", nullable = false)
    private String madeInDate;
    @Column(name = "expairy_date", nullable = false)
    private String expairyDate;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "unit_price", nullable = false)
    private Integer unitPrice;
    @ManyToOne
    @JoinColumn(name = "item_brand_id", nullable = false)
    private ItemBrandEntity itemBrandEntity;
}
