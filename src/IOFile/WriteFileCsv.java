package IOFile;

import Service.DanhBa;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileCsv {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String TITLE= "Số điện thoại,nhóm,Tên,Giới tính,Địa chỉ,Ngày sinh,Email";
    public void writerDanhBa(String path, List<DanhBa> list)  {
        FileWriter writer = null;
        try{
            writer = new FileWriter(path);
            writer.write(TITLE);
            writer.append(NEW_LINE_SEPARATOR);
            for (DanhBa danhBas : list) {
                writer.append(danhBas.getSoDienThoai());
                writer.append(COMMA_DELIMITER);
                writer.append(danhBas.getNhom());
                writer.append(COMMA_DELIMITER);
                writer.append(danhBas.getHoTen());
                writer.append(COMMA_DELIMITER);
                writer.append(danhBas.getGioiTinh());
                writer.append(COMMA_DELIMITER);
                writer.append(danhBas.getDiaChi());
                writer.append(COMMA_DELIMITER);
               writer.append(danhBas.getNgaySinh());
                writer.append(COMMA_DELIMITER);
                writer.append(danhBas.getEmail());
                writer.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Finish!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error fileCSV");
                e.printStackTrace();
            }
        }
    }
}
