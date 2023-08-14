package com.demo.interview.mappers;

import com.demo.interview.dtos.SignUpDto;
import com.demo.interview.entites.Email;
import com.demo.interview.dtos.EmailDto;
import com.demo.interview.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    EmailDto toUserDto(Email email);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
