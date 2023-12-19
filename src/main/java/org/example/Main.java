package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<CookRecipe> cookRecipes = new ArrayList<>();
        int memberId = 1;
        CookRecipe userInfo = null;
        System.out.println("요리 게시판");
        while (true) {
            System.out.println("게시판 입력: ");
            String command = sc.nextLine();
            if (command.equals("종료")) {
                break;
            } else if (command.equals("회원가입")) {
                System.out.println("회원가입을 입력하셨습니다, 회원가입 단계로 이동합니다.");
                String userId;
                String password;
                String passwordConfirm;
                LocalDate now = LocalDate.now();
                while (true) {

                    System.out.println("아이디를 입력해주세요: ");
                    userId = sc.nextLine();
                    boolean isDuplecated = false;
                    for (CookRecipe cookRecipe : cookRecipes) {
                        if (userId.equals(cookRecipe.getUserId())) {
                            System.out.println("중복아이디가 존재합니다.");
                            isDuplecated = true;
                        }
                    }
                    if (!isDuplecated) {
                        break;
                    }
                }
                while (true) {
                    System.out.println("비밀번호를 입력해주세요: ");
                    password = sc.nextLine();

                    System.out.println("비밀번호를 확인합니다: ");
                    passwordConfirm = sc.nextLine();

                    if (password.equals(passwordConfirm)) {
                        break;
                    }
                    System.out.println("일치하는 비밀번호가 없습니다.");
                }
                CookRecipe cookRecipe = new CookRecipe(memberId, userId, password, now.toString());
                cookRecipes.add(cookRecipe);
                System.out.println(userId + "님 회원가입을 환영합니다.");
                memberId++;
            } else if (command.equals("로그인")) {

                CookRecipe rogin = null;
                if (userInfo==null){
                    System.out.println("로그인 상태가 안닙니다.");
                    continue;
                }
                System.out.printf("아이디를 입력해주세요: ");
                String username = sc.nextLine();
                System.out.printf("비밀번호를 입력해주세요: ");
                String password = sc.nextLine();
                for (CookRecipe cookRecipe : cookRecipes) {
                    if (username.equals(cookRecipe.getUserId())) {
                        rogin = cookRecipe;
                        break;
                    }
                }
                if (rogin == null) {
                    System.out.println("로그인이 되지 않습니다.");
                    continue;
                }
                if (rogin.getPassword().equals(password)==false) {
                    System.out.println("일치하는 비밀번호가 없습니다.");
                    continue;
                }
                userInfo = rogin;
                System.out.println(username + "님 로그인이 완료되었습니다.");


            } else if (command.equals("로그아웃")) {
                if (userInfo==null){
                    System.out.println("로그아웃 상태입니다.");
                    continue;
                }
            }
        }
        sc.close();

        while (true){
            System.out.println("회원정보가 일치하여 로그인합니다. 레시피 단계로 이동합니다. ");
            System.out.println("메뉴를 선택 해주세요.");
            String choose = sc.nextLine();
            if (choose.equals("종료")){
                break;
            } else if (choose.equals("자신이 고르고 싶은 종류의 음식을 등록합니다.")) {
                System.out.println("등록");
                String command = sc.nextLine();
                System.out.println("재료: ");
                String ingredient = sc.nextLine();
                System.out.println("소요시간: ");
                int time = sc.nextInt();
                System.out.println("난이도: ");
                String difficulty = sc.nextLine();
            }
        }

    }
}