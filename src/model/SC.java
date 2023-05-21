package model;

/**
 * @author Zhai Jinpei
 */
public class SC{
    private String sno;
    private Integer cno;
    private Double score;

    public SC(){
    }

    public SC(String sno){
        this.sno = sno;
    }

    public SC(Integer cno){
        this.cno = cno;
    }

    public SC(Double score){
        this.score = score;
    }

    public SC(Integer cno,Double score){
        this.cno = cno;
        this.score = score;
    }

    public SC(String sno,Double score){
        this.sno = sno;
        this.score = score;
    }

    public SC(String sno,Integer cno){
        this.sno = sno;
        this.cno = cno;
    }

    public SC(String sno,Integer cno,Double score){
        this.sno = sno;
        this.cno = cno;
        this.score = score;
    }

    public String getSno(){
        return sno;
    }

    public void setSno(String sno){
        this.sno = sno;
    }

    public Integer getCno(){
        return cno;
    }

    public void setCno(Integer cno){
        this.cno = cno;
    }

    public Double getScore(){
        return score;
    }

    public void setScore(Double score){
        this.score = score;
    }
}
