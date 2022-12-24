package notepad;


import java.util.ArrayList;
import java.util.Arrays;

public class RabinKarp {

    public final static int d = 256;
    static ArrayList<Integer> positions = new ArrayList<Integer>();

   
    static ArrayList<Integer> search(String pat, String txt, int q)
    {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; 
        int t = 0; 
        int h = 1;

     
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

       
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

       
        for (i = 0; i <= N - M; i++) {

          
            if (p == t) {
         
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

              
                if (j == M) {
//                    
                      positions.add(i);
                }
            }

       
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

               
                if (t < 0)
                    t = (t + q);
            }
        }
        return positions;
    }


    public static void main(String[] args)
    {
        String txt = "After each slide, it one by one checks characters at the current shift and if all characters match then prints the match.\n" +
                "Like the Naive Algorithm, Rabin-Karp algorithm also slides the pattern one by one. But unlike the Naive algorithm, Rabin Karp algorithm matches the hash value of the pattern with the hash value of current substring of text, and if the hash values match then only it starts matching individual characters. So Rabin Karp algorithm needs to calculate hash values for following strings.";
        String pat = "Rabin";
        int q = 101; 
        search(pat, txt, q);
        String replacement = "";

        System.out.println(Arrays.toString(positions.toArray()));
    }
}

