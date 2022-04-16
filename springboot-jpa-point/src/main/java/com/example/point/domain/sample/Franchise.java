
package com.example.point.domain.sample;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Builder
@Table(name = "franchises3")
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
    private String thumUrl;

    @Column
    private Double x;

    @Column
    private Double y;
}

