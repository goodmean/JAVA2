package com.sbs.java.ssg;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== ���α׷� ���� ==");

		Scanner sc = new Scanner(System.in);
		String command;

		System.out.printf("��ɾ�) ");
		command = sc.next();
		System.out.printf("�Էµ� ��ɾ� : %s\n", command);

		System.out.printf("��ɾ�) ");
		int num = sc.nextInt();
		System.out.printf("�Էµ� ���� : %d\n", num);
		sc.close();

		System.out.println("== ���α׷� �� ==");
	}
}