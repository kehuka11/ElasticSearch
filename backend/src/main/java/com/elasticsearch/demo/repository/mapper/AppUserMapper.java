package com.elasticsearch.demo.repository.mapper;

import com.elasticsearch.demo.repository.model.AppUser;
import com.elasticsearch.demo.repository.model.AppUserExample;
import com.elasticsearch.demo.repository.model.AppUserWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    long countByExample(AppUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    int deleteByExample(AppUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    int insert(AppUserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    int insertSelective(AppUserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    List<AppUserWithBLOBs> selectByExampleWithBLOBs(AppUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    List<AppUser> selectByExample(AppUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    AppUserWithBLOBs selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    int updateByExampleSelective(@Param("record") AppUserWithBLOBs record, @Param("example") AppUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    int updateByExampleWithBLOBs(@Param("record") AppUserWithBLOBs record, @Param("example") AppUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    int updateByExample(@Param("record") AppUser record, @Param("example") AppUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    int updateByPrimaryKeySelective(AppUserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    int updateByPrimaryKeyWithBLOBs(AppUserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table app_user
     *
     * @mbg.generated Thu Aug 17 09:27:08 JST 2023
     */
    int updateByPrimaryKey(AppUser record);
}