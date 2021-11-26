package com.sbs.java.ssg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sbs.java.ssg.container.Container;
import com.sbs.java.ssg.dto.Article;
import com.sbs.java.ssg.dto.Member;
import com.sbs.java.ssg.util.Util;

public class MemberController extends Controller {
	private Scanner sc;
	private List<Member> members;
	private String command;
	private String actionMethodName;

	public MemberController(Scanner sc) {
		this.sc = sc;

		members = Container.memberDao.members;
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "logout":
			doLogout();
			break;
		default:
			System.out.println("존재하지 않는 명령어 입니다.");
			break;
		}
	}

	private void doLogout() {
		loginedMember = null;
		System.out.println("로그아웃 되었습니다.");

	}

	private void doLogin() {
		if (isLogined()) {
			System.out.println("이미 로그인 상태 입니다.");
			return;
		}

		String loginId = null;
		Member member;

		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();
			member = getMemberByLoginId(loginId);

			if (member == null) {
				System.out.println("아이디를 확인해주세요.");
				continue;
			}
			break;
		}

		while (true) {
			System.out.printf("로그인 비밀번호 : ");
			String loginPw = sc.nextLine();

			if (member.loginPw.equals(loginPw) == false) {
				System.out.println("비밀번호를 확인해주세요.");
				continue;
			}
			break;
		}

		loginedMember = member;
		System.out.printf("로그인 성공! %s님 환영합니다\n", loginedMember.name);

	}

	private Member getMemberByLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);

		if (index == -1) {
			return null;
		}

		return members.get(index);

	}

	private int getMemberIndexByLoginId(String loginId) {
		int i = 0;
		for (Member member : members) {
			if (member.loginId.equals(loginId)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private boolean isJoinableLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);

		if (index == -1) {
			return true;
		}

		return false;
	}

	private void doJoin() {
		int id = Container.memberDao.getNewId() + 1;
		String regDate = Util.getNowDateStr();
		String loginId = null;

		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();

			if (isJoinableLoginId(loginId) == false) {
				System.out.printf("%s(은)는 이미 사용중인 아이디입니다.\n", loginId);
				continue;
			}
			break;
		}
		String loginPw = null;
		String loginPwConfirm = null;

		while (true) {
			System.out.printf("로그인 비밀번호 : ");
			loginPw = sc.nextLine();
			System.out.printf("로그인 비밀번호 확인 : ");
			loginPwConfirm = sc.nextLine();

			if (loginPw.equals(loginPwConfirm) == false) {
				System.out.println("비밀번호를 다시 입력해주세요.");
				continue;
			}
			break;
		}
		System.out.printf("이름 : ");
		String name = sc.nextLine();

		Member member = new Member(id, regDate, loginId, loginPw, name);
		Container.memberDao.add(member);

		System.out.printf("%d번회원이 생성되었습니다.\n", id);

	}

	public void makeTestData() {
		System.out.println("테스트를 위한 회원 데이터를 생성합니다.");

		Container.memberDao.add(new Member(Container.memberDao.getNewId(), Util.getNowDateStr(), "admin", "admin", "관리자"));
		Container.memberDao.add(new Member(Container.memberDao.getNewId(), Util.getNowDateStr(), "user1", "user1", "홍길동"));
		Container.memberDao.add(new Member(Container.memberDao.getNewId(), Util.getNowDateStr(), "user2", "user2", "홍길순"));

	}

}
