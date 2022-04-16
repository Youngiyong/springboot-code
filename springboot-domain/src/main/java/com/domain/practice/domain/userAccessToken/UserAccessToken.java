package com.domain.practice.domain.userAccessToken;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
@Builder
@Entity
@Table(	name = "user_access_token")
public class UserAccessToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long clientId;

    @Column
    private Long userId;

    @Column
    private Long deviceId;

    @Column(length = 500)
    private String token;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "refresh_token_id")
    private UserRefreshToken refreshToken;

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime updateDate;

    @Column
    private LocalDateTime lastLoginDate;

    public void updateAccess(Long deviceId, Long clientId, String token) {
        this.deviceId = deviceId != null ? deviceId : this.deviceId;
        this.clientId = clientId != null ? clientId : this.clientId;
        this.token = token != null ? token : this.token;
        this.updateDate = LocalDateTime.now();
    }

    public void updateRefresh(Long deviceId, Long clientId, String token, String refreshToken, ZonedDateTime expireDate) {
        this.deviceId = deviceId != null ? deviceId : this.deviceId;
        this.clientId = clientId != null ? clientId : this.clientId;
        this.token = token != null ? token : this.token;
        this.refreshToken.update(refreshToken, expireDate);
        this.updateDate = LocalDateTime.now();
    }

    public void updateLogin(Long deviceId, Long clientId, String token, LocalDateTime lastLoginDate, String refreshToken, ZonedDateTime expireDate) {
        this.deviceId = deviceId != null ? deviceId : this.deviceId;
        this.clientId = clientId != null ? clientId : this.clientId;
        this.token = token != null ? token : this.token;
        this.lastLoginDate = lastLoginDate;
        this.refreshToken.update(refreshToken, expireDate);
        this.updateDate = LocalDateTime.now();
    }

    public void updateSample(Long deviceId, Long clientId, String token, String refreshToken, ZonedDateTime expireDate) {
        this.deviceId = deviceId != null ? deviceId : this.deviceId;
        this.clientId = clientId != null ? clientId : this.clientId;
        this.token = token != null ? token : this.token;
        this.refreshToken.update(refreshToken, expireDate);
        this.updateDate = LocalDateTime.now();
    }
}
