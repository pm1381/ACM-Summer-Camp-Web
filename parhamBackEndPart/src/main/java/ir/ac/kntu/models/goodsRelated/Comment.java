package ir.ac.kntu.models.goodsRelated;

import ir.ac.kntu.models.userRelated.Costumer;

import java.util.Objects;

public class Comment {
    private int id;
    private Costumer costumer;
    private String description;
    private CommentScore score;

    public Comment(int id,Costumer costumer, String description) {
        this.id = id;
        this.costumer = costumer;
        this.description = description;
        score = new CommentScore(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommentScore getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return Objects.equals(getCostumer(), comment.getCostumer()) && Objects.equals(getDescription(),
                comment.getDescription()) && Objects.equals(getScore(), comment.getScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCostumer(), getDescription(), getScore());
    }
}
