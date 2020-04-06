package hardProblems;

import java.util.*;
public class MedianSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	      
	      int nums1_point = 0, nums2_point = 0;
	      double result = 0.0;
	      Boolean flag_1 = false;
	      Boolean isEven = false;
	      int len1 = nums1.length;
	      int len2 = nums2.length;
	      int mid = (len1 + len2)/2;
	      int ans1 = 0, ans2 = 0;
	       if ((nums1.length + nums2.length)%2 == 0) {
	          isEven = true;    
	      } 

	     while (nums1_point < nums1.length && nums2_point < nums2.length) {
	          
	          if (nums1[nums1_point] > nums2[nums2_point]) {
	              nums2_point++;
	              flag_1 = false;
	              if (nums1_point + nums2_point == mid) break;
	          }
	          else{
	              nums1_point++;
	              flag_1 = true;
	              if (nums1_point + nums2_point == mid) break;
	          }
	     } 
	     while (nums1_point + nums2_point != mid) {
	         if (nums1_point == nums1.length) {
	             nums2_point++;
	             flag_1 = false;
	             if (nums1_point + nums2_point == mid)
	                 break;    
	         } else {
	              nums1_point++;
	              flag_1 = true;
	              if (nums1_point + nums2_point == mid) 
	                  break;
	         }        
	         
	     }
	      if (isEven == true) {
	    
			if (flag_1 == true) {
	               ans1 = nums1[nums1_point];
	              if (nums2_point <= nums2.length - 1){
	                 ans2 = Math.min(nums1[nums1_point + 1],nums2[nums2_point]);    
	              } else {
	                   ans2 = nums1[nums1_point + 1]; 
	              }
	              result = (double)(ans1 + ans2)/2;
	          } else {
	               ans1 = nums2[nums2_point];
	              if (nums1_point <= nums1.length - 1) {
	               ans2 = Math.min(nums2[nums2_point + 1],nums1[nums1_point]);
	              } else {
	            	   ans2 = nums2[nums2_point + 1];
	              }
	              result = (double)(ans1 + ans2)/2;
	          }
	      } else {
	          if (flag_1 == true) {
	              if (nums2_point <= nums2.length - 1) {
	                result = (double)Math.min(nums2[nums2_point],nums1[nums1_point + 1]);
	              } else {
	                  result = (double)nums1[nums1_point + 1];
	              }
	          } 
	          else {
	              if (nums1_point <= nums1.length - 1) {
	                result = (double)Math.min(nums1[nums1_point],nums2[nums2_point + 1]);
	              } else result = (double)nums2[nums2_point + 1];
	          } 
	      }
	        return result;
	    }
}
