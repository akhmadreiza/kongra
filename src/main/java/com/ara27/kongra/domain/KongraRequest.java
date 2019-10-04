package com.ara27.kongra.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class KongraRequest {
    private String apiName;
    private String apiUri;
    private String aclWhitelist;
    private String hcProvisionKey;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiUri() {
        return apiUri;
    }

    public void setApiUri(String apiUri) {
        this.apiUri = apiUri;
    }

    public String getAclWhitelist() {
        return aclWhitelist;
    }

    public void setAclWhitelist(String aclWhitelist) {
        this.aclWhitelist = aclWhitelist;
    }

    public String getHcProvisionKey() {
        return hcProvisionKey;
    }

    public void setHcProvisionKey(String hcProvisionKey) {
        this.hcProvisionKey = hcProvisionKey;
    }
}
