

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
char ** letterCombinations(char * digits, int* returnSize){
    char **res=(char **)malloc(sizeof(char*)*300);
    char *digToChar[10]={"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    int resLen=0;
    *returnSize=0;
    
    char *tmp[strlen(digits)+1];
     
    if(strlen(digits)==0)
        return res;
    
    
    dfs(res,digits,digToChar,tmp,&resLen,0);
    
    *returnSize=resLen;  
    return res;
}

void dfs(char ** res,char *digits,char **digToChar, char *tmp,int *resLen, int start){
    
    if(start==strlen(digits)){
        
        tmp[start]='\0';
        printf("%s",tmp);
        char * perRes=(char*)malloc(sizeof(char*)*strlen(tmp));
        strcpy(perRes,tmp);
        res[*resLen]=perRes;
        (*resLen)++;
        return;
    }
    
    for(int i=0;i<strlen(digToChar[digits[start]-'0']);i++){
        tmp[start]=digToChar[digits[start]-'0'][i];
        dfs(res,digits,digToChar,tmp,resLen,start+1);
    }
}