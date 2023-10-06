
Chess Board

 - 8x8 grid of squares
 - Each square is either empty or has a chess piece
 - Chess pieces:  ♔ ♕ ♚ ♛ ♘ ♗ ♙ ♖ ♞ ♝ ♟ ♜

Simple solution:

 - Array of arrays of characters
 - ``char[][]``
 - Char is 16 bits, we need 64 of them
 - How many bytes for chess board? 128 bytes
 
Can we be more efficient?

 - Yes!
 - There are 12 chess pieces
 - Plus one possibility for blank
 - How many bits to store one of 13 possible values?
 - Need 4 bits
 - A piece is 4 bits, we need 64 of them.
 - How many bytes for chess board? 32 bytes
