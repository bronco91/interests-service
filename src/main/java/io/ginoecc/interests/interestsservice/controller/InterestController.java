package io.ginoecc.interests.interestsservice.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/dashboard")
public class InterestController {

    @GetMapping(path = "/test")
    @ResponseBody
    public TestResponse hello() {
        return new TestResponse("Testing service's infrastructure and platform");
    }

    public static class TestResponse {

        private String message;
        private Date timeStamp;

        public TestResponse(){ }

        public TestResponse(String message){
            this.message = message;
            this.timeStamp = new Date();
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Date getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(Date timeStamp) {
            this.timeStamp = timeStamp;
        }
    }
}
