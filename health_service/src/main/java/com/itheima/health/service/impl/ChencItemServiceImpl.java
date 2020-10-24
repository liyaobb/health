package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.health.constant.MessageConstant;
import com.itheima.health.dao.CheckItemDao;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;

import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

@Service(interfaceClass = CheckItemService.class)
public class ChencItemServiceImpl implements CheckItemService {

   @Autowired
    private CheckItemDao checkItemDao;

    /**
     * 查询检查项
     * @return
     */
    @Override
    public List<CheckItem> findAll() {

        return checkItemDao.findAll();
    }

    /**
     * 添加检查项
     * @param checkItem
     */
    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult<CheckItem> findPage(QueryPageBean queryPageBean) {
        // mapper接口方式调用
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        //模糊查询 拼接%
        // 判断是否有查询条件
        if (!StringUtils.isEmpty(queryPageBean.getQueryString())){
            // 有查询条件 拼接
            queryPageBean.setQueryString("%"+queryPageBean.getQueryString()+"%");
        }
        // 然后查询语句会被分页
        Page<CheckItem> page = checkItemDao.findByCondition(queryPageBean.getQueryString());
        // 封装到分页结果对象中
        PageResult<CheckItem> pageResult = new PageResult<>(page.getTotal(), page.getResult());
        return pageResult;
    }




    /**
     * 根据id删除
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteById(int id) throws Exception {
        // 先判断这个检查项是否被检查组占用
        // 调用dao查询检查项的id是否在t_checkgroup_checkitem表中存在记录
        int cnt = checkItemDao.findCountByCheckItemId(id);
        // 被使用则不能删除
        if (cnt >0){
             new Result(true,MessageConstant.CHECKITEM_IN_USE);
        }
        checkItemDao.deleteById(id);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public CheckItem findById(int id) {
        return checkItemDao.findById(id);
    }

    /**
     * 更新检查项
     * @param checkItem
     */
    @Override
    public void update(CheckItem checkItem) {
        checkItemDao.update(checkItem);
    }

}
