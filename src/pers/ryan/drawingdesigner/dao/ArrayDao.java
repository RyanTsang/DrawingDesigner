package pers.ryan.drawingdesigner.dao;


/**
 *
 * @author Ryan Tsang
 */
public interface ArrayDao {
    
    public int addArray(String[][] array);
    
    public String[][] selectArray();
    
    public int updateArray(String[][] array);
    
    public int delArray();
    
}
