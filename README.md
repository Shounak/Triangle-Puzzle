# Triangle-Puzzle
Finds the maximum sum of a path taken from top to bottom on triangle of integers. 

#####Problem statement:#####
By starting at the top of the triangle and moving to adjacent numbers on the row below, the maximum total from top to bottom is 27.

**5**


**9**      6


4      **6**      8


0      **7**      1      5


I.e. 5 + 9 + 6 + 7 = 27.


#####Solution:#####
This solution uses a bottom-up approach. It sums all the elements in the current row with the larger of the two elements below it. 
It repeats this process up the triangle, until finally, the topmost element contains the maximum sum. 
This solution runs in O(n*log n) time and uses O(log n) space, where n is defined as the total number of integers in the input file. 

