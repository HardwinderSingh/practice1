package com.hsd.props;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
@Data
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "key.value")
public class AppconfigProps { 
	
	Map<String, String> map=new HashMap<String,String>();
	List<String> custromerlist;
}
