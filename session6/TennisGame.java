package session6;

public class TennisGame {
    public static final String EMPTY_STRING = "";
    public static final int CALL_LOVE = 0;
    public static final String ZERO_STRING = "Love";
    public static final String ONE_STRING = "Fifteen";
    public static final String TWO_STRING = "Thirty";
    public static final String THREE_STRING = "Forty";
    public static final String MINUS_STRING = "-";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player 1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player 2";
    public static final String WIN_PLAYER_1 = "win for player 1";
    public static final String WIN_PLAYER_2 = "win for player 2";

    public String getScore(int socreOfPlayer_1, int socreOfPlayer_2) {
        String score = EMPTY_STRING;
        int tempScore = CALL_LOVE;
        if (socreOfPlayer_1 == socreOfPlayer_2) {
            score = getScoreWhenEqual(socreOfPlayer_1);
        } else if (socreOfPlayer_1 >= 4 || socreOfPlayer_2 >= 4) {
            int minusResult = socreOfPlayer_1 - socreOfPlayer_2;
            if (minusResult == 1) score = ADVANTAGE_PLAYER_1;
            else if (minusResult == -1) score = ADVANTAGE_PLAYER_2;
            else if (minusResult >= 2) score = WIN_PLAYER_1;
            else score = WIN_PLAYER_2;
        } else {
            for (int scoreOfPlayer = 1; scoreOfPlayer < 3; scoreOfPlayer++) {
                if (scoreOfPlayer == 1) tempScore = socreOfPlayer_1;
                else {
                    score += MINUS_STRING;
                    tempScore = socreOfPlayer_2;
                }
                score = getScoreOfPlayer(score, tempScore);
            }
        }
        return score;
    }

    private String getScoreOfPlayer(String score, int tempScore) {
        switch (tempScore) {
            case 0:
                score += ZERO_STRING;
                break;
            case 1:
                score += ONE_STRING;
                break;
            case 2:
                score += TWO_STRING;
                break;
            case 3:
                score += THREE_STRING;
                break;
        }
        return score;
    }

    private String getScoreWhenEqual(int socreOfPlayer_1) {
        String score;
        switch (socreOfPlayer_1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}