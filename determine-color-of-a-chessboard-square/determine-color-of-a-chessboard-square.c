

bool squareIsWhite(char * coordinates){
     int x=coordinates[0]-'a';
     int y=coordinates[1]-'0';
    
     if(x%2==0)
         return y%2==0;
     else
        return y%2==1;
}