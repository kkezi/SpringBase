package ch02;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch02_obj.AlreadyMemberException;
import ch02_obj.ChangePasswordService;
import ch02_obj.IdPasswordNotMatchingException;
import ch02_obj.MemberNotFoundException;
import ch02_obj.MemberRegisterService;
import ch02_obj.RegisterRequest;

public class Main2_xml {
	static GenericXmlApplicationContext factory;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factory  //classpath:는 src밑이라는 의미
		= new GenericXmlApplicationContext("classpath:ch02_DIXML/Container2.xml");
		System.out.println("ok"); //확인 먼저 하고
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("명령어를 입력하세요");
			String command = scan.nextLine(); //console의 다음줄에서 값을 받겠다
			
			if(command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}  else if(command.startsWith("new ")) { //new가 오면 새 메서드 실행할거야 new email name psw1 psw2
				processNewCommand(command.split(" "));
				continue;
			} else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				
			}
		}
		
	} // end main

	
	
	//암호변경
	private static void processChangeCommand(String[] arg) {
		//change email oldpassword newpassword
		if (arg.length != 4) { 
			printHelp(); // 넣을려는 값이 5가 아니면 에러메세지 처리 
			return;
		}
		ChangePasswordService changePwdSvc
		= factory.getBean("changePwdSvc",ChangePasswordService.class);
		
		
		try {
		
		changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
		System.out.println("암호를 변경하였습니다");
		System.out.println(changePwdSvc.getDao().selectAll());
		} catch (IdPasswordNotMatchingException i) {
			 System.out.println("비밀번호가 일치하지 않습니다");
		}  catch (MemberNotFoundException i) {
			 System.out.println("존재하지 않는 이메일입니다");
		}
		
	}
	
	
	//가입하기
	private static void processNewCommand(String[] arg) {
		System.out.println(arg.length); // 입력받은 값 배열의 크기 확인하기
		if (arg.length != 5) { 
			printHelp(); // 넣을려는 값이 5가 아니면 에러메세지 처리 
			return;
		}
		
		MemberRegisterService regSvc = factory.getBean("memberRegSvc", MemberRegisterService.class);
		
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]); //배열의 첫번째 값은 이메일이니까
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		System.out.println(req);
		
		try {
		regSvc.regist(req);
		System.out.println("가입이 완료되었습니다");
		} catch (AlreadyMemberException e) {
			System.out.println("이미 존재하는 이메일입니다");
		}
		
		
	}
	
	public static void printHelp() {
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 암호 암호확인");
	}
} // end class
