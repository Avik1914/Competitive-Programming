class Solution {
    public String sortSentence(String s) {
        String[] arr=s.split(" ");
        Arrays.sort(arr,(a,b)->a.charAt(a.length()-1)-b.charAt(b.length()-1));
        StringBuilder str=new StringBuilder();
        
        
        for(int i=0;i<arr.length-1;i++)
            str.append(arr[i].substring(0,arr[i].length()-1)+" ");
        
        str.append(arr[arr.length -1].substring(0,arr[arr.length-1].length()-1));
        
        return str.toString();
    }
}