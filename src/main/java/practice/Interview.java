
package practice;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview {
    //Longest substring without repeating characters
    public static int longestSubStringWithOutRepeatingChars(String str) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);
            while (set.contains(ch)) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(ch);
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
            }
        }
        return maxLength;
    }


    public static Map<String, List<String>> groupAnagrams(String[] words) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(str -> {
                    char[] arr = str.toCharArray();
                    Arrays.sort(arr);
                    return new String(arr);
                }));
    }

    //Finding the first non-repeating character
    public static Character nonRepeatingCharacter(String str) {
        return str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().orElseThrow();
    }

    //find second largest Element Arrays DSA question
    public static int secondLargestElement(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    public static int[] moveAllZerosToEnd(int[] arr) {
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] != 0) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;

            }
        }
        return arr;
    }

    //[1,2,3,4,5,6], k =3
    //[6,5,4,3,2,1]
    //[4,5,6,3,2,1]
    //[4,5,6,1,2,3]

    public static int[] rotateArrayByKPositionsRight(int[] arr, int k){
        int n =arr.length;
        k=k%n;
        rotateSubArray(arr,0,n-1);
        rotateSubArray(arr, 0,k-1);
        rotateSubArray(arr,k,n-1);
        return arr;

    }

    public static int[] rotateSubArray(int[] arr, int left, int right){
        while (left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] =temp;
            left++;
            right--;
        }
        return arr;
    }

    public static int missingNumber(int[] arr){
        int left =0;
        int right = arr.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==mid+1){
                left= mid+1;
            }else right=mid-1;
        }
        return left+1;
    }


}
