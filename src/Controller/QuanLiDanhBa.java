package Controller;

import Service.DanhBa;

import java.util.ArrayList;
import java.util.List;

public class QuanLiDanhBa  {
    private List<DanhBa> listDanhBa = null;

    public QuanLiDanhBa( ) {
        listDanhBa =new ArrayList<>();
    }

    public List<DanhBa> getListDanhBa() {
        return listDanhBa;
    }

    public void setListDanhBa(List<DanhBa> listDanhBa) {
        this.listDanhBa = listDanhBa;
    }

    public void hienThi(List<DanhBa> list) {
        for (DanhBa danhBa : list){
            System.out.println(danhBa);
        }
    }

     public void them(DanhBa danhBa) {
        listDanhBa.add(danhBa);
    }

    public void capNhap(int index,DanhBa danhBa) {
//        int index = listDanhBa.indexOf(findBySdt(sdt));
        for (DanhBa db : listDanhBa ){
            if (listDanhBa.indexOf(db)==index){
                db.setSoDienThoai(danhBa.getSoDienThoai());
                db.setNhom(danhBa.getNhom());
                db.setHoTen(danhBa.getHoTen());
                db.setGioiTinh(danhBa.getGioiTinh());
                db.setDiaChi(danhBa.getDiaChi());
                db.setEmail(danhBa.getEmail());
            }
        }
    }
    public int checkDanhBaIndex(String sdt) {
        for (int i = 0; i < listDanhBa.size(); i++) {
            if (listDanhBa.get(i).getSoDienThoai().equals(sdt)){
                return listDanhBa.indexOf(i);
            }
        }
        return -1;
    }
    public void xoa(String sdt) {
        int findIndex = checkDanhBaIndex(sdt);
        if (findIndex==-1){
            System.out.println("Không tìm thấy danh bạ");
        }else {
            listDanhBa.remove(findIndex);
        }
    }
    public DanhBa findBySdt(String sdt){
        for (DanhBa danhBa : listDanhBa){
            if (danhBa.getSoDienThoai().equals(sdt)){
                return danhBa;
            }
        }
        return null;
    }
    public List<DanhBa> findByName(String name){
        List<DanhBa> list = new ArrayList<DanhBa>();
        int count = 0;
        for (DanhBa danhBa : list){
            if (danhBa.getHoTen().equals(name)){
                list.add(danhBa);
                count++;
            }
        }
        if (count!=0){
            return list;
        }else {
            return null;
        }
    }
}
