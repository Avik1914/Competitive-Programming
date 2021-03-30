

int secondHighest(char * c){
    int f=-1;
    int sec=-1;
    for(int i=0;i<strlen(c);i++){
        if(c[i]>='0' && c[i]<='9'){
            if(c[i]>f){
                sec=f;
                f=c[i];
            }else if(c[i]!=f && c[i]>sec){
                sec=c[i];
            }
        }
    }
    if(sec==-1)
        return -1;
    return sec-'0';

}