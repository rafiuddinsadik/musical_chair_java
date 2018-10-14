import java.util.Scanner;
import java.lang.Math;

class QuizExtended{
  
  static int[] cir;
  static int size = 20;
  static int start = 10;
  
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    cir = new int[20];
    
    int st = start;
    for(int i =0; i < cir.length; i++){
      cir[st] = i+1;
      ++st;
      while(st >= cir.length){
        st %= cir.length;
      }
    }
    
    while(size>1){
      int random = (int)(19*Math.random());
      for(int i = 0; i < random; i++){
        rotateRight();
      }
      removeByLeftShift();
    }
    
    for(int i = 0; i < cir.length; i++){
      if(cir[i]!=0){
        System.out.println("Champoin's ID is = "+cir[i] );
        break;
      }
    }
    //this part is for testing
    for(int i = 0; i < cir.length; i++){
      System.out.print(cir[i]+" ");
    }
    System.out.println();
  }
  
  static void rotateRight(){
    int[] temp = new int[20];
    int oldIndex = 10;
    int newIndex = oldIndex+1;
    for(int i = 0; i < cir.length; i++){
      while(oldIndex >= cir.length){
        oldIndex%=cir.length;
      }
      while(newIndex >= cir.length){
        newIndex%=cir.length;
      }
      temp[newIndex] = cir[oldIndex];
      ++newIndex;
      ++oldIndex;
    }
    cir = temp;
    start+=1;
    while(start >= cir.length){
      start%=cir.length;
    }
  }
  
  static void removeByLeftShift(){
    int removeElemIndex = 10;
    int nextIndex = removeElemIndex + 1;
    for(int i = 0; i < size; i++){
      while(nextIndex >= cir.length){
        nextIndex %= cir.length;
      }
      while(removeElemIndex >= cir.length){
        removeElemIndex %= cir.length;
      }
      cir[removeElemIndex] = cir[nextIndex];
      ++nextIndex;
      ++removeElemIndex;
    }
    int lastValueIndex = (start+size-1)%cir.length;
    cir[lastValueIndex] = 0;
    size -= 1;
    start -=1;
    while(start < 0){
      start = start + cir.length;
    }
  }
}