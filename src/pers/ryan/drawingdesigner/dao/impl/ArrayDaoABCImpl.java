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
 *  This class is for converting *.abc file to two dimensional array in memory.
 * @author Ryan Tsang
 */
public class ArrayDaoABCImpl implements ArrayDao{
    
    private String fileName;
    
    private static String COMMA_DELIMITER = ",";
    private static String NEW_LINE_SEPARATOR = "\n";
    
    public ArrayDaoABCImpl(String _fileName){
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
            List<List<List>> list = new ArrayList<List<List>>();
            
            for(int y = 0; y < array.length; y++){
                list.add(new ArrayList<List>());
                String lastColor = "";
                int count = 0;
                for(int x = 0; x < array[y].length; x++){
                    if(!lastColor.equals(array[y][x])){
                        list.get(y).add(new ArrayList());
                        list.get(y).get(count).add(array[y][x]);
                        list.get(y).get(count).add(1);
                        count++;
                        lastColor = array[y][x];
                    }else{
                        list.get(y).get(count-1).set(1, (int)list.get(y).get(count-1).get(1)+1);
                    }
                }
            }
            for(int y = 0; y < list.size(); y++){
                for(int i = 0; i < list.get(y).size(); i++){
                    fileWriter.append(list.get(y).get(i).get(0)+COMMA_DELIMITER+list.get(y).get(i).get(1));
                    if(i != (list.get(y).size()-1)){
                        fileWriter.append(COMMA_DELIMITER);
                    }else{
                        fileWriter.append(NEW_LINE_SEPARATOR);
                        impactedRowNum++;
                    }
                }
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
            List<List<String>> dataList = new ArrayList<List<String>>();
            List<List<String>> stringList = new ArrayList<List<String>>();
            while((thisLine = reader.readLine()) != null){
                thisLine = thisLine.replaceAll("/n", "");
                dataList.add(Arrays.asList(thisLine.split(COMMA_DELIMITER)));
            }
            for(int y = 0; y < dataList.size(); y++){
                stringList.add(new ArrayList<String>());
                for(int i = 0; i < dataList.get(y).size(); i = i+2){
                    for(int j = 0; j < Integer.parseInt(dataList.get(y).get(i+1)); j++){
                        stringList.get(y).add(dataList.get(y).get(i));
                    }
                }
            }
            
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
