=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: _______
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an approprate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2D arrays: This feature is natural to display the gameboard which is a 2d arrangment of 
  squares. For the same reason it makes sense to store the pieces locations in another 2d array.
  I followed the array[x][y] convention throughout the game.
  
  2. Sub-typing/Dynamic Dispatch: I used subytping through out the game by creating a general
  ChessPiece class. Each of the six specific types of pieces were a subtype of this Class. 
  This allows for much easier event handling and delegating the specific logic for the allowed 
  movements to each specific piece, while generalizing commands such as move.
  
  3. Collections: Each instance of ChessPiece stores a Set of legal moves. This is a natural 
  choice because there cannot be any duplicates and there is no order. This is used to check
  the legality of a move and to determine if the King is in Check.

  4. Testable Components: 


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?


- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?



========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.


