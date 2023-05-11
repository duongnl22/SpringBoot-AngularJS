package com.example.duongnl_assignment_java4.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

    @Bean
           public ModelMapper modelMapper() {
               ModelMapper modelMapper = new ModelMapper();
               modelMapper.getConfiguration()
                       .setMatchingStrategy(MatchingStrategies.STANDARD);
               return modelMapper;
           }
}
