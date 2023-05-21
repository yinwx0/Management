package model;

/**
 * @author Zhai Jinpei
 */
public class Admin{
    private Integer ano;
    private String password;

    public Admin(){
    }

    public Admin(String password){
        this.password = password;
    }

    public Integer getAno(){
        return ano;
    }

    public void setAno(Integer ano){
        this.ano = ano;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Admin(Integer ano,String password){
        this.ano = ano;
        this.password = password;
    }

    public Admin(Integer ano){
        this.ano = ano;
    }
}
