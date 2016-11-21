package com.SpaceMail;

import com.SpaceMail.converter.IMensajeConverter;
import com.SpaceMail.converter.IUsuarioConverter;
import com.SpaceMail.converter.MensajeConverter;
import com.SpaceMail.converter.UsuarioConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by juan on 11/2/16.
 */
@Configuration
public class configuracion {

    @Autowired
    AuthFilter authFilter;

    @Bean(name="usuarioConverter")
    public IUsuarioConverter getUsuarioConverter(){
        return new UsuarioConverter();
    }

    @Bean(name="mensajeConverter")
    public IMensajeConverter getNormalConverter(){
        return  new MensajeConverter();
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authFilter);
        registration.addUrlPatterns("/api/*");
        return registration;
    }

}
