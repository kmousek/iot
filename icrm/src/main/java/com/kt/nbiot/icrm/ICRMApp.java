package com.kt.nbiot.icrm;


import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kt.nbiot.frwk.utils.ComnUtils;




/** 
 *  NB-IoT version 1.0                                                                        
 *                                                                                             
 *  Copyright ⓒ 2017 kt corp. All rights reserved.                                            
 *                                                                                             
 *  This is a proprietary software of kt corp, and you may not use this file except in         
 *  compliance with license agreement with kt corp. Any redistribution or use of this          
 *  software, with or without modification shall be strictly prohibited without prior written  
 *  approval of kt corp, and the copyright notice above does not evidence any actual or        
 *  intended publication of such software.                                                     
 *                                               
 * @author NB-IoT jhpark                         
 * @Class Name : ICRMApp.java 
 * @since 2017.03.26                             
 * @version 1.0                                  
 * @See                                          
 *                                               
 *<pre>                                          
 *<< 개정이력(Modification Information) >>       
 *                                               
 * 수정일 수정자 수정내용                            
 * ------------------------------------          
 * 2017.03.26 NB-IoT jhpark 최초 생성            
 *                                               
 *</pre>                                         
 */ 

public class ICRMApp {

	static final Logger LOG = LoggerFactory.getLogger(ICRMApp.class);

	public static void main(String[] args) {
		wasMain();
	}

	public static void wasMain() {
		Tomcat tomcat = new Tomcat();

		String webAppDir = "src/main/webapp";

		String port = StringUtils.defaultString(System.getenv("PORT"), "8080");
		tomcat.setPort(Integer.parseInt(port));

		try {
			tomcat.addWebapp("/icrm", new File(webAppDir).getAbsolutePath());

			tomcat.start();
			tomcat.getServer().await();
		} catch (ServletException | LifecycleException e) {
			ComnUtils.logException(e);
		}
	}

}
