
import java.util.Scanner;
import java.util.InputMismatchException;

public class App {

    private static Scanner sc = new Scanner(System.in);
    private static  String inquiryMessage = "please select player 1: 0 for a human player, or 1 for a robot.";
    private static boolean pass = true;
    private static TicPlayer firstPlayer, secondPlayer;
    private static int firstPlayerType , secondPlayerType;
    private static String firstPlayerSymbol, secondPlayerSymbol;
    private static String firstPlayerName = "Darth Vader", secondPlayerName = "Anakin Skywalker";
    private static TicTacToeBoard gameBoard;

    public static void initialize(){
        //inquire first player type: 0 for human, 1 for robot.
        do{
            try{
                System.out.println(inquiryMessage);
                int choice = sc.nextInt();
                if (choice ==0 || choice ==1){
                    firstPlayerType = choice;
                    pass = false;
                }else{
                    inquiryMessage = "Oops, only 0 or 1 input is allowed, 0 for a human player, or 1 for a robot.";
                }
            }catch(Exception e){
                if(e instanceof InputMismatchException){
                    inquiryMessage = "please input 0 or 1:"; 
                    sc = new Scanner(System.in);
                    
                }
            }
        }while(pass);

        //inquire second player type: 0 for human, 1 for robot.
        pass = true;
        do{
            try{
                System.out.println("please select player 2: 0 for a human player, 1 for a robot");
                int choice = sc.nextInt();
                if (choice ==0 || choice ==1){
                    secondPlayerType = choice;
                    pass = false;
                }else{
                    inquiryMessage = "Oops, only 0 or 1 input is allowed, 0 for a human player, or 1 for a robot.";

                }
            }catch(Exception e){
                
                if(e instanceof InputMismatchException){
                    inquiryMessage = "please input 0 or 1:"; 
                    sc = new Scanner(System.in);  
                }
            }
        }while(pass);

        //select first player's symbol
        pass = true;
        inquiryMessage = "Which symbol should the first player use? please enter \"o\" or \"x\" and ENTER.";
        do{
            try{
                System.out.println(inquiryMessage);
                String choice = sc.next();
                choice = choice.toLowerCase();
                if (choice.equals("o") || choice.equals("x") ){ 
                    firstPlayerSymbol = choice;
                    if(firstPlayerSymbol.equals("o")){
                        secondPlayerSymbol = "x";
                    }else{
                        secondPlayerSymbol = "o";
                    }
                    pass = false;
                }else{
                    inquiryMessage = "Oops, only \'o\' or \'x\' is allowed, please try again.";
                }
            }catch(Exception e){
                inquiryMessage = "Please try again, press \'o\' or \'x\' and ENTER.";
                sc = new Scanner(System.in);
            }
        }while(pass);

        //user informations
        System.out.println("firstPlayer: " + firstPlayerName + ":" + firstPlayerType + ":" + firstPlayerSymbol);
        System.out.println("secondPlayer: " + secondPlayerName + ":" + secondPlayerType + ":" + secondPlayerSymbol);

        //creates first player
        if(firstPlayerType == 0){
            firstPlayer = new HumanTicPlayer(firstPlayerName, firstPlayerSymbol, sc);
        }else{
            firstPlayer = new RobotTicPlayer(firstPlayerName, firstPlayerSymbol);
        }
        
        //create second player
        if(secondPlayerType == 0){
            secondPlayer = new HumanTicPlayer(secondPlayerName, secondPlayerSymbol, sc);
        }else{
            secondPlayer = new RobotTicPlayer(secondPlayerName, secondPlayerSymbol);
        }
        //create the game board
        gameBoard = new TicTacToeBoard(firstPlayer,secondPlayer);
        //let the players remember the playing board.
        firstPlayer.setPlayingBoard(gameBoard);
        secondPlayer.setPlayingBoard(gameBoard);
        //start the game
        gameBoard.runningGame();
    }

    public static void main(String[] args) throws Exception {
        
        //get initiating input from the terminal.
        initialize();
        
    }
}
