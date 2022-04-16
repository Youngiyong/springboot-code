package com.giyong.querydsl.service;

import com.giyong.querydsl.domain.entity.user.User;
import com.giyong.querydsl.domain.entity.user.UserRepository;
import com.giyong.querydsl.model.dto.UserDto;
import com.giyong.querydsl.model.request.UserRequest;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.giyong.querydsl.domain.entity.user.QUser.user;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final JPAQueryFactory jpaQueryFactory;
    private final UserRepository userRepository;

    public User getUser(Long id){
        return jpaQueryFactory
                .select(user)
                .from(user)
                .where(user.id.eq(id))
                .fetchOne();
    }

    public Long getUser(String tel){
        return jpaQueryFactory
                .select(user.id)
                .from(user)
                .where(user.tel.eq(tel))
                .fetchOne();
    }

    public UserDto.User getUserDtoUser(Long id){
        return jpaQueryFactory
                .select(Projections.bean(
                        UserDto.User.class,
                        user.id,
                        user.name,
                        user.tel,
                        user.thumbnail,
                        user.grade,
                        user.createDate
                ))
                .from(user)
                .where(user.id.eq(id))
                .fetchOne();
    }

    public void signup(UserRequest.UserSign request){
        Long resultUser = getUser(request.getTel());

        if(resultUser!=null)
            throw new RuntimeException();

        User saveUser = User.builder()
                .grade(request.getGrade())
                .tel(request.getTel())
                .thumbnail(request.getThumbnail())
                .name(request.getName())
                .uuid(UUID.randomUUID().toString())
                .build();

        userRepository.save(saveUser);
    }

    public void update(Long userId, UserRequest.UserUpdate request){
        User resultUser = getUser(userId);

        if(resultUser==null)
            throw new RuntimeException();

        resultUser.update(request.getName(), request.getTel(), request.getThumbnail(), request.getIsAlertPush());

        userRepository.save(resultUser);
    }

    public UserDto.User getUserInfo(Long userId){
        UserDto.User resultUser = getUserDtoUser(userId);

        if(resultUser==null)
            throw new RuntimeException();

        return resultUser;
    }

}
