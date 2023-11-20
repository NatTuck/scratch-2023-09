
# Lecture 34 notes

Final exam: Monday, December 11, 11am-1:30pm, here


Going over 2b for the primes lab.

 - Change all int to long
 - Problem: BitSet.set(int)
 - Solution A: Write your own BitSet that takes longs
 - Solution B: Use an existing bitset that takes longs

In Java, bytes are different from characters.

 - Teletype machines
   - A typewriter, but you've got an electrical wire
     between the keyboard and the printing mechanism
   - Used a 6-bit digital encoding
 - Later, a 7 bit encoding happened: ASCII
 - Computers intiially used 8 bits/character
   - English charset was called Latin-1
   - Every language that used other characters got
     its own character set
   - Multi-byte characters sets were kind of awkward
 - Great idea: Universal character set
   - With 16-bits per character
   - Called Unicode / ucs2
 - Later, it was realized that there were more than 2^16
   characters.
 - So new character sets:
   - utf8, utf16, utf32 
   - variable length character sets
     - utf8:
       - first bit 0: next 7 bytes encode ASCII character
       - first bit 1: this character is at least 2 bytes

Streams:

 - Can only go through once.
 - Shouldn't modify contents during use.
 - Streams are lazy.
 - Sometimes parallel.
 
