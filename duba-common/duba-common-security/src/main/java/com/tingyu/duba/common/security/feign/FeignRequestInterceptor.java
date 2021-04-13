package com.tingyu.duba.common.security.feign;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.tingyu.duba.common.core.utils.ip.IpUtils;
import org.springframework.stereotype.Component;
import com.tingyu.duba.common.core.constant.CacheConstants;
import com.tingyu.duba.common.core.utils.ServletUtils;
import com.tingyu.duba.common.core.utils.StringUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * feign 请求拦截器
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest httpServletRequest = ServletUtils.getRequest();
        if (StringUtils.isNotNull(httpServletRequest)) {
            Map<String, String> headers = ServletUtils.getHeaders(httpServletRequest);
            // 传递用户信息请求头，防止丢失
            String userId = headers.get(CacheConstants.DETAILS_USER_ID);
            if (StringUtils.isNotEmpty(userId)) {
                requestTemplate.header(CacheConstants.DETAILS_USER_ID, userId);
            }
            String username = headers.get(CacheConstants.DETAILS_USERNAME);
            if (StringUtils.isNotEmpty(username)) {
                requestTemplate.header(CacheConstants.DETAILS_USERNAME, username);
            }
            String authentication = headers.get(CacheConstants.AUTHORIZATION_HEADER);
            if (StringUtils.isNotEmpty(authentication)) {
                requestTemplate.header(CacheConstants.AUTHORIZATION_HEADER, authentication);
            }

            // 配置客户端IP
            requestTemplate.header("X-Forwarded-For", IpUtils.getIpAddr(ServletUtils.getRequest()));
        }
    }
}