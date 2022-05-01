package com.giyong.es.domain.entity.franchise;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Builder
@Table(name = "franchises2")
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String tel;

    @Column
    private String address;

    @Column
    private String abbrAddress;

    @Column
    private String roadAddress;

    @Column
    private String category;

    @Column
    private String thumUrl;

    @Column
    private Double x;

    @Column
    private Double y;
}