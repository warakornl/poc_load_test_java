package com.example.demo.repository;

import com.example.demo.model.RequestInsertDataRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RequestInsertDataRepository {

    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int insertDataToActualTable(RequestInsertDataRequestBody requestObj){
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("log_id",requestObj.getLog_id());
        namedParameters.put("user_name",requestObj.getUser_name());
        namedParameters.put("age",requestObj.getAge());

        String query = "insert into request_log (log_id,user_name,age)\n" +
                "values (:log_id,:user_name,:age);";
        return namedParameterJdbcTemplate.update(query,namedParameters);
    }
}
