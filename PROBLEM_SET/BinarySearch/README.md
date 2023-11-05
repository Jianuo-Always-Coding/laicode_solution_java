# Binary Search
## find a missing number in a sorted array
#### Rule : 
1. first occurrence of elements such that array[index] - index = 2.
2. Return array[index] - 1;
#### Corner case
1. Array is [] :  return 1;
2. 一个连续的array(少最后一个)：return array[array.length - 1] + 1;
#### Code evaluation 
TC : O(logn) 
SC : O(1)
