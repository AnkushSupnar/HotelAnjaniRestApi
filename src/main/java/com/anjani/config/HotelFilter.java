package com.anjani.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class HotelFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        log.info(
                "Starting a transaction for req : {}, Host={}",
                req.getRequestURI(),request.getRemoteHost() );
        MDC.put("UUID", UUID.randomUUID().toString());

        chain.doFilter(request, response);
        log.info(
                "Committing a transaction for req : {}",
                req.getRequestURI());
    }
}
