class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums,temp,0,nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int[] temp, int low, int high)
    {
        if(low>=high)
        {
            return;
        }
        int mid=low+(high-low)/2;
        mergeSort(nums,temp,low,mid);
        mergeSort(nums,temp,mid+1,high);

        if(nums[mid]<=nums[mid+1]) return;

        merge(nums,temp,low,mid,high);
    }

    private void merge(int[] nums,int[] temp, int low,int mid,int high)
    {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }

        int left = low;
        int right = mid+1;
        int k=low;

        while(left<=mid && right<=high)
        {
            if (temp[left] <= temp[right]) {
                nums[k++] = temp[left++];
            } else {
                nums[k++] = temp[right++];
            }
        }

        while (left <= mid) {
            nums[k++] = temp[left++];
        }
    }
}