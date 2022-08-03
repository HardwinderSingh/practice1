package com.hsd.code;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hsd.props.AppconfigProps;
import com.hsd.props.FinalValue;
@Component
public class client implements CommandLineRunner{
	
	@Autowired
	private AppconfigProps appconfigProps;

	@Override
	public void run(String... args) throws Exception {
		Map<String, String> map = appconfigProps.getMap();
		
		
		System.out.println("printing "); 
		System.out.println(map.get(FinalValue.SUCCESS)); 
		System.out.println(""+map.get(FinalValue.ERROR));
		System.out.println(""+map.get(FinalValue.FAIL));
	}

}
