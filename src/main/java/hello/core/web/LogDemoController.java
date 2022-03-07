package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger; // mylogger를 찾을 수 있음

    @RequestMapping("log-demo")
    @ResponseBody // ResponseBode -> 문자를 그대로 바디에 담아서 보낼 수 있음
    public String logDemo(HttpServletRequest request) {
        // HttpServletRequest request -> httpRequest 정보를 받을 수 있음(고객 요청정보)

        String requestURL = request.getRequestURI().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();
        System.out.println("myLogger = " + myLogger);
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";

    }

}
