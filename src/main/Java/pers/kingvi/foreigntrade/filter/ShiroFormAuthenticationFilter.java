package pers.kingvi.foreigntrade.filter;

import com.google.gson.Gson;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import pers.kingvi.foreigntrade.util.fts.FtsUtils;
import pers.kingvi.foreigntrade.util.fa.FaUtils;
import pers.kingvi.foreigntrade.vo.AuthResult;
import pers.kingvi.foreigntrade.util.ResultCode;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;


@Component
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    private void setHeader(HttpServletRequest request, HttpServletResponse response){
        //跨域的header设置
        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", request.getMethod());
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        //防止乱码，适用于传输JSON数据
        //Content-Type, Content-Length, Authorization, Accept, X-Requested-With , yourHeaderFeild
        response.setHeader("Content-Type","application/json;charset=UTF-8");
        response.setStatus(HttpStatus.OK.value());
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
        if (super.isAccessAllowed(request, response, mappedValue)) {
            String[] roles =  (String[])mappedValue;
            if (roles == null || roles.length == 0) {
                return true;
            }

            Subject subject = getSubject(request, response);
            if (subject.hasAllRoles(Arrays.asList(roles))) {
                return true;
            }
            //已经登录角色判断
            try {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                HttpServletRequest httpRequest = (HttpServletRequest) request;
                HttpServletResponse resp = (HttpServletResponse) response;
                setHeader(httpRequest, httpResponse);
                AuthResult authResult = new AuthResult();
                //如果因为fa角色或admin被拒绝访问，则提示登录fts账号
                if (subject.hasRole("fts")) {
                    authResult = new AuthResult(ResultCode.AUTH_SUCCESS, "fts", FtsUtils.getUserVo().getName(), "intercept");
                }
                //如果因为fts角色或admin被拒绝访问，则提示登录fa账号
                else if (subject.hasRole("fa")) {
                    authResult = new AuthResult(ResultCode.AUTH_SUCCESS, "fa", FaUtils.getUserVo().getName(), "intercept");
                //如果因为fts或fa角色被拒绝访问，则提示登录admin账号
                } else if (subject.hasRole("admin")){
                    authResult = new AuthResult(ResultCode.AUTH_SUCCESS, "admin", "weiweiwei", "intercept");
                }
                PrintWriter out = resp.getWriter();
                Gson gson = new Gson();
                out.write(gson.toJson(authResult));
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;/*super.isAccessAllowed(request, response, mappedValue);*/
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        setHeader(httpRequest, httpResponse);
        PrintWriter out = resp.getWriter();
        //isAccessAllowed未返回，则说明用户未登录，返回未登录状态信息, interceptType为fail，则需要拦截，窗口提示
        AuthResult ar = new AuthResult(ResultCode.AUTH_FAIL, "", "", "fail");
        Gson gson = new Gson();
        String json = gson.toJson(ar);
        out.write(json);
        out.flush();
        out.close();
        return false;
    }
}
