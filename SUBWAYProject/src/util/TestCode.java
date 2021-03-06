package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestCode {
//	유효성 검사 서비스 객체 생성
	private VerifiedUtil verifiedUtil = VerifiedUtil.getInstance ();
	
	public static void main (String[] args) {
		new TestCode().start();
	}
	
	private void start() {
//		System.out.print("입력>");
//		String userInput = ScanUtil.nextLine();
//		int userInput = ScanUtil.nextInt();
//		exceiptionTest(userInput);
//		nowTime();
//		commaTest();
//		System.out.println ("회원가입 메서드 호출");
//		join();
//		join2();
	}
	
	private void exceiptionTest(String userInput) {
		System.out.println("userInput : " + userInput);
	}
	private void exceiptionTest(int userInput) {
		System.out.println("userInput : " + userInput);
	}

	//회원 가입 시 메뉴 유효성 검사(switch 문을 안쓰는 경우)
	private void join() {
		System.out.println ("==회원가입1==");
		System.out.print ("회원명 > ");
		String userName = ScanUtil.nextLine ();
		int userCodeInput;
		
		while(true) {
			System.out.println ("회원 코드 선택 : 1. 고객\t2. 가맹점주");
			userCodeInput = ScanUtil.nextInt ();//입력한 내용이 숫자인지 문자인지 판별
			if(userCodeInput != ScanUtil.ERROR) {
				boolean flag = verifiedUtil.verifiedMenu (2, userCodeInput);//입력한 내용이 메뉴에 맞추어 입력하였는지 판별
				if(flag) {
					System.out.println ("메뉴에 맞게 정상적으로 입력하셨습니다.");
					break;
				}else {
					System.out.println ("정상적인 메뉴를 입력하지 않음.");
				}
			}else {
				System.out.println ("숫자가 아님 재입력");
			}
		}
	}
	
	
	
	//회원 가입 시 메뉴 유효성 검사(switch 문을 쓰는 경우)
		private void join2() {
			System.out.println ("==회원가입2==");
			System.out.print ("회원명 > ");
			String userName = ScanUtil.nextLine ();
			int userCodeInput = 0;
			
			while(userCodeInput == 0) {
				System.out.println ("회원 코드 선택 : 1. 고객\t2. 가맹점주");
				userCodeInput = ScanUtil.nextInt ();//입력한 내용이 숫자인지 문자인지 판별
				if(userCodeInput != ScanUtil.ERROR) {
					switch(userCodeInput) {
						case 1:
							System.out.println ("고객입니다.");
							break;
						case 2:
							System.out.println ("가맹점주입니다.");
							break;
						default :
							System.out.println ("잘못입력하셨습니다.");
							userCodeInput = 0;
					}
				}else {
					System.out.println ("숫자가 아님 재입력");
				}
			}
			System.out.println("test");
		}
		
		private void commaTest() {
			String input = "써브웨이와 함께하는 KBS '오!삼광빌라' 하하";
			String inputM = input.replaceAll("'", "\'");
			System.out.println(inputM);
		}
		
		private void nowTime() {
//		오늘 날짜 가져오는 소스
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String datestr = sdf.format(cal.getTime());
			System.out.println(datestr);
		}
		
		
}
