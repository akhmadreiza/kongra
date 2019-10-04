package com.ara27.kongra.domain.kong;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HCOauthRequest extends ApiPluginCreationRequest {

    @JsonProperty("config.enable_client_credentials")
    private String enableClientCredentials;

    @JsonProperty("config.enable_implicit_grant")
    private String enableImplicitGrant;

    @JsonProperty("config.hide_credentials")
    private String hideCredentials;

    @JsonProperty("config.enable_password_grant")
    private String enablePasswordGrant;

    @JsonProperty("config.enable_authorization_code")
    private String enableAuthorizationCode;

    @JsonProperty("config.provision_key")
    private String provisionKey;

    @JsonProperty("config.token_expiration")
    private int tokenExpiration;

    @JsonProperty("config.global_credentials")
    private String globalCredentials;

    public HCOauthRequest(String provisionKey) {
        this.enableClientCredentials = "true";
        this.enableImplicitGrant = "false";
        this.hideCredentials = "false";
        this.enablePasswordGrant = "true";
        this.enableAuthorizationCode = "true";
        this.tokenExpiration = 7200;
        this.globalCredentials = "true";
        this.provisionKey = provisionKey;
    }

    public String getEnableClientCredentials() {
        return enableClientCredentials;
    }

    public void setEnableClientCredentials(String enableClientCredentials) {
        this.enableClientCredentials = enableClientCredentials;
    }

    public String getEnableImplicitGrant() {
        return enableImplicitGrant;
    }

    public void setEnableImplicitGrant(String enableImplicitGrant) {
        this.enableImplicitGrant = enableImplicitGrant;
    }

    public String getHideCredentials() {
        return hideCredentials;
    }

    public void setHideCredentials(String hideCredentials) {
        this.hideCredentials = hideCredentials;
    }

    public String getEnablePasswordGrant() {
        return enablePasswordGrant;
    }

    public void setEnablePasswordGrant(String enablePasswordGrant) {
        this.enablePasswordGrant = enablePasswordGrant;
    }

    public String getEnableAuthorizationCode() {
        return enableAuthorizationCode;
    }

    public void setEnableAuthorizationCode(String enableAuthorizationCode) {
        this.enableAuthorizationCode = enableAuthorizationCode;
    }

    public String getProvisionKey() {
        return provisionKey;
    }

    public void setProvisionKey(String provisionKey) {
        this.provisionKey = provisionKey;
    }

    public int getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(int tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }

    public String getGlobalCredentials() {
        return globalCredentials;
    }

    public void setGlobalCredentials(String globalCredentials) {
        this.globalCredentials = globalCredentials;
    }
}
