package com.example.demo.component;




import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;


import java.util.Map;

/**
 *将自定义的异常转换器中的内容放到容器中
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","test");

        Map<String,Object> extc = (Map<String, Object>) webRequest.getAttribute("extc", 0);
        map.put("extc",extc);
        return map;
    }
}
