package com.ara27.kongra.service.impl;

import com.ara27.kongra.domain.KongraRequest;
import com.ara27.kongra.domain.kong.ACLRequest;
import com.ara27.kongra.domain.kong.HCOauthRequest;
import com.ara27.kongra.domain.kong.KongApiCreationRequest;
import com.ara27.kongra.service.KongAdminService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class KongAdminServiceImpl implements KongAdminService {

    @Value("${kong.adminUrl}")
    private String kongAdminUrl;

    @Value("${kong.apiKey}")
    private String apiKey;

    @Value("${kong.upstreamUrl}")
    private String upstreamUrl;

    public static final String ACL_PLUGIN_DEFAULT_NAME = "acl";
    public static final String HCOAUTH2_PLUGIN_DEFAULT_NAME = "hc-oauth2";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<String> createKongApi(KongApiCreationRequest kongApiCreationRequest) {
        ResponseEntity responseEntity = restTemplate.exchange(kongAdminUrl + "/apis", HttpMethod.POST, httpEntity(kongApiCreationRequest), Map.class);
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> createAclPluginToApi(ACLRequest aclRequest, String apiName) {
        ResponseEntity responseEntity = restTemplate.exchange(kongAdminUrl + "/apis" + "/" + apiName + "/plugins", HttpMethod.POST, httpEntity(aclRequest), Map.class);
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> createHcOauthPluginToApi(HCOauthRequest hcOauthRequest, String apiName) {
        ResponseEntity responseEntity = restTemplate.exchange(kongAdminUrl + "/apis" + "/" + apiName + "/plugins", HttpMethod.POST, httpEntity(hcOauthRequest), Map.class);
        return responseEntity;
    }

    @Override
    public KongApiCreationRequest constructKongApiCreationRequest(KongraRequest kongraRequest) {
        KongApiCreationRequest kongApiCreationRequest = new KongApiCreationRequest();
        kongApiCreationRequest.setName(kongraRequest.getApiName());
        kongApiCreationRequest.setStripUri(true);
        kongApiCreationRequest.setUpstreamUrl(upstreamUrl + kongraRequest.getApiUri());
        kongApiCreationRequest.setUris(kongraRequest.getApiUri());
        return kongApiCreationRequest;
    }

    @Override
    public ACLRequest constructAclRequest(KongraRequest kongraRequest) {
        ACLRequest aclRequest = new ACLRequest();
        aclRequest.setAclWhitelist(kongraRequest.getAclWhitelist());
        aclRequest.setName(ACL_PLUGIN_DEFAULT_NAME);
        return aclRequest;
    }

    @Override
    public HCOauthRequest constructHcOauthRequest(KongraRequest kongraRequest) {
        HCOauthRequest hcOauthRequest = new HCOauthRequest(kongraRequest.getHcProvisionKey());
        hcOauthRequest.setName(HCOAUTH2_PLUGIN_DEFAULT_NAME);
        return hcOauthRequest;
    }

    private HttpEntity httpEntity(Object object) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("apiKey", apiKey);
        final HttpEntity entity = new HttpEntity(object, httpHeaders);
        return entity;
    }
}
