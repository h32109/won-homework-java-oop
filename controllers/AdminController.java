package com.won.controllers;

import javax.swing.JOptionPane;

import com.won.domains.MemberBean;
import com.won.services.MemberService;

public class AdminController {

	public static void main(String[] args) {
		MemberBean member = null;
		MemberService service = new MemberService();
		
		while(true) {
			switch(JOptionPane.showInputDialog("관리자모드\n"
					+ "1.회원목록\n"
					+ "2.아이디검색\n"
					+ "3.이름검색\n"
					+ "4.전체회원수")){
				case "1" :
					JOptionPane.showMessageDialog(null, service.list());
					break;
				case "2" :
					String searchId=JOptionPane.showInputDialog("아이디 입력");
					member = service.findById(searchId);
					JOptionPane.showMessageDialog(null, member.toString());
					break;
				case "3" :
					String searchName=JOptionPane.showInputDialog("이름 입력");
					JOptionPane.showMessageDialog(null,service.findByName(searchName));
					break;
				case "4" :
					JOptionPane.showMessageDialog(null, service.countAll());
					break;
				default :
					break;
					
			}
		}
	}

}
