package com.test.service.implementation;

import com.test.config.AppConfig;
import com.test.models.CardConnectRequestEntity;
import com.test.service.interfaces.CardConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CardConnectServiceImpl implements CardConnectService {

    @Autowired
    private AppConfig appConfig;

    @Value("${resource.url}")
    private String url;

    @Value("${client.username}")
    private String username;

    @Value("${client.password}")
    private String password;


    public CardConnectRequestEntity cardConnectRequest(CardConnectRequestEntity cardConnectRequestEntity) {

        RestTemplate restTemplate = appConfig.restTemplate();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
        HttpEntity<CardConnectRequestEntity> entity = new HttpEntity<>(cardConnectRequestEntity, header);
        ResponseEntity<CardConnectRequestEntity> cardConnectResponse = restTemplate
                .exchange(url, HttpMethod.PUT, entity, CardConnectRequestEntity.class);
        return cardConnectResponse.getBody();
    }
}
