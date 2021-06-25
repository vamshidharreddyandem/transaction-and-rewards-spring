package com.test.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.rewards.rest.service.RewardsPointsService;

@Profile("test")
@Configuration
public class RewardsServiceTestConfiguration {
   @Bean
   @Primary
   public RewardsPointsService challengeService() {
      return Mockito.mock(RewardsPointsService.class);
   }
}