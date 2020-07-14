package com.wzh.db.tool.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.chenlin.dp.common.constant.SystemConstant;
import net.chenlin.dp.common.controller.AbstractController;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.SysUserEntity;
import net.chenlin.dp.shiro.service.SysUserService;

/**
 * amar clock
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/tool/amarclock")
public class ToolAmarclockController extends AbstractController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 用户列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysUserEntity> list(@RequestBody Map<String, Object> params) {
		if(getUserId() != SystemConstant.SUPER_ADMIN) {
			params.put("userIdCreate", getUserId());
		}
		return sysUserService.listUser(params);
	}

}
