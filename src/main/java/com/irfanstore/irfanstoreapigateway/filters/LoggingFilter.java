package com.irfanstore.irfanstoreapigateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoggingFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest httpServerRequest =  RequestContext.getCurrentContext().getRequest();

        System.out.println(String.format("REST request to API Gateway : {%s}. Request URI: {%s}", httpServerRequest, httpServerRequest.getRequestURI()));
        return null;
    }
}
