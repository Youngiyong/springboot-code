package com.domain.practice.domain.userDevice;

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
@Table(	name = "user_device")
public class UserDevice extends BaseAllTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column(length = 64)
    private String deviceHash;

    @Column(length = 32)
    private String deviceKey;

    @Column(length = 10)
    private String version;

    @Column(length = 100)
    private String device;

    @Column(length = 10)
    private String platform;

    @Column(length = 10)
    private String platformVersion;

    @Column(length = 100)
    private String adid;

    @Column
    private Boolean isRooted;

    @Column(length = 2)
    private String language;

    @Column(length = 50)
    private String ip;

    public void update(String deviceHash) {
        this.deviceHash = deviceHash != null ? deviceHash : this.deviceHash;
        this.setUpdateDate(ZonedDateTime.now());
    }
}
