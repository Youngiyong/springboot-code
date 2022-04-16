package com.giyong.querydsl.domain.entity.user;


import com.giyong.querydsl.domain.converter.UserGradeConverter;
import com.giyong.querydsl.domain.entity.BaseAllTimeEntity;
import com.giyong.querydsl.domain.enums.EUserGradeFlag;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.ZonedDateTime;

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

    @Column(nullable = false, length = 36)
    private String uuid;

    @Column(nullable = false, length = 20)
    private String tel;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 256)
    private String thumbnail;

    @Column
    private Boolean isAlertPush;

    @Convert(converter = UserGradeConverter.class)
    @Column(name = "grade_flag", nullable = false, length = 20)
    private EUserGradeFlag grade;

    public void update(String name, String tel, String thumbnail, Boolean isAlertPush){
        this.name = name != null ? name : this.name;
        this.tel = tel != null ? tel : this.tel;
        this.thumbnail = thumbnail != null ? thumbnail : this.thumbnail;
        this.isAlertPush = isAlertPush != null ? isAlertPush : this.isAlertPush;
        this.setUpdateDate(ZonedDateTime.now());
    }

}
