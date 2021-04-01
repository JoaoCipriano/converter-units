package com.example.demo.filter;

import org.apache.tomcat.util.buf.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Component
public class LoggingFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String urlWithParameters = getURLWithParameters((HttpServletRequest) servletRequest);
        LOGGER.info(urlWithParameters);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getURLWithParameters(HttpServletRequest request) {
        StringBuilder uri = new StringBuilder();

        uri.append(request.getMethod());
        uri.append(" ");
        uri.append(request.getRequestURL().toString());
        if (!request.getParameterMap().isEmpty()) {
            uri.append("?");
            uri.append(getParameters(request));
        }
        return uri.toString();
    }

    private String getParameters(HttpServletRequest request) {
        Map<String, String[]> parameters = request.getParameterMap();

        StringBuilder params = new StringBuilder();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            if (params.length() > 0)
                params.append("&");

            params.append(entry.getKey());
            params.append("=");
            params.append(StringUtils.join(entry.getValue()));
        }
        return params.toString();
    }
}
