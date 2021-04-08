/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* runningSum(int* nums, int numsSize, int* returnSize){
    int run=0;
    int* res=(int*)malloc(numsSize*sizeof(int));
    for(int i=0;i<numsSize;i++){
        
        run+=*nums;
        res[i]=run;
        nums++;
    }
    *returnSize = numsSize;
    return res;
}