
package ludo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import static ludo.Board.GLOBE_TILES;
import static ludo.Board.STAR_TILES;
import static ludo.Player.GOAL;
import static ludo.Player.OUT_OF_BOARD;
import static ludo.Player.START_DISTANCE;

/**
 * buat main sama computer
 */
public class Autoplay {
    public enum AutoplayMode {
        customAI,
        qLearning,
        random};
    
    private final Random r;
    private final Map<String, Integer> rewards;
    

    /**
     * Initializes the random number generator, the custom AI reward hash table and generates the qTable.
     */
    public Autoplay(){
        this.r= new Random();  
        this.rewards = new HashMap<>();
        
        rewards.put("hitGoal", 5);
        rewards.put("startToken", 10);
        rewards.put("startFinalTrack", 9);
        rewards.put("hitStar", 6);
        rewards.put("hitGlobe", 8);
        rewards.put("sendHome", 10);
        rewards.put("aheadOpponent", -3);
        rewards.put("behindOpponent", 2);  
        rewards.put("hitLastStar", -15);
    }
    
    //Reads the reward of each of the possible moves from a qTable and select the token with the highest reward.
    private int maxQToken(GameState game){
        Player currentPlayer = game.getPlayers()[game.getCurrentPlayer()];
        double qValue=0;
        double maxQ=-100;
        int maxQToken=0;
     
        if (game.getDice().getIsSix()){
            for(Token token: currentPlayer.getTokens()){
                if(token.getPosition()==OUT_OF_BOARD){
                     return token.getIndex();           
                }
            }
        }
        for(int tokenIndex: currentPlayer.getTokensOut()){
            Token token= currentPlayer.getToken(tokenIndex);
            int tokenPosition;
            if (token.getFinalTrack())
                tokenPosition= token.getPosition()+51;
            else
                tokenPosition = (token.getPosition()+52-currentPlayer.getPIndex()*START_DISTANCE)%52; 
            //System.out.printf("token %d: pos %d, qvalue %.15f\n",tokenIndex,currentPlayer.getToken(tokenIndex).getPosition(),qValue);
            if (qValue>maxQ){
                maxQ=qValue;
                maxQToken=tokenIndex;
            }
        }
        //System.out.printf("maxReward:%.15f, selectedToken:%d\n",maxQ,maxQToken);
        return maxQToken;
    }
    
    //Calculates the rewards for each of the possible moves and selects the token with the maximum reward
    private int maxRewardToken(GameState game){
        Player currentPlayer = game.getPlayers()[game.getCurrentPlayer()];
        List<Integer> opponentPositions=getOpponentPositions(game);
        int reward;
        int maxReward=-100;
        int maxRewardToken=0;
     
        if (game.getDice().getIsSix()){
            for(Token token: currentPlayer.getTokens()){
                if (!(token.getFinalTrack()&&!token.getOut())){
                    reward = getReward(game.getCurrentPlayer(), token, opponentPositions, game.getBoard().getSpecial(), game.getDice().getResult());
                    //System.out.printf("token %d: pos %d, reward %d\n",token.getIndex(),token.getPosition(),reward);
                    if (reward>maxReward){
                        maxReward=reward;
                        maxRewardToken=token.getIndex();
                    }
                }
            }        
        }
        else{
            for(int tokenIndex: currentPlayer.getTokensOut()){
               reward = getReward(game.getCurrentPlayer(),currentPlayer.getToken(tokenIndex), opponentPositions, game.getBoard().getSpecial(), game.getDice().getResult());
                //System.out.printf("token %d: pos %d, reward %d\n",tokenIndex,currentPlayer.getToken(tokenIndex).getPosition(),reward);
                if (reward>maxReward){
                    maxReward=reward;
                    maxRewardToken=tokenIndex;
                }
            }
        }
        //System.out.printf("maxReward:%d, selectedToken:%d\n",maxReward,maxRewardToken);
        return maxRewardToken;
    }
    
