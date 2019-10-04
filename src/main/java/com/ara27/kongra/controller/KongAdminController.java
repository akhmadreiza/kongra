package com.ara27.kongra.controller;

import com.ara27.kongra.domain.KongraRequest;
import com.ara27.kongra.domain.kong.ACLRequest;
import com.ara27.kongra.domain.kong.HCOauthRequest;
import com.ara27.kongra.domain.kong.KongApiCreationRequest;
import com.ara27.kongra.domain.kong.KongConsumerAclCreationRequest;
import com.ara27.kongra.service.KongAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kongra/v1")
public class KongAdminController {
    @Autowired
    KongAdminService kongAdminService;

    @PostMapping("/register")
    public ResponseEntity<String> registerApi(@RequestBody KongraRequest kongraRequest) {
        ResponseEntity<String> responseEntityCreateApi = createApi(kongraRequest);
        if (!isSuccessful(responseEntityCreateApi)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ResponseEntity<String> responseEntityCreateAclPlugins = createAclPlugin(kongraRequest);
        if (!isSuccessful(responseEntityCreateAclPlugins)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ResponseEntity<String> responseEntityCreateHcOauthPlugins = createHcOauthPlugin(kongraRequest);
        if (!isSuccessful(responseEntityCreateHcOauthPlugins)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ResponseEntity<String> responseEntityCreateAclConsumerPlugin = createAclConsumerPlugin(kongraRequest);
        if (!isSuccessful(responseEntityCreateAclConsumerPlugin)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntityCreateApi;
    }

    private Boolean isSuccessful(ResponseEntity<String> responseEntity) {
        return responseEntity.getStatusCode().is2xxSuccessful();
    }

    private ResponseEntity<String> createApi(KongraRequest kongraRequest) {
        KongApiCreationRequest kongApiCreationRequest = kongAdminService.constructKongApiCreationRequest(kongraRequest);
        ResponseEntity<String> responseEntity = kongAdminService.createKongApi(kongApiCreationRequest);
        return responseEntity;
    }

    private ResponseEntity<String> createAclPlugin(KongraRequest kongraRequest) {
        ACLRequest aclRequest = kongAdminService.constructAclRequest(kongraRequest);
        ResponseEntity<String> responseEntity = kongAdminService.createAclPluginToApi(aclRequest, kongraRequest.getApiName());
        return responseEntity;
    }

    private ResponseEntity<String> createHcOauthPlugin(KongraRequest kongraRequest) {
        HCOauthRequest hcOauthRequest = kongAdminService.constructHcOauthRequest(kongraRequest);
        ResponseEntity<String> responseEntity = kongAdminService.createHcOauthPluginToApi(hcOauthRequest, kongraRequest.getApiName());
        return responseEntity;
    }

    private ResponseEntity<String> createAclConsumerPlugin(KongraRequest kongraRequest) {
        KongConsumerAclCreationRequest request = kongAdminService.constructAclConsumerPluginRequest(kongraRequest);
        ResponseEntity<String> responseEntity = kongAdminService.createConsumerAclPlugin(request, "my-homecredit-app"); //TODO remove hardcoded later
        return responseEntity;
    }
}
