/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

  */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket=new List[nums.length+1];
        HashMap<Integer,Integer> hmap =new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(nums[i])){
                hmap.put(nums[i],hmap.get(nums[i])+1);
            }
            else{hmap.put(nums[i],1);}
        }

        for(int key:hmap.keySet()){
            if(bucket[hmap.get(key)]==null)
            {
                bucket[hmap.get(key)]=new ArrayList<>();
            }
            bucket[hmap.get(key)].add(key);
        }
        int ans[]=new int[k];
        int count=0;
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
            if(k==0)
            break;
            for(int j=0;j<bucket[i].size();j++){
                ans[count]=bucket[i].get(j);
                count++;
                k--;
                if(k==0)
                break;
            }
        }
        }
        return ans;

    }
}
