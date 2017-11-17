package pers.ryan.drawingdesigner.form;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  This class allow user draw on it.
 *  It has most of properties related to drawing.
 * @author Ryan Tsang
 */
public class DrawPanel extends JPanel{
    
    private int MAX_X = 30;
    private int MAX_Y = 30;
    private String [][] stringArray = new String[MAX_Y][MAX_X];
    private Color currentColor = Color.BLACK;
    private Boolean isShowGrid = false;

    static final Map<String,Color> STRING_COLOR_MAP = new HashMap<String,Color>();
    
    {
        initialStringArray();
    }
    
    static{
        STRING_COLOR_MAP.put("b", Color.BLACK);
        STRING_COLOR_MAP.put("W", Color.WHITE);
        STRING_COLOR_MAP.put("R", Color.RED);
        STRING_COLOR_MAP.put("Y", Color.YELLOW);
        STRING_COLOR_MAP.put("B", Color.BLUE);
        STRING_COLOR_MAP.put("G", Color.GREEN);
    }
    
    public DrawPanel(){
        super();
        //When user click on it, change the two dimensional array and repaint this panel
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int mouseX = evt.getX()/(getSize().width/MAX_X);
                int mouseY = evt.getY()/(getSize().height/MAX_Y);
                
                for (Entry<String, Color> entry : STRING_COLOR_MAP.entrySet()) {
                   if (currentColor.equals(entry.getValue())) {
                       stringArray[mouseY][mouseX] = entry.getKey();
                    }
                }
                myPaint(mouseX, mouseY);
            }
        });
    }
    
    //Paint this panel accroding to the two dimentsional array
    public void myPaint(){
        Graphics2D g2d = (Graphics2D) getGraphics();
        int width = getSize().width/MAX_X;
        int height = getSize().height/MAX_Y;
        
        for(int y = 0; y < getStringArray().length; y++){
            for(int x = 0; x < getStringArray()[y].length; x++){
                g2d.setColor(STRING_COLOR_MAP.get(getStringArray()[y][x]));
                g2d.fillRect(x*width, y*height, width, height);
            }
        }
        
        if(isShowGrid){
            for(int y = 0; y < getStringArray().length; y++){
                for(int x = 0; x < getStringArray()[y].length; x++){
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(x*width, y*height, width, height);
                }
            }  
        }
    }
    
    //Paint specific rectangle instead of paint the whole panel in order to improve performance
    public void myPaint(int x, int y){
        Graphics2D g2d = (Graphics2D) getGraphics();
        int width = getSize().width/MAX_X;
        int hidth = getSize().height/MAX_Y;
        
        g2d.setColor(STRING_COLOR_MAP.get(getStringArray()[y][x]));
        g2d.fillRect(x*width, y*hidth, width, hidth);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        myPaint();
    }
    
    //Please see the document for more details of this method
    public void rotate(){
        String[][] tempStringArray = new String[MAX_Y][MAX_X];
        for(int y = 0; y < MAX_Y; y++){
            tempStringArray[y] = stringArray[y].clone();
        }
        for(int y = 0; y < MAX_Y; y++){
            for(int x = 0; x < MAX_X; x++){
                stringArray[x][MAX_X-1-y] = tempStringArray[y][x];
            }
        }
        myPaint();
    }

    /**
     * @return the stringArray
     */
    public String[][] getStringArray() {
        return stringArray;
    }

    /**
     * @param stringArray the stringArray to set
     */
    public void setStringArray(String[][] stringArray) {
        this.stringArray = stringArray;
        if(stringArray != null && stringArray[0] != null){
            this.MAX_X = stringArray[0].length;
            this.MAX_Y = stringArray.length;
        }
        myPaint();
    }

    /**
     * @return the currentColor
     */
    public Color getCurrentColor() {
        return currentColor;
    }

    /**
     * @param currentColor the currentColor to set
     */
    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    /**
     * @return the IsShowGrid
     */
    public Boolean getIsShowGrid() {
        return isShowGrid;
    }

    /**
     * @param IsShowGrid the IsShowGrid to set
     */
    public void setIsShowGrid(Boolean IsShowGrid) {
        this.isShowGrid = IsShowGrid;
        myPaint();
    }
    
    public void clearImage(){
        initialStringArray();
        myPaint();
    }
    
    //Please see the document for more details of this method
    public void flipHorizontally(){
        String[] tempStringArray;
        for(int y = 0; y < MAX_Y; y++){
            tempStringArray = stringArray[y].clone();
            for(int x = 0; x < MAX_X; x++){
                stringArray[y][x] = tempStringArray[MAX_X-x-1];
            }
        }
        myPaint();
    }
    
    //Please see the document for more details of this method
    public void flipVertically(){
        List<String> tempStringList = new ArrayList<String>();
        for(int x = 0; x < MAX_X; x++){
            for(int y = 0; y < MAX_Y; y++){
                tempStringList.add(stringArray[y][x]);
            }
            for(int y = 0; y < MAX_Y; y++){
                stringArray[y][x] = tempStringList.get(MAX_Y-y-1);
            }
            tempStringList.clear();
        }
        myPaint();
    }
    
    /***
     * Initialize the string Array
     */
    private void initialStringArray() {

        for(int x = 0; x < MAX_X; x++){
            for(int y = 0; y < MAX_Y; y++){
                getStringArray()[y][x] = "W";
            }
        }
    }
}