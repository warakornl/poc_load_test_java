package com.example.demo.controller;

import com.example.demo.model.RequestInsertDataRequestBody;
import com.example.demo.model.RequestInsertDataResponse;
import com.example.demo.service.RequestInsertDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @Autowired
    private RequestInsertDataService requestInsertDataService;

    @PostMapping("/v1/requestInsertData")
    public ResponseEntity<RequestInsertDataResponse> rptRequestGenReport(
            @RequestBody RequestInsertDataRequestBody requestObj
    ) {
        HttpStatus status = requestInsertDataService.RequestInsertData(requestObj);
        //RequestInsertDataResponse rptRequestGenReportResponse = reportService.RequestGenReport(rptcommRequest,requestUid,resourceOwnerId,sourceSystem,CommonConstants.REQUEST_BEHAVIOR_ADHOC);
        return new ResponseEntity<RequestInsertDataResponse>(HttpStatus.valueOf(status.value()));


    }

}
