import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
  static int testCase;
  static String memories;
  static String resetMemories = "";
  static StringBuilder result = new StringBuilder();

  static int reset(String memories){
    String[] memory = memories.split("");
    String[] resetMemory = resetMemories.split("");
    int count = 0;

    for(int i=0; i<memory.length; i++){
      if(!memory[i].equals(resetMemory[i])){
        for(int j=i; j<memory.length; j++){
          resetMemory[j] = memory[i];
        }
        count++;
      }
    }

    return count;
  }
  
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    testCase = Integer.parseInt(br.readLine());

    for(int i=0; i<testCase; i++){
      memories = br.readLine();
      for(int j=0; j< memories.length(); j++){
        resetMemories += "0";
      }
      result.append("#" + (i+1) + " ");
      result.append(reset(memories) + "\n");
    }
    System.out.println(result.toString());
  }
  
}
