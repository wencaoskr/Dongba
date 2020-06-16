package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMenuDao {

	 /**
	  * 基于菜单id删除角色菜单关系数据
	  * @param id
	  * @return
	  */
	 @Delete("delete from sys_role_menus where menu_id=#{id}")
	 int deleteObjectsByMenuId(Integer id);
}
