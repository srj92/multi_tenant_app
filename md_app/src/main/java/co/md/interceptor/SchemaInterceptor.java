package co.md.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class SchemaInterceptor extends HandlerInterceptorAdapter {
	private static final String SCHEMA_HEADER = "X-SchemaID";

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

		String schema = req.getHeader(SCHEMA_HEADER);
		boolean schemaSet = false;

		if (StringUtils.isEmpty(schema)) {
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			res.setContentType(MediaType.APPLICATION_JSON_VALUE);
			res.getWriter().write("{\"error\": \"No schema supplied\"}");
			res.getWriter().flush();
		} else {
			SchemaContext.setCurrentSchema(schema);
			schemaSet = true;
		}

		return schemaSet;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		SchemaContext.clear();
	}

}
