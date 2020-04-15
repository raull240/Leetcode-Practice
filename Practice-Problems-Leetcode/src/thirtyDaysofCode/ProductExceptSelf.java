package thirtyDaysofCode;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int right = 1;
        result[0] = 1;
        for (int i = 1; i < nums.length;i++) {
            result[i] = result[i - 1] * nums[i - 1];    
        }
        for (int i = nums.length - 1;i >=0 ; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int[] result = new ProductExceptSelf().productExceptSelf(arr);
		for (int res : result) {
			System.out.println(res);
		}
	}
}
