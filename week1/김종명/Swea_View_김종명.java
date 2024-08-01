import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  static int testCase=10;
  static int N;
  static int[] buildings;
  static int[] sightRule = {-2, -1, 1, 2};
  static StringBuilder result = new StringBuilder();

  static int buildingSight(int[] buildings){
    int totalSight = 0;
    int maxHeight = -1;

    for(int i=2; i<N-2; i++){
      for(int j=0; j<4; j++){
        if(buildings[i + sightRule[j]] > maxHeight){
          maxHeight = buildings[i + sightRule[j]];
        }
      }
      if(buildings[i] - maxHeight > 0){
        totalSight += buildings[i] - maxHeight;
      }
      maxHeight = -1;
    }

    return totalSight;
  }

  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for(int i=0; i<testCase; i++){

      N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      buildings = new int[N];

      for(int j=0; j<N; j++){
        buildings[j] = Integer.parseInt(st.nextToken());
      }

      result.append("#").append(i+1).append(" ");
      result.append(buildingSight(buildings)).append("\n");
    }
    
    System.out.println(result.toString());
  }
}
