import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
            int n=sc.nextInt();
            int[] arr1=new int[n];
           
            
            for(int i=0;i<n;i++)
                arr1[i]=sc.nextInt();
           
            int start=0;
            long sum=0;
            long res=0;
            Map<Long,Integer> map=new HashMap();
            map.put(0l,-1);
        
            for(int i=0;i<n;i++){
                sum+=arr1[i];
                if(map.containsKey(sum))
                    start=Math.max(start,map.get(sum)+2);  
                res+=i-start+1;
                map.put(sum,i);
            }
        System.out.println(res);
    }
}
