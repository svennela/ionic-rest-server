package com.bitcup.spring.config;

import com.bitcup.spring.filter.AuthFilter;
import com.bitcup.spring.filter.CorsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    private static final Logger logger = LoggerFactory.getLogger(AppInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        logger.info("enable annotation-driven mvc....");
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(MvcConfig.class);
        rootContext.setDisplayName("angular-auth");

        // creates spring container and add listener for injecting config into servlet context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        logger.info("creating dispatcher servlet and mapping all requests to it....");
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        servletContext.addFilter("corsFilter", CorsFilter.class).addMappingForUrlPatterns(null, false, "/*");
        servletContext.addFilter("authFilter", AuthFilter.class).addMappingForUrlPatterns(null, false, "/*");

        FilterRegistration.Dynamic filter =
                servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
        filter.addMappingForUrlPatterns(null, false, "/*");
        filter.setInitParameter("encoding", "UTF-8");
        filter.setInitParameter("forceEncoding", "true");
    }
}
