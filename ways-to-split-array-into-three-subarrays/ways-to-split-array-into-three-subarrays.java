                        hi=mid;
                    else
                        lo=mid+1;
                }
                
                start=lo;
                if(start>=len || sum-prefix[start]<prefix[start]-f)
                    continue;
                lo=start;
                hi=len-1;
                while(lo<hi){
                    int mid=((lo+hi)/2)+1;
                    if(sum-prefix[mid]>=prefix[mid]-f)
                        lo=mid;
                    else
                        hi=mid-1;
                }
                end=hi;
            }else
                break;
            if(end-start+1>0 && sum-prefix[end]>=prefix[end]-f && prefix[start]-f>=f){
                if(end!=len-1)
                    ans+=end-start+1;
                else
                    ans+=end-start;
                ans%=1000000007;
            }
            else
                continue;
        }
        return (int)ans;
    }
}
