package guru.springframework.configuration;

import guru.springframework.mapper.LoanMapper;
import guru.springframework.mapper.MediaMapper;
import guru.springframework.services.LoanService;
import guru.springframework.services.MediaService;
import guru.springframework.services.impl.JdbcLoanServiceImpl;
import guru.springframework.services.impl.JdbcMediaServiceImpl;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

    @Bean
    public MediaService jdbcMediaService(MediaMapper mediaMapper) {
        return new JdbcMediaServiceImpl(mediaMapper);
    }

    @Bean
    public LoanService jdbcLoanService(LoanMapper loanMapper){return new JdbcLoanServiceImpl(loanMapper);}
}
