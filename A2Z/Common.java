public class Common {
    // number just greater than or equal to target O(Log n)
    public int lowerBound(int arr[],int target){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(target>=arr[mid]){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    // number just smaller than or equal to target O(Log n)
    public int upperBound(int arr[],int target){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(target<=arr[mid]){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public int slidingWindow(int arr[]){
        int i=0;
        int j=0;
        int ans=0;
        boolean someInvalidConditionWhereWindowShouldShrink = true;

        while(j<arr.length){
            //Implement condition with j pointer
            // sum+=nums[j]

            while(i<=j && someInvalidConditionWhereWindowShouldShrink){
                //Implement logic to undo added element in window
                i++;
            }

            //Perform or implement result according to condition
            ans+=0;
            j++;
        }

        return ans;
    }


}
