package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.exception.MyException;
import com.itheima.health.pojo.Setmeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SetmealDao {
    /**
     * 分页条件查询
     * @param queryString
     * @return
     */
    Page<Setmeal> findByCondition(CharSequence queryString);

    /**
     * 新增套餐
     * @param setmeal
     */
    void add(Setmeal setmeal);

    /**
     * 添加套餐与检查组的关系
     * @param setmealId
     * @param checkgroupId
     */
    void addSetmealCheckGroup(@Param("setmealId") Integer setmealId, @Param("checkgroupId") Integer checkgroupId);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Setmeal findById(int id);

    /**
     * 通过id查询选中的检查组ids
     * @param id
     * @return
     */
    List<Integer> findCheckgroupIdsBySetmealId(int id);

    /**
     * 更新套餐
     * @param setmeal
     */
    void update(Setmeal setmeal);

    /**
     * 删除旧关系
     * @param id
     */
    void deleteSetmealCheckGroup(Integer id);

    /**
     * 通过套餐的id查询订单是否被使用
     * @param id
     * @return
     */
    int findOrderCountBySetmealId(Integer id);

    /**
     * 通过id删除套餐信息
     * @param id
     */
    void deleteById(Integer id);
}
