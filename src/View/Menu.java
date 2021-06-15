package View;

import Controller.QuanLiDanhBa;
import Controller.Validate;
import IOFile.ReadFileCsv;
import IOFile.WriteFileCsv;
import Service.DanhBa;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    QuanLiDanhBa ql = new QuanLiDanhBa();
    ReadFileCsv rs = new ReadFileCsv();
    WriteFileCsv ws = new WriteFileCsv();
    public void case2() {
        ql.them(themDanhBa());
    }

    public void case1() {
        if (ql.getListDanhBa() == null) {
            System.out.println("Danh bạ rỗng");
        } else {
            ql.hienThi(ql.getListDanhBa());
        }
    }

    public void case3() {
        System.out.println("Nhập số điện thoại : ");
        String sdt = sc.nextLine();
        if (ql.findBySdt(sdt) != null) {
            ql.capNhap(ql.checkDanhBaIndex(sdt), themDanhBa());
        } else {
            System.out.println("Số điện thoại không tồn tại");
        }
    }

    public void case4() {
        System.out.println("Nhập số điện thoại :");
        String sdt = sc.nextLine();
        System.out.println("Bạn có chắc muốn xóa : ");
        System.out.println("1. Có");
        System.out.println("1. Không");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                ql.xoa(sdt);
                break;
            case 2:
                ql.hienThi(ql.getListDanhBa());
                break;
        }
    }

    public void case5() {
        System.out.println("Tìm kiếm theo :");
        System.out.println("1. Tìm theo số điện thoại");
        System.out.println("2. Tìm theo tên");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Nhập số điện thoại : ");
                String sdt = sc.nextLine();
                ql.findBySdt(sdt);
                break;
            case 2:
                System.out.println("Nhập tên :");
                String name = sc.nextLine();
                ql.hienThi(ql.findByName(name));
                break;
        }
    }
    public void case6(){
        ql.hienThi(rs.readerStudent("src/file.csv"));
    }
    public void case7(){
        ws.writerDanhBa("src/file.csv", ql.getListDanhBa());
    }


    public static DanhBa themDanhBa() {
        Scanner sc = new Scanner(System.in);
        QuanLiDanhBa ql = new QuanLiDanhBa();
        System.out.println("Nhập danh bạ");
        String sdt = null;
        do {
            do {
                System.out.println("Nhập số điện thoại (0xxxxxxxxx): ");
                sdt = sc.nextLine();
                if (ql.findBySdt(sdt) == null) {
                    if (!Validate.validate(sdt, Validate.SO_DIEN_THOAI)) {
                        System.out.println("Sai cú pháp yêu cầu nhập lại");
                    }
                } else {
                    System.out.println("Số điện thoại đã tồn tại");
                }
            } while (!Validate.validate(sdt, Validate.SO_DIEN_THOAI));
        } while (ql.findBySdt(sdt) != null);
        System.out.println("Nhập nhóm : ");
        String nhom = sc.nextLine();
        System.out.print("Nhập họ tên :");
        String ten = sc.nextLine();
        System.out.print("Nhập giới tính :");
        String gioiTinh = sc.nextLine();
        System.out.print("Nhập địa chỉ : ");
        String diaChi = sc.nextLine();
        String email;
        do {
            System.out.print("Nhập Email (ten.ho@codegym.vn): ");
            email = sc.nextLine();
            if (!Validate.validate(email, Validate.EMAIL)) {
                System.out.println("Sai cú pháp yêu cầu nhập lại");
            }
        } while (!Validate.validate(email, Validate.EMAIL));
        String dateOfBirth;
        do {
            System.out.print("Nhập ngày sinh(dd/mm/yyyy):");
            dateOfBirth = sc.nextLine();
            if (!Validate.validate(dateOfBirth, Validate.DATE_OF_BIRTH)) {
                System.out.println("Sai cú pháp yêu cầu nhập lại");
            }
        } while (!Validate.validate(dateOfBirth, Validate.DATE_OF_BIRTH));
        return new DanhBa(sdt, nhom, ten, gioiTinh, diaChi, dateOfBirth, email);
    }
}