    //Calculates the reward for a move by adding up the rewards from the hash table for each of the verified conditions
    private int getReward (int pIndex, Token token, List<Integer> opponentPositions, boolean specialBoard, int diceResult){
        int reward=0;
        int nextPosition= token.getPosition()+diceResult;
        if(token.getPosition()==OUT_OF_BOARD&&diceResult==6){
            reward+=rewards.get("startToken");
            //System.out.println("startToken: "+rewards.get("startToken"));
        }
        else{
            if(token.getFinalTrack()){
                if(nextPosition==GOAL){
                    reward+=rewards.get("hitGoal");
                    //System.out.println("hitGoal: "+rewards.get("hitGoal"));
                }
                else{
                    reward-=rewards.get("hitGoal")/2;
                    //System.out.println("hitGoal: "+-rewards.get("hitGoal")/2);
                }
            }
            else{
                if(specialBoard){
                    if(STAR_TILES.contains(nextPosition)){
                    reward+=rewards.get("hitStar");
                    //System.out.println("hitStar: "+rewards.get("hitStar"));
                }
                if(GLOBE_TILES.contains(nextPosition)){
                    reward+=rewards.get("hitGlobe");
                    //System.out.println("hitGlobe: "+rewards.get("hitGlobe"));
                }}
                if(token.getPosition()<(pIndex*START_DISTANCE+50)%52&&nextPosition>(pIndex*START_DISTANCE+50)%52){
                    reward+=rewards.get("startFinalTrack");
                    //System.out.println("startFinalTrack: "+rewards.get("startFinalTrack"));
                }
                if(opponentPositions.contains(nextPosition%52)){
                    reward+=rewards.get("sendHome");
                    //System.out.println("sendHome: "+rewards.get("sendHome"));
                }
                if(nextPosition==(pIndex*START_DISTANCE+50)%52){
                    reward+=rewards.get("hitLastStar");     
                    //System.out.println("hitLastStar: "+rewards.get("hitLastStar"));
                }
                int ao = rewards.get("aheadOpponent")*tokensBehind(opponentPositions,nextPosition%52);
                int bo = rewards.get("behindOpponent")*tokensAhead(opponentPositions,nextPosition%52);
                if(ao!=0){
                    reward+=ao;
                    //System.out.println("aheadOpponent: "+ao);
                }
                if(bo!=0){
                    reward+=bo;
                    //System.out.println("behindOpponent: "+bo);
                }
            }
        }
        return reward;
    }
    
   //Calculates the number of opponent's tokens that will be within 6 tiles ahead of the player's token
   //in case the token moves to the position nextPosition
    private int tokensAhead(List<Integer> opponentPositions, int nextPosition){
        int tokens=0;
        for(int i=1; i<=6; i++){
            if (opponentPositions.contains(nextPosition+i)){
                tokens += Collections.frequency(opponentPositions, nextPosition+i);
            }
        }
        return tokens;
    }
    
   //Calculates the number of opponent's tokens that will be within 6 tiles behind the player's token
   //in case the token moves to the position nextPosition
    private int tokensBehind(List<Integer> opponentPositions, int nextPosition){
        int tokens=0;
        for(int i=1; i<=6; i++){
            if (opponentPositions.contains(nextPosition-i))
                tokens += Collections.frequency(opponentPositions, nextPosition-i);
        }
        return tokens;
    }
    
   //Generates a list of integers with the positions of all the opponent's tokens that are currently in the board.
    private List<Integer> getOpponentPositions(GameState game){
        List<Integer> opponentPositions=new ArrayList<>();
        for(int playerIndex: game.getXPlayers())
            if(playerIndex!=game.getCurrentPlayer()){
                for(int tokenIndex: game.getPlayers()[playerIndex].getTokensOut())
                    if(!game.getPlayers()[playerIndex].getToken(tokenIndex).getFinalTrack())
                        opponentPositions.add(game.getPlayers()[playerIndex].getToken(tokenIndex).getPosition());
            }
        return opponentPositions;                 
    }
    
    //Selects a random token from all the possible options available
    private int randomToken(GameState game){
        int selectedToken=0;
        if(game.getDice().getIsSix()){
            selectedToken=r.nextInt(4);
        }
        else{
            if(game.getPlayers()[game.getCurrentPlayer()].getTokensOut().size()>0)
                selectedToken=game.getPlayers()[game.getCurrentPlayer()].getTokensOut().get(r.nextInt(game.getPlayers()[game.getCurrentPlayer()].getTokensOut().size()));
        }
        return selectedToken;
    }
   
    /**
     * Selects the index of the token to be moved according to the player's AutoplayMode settings.
     * @param game instance of the GameState class containing the state of each of the elements present in a round of Ludo
     * @return the index of the selected token
     */
    public int selectToken(GameState game){
        AutoplayMode autoMode=game.getPlayers()[game.getCurrentPlayer()].getAutoMode();
        int selectedToken=0;
        switch(autoMode){
            case customAI:{selectedToken = maxRewardToken(game); break;}
            case qLearning:{selectedToken = maxQToken(game); break;}
            case random:{selectedToken = randomToken(game); break;}
        }
        return selectedToken;
    }
}

    

  

