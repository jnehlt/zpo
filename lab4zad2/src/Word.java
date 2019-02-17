import java.util.ArrayList;
import java.util.Arrays;

public class Word {
    String Word;
    ArrayList<String> ValidStranslations;

    public Word() {
        ValidStranslations = new ArrayList<>();
    }

    public Float getScore(String in) {
        System.out.println("IN = " + in);
        Integer lev = Integer.MAX_VALUE;
        for(String translation : ValidStranslations) {
            Integer tmp_lev = calcLevenstein(in, translation);
            if(tmp_lev < lev) {
                lev = tmp_lev;
            }
        }

        if(lev == 0) return 1.0f;
        if(lev == 1) return 0.5f;
        return 0.0f;
    }

    public Integer calcLevenstein(String in, String comp) {
        int [][] dp = new int[in.length() + 1][comp.length() + 1];

        for (int i = 0; i <= in.length(); i++) {
            for (int j = 0; j <= comp.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1] + costOfSubstitution(in.charAt(i - 1),
                                comp.charAt(j - 1)),
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1);
                }
            }
        }
//        System.out.println(comp);
//        for(int i = 0; i <= in.length(); i++) {
//            for(int j = 0; j <= comp.length(); j++) {
//                System.out.print(dp[i][j] + "  ");
//            }
//            System.out.println("");
//        }
        return dp[in.length()][comp.length()];
    }

    private int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    private int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
}
