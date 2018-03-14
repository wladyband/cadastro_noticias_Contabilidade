package br.com.mdw.cors;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.mdw.config.MdwApiProperty;

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//implements Filter
@Configuration
public class CorsFilter {

	

	    @Autowired
	    private MdwApiProperty mdwApiProperty;
	    @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
		        registry.addMapping("/**")
			    .allowedOrigins(mdwApiProperty.getOriginPermitida())
			    .allowedMethods("PUT", "DELETE", "POST", "GET", "OPTIONS")
			    .allowedHeaders("Authorization", "Content-Type", "Accept")
			    .exposedHeaders("header1", "header2")
			    .allowCredentials(true)
	                    .maxAge(3600);
	            }
	        };
	    }
	 
	
	
	
	
//	@Autowired
//	private MdwApiProperty mdwApiProperty;
//	
//	
//	
//	
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//	throws IOException, ServletException {
//
//	HttpServletResponse response = (HttpServletResponse) resp;
//	HttpServletRequest request = (HttpServletRequest) req;
//
//	response.setHeader("Access-Control-Allow-Origin", mdwApiProperty.getOriginPermitida());
//
//	response.setHeader("Access-Control-Allow-Credentials", "true");
//	response.setHeader("Access-Control-Allow-Methods",
//	"ACL, CANCELUPLOAD, CHECKIN, CHECKOUT, COPY, DELETE, GET, HEAD, LOCK, MKCALENDAR, MKCOL, MOVE, OPTIONS, POST, PROPFIND, PROPPATCH, PUT, REPORT, SEARCH, UNCHECKOUT, UNLOCK, UPDATE, VERSION-CONTROL");
//	response.setHeader("Access-Control-Max-Age", "3600");
//	response.setHeader("Access-Control-Allow-Headers",
//	"Origin, X-Requested-With, Content-Type, Accept, Key, Authorization");
//
//	if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
//	response.setStatus(HttpServletResponse.SC_OK);
//	} else {
//	chain.doFilter(req, resp);
//	}
//	}
	
	
	
	
	
	
	
	
	
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//		
//		HttpServletRequest request = (HttpServletRequest) req;
//		HttpServletResponse response = (HttpServletResponse) resp;
//		
//		response.setHeader("Access-Control-Allow-Origin", mdwApiProperty.getOriginPermitida());
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//		
//		if ("OPTIONS".equals(request.getMethod()) && mdwApiProperty.getOriginPermitida().equals(request.getHeader("Origin"))) {
//			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
//        	response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
//        	response.setHeader("Access-Control-Max-Age", "3600");
//			
//			response.setStatus(HttpServletResponse.SC_OK);
//		} else {
//			chain.doFilter(req, resp);
//		}
//		
//}
	
	
	

	// @Override
	// public void doFilter(ServletRequest req, ServletResponse resp, FilterChain
	// chain)
	// throws IOException, ServletException {
	//
	// HttpServletRequest request = (HttpServletRequest) req;
	// HttpServletResponse response = (HttpServletResponse) resp;
	//
	// response.setHeader("Access-Control-Allow-Origin",
	// request.getHeader("Origin"));
	//
	// response.setHeader("Access-Control-Allow-Credentials", "true");
	//
	// response.setHeader("Access-Control-Allow-Origin",
	// request.getHeader("Origin"));
	//
	// if ("OPTIONS".equals(request.getMethod())) {
	// response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT,
	// OPTIONS");
	// response.setHeader("Access-Control-Allow-Headers", "Authorization,
	// Content-Type, Accept");
	// response.setHeader("Access-Control-Max-Age", "3600");
	// response.setStatus(HttpServletResponse.SC_OK);
	// } else {
	// chain.doFilter(req, resp);
	// }
	//
	// }
//
//	@Override
//	public void destroy() {
//	}
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {
//	}

}




//@Override
//public void addCorsMappings(CorsRegistry registry) {
//	registry.addMapping("/**");
//}

*/