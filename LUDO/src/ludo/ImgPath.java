
package ludo;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper class to set up and retrieve the path(location) of each of the images of the ludo elements.
 */
public class ImgPath {
    
    /**
     * player colors
     */
    public enum Color {yellow, red, green, blue};

    /**
     * player themes
     */
    public enum Theme {plain, solid, fruits};

    /**
     * available board 
     */
    public enum Board {board, specialboard};

    /**
     * The two possible states of the dice: showing a result or rolling (being animated)
     */
    public enum DiceImg {result, animateddice};
    
    public static final String GEN_PATH ="images";
    public static final String DIR ="\\";
    public static final String FILE_EXTENSION =".png";
    public static final String DICE_PATH =GEN_PATH+DIR+"dice\\reddice\\";
    
    
    private static Map<Theme, String> themePath = new HashMap<>();
    private static Map<Color, String> tokenPath = new HashMap<>();
    private static Map<Board, String> boardPath = new HashMap<>();
    private static String dicePath;
    
    /**
     * Creates a hash table with a path for each of the possible themes
     */
    public ImgPath(){
        for (Theme t: Theme.values()){
            themePath.put(t, GEN_PATH+DIR+t.name()+DIR);}
    }
    
    public static void setTokenPath(Theme t){
        for(Color c: Color.values()){
            tokenPath.put(c, themePath.get(t)+c.name()+FILE_EXTENSION);}
    }
    

    public static String getTokenPath(Color c){
        return tokenPath.get(c);
    }
    

    public static void setBoardPath(Theme t){
        for(Board b: Board.values()){
            boardPath.put(b, themePath.get(t)+b.name()+FILE_EXTENSION);}
    }
    
    public static String getBoardPath(Board b){
        return boardPath.get(b);}
}
