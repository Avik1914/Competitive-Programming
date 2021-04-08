

int balancedStringSplit(char * s){
    int res=0;
    int noOfL=0;
    int noOfR=0;
    
    while(*s!='\0'){
        if(*s=='L')
            noOfL++;
        else
            noOfR++;
        if(noOfL==noOfR){
            res++;
            noOfL=0;
            noOfR=0;
        }
        s++;
    }
    
    return res;
}