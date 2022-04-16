package com.domain.practice.domain.user;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@Builder
@Entity
@Table(	name = "user")
public class User extends BaseAllTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false, length = 36)
    private String uuid;

    @Column(nullable = false, length = 20)
    private String tel;

    @Column(nullable = false, length = 50)
    private String name;

    @Column
    private Integer point;

    @Column(length = 256)
    private String thumbnail;

    @Convert(converter = UserGenderConverter.class)
    @Column(name = "gender_flag", nullable = false, length = 10)
    private EUserGenderFlag gender;

    @Column
    private Boolean isAlertPush;

    public void updatePaymentNumber(String paymentNumber){
//        this.paymentNumber = paymentNumber != null ? paymentNumber : this.paymentNumber;
        this.setUpdateDate(ZonedDateTime.now());
    }

    public void addPoint(int point) {
        this.point += point;
    }
    public void returnPoint(int cheesePoint) {
        this.point -= cheesePoint;
    }
}
