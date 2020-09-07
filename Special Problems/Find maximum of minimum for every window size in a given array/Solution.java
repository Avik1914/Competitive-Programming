/*
Problem Description
Given an integer array of size n, find the maximum of the minimum’s of every window size in the array. Note that window size varies from 1 to n.

Example:

Input: arr[] = {10, 20, 30, 50, 10, 70, 30}
Output: 70, 30, 20, 10, 10, 10, 10

The first element in the output indicates the maximum of minimums of all
windows of size 1.
Minimums of windows of size 1 are {10}, {20}, {30}, {50}, {10},
{70} and {30}. Maximum of these minimums is 70

The second element in the output indicates the maximum of minimums of all
windows of size 2.
Minimums of windows of size 2 are {10}, {20}, {30}, {10}, {10},
and {30}. Maximum of these minimums is 30




The third element in the output indicates the maximum of minimums of all
windows of size 3.
Minimums of windows of size 3 are {10}, {20}, {10}, {10} and {10}.
Maximum of these minimums is 20

Similarly, other elements of output are computed.
*/

/*
Description of the approach
This is stack related problem where we need to construct two preprocessing arrays with the left and right smaller elements details. As stack can easily solve the problem of finding the Next Smaller Element, So it can be rightly used in this problem.

So this will be a two step algorithm ,

1st Step :- In this step the preprocessing arrays will be created using a stack where the details of left and right smaller elements will be present.
2nd Step :- In this step the we can calculate the window for each element where it is the smallest number and then we can compare its value with the answer already           present in the output array(initialized with zero), if this value is larger than the answer then we shall replace this value for that window.
*/

