package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    /**
     * 查询检查项
     * @return
     */
    List<CheckItem> findAll();

    /**
     * 添加检查项目
     * @param checkItem
     */
    void add(CheckItem checkItem);

    /**
     * 分页查询
     * @param queryString
     * @return
     */
    Page<CheckItem> findByCondition(String queryString);


    /**
     * 先查询该检查项是否被检查组占用
     * @param id
     */
    int findCountByCheckItemId(int id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    CheckItem findById(int id);

    /**
     * 跟新检查项
     * @param checkItem
     */
    void update(CheckItem checkItem);
}
