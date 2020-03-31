package com.cloud.demo.consumer.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ServiceFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //filterType 为过滤类型，可选值有 pre（路由之前）、routing（路由之时）、post（路由之后）、error（发生错误时调用）。
        return "pre";
    }

    @Override
    public int filterOrder() {
        //filterOrdery 为过滤的顺序，如果有多个过滤器，则数字越小越先执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //shouldFilter 表示是否过滤，这里可以做逻辑判断，true 为过滤，false 不过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //run 为过滤器执行的具体逻辑，在这里可以做很多事情，比如：权限判断、合法性校验等。
        //这里写校验代码
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String name = request.getParameter("name");
        if(!"12345".equals(name)){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().setCharacterEncoding("UTF-8");
                context.getResponse().getWriter().write("名字错了");
            }catch (Exception e){}
        }
        return null;
    }
}
