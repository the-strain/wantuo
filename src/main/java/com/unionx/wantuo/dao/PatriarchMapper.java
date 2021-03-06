package com.unionx.wantuo.dao;

import org.apache.ibatis.annotations.Param;

import com.unionx.wantuo.base.BaseDao;
import com.unionx.wantuo.model.Patriarch;

public interface PatriarchMapper extends BaseDao<Patriarch> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_patriarch
     *
     * @mbggenerated Thu Jan 14 16:39:26 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_patriarch
     *
     * @mbggenerated Thu Jan 14 16:39:26 CST 2016
     */
    int insert(Patriarch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_patriarch
     *
     * @mbggenerated Thu Jan 14 16:39:26 CST 2016
     */
    int insertSelective(Patriarch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_patriarch
     *
     * @mbggenerated Thu Jan 14 16:39:26 CST 2016
     */
    Patriarch selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_patriarch
     *
     * @mbggenerated Thu Jan 14 16:39:26 CST 2016
     */
    int updateByPrimaryKeySelective(Patriarch record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_patriarch
     *
     * @mbggenerated Thu Jan 14 16:39:26 CST 2016
     */
    int updateByPrimaryKey(Patriarch record);
    
    /**
     * 根据家长登入帐号查看家长信息
     * @param loginAccounts	家长帐号
     * @return
     */
    Patriarch findByLoginAccounts(@Param("loginAccounts")String loginAccounts);
    
    /**
     * 后台管理根据家长帐号修改家长信息
     * @param login_accounts
     * @return
     */
    public int updateByLoginAccounts(@Param("login_accounts")String login_accounts,@Param("status") Integer status);

    int updatePatriarchId(@Param("id")String id,@Param("status") Integer status);
}