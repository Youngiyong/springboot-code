package com.example.point.domain.store;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@DynamicInsert
@DynamicUpdate
@Table(name = "store3")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128)
    private String name;

    @Column(length = 256)
    private String thumbnail;

    @Column(length = 10)
    private String zipCode;

    @Column(length = 256)
    private String address;

    @Column(length = 256)
    private String addressExtra;

    @Column
    private Point location;

    @Column(length = 20)
    private String tel;

    // 업데이트 메서드
    public void update(String name,
                       String zipCode,
                       String address,
                       String addressExtra){

        this.name = name != null ? name : this.name;
        this.zipCode = zipCode != null ? zipCode : this.zipCode;
        this.address = address != null ? address : this.address;
        this.addressExtra = addressExtra != null ? addressExtra : this.addressExtra;
    }

}

