package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.Business;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-22 17:21
 */
@Repository
public interface BusiDao {
    int createBusi(Business business);
    boolean deleteBusi(int busiId);
    boolean modifyBusi(Business business);
    Business queryBusi(int busiId);
    Business queryBusiByName(String busiName);

    /**
     * 查询具体业务关联的其他业务
     * @param busiId
     * @return
     */
    List<Business> queryBusiRela(int busiId);

    /**
     * 添加和删除业务对象关联
     * @param busiId1
     * @param busiId2
     * @return
     */
    boolean addRelation(@Param("busiId1") int busiId1,@Param("busiId2") int busiId2);
    boolean deleteRelation(@Param("busiId1") int busiId1,@Param("busiId2") int busiId2);
    boolean deleteBusiRelation(@Param("busiId") int busiId);
    List<Business> queryBusiByClass(int classId);
    List<Business> queryAllBusi();
}
