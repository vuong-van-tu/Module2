package IOFile;
import Service.DanhBa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCsv {
    private static final String COMMA_DELIMITER = ",";
    public List readerStudent(String path){
        List<DanhBa> newDanhBaList = new ArrayList<DanhBa>();
        FileReader reader =null;
        BufferedReader br = null;
        try {
            reader = new FileReader(path);
            br = new BufferedReader(reader);
            String line = br.readLine();
            while ((line = br.readLine()) != null){
                String[] lines = line.split(COMMA_DELIMITER);
                newDanhBaList.add(new DanhBa(lines[0],lines[1],lines[2],lines[3],lines[4],lines[5],lines[6]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newDanhBaList;
    }

}

