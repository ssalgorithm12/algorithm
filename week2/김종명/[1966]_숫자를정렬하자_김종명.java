package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
  static int testCase;
  static int N;
  static int[] arr;
  static StringBuilder result = new StringBuilder();

  private static int[] countingSort(int maxValue){
    int[] newArr = new int[N];
    int[] countArr = new int[maxValue+1];
    int[] sumArr = new int[maxValue+1];
    int total = 0;

    for(int i=0; i<arr.length; i++){
      countArr[arr[i]] += 1;
    }

    for(int i=0; i<countArr.length; i++){
      total += countArr[i];
      sumArr[i] = total;
    }

    for(int i=0; i<arr.length; i++){
      newArr[--sumArr[arr[i]]] = arr[i];
    }

    return newArr;
  }
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    testCase = Integer.parseInt(br.readLine());

    for(int i=0; i<testCase; i++){
      N = Integer.parseInt(br.readLine());
      arr = new int[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int maxValue = Integer.MIN_VALUE;
      for(int j=0; j<N; j++){
        arr[j] = Integer.parseInt(st.nextToken());
        if(arr[j] > maxValue){
          maxValue = arr[j];
        }
      }

      int[] newArr = countingSort(maxValue);

      result.append("#" + (i+1) + " ");
      for(int j=0; j<N; j++){
        result.append(newArr[j] + " ");
      }
      result.append("\n");
    }

    System.out.println(result.toString());
  }
}