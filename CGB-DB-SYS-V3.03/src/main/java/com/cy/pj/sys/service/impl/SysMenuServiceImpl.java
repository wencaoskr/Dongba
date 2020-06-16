package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.bo.Node;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Override
	public int updateObject(SysMenu entity) {
		//1.参数校验
		//2.将数据保存到数据库
		int rows=sysMenuDao.updateObject(entity);
		return rows;
	}
	@Override
	public int saveObject(SysMenu entity) {
		//1.参数校验
		//2.将数据保存到数据库
		int rows=sysMenuDao.insertObject(entity);
		return rows;
	}
	
	@Override
	public List<Node> findZTreeMenuNodes() {
		// TODO Auto-generated method stub
		return sysMenuDao.findZTreeMenuNodes();
	}
	
	@Override
	public int deleteObject(Integer id) {
		//1.参数校验
		if(id==null||id<1)
			throw new IllegalArgumentException("id值无效");
		//2.基于id统计子菜单数并进行校验
		int childCount=sysMenuDao.getChildCount(id);
		if(childCount>0)
			throw new ServiceException("请先删除子菜单");
		//3.删除菜单角色关系数据
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		//4.删除菜单自身信息
		int rows=sysMenuDao.deleteObject(id);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在了");
		return rows;
	}
	@Override
	public List<SysMenu> findObjects() {
		List<SysMenu> list=sysMenuDao.findObjects();
		if(list==null||list.size()==0)
			throw new ServiceException("没有找到对应的菜单");
		return list;
	}

}
