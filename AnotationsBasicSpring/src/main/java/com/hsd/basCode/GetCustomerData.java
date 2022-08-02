package com.hsd.basCode;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "com.value")
public class GetCustomerData implements CommandLineRunner{
	//@Value("${c.name}")
	//String name;
	//@Value("${c.add}")
	
	//String address;
	List<String> list;
	Map<String, List<String>> map;
	Map<String,Map<String,Map<String,List<String>>>> location;
	HashSet<String> set;
	/*
	 * @Override public String toString() { // TODO Auto-generated method stub
	 * return "name "+name+"  address="+address; }
	 */


	@Override
	public void run(String... args) throws Exception {
		System.out.println(this);
		
		
	}
	
	

	
	

}
