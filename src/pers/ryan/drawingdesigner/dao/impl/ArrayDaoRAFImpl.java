package pers.ryan.drawingdesigner.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pers.ryan.drawingdesigner.dao.ArrayDao;

/**
 *  This class is for converting *.raf file to two dimensional array in memory.
 * @author Ryan Tsang
 */
public class ArrayDaoRAFImpl implements ArrayDao{
    
    private String fileName;
    
    private static String COMMA_DELIMITER = ",";
    private static String NEW_LINE_SEPARATOR = "\n";
    
    public ArrayDaoRAFImpl(String _fileName){
        fileName = _fileName;
    }
    
    @Override
    public int addArray(String[][] array) {
        StringBuffer stringBuffer = new StringBuffer();
        String s = new String();
        RandomAccessFile RAFFile = null;
        int impactedRowNum = 0;
        
        try {
            File file = new File(fileName);
            if(file.exists()){
                file.delete();
            }
            
            RAFFile = new RandomAccessFile(fileName, "rw");
            for(int y = 0; y < array.length; y++){
                for(int x = 0; x < array[y].length; x++){
                    stringBuffer.append((x+1)+COMMA_DELIMITER+(y+1)+COMMA_DELIMITER+array[y][x]+COMMA_DELIMITER);
                }
            }
            s = stringBuffer.substring(0, stringBuffer.length()-1);
            RAFFile.writeUTF(s);
       } catch (IOException ex) {
           Logger.getLogger(ArrayDaoRAFImpl.class.getName()).log(Level.SEVERE, null, ex);
       }finally {
        try {
            RAFFile.close();
        } catch (IOException e) {
            System.out.println("Error while closing RAF file !!!");
            e.printStackTrace();
        }
        }
       return impactedRowNum;
    }

    @Override
    public String[][] selectArray() {
        RandomAccessFile RAFFile = null; 
        String[][] stringArray = null;
        String s = "";
        try {
            RAFFile = new RandomAccessFile(fileName, "r");
            List<List<String>> stringList = new ArrayList<List<String>>();
            String[] tempArray = new String[3];
            String[] tempArray1 = new String[4];
            List<String> tempList = new ArrayList<String>();
            int lastY = 1;
            s = RAFFile.readUTF();
            while(!s.equals("")){
                tempArray1 = s.split(COMMA_DELIMITER, 4);
                tempArray = Arrays.copyOfRange(tempArray1, 0, 3);
                if(tempArray1.length == 4){
                    s = tempArray1[3];
                }else{
                    s = "";
                }
                if(lastY == Integer.parseInt(tempArray[1])){
                    tempList.add(tempArray[2]);
                }else{
                    stringList.add(tempList);
                    tempList = new ArrayList<String>();
                    tempList.add(tempArray[2]);
                }
                lastY = Integer.parseInt(tempArray[1]);
            }
            stringList.add(tempList);
            stringArray = new String[stringList.size()][stringList.get(0).size()];
            for(int i = 0; i < stringList.size(); i++){
                stringArray[i] = stringList.get(i).toArray(stringArray[i]);
            }
       }catch (FileNotFoundException ex) {
            Logger.getLogger(ArrayDaoCSVImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArrayDaoCSVImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
           try {
               RAFFile.close();
           } catch (IOException ex) {
               Logger.getLogger(ArrayDaoCSVImpl.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return stringArray;
    }

    @Override
    public int updateArray(String[][] array) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
