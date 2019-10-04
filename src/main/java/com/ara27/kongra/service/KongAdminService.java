package com.ara27.kongra.service;

import com.ara27.kongra.domain.KongraRequest;
import com.ara27.kongra.domain.kong.*;
import org.springframework.http.ResponseEntity;

public interface KongAdminService {
    ResponseEntity<String> createKongApi(KongApiCreationRequest kongApiCreationRequest);

    ResponseEntity<String> createAclPluginToApi(ACLRequest aclRequest, String apiName);

    ResponseEntity<String> createHcOauthPluginToApi(HCOauthRequest hcOauthRequest, String apiName);

    ResponseEntity<String> createFileLogPluginToApi(FileLogRequest fileLogRequest, String apiName);

    ResponseEntity<String> createConsumerAclPlugin(KongConsumerAclCreationRequest kongConsumerAclCreationRequest, String consumerName);

    KongApiCreationRequest constructKongApiCreationRequest(KongraRequest kongraRequest);

    ACLRequest constructAclRequest(KongraRequest kongraRequest);

    FileLogRequest constructFileLogRequest(KongraRequest kongraRequest);

    HCOauthRequest constructHcOauthRequest(KongraRequest kongraRequest);

    KongConsumerAclCreationRequest constructAclConsumerPluginRequest(KongraRequest kongraRequest);
}
