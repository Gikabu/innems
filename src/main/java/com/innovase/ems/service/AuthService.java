package com.innovase.ems.service;

import com.innovase.ems.models.Token;
import com.innovase.ems.repositories.TokenRepository;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class AuthService {

    private String TOKEN = "";
    private boolean authenticated = false;

    TokenRepository tokenRepository;

    public AuthService(TokenRepository repository){
        this.tokenRepository = repository;
    }

    public void registerURL(){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("{\"ShortCode\":\"842074\", " +
                "\"ResponseType\":\"Cancelled\", " +
                "\"ConfirmationURL\":\"http://192.168.100.3:8100/confirmation\"," +
                "\"ValidationURL\":\"http://192.168.100.3:8100/validation_url\"}", mediaType);
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/mpesa/c2b/v1/registerurl")
                .post(body)
                .addHeader("authorization", "Bearer " + TOKEN)
                .addHeader("content-type", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void authenticate(){
        String app_key = "bzsd0VfvqMbaiY5yHGAt03ACRwcIGbfJ";
        String app_secret = "xxazFOhPDIUBWVWx";
        String appKeySecret = app_key + ":" + app_secret;
        byte[] bytes = appKeySecret.getBytes(StandardCharsets.ISO_8859_1);
        String auth = Base64.encode(bytes);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .get()
                .addHeader("authorization", "Basic " + auth)
                .addHeader("cache-control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject object = new JSONObject(Objects.requireNonNull(response.body()).toString());
            TOKEN = object.optString("access_token");
            System.out.print(TOKEN);
            authenticated = true;

            Token token = new Token();
            token.setId(0L);
            token.setToken(TOKEN);
            token.setExpiry(System.currentTimeMillis() + Long.parseLong(object.optString("expires_in")));
            tokenRepository.save(new Token());

            registerURL();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @PostConstruct
    public void getSavedToken(){
        Token token;
        if (tokenRepository.findById(0L).isPresent()) {
            token = tokenRepository.findById(0L).get();
            this.authenticated = token.getExpiry() > System.currentTimeMillis();
            if (authenticated) {
                this.TOKEN = token.getToken();
                System.out.print(TOKEN);
            }
            else {
                tokenRepository.delete(token);
                authenticate();
            }
        }
    }

    public boolean getAuthStatus(){
        return this.authenticated;
    }

    public String getToken(){
        return this.TOKEN;
    }
}
