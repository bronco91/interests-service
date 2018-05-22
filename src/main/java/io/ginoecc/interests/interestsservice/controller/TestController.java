package io.ginoecc.interests.interestsservice.controller;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/dashboard")
public class TestController {

    @Value("${spring.profiles.active}")
    private String env;

    @GetMapping(path = "/test")
    @Async
    public CompletableFuture<TestResponse> hello() {
        return  CompletableFuture.completedFuture(new TestResponse("Testing service's infrastructure and platform",env));
    }

    public static class TestResponse {

        private String message;
        private Date timeStamp;
        private String env;

        public TestResponse(){ }

        public TestResponse(String message, String env){
            this.message = message;
            this.env = env;
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

        public String getEnv() {
            return env;
        }

        public void setEnv(String env) {
            this.env = env;
        }

        public void setTimeStamp(Date timeStamp) {
            this.timeStamp = timeStamp;
        }
    }
}
