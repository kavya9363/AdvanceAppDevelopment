package com.yoga.yoga.service;
import java.util.List;
import com.yoga.yoga.dto.request.UserRequest;
import com.yoga.yoga.dto.response.TotCountResponse;
import com.yoga.yoga.dto.response.UserResponse;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse getUser(Long uid);

    UserResponse updateUser(UserRequest request, Long uid);

    boolean deleteUser(Long uid);

    public TotCountResponse getTotCount();
}
