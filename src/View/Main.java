package View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        while (true) {
            System.out.println("================Menu===============");
            System.out.println("1. Hiển thị danh bạ");
            System.out.println("2. Thêm danh bạ");
            System.out.println("3. Sửa danh bạ ");
            System.out.println("4. Xóa danh bạ");
            System.out.println("5. Tìm kiếm ");
            System.out.println("6. Sắp xếp");
            System.out.println("7. In file");
            System.out.println("8. Đọc file");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    menu.case1();
                    break;
                case 2:
                    menu.case2();
                    break;
                case 3:
                    menu.case3();
                    break;
                case 4:
                    menu.case4();
                    break;
                case 5:
                    menu.case5();
                    break;
//                case 6:
//                    menu.case6();
//                    break;
//                case 7:
//                    menu.case7();
//                    break;
                case 8:
                    System.out.println("Bái bai :))");
                    System.exit(0);
            }
        }
    }
}
