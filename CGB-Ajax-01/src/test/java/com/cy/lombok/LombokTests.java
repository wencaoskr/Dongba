package com.cy.lombok;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.activity.pojo.Activity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LombokTests {
	  //private static final Logger log=
	  //LoggerFactory.getLogger(LombokTests.class);
	  @Test
	  public void testActivity() {
		  Activity aty=new Activity();
		  aty.setTitle("Title-A");
		  String title=aty.getTitle();
		  System.out.println(title);
		  System.out.println(aty);
		  log.info("aty.title is {}",title);
	  }
}








