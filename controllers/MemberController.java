package com.won.controllers;

import com.won.domains.MemberBean;
import javax.swing.JOptionPane;
import com.won.services.MemberService;

public class MemberController {

	public static void main(String[] args) {
		MemberBean member = null;
		MemberService service = new MemberService();
		String temp = "";
		
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n"
					+ "1.회원가입\n"
					+ "2.마이페이지\n"
					+ "3.비번수정\n"
					+ "4.회원탈퇴\n"
					+ "5.아이디중복 여부\n"
					+ "6.로그인\n")) {
			case "0" :
				JOptionPane.showMessageDialog(null, "종료");
				
				return;
				
			case "1" :
				member = new MemberBean();
				String spec = JOptionPane.showInputDialog("이름, ID, PASSWORD, 주민번호, 혈액형, 키, 몸무게");
				String[] arr = spec.split(",");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPw(arr[2]);
				member.setSsn(arr[3]);
				member.setBlood(arr[4]);
				member.setHeight(Double.parseDouble(arr[5]));
				member.setWeight(Double.parseDouble(arr[6]));
				JOptionPane.showMessageDialog(null, service.getSign(member));
				break;
				
			case "2" :
				JOptionPane.showMessageDialog(null, service.getMyPage(member));
				
				break;
				
			case "3" :
				
				break;
				
			case "4" :
				
				break;
				
			case "5" :
				temp = JOptionPane.showInputDialog("아이디를 입력해 주세요.");
				JOptionPane.showMessageDialog(null, service.existId(temp));
				
				break;
				
			case "6" :
				temp = JOptionPane.showInputDialog("아이디와 비밀번호를 입력해 주세요.");
			
				break;
			
			}
		}

	}

}
