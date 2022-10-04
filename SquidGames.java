/*
Problem Statement
You are Player-50 and your opponent is Player-218. You will be given N marbles and each will have a number written on it. But, before this, you along with your opponent are asked to decide a game.
So, you come up with a game that goes as follows:
Both of you will take turns, with you starting first. On each turn, the player removes any marble from the given marbles. The player who removes a marble loses if the sum of the values of all removed marbles is divisible by 3. But if there are no remaining marbles, then Player 218 wins(even if it was your turn).
Since none of you wants to die, players play mindfully.
Given a function that should return true if you win and false if Player 218 wins. But, there is some logical error. Fix the bug…
*/
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	public static void main (String[] args) {
                      // Your code here
        Scanner inputTaker = new Scanner(System.in);
        int t = inputTaker.nextInt();
        while(t > 0){
            int n = inputTaker.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ;i < n ;i++){
                arr[i] = inputTaker.nextInt();
            }
            if(playTheGame(arr, n)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
            t--;
        }
	}

    private static boolean playTheGame(int[] arr, int n){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,0);
        map.put(2,0);
        for(int i = 0 ;i < n ;i++){
            Integer remainder = arr[i]%3;
            if(map.containsKey(remainder)){
                Integer prevCount = map.get(remainder);
                map.put(remainder, prevCount + 1);
            }else{
                map.put(remainder, 1);
            }
        }
        if(map.get(0) % 2 == 0){
            return map.get(1) > 0 && map.get(2) > 0;
        }else{
            return Math.abs(map.get(1) - map.get(2)) > 2;
        }
    }
}