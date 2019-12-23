package repository;

import dto.StudentDTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final String filename = "Student.txt";


    public void write(List<StudentDTO> list){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
             fos = new FileOutputStream(new File(filename));
             oos = new ObjectOutputStream(fos);
             oos.writeObject(list);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }finally {
            closeStream(fos);
            closeStream(oos);
        }
    }
    public List<StudentDTO> read(){
        List<StudentDTO> list = new ArrayList<>();
        FileInputStream fis =null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(filename));
            ois = new ObjectInputStream(fis);
            list =(List<StudentDTO>) ois.readObject();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            closeStream(fis);
            closeStream(ois);
        }
        return list;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
