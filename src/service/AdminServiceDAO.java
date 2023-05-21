package service;

import dao.impl.AdminDAOImpl;
import factory.Factory;
import model.Admin;
import model.SC;
import model.Stu;

import java.sql.SQLException;

public interface AdminServiceDAO{
    AdminDAOImpl adminDAO = Factory.AdminImpl();

    boolean checkLogin(Admin admin) throws SQLException;

    /**
     *  select * from stu
     */
    Object[][] selectAllStu(Stu stu) throws SQLException;


    /**
     *  select * from s_c
     */

    Object[][] selectAllStuAllCourseScore(SC sc) throws SQLException;


    /**
     *  先初始化一个String数组来存所有的 selectAllStu()的数组索引1,遍历该String数组 每次 调用selectStuAllScoreBySno（）
     */

    Object[][] selectAllStuAllScore(SC sc) throws SQLException;


    /**
     *     遍历cou，初始化object长度为15，object[i][1]=selectCourseAvgScoreByCno()的数组索引1
     */

    Object[][] selectAllCourseAvgScore(SC sc) throws SQLException;

    /**
     * 调用selectAllStuAllScore()的数组
     * <pre>
     *     {@code
     *      Arrays.sort(ts_id,new Comparator<double[]>() {
     *                 @Override
     *                 public int compare(double[] o1, double[] o2) {
     *            	    return o1[1] - o2[1];
     *             });
     *             }
     * </pre>
   */
    Object[][] sortAllStuAllScore(SC sc) throws SQLException;

    /**
     * 调用 selectCourseAllStuScoreByCno（）
     */

    Object[][] sortCourseAllStuScore(SC sc) throws SQLException;

    /**
     * insert into stu values(?,?,?,?)
     */

    void insertStu(Stu stu) throws SQLException;

    /**
     * insert into s_c values(?,?,?,?)
     */

    void insertScore(SC sc) throws SQLException;

    /**
     *  update stu set id = ? where sno = ?
     */

    void modifyStu(Stu stu) throws SQLException;

    /**
     update s_c set sno = ? ,cno = ? ,score = ? where sno = ? and cno = ?
     */
    void modifySC(SC sc) throws SQLException;

    /**
     delete from stu where sno = ?
     */
    void deleteStu(Stu stu) throws SQLException;

    /**
     delete from s_c where sno = ? and cno = ?
     */
    void deleteScore(SC sc) throws SQLException;

}
