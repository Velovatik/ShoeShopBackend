package com.velov.shoeshop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String title;

    @JdbcTypeCode(SqlTypes.JSON)
    private SizeJson sizeJson;

    @Enumerated(EnumType.STRING)
    private sexType sexType;

    private int manufacturerId;
}
