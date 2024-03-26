package com.yoga.yoga.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoga.yoga.constant.Api;
import com.yoga.yoga.dto.request.UserRequest;
import com.yoga.yoga.dto.response.TotCountResponse;
import com.yoga.yoga.dto.response.UserResponse;
import com.yoga.yoga.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Api.USER)
@RequiredArgsConstructor
@Tag(name = "User")
public class UserController {
    
     private final UserService userService; 

     @GetMapping("/get")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> userList = userService.getAllUsers();
        return !userList.isEmpty() ? ResponseEntity.ok().body(userList) : ResponseEntity.noContent().build();
    }

    @GetMapping("/find/{uid}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long uid) {
        UserResponse userResponse = userService.getUser(uid);
        return userResponse != null ? ResponseEntity.ok().body(userResponse) : ResponseEntity.notFound().build();
    }

   @GetMapping("/getCount")
   public ResponseEntity<TotCountResponse> getTotCount() {
       TotCountResponse countResponse = userService.getTotCount();
       return ResponseEntity.ok(countResponse);
    //    return countResponse.getTotCount() != 0 ? ResponseEntity.ok().body(countResponse)
    //            : ResponseEntity.noContent().build();

   }

    @PutMapping("/edit/{uid}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request, @PathVariable Long uid) {
        UserResponse userResponse = userService.updateUser(request, uid);
        return userResponse != null ? ResponseEntity.ok().body(userResponse) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{uid}")
    public ResponseEntity<String> deleteUser(@PathVariable Long uid) {
        boolean isDeleted = userService.deleteUser(uid);
        return isDeleted ? ResponseEntity.ok().body("User deleted successfully!")
                : ResponseEntity.notFound().build();
    }

}
