package com.sbs.java.ssg;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0;
		
		while(true) {
			System.out.println("명령어) ");
			String command = sc.nextLine();
			
			command = command.trim();
			
			if(command.length() == 0) {
				continue;
			}
			if(command.equals("system exit")) {
				break;
			} if(command.equals("article write")) {
				int id = lastArticleId + 1;
				lastArticleId = id;
				System.out.println("제목 : ");
				String title = sc.nextLine();
				System.out.println("내용 : ");
				String body = sc.nextLine();
				
				System.out.printf("%d번글이 생성되었습니다.", id);
				
			} else if ( command.equals("article list") ) {
				System.out.println("게시물이 없습니다.");
			} else {
				System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.", command);
			}
		}
		
		sc.close();
		
		System.out.println("== 프로그램 끝 ==");
	}
}