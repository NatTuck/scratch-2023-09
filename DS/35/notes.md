
# Lecture 35: It's After Thanksgiving

Our point of sale program:

 - Terminal app
 - Interactive
 - Reads menu data in once on startup
   - O(n) in size of menu
 - Accepts multiple orders
   - Order is a list of item codes
 - Prints bill / recipt for each order
   - O(n) in size of order

Example: 

 Input: S2, R09, G
 Output:
 
    Salmon                         7.75/each  1     =  7.75
    Eel Roll                       8.25/each  1     =  8.25
    Chicken Terroriaki, Egg Rolls 12.50/each  1     = 12.50 
        subtotal ...
        + 6.25% tax ...
        = total

Ideas:

 - Sorting take O(n log n)
 - Loading into a linked list would take O(n)
   - Finding an item takes O(n)
 - If we split by letter in our list, we can do
   constant time lookups.
 - Loading into a hash map will take O(n).
   - Finding item in a hash map takes O(1).


