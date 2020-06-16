package com.cy.json;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.activity.pojo.Activity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class JSONTests {
	   @Test
	   void testObjectToJsonString() throws JsonProcessingException {
		   Activity aty=new Activity();
		   aty.setId(100L);
		   aty.setTitle("MySQL");
		   aty.setCategory("RDBMS");
		   aty.setStartTime(new Date());
		   aty.setEndTime(new Date());
		   aty.setCreatedTime(new Date());
		   aty.setRemark("关系数据库");
		   aty.setState(1);
		   ObjectMapper objectMapper=new ObjectMapper();
		   //将java对象转换为json格式的字符串。
		   String jsonStr=objectMapper.writeValueAsString(aty);
		   System.out.println(jsonStr);
		   //将json格式字符串转换为java对象
		   Activity aty02=
		   objectMapper.readValue(jsonStr, Activity.class);
		   System.out.println(aty02);
	   }
	
}
