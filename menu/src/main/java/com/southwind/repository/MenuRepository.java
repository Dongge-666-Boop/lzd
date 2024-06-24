package com.southwind.repository;

import com.southwind.entity.Menu;

import java.util.List;

public interface MenuRepository {
    public List<Menu> findAll(int index,int limit);
    public int count();
    public void save(Menu menu);
    public Menu findById(long id);

    /**
     * 修改菜品
     * @param menu
     */
    public void update(Menu menu);

    /**
     * 删除菜品
     * @param id
     */
    public void deleteById(long id);
}
