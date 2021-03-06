/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landCoffee_DAO;

import java.util.List;

/**
 *
 * @author Nguyễn Tiến Dũng
 */
public abstract class LandCoffee_DAO<EntityType, KeyType> {

    public abstract void insert(EntityType entity);

    public abstract void update(EntityType entity);

    public abstract void delete(KeyType id);

    public abstract List<EntityType> selectAll();

    public abstract EntityType selectById(KeyType id);

    protected abstract List<EntityType> selectBySql(String sql, Object... args);
}
