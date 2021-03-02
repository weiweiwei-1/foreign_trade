package pers.kingvi.foreigntrade.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;

@Component
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
        /*if (request instanceof HttpServletRequest) {
            if (((HttpServletRequest) request).getMethod().toUpperCase().equals("OPTIONS")) {
                return true;
            }
        }*/

        if (super.isAccessAllowed(request, response, mappedValue)) {
            String[] roles =  (String[])mappedValue;
            if (roles == null || roles.length == 0) {
                return true;
            }

            Subject subject = getSubject(request, response);
            if (subject.hasAllRoles(Arrays.asList(roles))) {
                return true;
            }
            try {
                HttpServletResponse resp = (HttpServletResponse) response;
                resp.setContentType("application/json; charset=utf-8");
                PrintWriter out = resp.getWriter();
                String error = "请登录货代账号进行操作";
                // out.write(responseMessage.toJson().toJSONString()); // 返回自己的json
                out.write(error);
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
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out2 = resp.getWriter();
        String error2 = "错误";
        // out.write(responseMessage.toJson().toJSONString()); // 返回自己的json
        out2.write(error2);
        out2.flush();
        out2.close();
        return false;
    }
}
