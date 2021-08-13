package ir.ac.kntu.models.goodsRelated;

public class CommentScore {
    private int id;
    private int positiveScore = 0;
    private int negativeScore = 0;

    public CommentScore(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPositiveScore() {
        return positiveScore;
    }

    public void setPositiveScore() {
        this.positiveScore = positiveScore++;
    }

    public int getNegativeScore() {
        return negativeScore;
    }

    public void setNegativeScore() {
        this.negativeScore = negativeScore++;
    }
}
