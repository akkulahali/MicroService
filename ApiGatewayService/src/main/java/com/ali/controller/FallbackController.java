package com.ali.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {
    @GetMapping("/auth")
    public ResponseEntity<String> fallbackAtuh(){
        return ResponseEntity.ok("Auth servisi şuan hizmet verememektedir. lütfren daha sonra denyinizi.");
    }
    @GetMapping("/product")
    public ResponseEntity<String> fallbackProduc(){
        return ResponseEntity.ok("Product servisi şuan hizmet verememektedir. lütfren daha sonra denyinizi.");
    }

    @GetMapping("/sale")
    public ResponseEntity<String> fallbackSale(){
        return ResponseEntity.ok("Sale servisi şuan hizmet verememektedir. lütfren daha sonra denyinizi.");
    }
    @GetMapping("/user")
    public ResponseEntity<String> fallbackUser(){
        return ResponseEntity.ok("User servisi şuan hizmet verememektedir. lütfren daha sonra denyinizi.");
    }


}
