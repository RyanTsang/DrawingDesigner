package pers.ryan.drawingdesigner.service;

import java.nio.file.Files;
import pers.ryan.drawingdesigner.dao.ArrayDao;
import pers.ryan.drawingdesigner.dao.impl.ArrayDaoABCImpl;
import pers.ryan.drawingdesigner.dao.impl.ArrayDaoCSVImpl;
import pers.ryan.drawingdesigner.dao.impl.ArrayDaoRAFImpl;
import pers.ryan.drawingdesigner.dao.impl.ArrayDaoTXTImpl;

/**
 *
 * @author Ryan Tsang
 */
public class ArrayService {
    String fileName;
    ArrayDao dao;
    
    public ArrayService(String _fileName) {
        fileName = _fileName;
        
        String extension= "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
        extension = fileName.substring(i+1);
        }
        
        /***
         * Use Polymorphism
         */
        if(extension.equals("csv")){
            dao = new ArrayDaoCSVImpl(fileName);
        }else if(extension.equals("txt")){
            dao = new ArrayDaoTXTImpl(fileName);
        }else if(extension.equals("abc")){
            dao = new ArrayDaoABCImpl(fileName);
        }else if(extension.equals("raf")){
            dao = new ArrayDaoRAFImpl(fileName);
        }else{
            //If user input unsupport fiel type, throw an exception
            throw new RuntimeException("File extension invalid, please try again.");
        }
    }
    
    public String[][] findArray(){
        return dao.selectArray();
    }
    
    public int saveArray(String[][] array){
        return dao.addArray(array);
    }
}
