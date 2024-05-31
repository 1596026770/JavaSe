package _视频._17Stream.黄埔班考试真题P151;

public class JavaTest5 {
    public static void main(String[] args) {
     int[] nums = {5,7,7,7,7,8,8,10};
//     int[] nums1 = {5,7,7,8,8,10};
     int[] nums2 = {};
        System.out.println("["+startIndex(nums, 8)+","+endIndex(nums,8)+"]");
        System.out.println("["+startIndex(nums, 7)+","+endIndex(nums,7)+"]");
        System.out.println("["+startIndex(nums2, 0)+","+endIndex(nums2,0)+"]");

    }

    public static int startIndex(int[] nums, int target){
        if(nums ==null)return -1;
        int rs = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(target > nums[mid]){
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }else {
                rs = mid;
                right = mid-1;
            }
        }
//        if(left >= nums.length || (nums[left]!=target)){
//            return -1;
//        }else {
//            return left;
//        }
        return rs;

    }

    public static int endIndex(int[] nums, int target){
        if(nums ==null)return -1;
        int rs = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(target > nums[mid]){
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }else {
                rs = mid;
                left = mid+1;
            }
        }
//        if(right < 0 || (nums[right]!=target)){
//            return -1;
//        }else {
//            return right;
//        }
        return rs;
    }

}
