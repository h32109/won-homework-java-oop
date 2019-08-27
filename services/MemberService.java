package com.won.services;

import com.won.domains.MemberBean;


public class MemberService {
	/**
	 * 
	 * 요구사항(기능정의)
	 * <사용자기능>
	 * 1. 회원가입
	 * 2. 마이페이지에서 회원가입 정보 보기
	 * 3. 비번 수정
	 * 4. 회원 탈퇴
	 * 5. 아이디 존재 여부
	 * 6. 로그인
	 ***************
	 * <관리자기능>
	 * a. 회원 목록
	 * b. 아이디검색
	 * c. 이름검색(중복 가능한 값)
	 * d. 전체 회원 수
	 */
	
		private MemberBean[] members;
		private int count;
		
		public MemberService() {
			members = new MemberBean[1000];
			count = 0;
		}
		
	/**
	 * 1. 회원가입	
	 */
		
	public String getSign(MemberBean param) {
		String msg = "회원가입";
		members[count] = param;
		count++;
		return msg;
	}
	/**
	 * 2. 마이페이지 
	 */

	
	public String getMyPage(MemberBean param) {
		return param.toString();
	}
	
	
	/**
	 *  3. 비번수정(옛날비번, 신규비번을 입력받아서 옛날비번을 체크 후 일치하면 신규비번으로 변경)
	 *  비번변경 후 로그인을 실행해서 새로 바뀐 비번이 로그인 성공, 옛날 비번 로그인 실패
	 */
	
	public String changePw(MemberBean member) {
		String msg = "비밀번호 변경 실패";
		String Id = member.getId();
		String[] newPw = member.getPw().split(",");
		for(int i = 0;i < count;i++) {
			if(Id.equals(members[i].getId()) && newPw[0].equals(members[i].getPw())) {
				member.setPw(newPw[1]);
				msg = "비밀번호 변경 완료";
				break;
			}
		}
		return msg;
	}
	
	
	
	/**
	 *  4. 회원탈퇴
	 */
	
	public String signOut(MemberBean member) {
		String msg = "탈퇴실패";
		int temp = 0;
		for(int i = 0;i<count;i++) {
			while(true) {
				temp++;
			if(member.getId().equals(members[i].getId()) && 
					member.getPw().equals(members[i].getPw())) {
				break;
			}
		}
		for(i = 0;i<count;i++) {
			if(member.getId().equals(members[i].getId()) && 
					member.getPw().equals(members[i].getPw())) {
				members[i]=members[count+1];
				members[count] = members[temp];
				count--;
				count--;
				msg = "탈퇴완료";
			}
		}
		}
		return msg;
	}
	
	
	
	/**
	 *  5. 아이디 중복검사
	 */
	
	public String existId(String id) {
		String msg = "가입 가능한 아이디";
		for(int i = 0; i<3; i++) {
			if(id.equals(members[i].getId())) {
				msg = "아이디가 이미 존재합니다.";
				break;
			}
		}
		return msg;
	}
	
	
	
	
	/**
	 *  6. 로그인(파라미터로 ID, PW만 입력받은 상태)
	 */
	
	public String login(MemberBean param) {
		String result ="로그인 실패";
		for(int i = 0; i<3; i++) {
			if(param.getId().equals(members[i].getId())&& param.getPw().equals(members[i].getPw())) {
				members[i] = param;
				result = "로그인 성공";
				break;
			}
		}
		return result;
	}
	
	
	
	/**
	 * ***********************************************************************************
	 *                                                 관리자 모드
	 * ***********************************************************************************
	 */
	
	
	
	
	/**
	 *  1. 회원목록
	 */
	
	public String list() {
		String msg = "";
		for(int i = 0; i<count;i++) {
			msg += members[i].toString() + "\n";
		}
		return msg;
	}
	
	
	
	
	/**
	*  2. 아이디검색
	*/
		
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for(int i = 0;i < count;i++) {
			if(id.equals(members[i].getId())) {
				member = members[i];
				break;
			}
		}
		return member;
	}

	
	
	
	/**
	*  3. 이름검색(중복 가능한 값)
	*/
	
	public MemberBean[] findByName(String name) {
		int num = 0;
		for(int i = 0; i<count;i++) {
			if(name.equals(members[i].getName())) {
			num++;
			}
		}
		
		MemberBean[] members = new MemberBean[num];
		num=0;
		for(int i = 0;i<count;i++) {
			if(name.equals(members[i])) {
				members[i] = this.members[i];
				num++;
				if(num==members.length) {
					break;
				}
				
			}
		}
		return members;
	}
	
	
	/**
	 *  4. 전체 회원 수
	 */
	
	public String countAll() {
		return "총회원 수 : "+"count";
	}

}
	


