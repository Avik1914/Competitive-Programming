// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
       
        System.out.println(solution(s1,s2));
    }
    
    public static boolean solution(String S,String T){
        char[] arr1=S.toCharArray();
        char[] arr2=T.toCharArray();
        int ind1=0,ind2=0;
        int len1=arr1.length;
        int len2=arr2.length;
        int i=0,j=0;
        
        while(ind1<len1 || ind2<len2){
        if(ind1<len1 && ind2<len2 
            && Character.isLetter(arr1[ind1]) 
                && Character.isLetter(arr2[ind2])){
            if(arr1[ind1]!=arr2[ind2])
                return false;
            i++;
            j++;
            ind1++;
            ind2++;
        }else{
            int val1=0;
            int val2=0;
            while(ind1<len1 && Character.isDigit(arr1[ind1]))
                val1=val1*10+arr1[ind1++]-'0';
            while(ind2<len2 && Character.isDigit(arr2[ind2]))
                val2=val2*10+arr2[ind2++]-'0';
            
            i+=val1;
            j+=val2;
            if(j<i){
                if(ind2>=len2)
                    return false;
                ind2++;
                j++;
            }else if(i<j){
                if(ind1>=len1)
                    return false;
                ind1++;
                i++;
            }
        }
            System.out.println(i+","+j);
        }
        return i==j;
    }
}
