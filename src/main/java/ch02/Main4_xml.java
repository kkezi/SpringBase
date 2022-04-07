package ch02;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch02_objScan.AuthenticationService;
import ch02_objScan.PasswordChangeService;



public class Main4_xml {
	static GenericXmlApplicationContext factory;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factory = new GenericXmlApplicationContext("classpath:ch02_DIXML/Container4_scan.xml");
		
		//getBean하는 방식 중에 이런 방식도 있습니다
		PasswordChangeService pcw = (PasswordChangeService) factory.getBean("pwChangeSvc");
		//System.out.println(pcw);   //확인
		//System.out.println("ok");  //확인
		
		pcw.changePassword("kicuser","1111","2222");
	
		AuthenticationService authSvc = 
				factory.getBean("authenticationService",AuthenticationService.class);
		runAuthAndCatchAuthEx(authSvc,"kicuser","1111");
		runAuthAndCatchAuthEx(authSvc,"kicuser","11111");
		runAuthAndCatchAuthEx(authSvc,"kicuser","111111");
		
		
		
		System.out.println("ok");
		
		
	} // end main

		private static void runAuthAndCatchAuthEx (
				AuthenticationService authSvc, String userId, String password) {
			try {
			authSvc.authenticate(userId, password);
			} catch(Exception ex) {
				
			}
		}
	
	
	
	
	
	
} //end class
