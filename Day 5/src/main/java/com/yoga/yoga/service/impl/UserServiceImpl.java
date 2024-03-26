package com.yoga.yoga.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yoga.yoga.dto.request.UserRequest;
import com.yoga.yoga.dto.response.TotCountResponse;
import com.yoga.yoga.dto.response.UserResponse;
import com.yoga.yoga.model.User;
import com.yoga.yoga.model.enumerate.Role;
import com.yoga.yoga.repository.UserRepository;
import com.yoga.yoga.service.UserService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService{

     private final UserRepository userRepository;

     @Override
    public List<UserResponse> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .filter(user -> !user.getRole().equals(Role.ADMIN))
                .map(this::mapUserToUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUser(Long uid) {
        User user = userRepository.findByUid(uid);
        return mapUserToUserResponse(user);
    }

    @Override
    public UserResponse updateUser(UserRequest request, Long uid) {
        User user = userRepository.findByUid(uid);
        User newUser = new User();
        if (user != null) {
            newUser = User.builder()
            		.uid(uid)
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .role(request.getRole())
                    .build();
            userRepository.save(newUser);
        }
        return mapUserToUserResponse(newUser);
    }

    @Override
    public boolean deleteUser(Long uid) {
        User user = userRepository.findByUid(uid);

        if (user != null) {
            userRepository.deleteByUid(uid);
            return true;
        } else {
            return false;
        }
    }

    private UserResponse mapUserToUserResponse(User user) {
        return UserResponse.builder()
                .uid(user.getUid())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }


    @Override
   public TotCountResponse getTotCount() {
    //    long count = userRepository.count();
    //    return CountResponse.builder().count(count).build();
           TotCountResponse totCountsResponse = new TotCountResponse();
			List<User> allUsers = userRepository.findAll();
	
			long totalUserCount = allUsers.size();
			long adminCount = countUsersByRole(allUsers, Role.ADMIN);
			long customerCount = countUsersByRole(allUsers, Role.CUSTOMER);
	
			totCountsResponse.setTotalUsers(totalUserCount);
			totCountsResponse.setAdminUsers(adminCount);
			totCountsResponse.setCustomerUsers(customerCount);
	
		return totCountsResponse;
   }

   private long countUsersByRole(List<User> users, Role role) {
    return users.stream()
        .filter(user -> user.getRole() == role)
        .count();
}

}
