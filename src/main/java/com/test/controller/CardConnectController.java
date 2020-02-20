package com.test.controller;

import com.test.models.CardConnectRequestEntity;
import com.test.service.interfaces.CardConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/card-connect")
public class CardConnectController {

    @Autowired
    private CardConnectService cardConnectService;


    @PostMapping
    ResponseEntity cardConnectRestClient(@RequestBody CardConnectRequestEntity cardConnectRequestEntity) {

        return ResponseEntity.ok(cardConnectService.cardConnectRequest(cardConnectRequestEntity));
    }
}
