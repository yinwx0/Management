package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zhai Jinpei
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SC{
    private String sno;
    private Integer cno;
    private Double score;

    public SC(String sno,Integer cno){
        this.sno = sno;
        this.cno = cno;
    }

    public SC(Integer cno){
        this.cno = cno;
    }
}
