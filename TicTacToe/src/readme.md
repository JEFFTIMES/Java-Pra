## basic logic

### initiating

1. The *main()* method starts an initialize() method to inquery information for the the initiating parameters of the game. 
        players' type;
        players' symbol;

2. Construct 2 players from class **HumanPlayer** or class **RobotPlayer** depends on the type parameter and the symbol parameter come from the initiating arguments. Both **HumanPlayer** and **RobotPlayer** are the descendants extend from class **player**. The **Player** should has a variable *occupiedPlaces[]:int* to remember the places has been placed by itself. And it should have a variable *playingBoard* to remember the gameBoard it plays with (will be set after the board is constructed). Both players should implement the **ProposeAMove** interface to tell the board where to move. The two types of player is different from each other at the way it implements the ProposeAMove interface, the **HumanPlayer** implement it as an agent who scanning input from the keyboard, the **RobotPlayer** implement it by call the makeDecision() method which just randomly selecting a place in the available places.
   
3. Pass the two created players to the constructor to create an empty *gameBoard* form class **TicTacToeBoard**. except the *firstPlayers* and the *secondPlayer*, the *gameBoard* should have an *activePlayer* to represent the one who is placing the move. the *gameBoard* should have a variable *emptyBoard[][]:String* to save the empty board, a variable *currentBoard[][]:String* representing the board after each placement. The variable *gameBoard.occupiedPlaces[]:int* saves all the places occupied by both players. a place-index-number-to-board-coordination maping to help the updateBoard() method updating the gameBoard[][]. a *winPatterns[][]:ArrayList<Integer>* saved the winning patterns for checkingWinStatus() comparing with activePlayer.occupiedPlaces[].
   
4. the *gameBoard* object call Player.setGameBoard() method of each player, pass *this* for them to remember the board which they play with. 
   
5. *gameBoard* places the first player the *activePlayer*, then call *runningGame()* method to entering the game looping.

### runningGame() looping

in the runningGame() method, build a loop to repeat the following actions until the checkingWinStatus() return true.

1. the gameBoard start a do-while loopto ask the activePlayer to proposeAMove() until the proposed move is available.
   
2. Once the move is qualified, the gameBoard calls the placeMove() method to push the newMove into both the activePlayer's occupiedPlaces[]:ArrayList<Integer>, and the gameBoard's occupidPlaces[]:ArrayList<Integer> also.

3. call updateBoard() to populate the newMove on the currentBoardView. 

4. call the displayBoard() to print the new view out the terminal.

5. after any placement, call checkWinStatus() to check the status. if current player won or there is not available places for next move, update the winner and return true to break the looping.else swithes the activeToke to another player, keep the looping.


### closing
if checkWinStatus() return true to breaks the looping, print out the winner and quit. 

