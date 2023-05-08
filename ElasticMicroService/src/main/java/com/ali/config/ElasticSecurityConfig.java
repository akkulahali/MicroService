package com.ali.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * a@Configuration -> Konfigürasyon dosyası olarak spring e bildireceğimiz sınıflara ekliyoruz.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ElasticSecurityConfig {

    @Bean
    JwtTokenFilter getTokenFilter(){
        return new JwtTokenFilter();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        /**
         * _csrf -> bunu kapatmak için disable komutunu kullanıyorz.
         */
        httpSecurity.csrf().disable();
        /**
         * Gelen bütün isteklere oturum açılmışmı kendini doğrulamışmı bak.
         * Eğer özel adreslere erişimi açmak istiyorsanız bunları belirterek izin vermelisiniz.
         * Match("/{URLS}") için izin ver permitAll demelisiniz.
         */
        httpSecurity.authorizeRequests()
                .antMatchers("/mylogin.html","/v1/**").permitAll()
                .anyRequest().authenticated();
        /**
         * Yetkisiz girişlerde kullanıcıların kendilerini doğrulamaları için login formuna yönlendirme yaparız.
         */
        //httpSecurity.formLogin();
        /**
         * Eğer kullanıcıya kendi login formunuzu göstermek istiyor iseniz. o zaman kendi formunuza izin vererek
         * yönlendirme işlemi yapmalısınız.
         */
        // httpSecurity.formLogin().loginPage("/mylogin.html");
        /**
         * Auth servis üzerinden kendisini doğrulayan bir kişinin isteklerinin nasıl işleyeceğini çözmemiz gerekiyor.
         * Kişinin elinde olan token bilgisi okunarak bu kişiye yetkileri sahilinde geçerli olan token üzerinden
         * oturum izni verilecek, böylecek işi her seferinde kenidini doğrulamak zorunda kalmayacak.
         * Bunu başarmak için önvcelikle filter işleminin öncesine bir işlem adımı sokarak kişiyi soğruluyoruz.
         */
        httpSecurity.addFilterBefore(getTokenFilter(), UsernamePasswordAuthenticationFilter.class);


        return httpSecurity.build();
    }

}
