package com.won.services;

import com.won.domains.SubjectBean;

public class SubjectService {
	private SubjectBean[] subjects;
	private int count;
	
	public SubjectService() {
		subjects = new SubjectBean[10];
		count = 0;
	}
}
