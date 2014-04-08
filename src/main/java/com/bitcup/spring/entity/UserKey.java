package com.bitcup.spring.entity;

public class UserKey {
    private String userId;
    private String privateKey;

    public UserKey() {
    }

    public UserKey(String userId, String privateKey) {
        this.userId = userId;
        this.privateKey = privateKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @Override
    public String toString() {
        return "UserKey{" +
                "userId='" + userId + '\'' +
                ", privateKey='" + privateKey + '\'' +
                '}';
    }
}
