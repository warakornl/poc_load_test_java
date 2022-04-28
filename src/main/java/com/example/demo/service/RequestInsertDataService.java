package com.example.demo.service;

import com.example.demo.model.RequestInsertDataRequestBody;
import com.example.demo.repository.RequestInsertDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RequestInsertDataService {
    @Autowired
    RequestInsertDataRepository requestInsertDataRepository;

    public HttpStatus RequestInsertData(RequestInsertDataRequestBody requestObj){

        try {
            if(requestInsertDataRepository.insertDataToActualTable(requestObj)>0){
                return HttpStatus.ACCEPTED;
            }else{
                return HttpStatus.BAD_REQUEST;
            }
        }catch (Exception e){
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }
    }
}
