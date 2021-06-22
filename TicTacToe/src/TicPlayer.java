import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


interface ProposeAMove{
    public int proposeAMove();
} 

public class TicPlayer implements ProposeAMove{
    
    //player name
    private String name;
    //player symbol
    private String symbol;
    //occupiedPlaces
    protected ArrayList<Integer> occupiedPlaces;
    //playing game board
    protected TicTacToeBoard playingBoard;
    //constructor
    public TicPlayer(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
        this.occupiedPlaces = new ArrayList<>();
    }
    //get the player's name
    public String getName(){
        return this.name;
    }

    //get the symbol
    public String getSymbol(){
        return this.symbol;
    }
    //set player's playing game board, to access the board's occupiedPlaces.
    public void setPlayingBoard(TicTacToeBoard board){
        this.playingBoard = board;
    }
    //add the qualified move to its occupiedPlaces ArrayList.
    public void addAMove(int move){
        this.occupiedPlaces.add(move);
    }
    //propose a move to the board when it is called.
    public int proposeAMove(){
        System.out.println("This is a void func in the class TicPlayer.\n Please implement it youself.");
        return 0;
    }
    
}

class HumanTicPlayer extends TicPlayer{

    //a Scanner variable to receive the System.in.Scanner obj created by main()
    //could be upgrade to a singleton.
    public Scanner scanner;    
    //constructor
    public HumanTicPlayer(String name, String symbol, Scanner sc){
        super(name,symbol);
        this.scanner = sc;
    }
    
    //HumanTicPlayer override the proposeAMove method, 
    //implement an agent to ask human player select a 
    //move and input the index-number of the place.
    @Override
    public int proposeAMove(){
        //scanner for scanning human player input.
        boolean pass = true;
        int move = 0;
        String message = "please make a move, input the number 1-9 which represents the selected place:"; 
        // System.out.println(message);
        // move = scanner.nextInt();
        do{
            try{
                System.out.println(message);
                move = scanner.nextInt();
                if (move < 1 || move > 9){
                    message = "value error, please input number 1-9.";
                }else{
                    pass = false;
                }
            }catch(Exception e){
                if(e instanceof InputMismatchException){
                    message = "please input number 1-9:";
                    scanner = new Scanner(System.in);
                }
            }
        }while(pass);
        return move;
    }
}



class RobotTicPlayer extends TicPlayer {

    //the total places
    private final ArrayList<Integer> totalPlaces;
    //the available places
    private ArrayList<Integer> restPlaces;
    //random
    private Random rand;
    //constructor
    public RobotTicPlayer(String name, String symbol) {
        super(name, symbol);
        totalPlaces = new ArrayList<>();
        for(int i=0; i<9; i++){
            totalPlaces.add(i+1);
        }
        restPlaces = new ArrayList<>();
        rand = new Random();
    }

    //make a decison which place is chosen as the move.
    //first the method checks which places are available by
    //minusing the playingBoard's occupiedPlaces from the totalPlaces.
    //then randomly chooses a number from the rests of the places.
    public int makeDecison(){
        int move = 0;
        int numberOfRestPlaces=0;
        int index = 0;
        restPlaces = totalPlaces;
        //if the minus does not change the totalPLaces means the board is empty.
        if(!restPlaces.removeAll(playingBoard.getOccupiedPlaces())){
            System.out.println("I am happy to make the first move.");
        }
        numberOfRestPlaces = restPlaces.size();
        //dev output
        System.out.println("remain places: " + numberOfRestPlaces);
        index = rand.nextInt(numberOfRestPlaces);
        move = restPlaces.get(index);
        return move;
    }
    //override the proposeAMove() 
    @Override
    public int proposeAMove(){
        System.out.println("Let me make a move...");
        return makeDecison();
    }
}