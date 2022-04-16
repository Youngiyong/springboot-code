package com.cheese.domain.domain.user;


import com.cheese.domain.converter.user.UserGenderConverter;
import com.cheese.domain.converter.user.UserGradeConverter;
import com.cheese.domain.converter.StatusConverter;
import com.cheese.domain.converter.user.UserTsidConverter;
import com.cheese.domain.domain.BaseAllTimeEntity;
import com.cheese.domain.domain.bankStateCode.BankStateCode;
import com.cheese.domain.domain.bankTranCode.BankTranCode;
import com.cheese.domain.domain.userBankAccount.UserBankAccount;
import com.cheese.domain.domain.userHasGiftCard.UserHasGiftCard;
import com.cheese.domain.domain.userHasTerm.UserHasTerm;
import com.cheese.domain.domain.userLikeStore.UserLikeStore;
import com.cheese.domain.domain.userVisitStore.UserVisitStore;
import com.cheese.domain.enums.EStatusFlag;
import com.cheese.domain.enums.user.EUserGenderFlag;
import com.cheese.domain.enums.user.EUserGradeFlag;
import com.cheese.domain.enums.user.EUserTsidFlag;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
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

    @Convert(converter = UserTsidConverter.class)
    @Column(name = "tsid_flag", nullable = false, length = 19)
    private EUserTsidFlag tsidFlag;

    @Column(nullable = false, length = 20)
    private String tel;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    @Column(length = 256)
    private String thumbnail;

    @Convert(converter = UserGenderConverter.class)
    @Column(name = "gender_flag", nullable = false, length = 10)
    private EUserGenderFlag gender;

    @Convert(converter = UserGradeConverter.class)
    @Column(name = "grade_flag", nullable = false, length = 20)
    private EUserGradeFlag grade;

    @Convert(converter = StatusConverter.class)
    @Column(name = "status_flag", nullable = false, length = 20)
    private EStatusFlag status;

    @OneToMany(mappedBy = "user")
    private List<UserVisitStore> userVisitStores;

    @OneToMany(mappedBy = "user")
    private List<UserLikeStore> userLikeStores;

    @OneToMany(mappedBy = "user")
    private List<UserBankAccount> userBankAccounts;

    @OneToMany(mappedBy = "user")
    private List<UserHasGiftCard> giftcards;

    @OneToMany(mappedBy = "term")
    private List<UserHasTerm> terms;

    @OneToMany(mappedBy = "user")
    private List<BankTranCode> bankTranCodes;

    @OneToMany(mappedBy = "user")
    private List<BankStateCode> bankStateCodes;

    @Column
    private Boolean isFingerprint;

    @Column
    private Boolean isAlertPush;

    @Column
    private Boolean isAlertPay;

    @Column
    private Boolean isAlertPromotion;

    @Column
    private Boolean isLocation;

    @Column(length = 100)
    private String deleteReason;

    public void updatePaymentNumber(String paymentNumber){
//        this.paymentNumber = paymentNumber != null ? paymentNumber : this.paymentNumber;
        this.setUpdateDate(ZonedDateTime.now());
    }

    public void updateAlert(Boolean isFingerprint,
                       Boolean isAlertPay,
                       Boolean isAlertPromotion,
                       Boolean isAlertPush,
                       Boolean isLocation
    ){
        this.isFingerprint = isFingerprint != null ? isFingerprint : this.isFingerprint;
        this.isAlertPay = isAlertPay != null ? isAlertPay : this.isAlertPay;
        this.isAlertPromotion = isAlertPromotion != null ? isAlertPromotion : this.isAlertPromotion;
        this.isAlertPush = isAlertPush != null ? isAlertPush : this.isAlertPush;
        this.isLocation = isLocation != null ? isLocation : this.isLocation;
        this.setUpdateDate(ZonedDateTime.now());
    }

    public boolean usePoint(int cheesePoint) {
        if (this.point >= cheesePoint) {
            this.point = this.point - cheesePoint;
            return true;
        } else {
            return false;
        }
    }

    public void addPoint(int cheesePoint) {
        this.point += cheesePoint;
    }
    public void returnPoint(int cheesePoint) {
        this.point -= cheesePoint;
    }
}
