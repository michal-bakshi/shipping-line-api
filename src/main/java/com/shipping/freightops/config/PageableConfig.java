package com.shipping.freightops.config;

import com.shipping.freightops.dto.PageResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PageableConfig {
  @Bean
  public PageableHandlerMethodArgumentResolverCustomizer customizer() {
    return pageableResolver -> {
      pageableResolver.setMaxPageSize(100);
    };
  }
}
