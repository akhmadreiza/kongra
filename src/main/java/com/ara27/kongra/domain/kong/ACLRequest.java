package com.ara27.kongra.domain.kong;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ACLRequest extends ApiPluginCreationRequest {
    @JsonProperty("config.whitelist")
    private String aclWhitelist;

    public String getAclWhitelist() {
        return aclWhitelist;
    }

    public void setAclWhitelist(String aclWhitelist) {
        this.aclWhitelist = aclWhitelist;
    }
}
