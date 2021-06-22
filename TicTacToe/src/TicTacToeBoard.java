import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//the check board like this
//       c0 c1 c2 c3 c4 
// r0     o  |  x  |  o 
// r1     -  +  -  +  - 
// r2     x  |  o  |  x 
// r3     -  +  -  +  - 
// r4     o  |  x  |  o 

// the validated input map to the available places.
// 1: board[0][0]
// 2: board[0][2]
// 3: board[0][4]
// 4: board[2][0]
// 5: board[2][2]
// 6: board[2][4]
// 7: board[4][0]
// 8: board[4][2]
// 9: board[4][4]


//int[] row = {-1,0,0,0,2,2,2,4,4,4}
//int[] col = {-1,0,2,4,0,2,4,0,2,4}

@FunctionalInterface
interface IndexToCoordiation{
    int mapping(int index);
}


public class TicTacToeBoard {

    //an empty board 
    private final String [][] emptyBoardView = {
                            {" ","|"," ","|"," "},  //row0
                            {"-","+","-","+","-"},  //row1
                            {" ","|"," ","|"," "},  //row2
                            {"-","+","-","+","-"},  //row3
                            {" ","|"," ","|"," "},  //row4
                        //   c0  c1   c2  c3  c4
                            };
    //win patterns
    private final int [][] winPatterns = {
                                    {1,2,3},
                                    {4,5,6},
                                    {7,8,9},
                                    {1,4,7},
                                    {2,5,8},
                                    {3,6,9},
                                    {1,5,9},
                                    {3,5,7},
                                    };

    //current board 
    private String [][] currentBoardView;
    //an empty ArrayList to append the occupied places.                      
    private ArrayList<Integer> occupiedPlaces;  
    //players 
    private TicPlayer firstPlayer, secondPlayer;
    //active player
    private TicPlayer activePlayer;
    //winner
    private String winner;
    //lambda : index number mapping to row coordination.
    IndexToCoordiation indexToRow = (i) ->  (int)((i-1)/3)*2;
    //lambda : index number mapping to row coordination.
    IndexToCoordiation indexToCol = (i) ->  (int)((i-1)%3)*2;

    public TicTacToeBoard(TicPlayer firstPlayer, TicPlayer secondPlayer){

        currentBoardView = emptyBoardView.clone();
        occupiedPlaces = new ArrayList<>();
        this.firstPlayer =  firstPlayer;
        this.secondPlayer = secondPlayer;
        activePlayer = firstPlayer;
        winner = "";
    }

    public ArrayList<Integer> getOccupiedPlaces(){
        return this.occupiedPlaces; 
    }

    public void runningGame(){
        int proposedMove;
        boolean gameOver = false;
        //reverse the active player against the initiating for correcting the following while() process
        switchPlayer();
        while(!gameOver){
            //switch player
            switchPlayer();
            do{
                //ask active player to propose a move.
                proposedMove = activePlayer.proposeAMove();
            //is the move avaiable?
            }while(isMoveAvailable(proposedMove));
            //place the qualified proposed move
            placeMove(proposedMove);
            //update the game board
            updateBoardView(proposedMove);
             //display the updated board
            displayBoard();
            //check winning status
            gameOver = checkWinStatus();           
        }
        System.out.println("Game Over, Winner is: " + winner);
    }
    
    //switch active player between the first and the second player.
    private void switchPlayer(){
        if(activePlayer == firstPlayer){    
            activePlayer = secondPlayer;
        }else{
            activePlayer = firstPlayer;
        }
    }
    
    //to checks is that proposed move available.
    //it is not available if the move the player proposed is in the baord's occupiedPlaces.
    private boolean isMoveAvailable(int move){
        //check if the place is avaiable
        return this.occupiedPlaces.contains(move);
    }

    private void placeMove(int move){

        //update player's occupies
        activePlayer.addAMove(move);
        //update board's occupies
        this.occupiedPlaces.add(move);
    }

    //each time a player makes a move, populate the occupiedPlaces on the currentBoardView
    //then call the displayBoard() to print the borad.
    private void updateBoardView(int move){
        HashMap<String,Integer> coords;
        //call the mapIndexToCoords() method to map the move from 
        //the index number to the coordinations of the view.
        coords = mapIndexToCoords(move, indexToRow, indexToCol);
        currentBoardView[coords.get("row")][coords.get("col")] = activePlayer.getSymbol();
    }

    //mapping index (1-9) to the board coordinations (row,col)
    //to facilitate the updating of the board 
    //take two lambdas as the parameters to map index to coords. 
    private HashMap<String,Integer> mapIndexToCoords(int index, IndexToCoordiation toRow, IndexToCoordiation toCol){
        HashMap<String,Integer> coord = new HashMap<>();
        int row,col;
        row = toRow.mapping(index);
        col = toCol.mapping(index);
        coord.put("row",row);
        coord.put("col",col);
        return coord;  
    }

    //display board.
    private void displayBoard(){
        String rowString = "";
        for(int row = 0; row < currentBoardView.length; row++){
            rowString = String.join("",currentBoardView[row]);
            System.out.println(rowString);
        }
    }
    
    //check if the active player's occupiedPlaces containsAll() 
    //one of the winPatterns, yes to set the winner the active player's name.
    //if no, check is there any available places left, if no set the 
    //winner the "duce". either the winner get a player's name or duce
    //return true.
    private  boolean checkWinStatus(){
        //check win Patterns
        for(int i = 0; i < winPatterns.length; i++){
            List<Integer> winPattern = new ArrayList<>();
            winPattern = IntStream.of(winPatterns[i]).boxed().collect(Collectors.toList());
            //dev output
            //System.out.println("win Pattern: " + winPattern);
            //System.out.println("player's places: " + activePlayer.occupiedPlaces);
            //check if player's places contains this win pattern.
            if(activePlayer.occupiedPlaces.containsAll(winPattern)){
                winner = activePlayer.getName();
                return true;
            }
        }
        //check duce by checking the length of board's occupiedPlaces,
        //if all 9 of the places were be occupied, that is mean duce.
        if(this.occupiedPlaces.size()==9){
            winner = "duce";
            return true;
        }
        //otherwise return false to continue the loop.
        return false;
    }
    
}        

