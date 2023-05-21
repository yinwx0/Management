package model;

/**
 * @author Zhai Jinpei
 */
public class Stu{
    private String ca;
    private String sno;
    private String name;
    private String sex;

    public Stu(){
    }

    public Stu(String sno){
        this.sno = sno;
    }

    public Stu(String ca,String sno,String name,String sex){
        this.ca = ca;
        this.sno = sno;
        this.name = name;
        this.sex = sex;
    }

    public String getCA(){
        return ca;
    }

    public void setCA(String ca){
        this.ca = ca;
    }

    public String getSno(){
        return sno;
    }

    public void setSno(String sno){
        this.sno = sno;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }
}
