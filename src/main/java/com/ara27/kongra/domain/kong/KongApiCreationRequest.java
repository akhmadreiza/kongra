package com.ara27.kongra.domain.kong;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class KongApiCreationRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("uris")
    private String uris;

    @JsonProperty("upstream_url")
    private String upstreamUrl;

    @JsonProperty("strip_uri")
    private Boolean stripUri;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUris() {
        return uris;
    }

    public void setUris(String uris) {
        this.uris = uris;
    }

    public String getUpstreamUrl() {
        return upstreamUrl;
    }

    public void setUpstreamUrl(String upstreamUrl) {
        this.upstreamUrl = upstreamUrl;
    }

    public Boolean getStripUri() {
        return stripUri;
    }

    public void setStripUri(Boolean stripUri) {
        this.stripUri = stripUri;
    }
}
