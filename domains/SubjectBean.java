package com.won.domains;

public class SubjectBean {
	private int kor, eng, math;
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getKor() {
		return kor;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getMath() {
		return math;
	}
	
	public String toString() {
		return String.format("국어 : %d \n"
				+ "영어 : %d \n "
				+ "수학 : %d", kor,eng,math);
	}
	
}
