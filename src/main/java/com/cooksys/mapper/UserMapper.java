package com.cooksys.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.cooksys.dto.UserDto;
import com.cooksys.dto.UserRequestDto;
import com.cooksys.entity.User;

@Mapper(componentModel = "Spring")
public interface UserMapper {

	 @Mappings({
         @Mapping(source = "profile", target = "profile"),
         @Mapping(source = "credentials", target = "credentials")
	 })
	User toUser(UserRequestDto userRequestDto);
	 
	 @Mappings({
		 @Mapping(source = "credentials.username", target = "username"),
		 @Mapping(source = "profile", target = "profile"),
		 @Mapping(source = "joined", target = "joined")
	 })
	 UserDto toUserDto(User user);
	
}
