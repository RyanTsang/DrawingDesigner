package pers.ryan.drawingdesigner.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pers.ryan.drawingdesigner.dao.ArrayDao;

/**
 *  This class is for converting *.txt file to two dimensional array in memory.
 * @author Ryan Tsang
 */
public class ArrayDaoTXTImpl implements ArrayDao{
    
    private String fileName;
    
    private static String COMMA_DELIMITER = ",";
    private static String NEW_LINE_SEPARATOR = "\n";
    
    public ArrayDaoTXTImpl(String _fileName){
        fileName = _fileName;
    }
    
    @Override
    public int addArray(String[][] array) {
        FileWriter fileWriter = null;

        int impactedRowNum = 0;
        
        try {
            File file = new File(fileName);
            if(file.exists()){
                file.delete();
            }
            fileWriter = new FileWriter(file , true);
            for(int y = 0; y < array.length; y++){
                for(int x = 0; x < array[y].length; x++){
                    fileWriter.append((x+1)+COMMA_DELIMITER+(y+1)+COMMA_DELIMITER+array[y][x]+NEW_LINE_SEPARATOR);
                }
                impactedRowNum++;
            }
       } catch (IOException ex) {
           Logger.getLogger(ArrayDaoCSVImpl.class.getName()).log(Level.SEVERE, null, ex);
       }finally {
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error while flushing/closing fileWriter !!!");
            e.printStackTrace();
        }
        }
       return impactedRowNum;
    }

    @Override
    public String[][] selectArray() {
       BufferedReader reader = null; 
       String[][] stringArray = null;
       try {
            reader = new BufferedReader(new FileReader(fileName));
            String thisLine = "";
            List<List<String>> stringList = new ArrayList<List<String>>();
            String[] tempArray = new String[3];
            List<String> tempList = new ArrayList<String>();
            int lastY = 1;
            while((thisLine = reader.readLine()) != null){
                thisLine = thisLine.replaceAll("/n", "");
                tempArray = thisLine.split(COMMA_DELIMITER);
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
        }finally{
           try {
               reader.close();
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
