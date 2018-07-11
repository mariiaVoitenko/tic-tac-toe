1) There are two kind of players: common one and AI one. AIPlayer extends Player. Both of them have ID and character for
   representing their steps on board
2) Board.java is class representing the play board. It creates it, marks it with players' characters, checks if position
   is free and draws itself
3) Position.java represents single point on the board.
4) PlayerList.java performs logic to set up players with their IDs and characters and shuffles the list of them to make
   random order of turns
5) Game.java is class responsible for handling all game process using different classes which have responsibility in one
   area of game. It reads properties, sets up players, takes player's input, marks the board, draws current state of
   board and checks if someone is a winner
6) There are several strategies for defining a winner. Now it is required to set a whole line (horizontal, vertical or
   any of diagonal) with player's character, but possible strategies can be easily configured. Every strategy has own
   traversal order which defines a way to navigate board while finding marked lines. WinStrategyContainer.java is made
   for containing all strategies and checking them for defining a winner.
7) MessagePrinter.java is responsible for printing messages to console.
8) Player's input is handled by PositionReader.java interface, having two implementations. AIPositionReader is a random-
   based position provider. InputPositionReader.java handles console input of real users and triggers validation for it.
   Input is required until real user enters correct position, divided by comma.
9) PositionReaderFactory.java returns proper PositionReader for current player.
10)To validate input from console and configurations several validators are provided. All of them throw customized
   exceptions.
   
   Information about deployment can be found in HOWTODEPLOY.txt