package com.ara27.kongra.domain.kong;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class KongConsumerAclCreationRequest {
    private String group;

    public KongConsumerAclCreationRequest(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
