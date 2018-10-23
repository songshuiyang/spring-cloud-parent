package com.songsy.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求过滤
 * @author songshuiyang
 * @date 2018/10/23 20:50
 */
public class AccessFilter extends ZuulFilter{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 定义过滤器的类型，决定过滤器在请求的那个生命周期中执行
     * @return
     */
    @Override
    public String filterType() {
        // 代表会在请求被路由之前被执行
        return "pre";
    }

    /**
     * 定义过滤器的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否需要被执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 过滤器的具体实现
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.error("access check failed");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.error("access check passs");
        return null;
    }
}
