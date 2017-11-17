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
 *  This class is for converting *.csv file to two dimensional array in memory.
 * @author Ryan Tsang
 */
public class ArrayDaoCSVImpl implements ArrayDao{
    
    private String fileName;
    
    private static String COMMA_DELIMITER = ",";
    private static String NEW_LINE_SEPARATOR = "\n";
    
    public ArrayDaoCSVImpl(String _fileName){
        fileName = _fileName;
    }
    
    @Override
    public int addArray(String[][] array) {
        FileWriter fileWriter = null;

        int impactedRowNum = 0;
        
        try {
            File file = new File(fileName);
			//Delete existing file if there is
            if(file.exists()){
                file.delete();
            }
            fileWriter = new FileWriter(file , true);
			//Write every single item in the file using two for loop
            for(int y = 0; y < array.length; y++){
                for(int x = 0; x < array[y].length; x++){
                    fileWriter.append(array[y][x]);
                    if(x != (array[y].length-1)){
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
			//Flush and close fileWriter after used
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
		   //create BufferedReader
            reader = new BufferedReader(new FileReader(fileName));
            String thisLine = "";
            List<List<String>> stringList = new ArrayList<List<String>>();
			//read a whole line each time
            while((thisLine = reader.readLine()) != null){
                thisLine = thisLine.replaceAll("/n", "");
                stringList.add(Arrays.asList(thisLine.split(COMMA_DELIMITER)));
            }
			//Package two dimensional array
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
			   //Close reader after used
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
