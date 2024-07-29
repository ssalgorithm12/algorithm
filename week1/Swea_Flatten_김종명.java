import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
  static int testCase = 10;
  static int[] boxes = new int[100];
  static int dumpCount;
  static StringBuilder result = new StringBuilder();

  static int flatten(int[] boxes, int dumpCount){
    while(dumpCount > 0){
      Arrays.sort(boxes);
      boxes[99] -= 1;
      boxes[0] += 1;
      dumpCount--;
    }
    Arrays.sort(boxes);
    return boxes[99] - boxes[0];
  }
  
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for(int i=0; i<testCase; i++){
      dumpCount = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      for(int j=0; j<100; j++){
        boxes[j] = Integer.parseInt(st.nextToken());
      }

      result.append("#" + (i+1) + " ");
      result.append(flatten(boxes, dumpCount)).append("\n");
    }

    System.out.println(result.toString());
  }
}
