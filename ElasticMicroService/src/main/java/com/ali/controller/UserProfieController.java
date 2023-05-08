package com.ali.controller;

import com.ali.dto.request.AddUserRequestDto;
import com.ali.dto.request.BaseRequestDto;
import com.ali.repository.entity.UserProfile;
import com.ali.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.ali.constants.EndPoints.*;
@RestController
@RequestMapping(ELASTIC+USER)
@RequiredArgsConstructor
public class UserProfieController {
    private final UserProfileService userProfileService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> addUser(@RequestBody AddUserRequestDto dto){
        userProfileService.saveDto(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping(GETALL)
    public ResponseEntity<Iterable<UserProfile>> findAll(){
     return  ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping(GETALL_VIP)
    @PreAuthorize("hasAuthority('VIP') or hasAuthority('OzelMusteri') ")
    public ResponseEntity<Iterable<UserProfile>> findAllVip(){
        return  ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping(GETALL_BEN)
    @PreAuthorize("hasAuthority('BEN')")
    public ResponseEntity<Iterable<UserProfile>> findAllBen(){
        return  ResponseEntity.ok(userProfileService.findAll());
    }


    @PostMapping(GETALLPAGE)
    public ResponseEntity<Page<UserProfile>> findAll(@RequestBody BaseRequestDto dto){
        return ResponseEntity.ok(userProfileService.findAll(dto));
    }

}
