package cn.itcast.demo.zuul.zuuldemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hftang
 * @date 2019-01-12 17:55
 * @desc
 */
@Component
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //拦截的类型 前置拦截
        return "pre";
    }

    @Override
    public int filterOrder() {
        //拦截的优先级 值越小 优先级越高
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行拦截
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //拦截的逻辑处理
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");

        if (StringUtils.isEmpty(token)) {
            currentContext.setResponseStatusCode(401);//没token 返回401
            currentContext.setSendZuulResponse(false);//高速zuul不要继续路由了
        }
        return null;
    }
}
