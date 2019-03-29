package de.grimmpp.springboot.zipkindemo.zipkindemo;

import brave.http.HttpTracing;
import brave.spring.web.TracingClientHttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
public class ZipkinController {

    private static final Logger LOG = Logger.getLogger(ZipkinController.class.getName());

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(HttpTracing tracing) {
        return new RestTemplateBuilder()
                .additionalInterceptors(TracingClientHttpRequestInterceptor.create(tracing))
                .build();
    }

    @Value("${baseUrl:}")
    private String baseUrl;

    @RequestMapping(value="/zipkin")
    @ResponseBody
    public String zipkinService1(@RequestParam(value = "count",required = false) Long count)
    {
        if (baseUrl != null && !baseUrl.isEmpty() && count > 0) {
            long next = count -1;
            String response = restTemplate.getForObject(baseUrl + "/zipkin?count="+next, String.class);
            return response + " Response "+next+", ";

        } else {
            return " ";
        }
    }
}
