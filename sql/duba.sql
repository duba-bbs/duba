-- ----------------------------
-- 部门表
-- ----------------------------
DROP TABLE
IF EXISTS sys_dept;

CREATE TABLE sys_dept (
	dept_id BIGINT (20) NOT NULL auto_increment COMMENT '部门id',
	parent_id BIGINT (20) NOT NULL DEFAULT 0 COMMENT '父部门id',
	ancestors VARCHAR (50) NOT NULL DEFAULT '' COMMENT '祖级列表',
	dept_name VARCHAR (30) NOT NULL DEFAULT '' COMMENT '部门名称',
	order_num INT (4) NOT NULL DEFAULT 0 COMMENT '显示顺序',
	leader VARCHAR (20) NOT NULL DEFAULT '' COMMENT '负责人',
	phone VARCHAR (11) NOT NULL DEFAULT '' COMMENT '联系电话',
	email VARCHAR (50) NOT NULL DEFAULT '' COMMENT '邮箱',
	STATUS CHAR (1) NOT NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
	del_flag CHAR (1) NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
	create_by VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_by VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	update_time datetime NOT NULL COMMENT '更新时间',
	PRIMARY KEY (dept_id)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '部门表';

INSERT INTO sys_dept VALUES ( 1, 0, '0', '听鱼集团', 0, '听鱼', '15888888888', 'tingyu@qq.com', '0', '0', 'admin', sysdate(), 'admin', sysdate());
INSERT INTO sys_dept VALUES ( 2, 1, '0,1', '杭州分公司', 1, '听鱼', '15888888888', 'tingyu@qq.com', '0', '0', 'admin', sysdate(), 'admin', sysdate());
INSERT INTO sys_dept VALUES ( 3, 1, '0,1', '上海分公司', 2, '听鱼', '15888888888', 'tingyu@qq.com', '0', '0', 'admin', sysdate(), 'admin', sysdate());
INSERT INTO sys_dept VALUES ( 4, 2, '0,1,2', '研发部门', 1, '听鱼', '15888888888', 'tingyu@qq.com', '0', '0', 'admin', sysdate(), 'admin', sysdate());
INSERT INTO sys_dept VALUES ( 5, 2, '0,1,2', '市场部门', 2, '听鱼', '15888888888', 'tingyu@qq.com', '0', '0', 'admin', sysdate(), 'admin', sysdate());
INSERT INTO sys_dept VALUES ( 6, 2, '0,1,2', '测试部门', 3, '听鱼', '15888888888', 'tingyu@qq.com', '0', '0', 'admin', sysdate(), 'admin', sysdate());
INSERT INTO sys_dept VALUES ( 7, 2, '0,1,2', '财务部门', 4, '听鱼', '15888888888', 'tingyu@qq.com', '0', '0', 'admin', sysdate(), 'admin', sysdate());
INSERT INTO sys_dept VALUES ( 8, 2, '0,1,2', '运维部门', 5, '听鱼', '15888888888', 'tingyu@qq.com', '0', '0', 'admin', sysdate(), 'admin', sysdate());
INSERT INTO sys_dept VALUES ( 9, 2, '0,1,3', '市场部门', 1, '听鱼', '15888888888', 'tingyu@qq.com', '0', '0', 'admin', sysdate(), 'admin', sysdate());
INSERT INTO sys_dept VALUES ( 10, 3, '0,1,3', '财务部门', 2, '听鱼', '15888888888', 'tingyu@qq.com', '0', '0', 'admin', sysdate(), 'admin', sysdate());

-- ----------------------------
-- 岗位信息表
-- ----------------------------
DROP TABLE
IF EXISTS sys_position;

CREATE TABLE sys_position (
	position_id BIGINT (20) NOT NULL auto_increment COMMENT '岗位ID',
	position_code VARCHAR (64) NOT NULL DEFAULT '' COMMENT '岗位编码',
	position_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '岗位名称',
	position_sort INT (4) NOT NULL DEFAULT 0 COMMENT '显示顺序',
	STATUS CHAR (1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
	create_by VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_by VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	update_time datetime NOT NULL COMMENT '更新时间',
	remark VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	PRIMARY KEY (position_id)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '岗位信息表';

INSERT INTO sys_position VALUES ( 1, 'ceo', '董事长', 1, '0', 'admin', sysdate(), 'admin', sysdate(), '' );
INSERT INTO sys_position VALUES ( 2, 'pm', '项目经理', 2, '0', 'admin', sysdate(), 'admin', sysdate(), '' );
INSERT INTO sys_position VALUES ( 3, 'hr', '人力资源', 3, '0', 'admin', sysdate(), 'admin', sysdate(), '' );
INSERT INTO sys_position VALUES ( 4, 'staff', '普通员工', 4, '0', 'admin', sysdate(), 'admin', sysdate(), '' );

-- ----------------------------
-- 用户信息表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
	`user_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`dept_id` BIGINT (20) NOT NULL DEFAULT 0 COMMENT '部门ID',
	`username` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '登录账号',
	`nick_name` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '用户昵称',
	`user_type` CHAR (1) NOT NULL DEFAULT '0' COMMENT '用户类型（0超级管理员 1内部员工 2外部用户）',
	`email` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '用户邮箱',
	`motto` VARCHAR (200) NOT NULL DEFAULT '' COMMENT '座右铭',
	`phonenumber` VARCHAR (11) NOT NULL DEFAULT '' COMMENT '手机号码',
	`sex` CHAR (1) NOT NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
	`avatar` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '头像路径',
	`password` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '密码',
	`modify_pwd_time` datetime NOT NULL COMMENT '最后更新密码时间',
	`salt` VARCHAR (20) NOT NULL DEFAULT '' COMMENT '盐加密',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`login_time` datetime NOT NULL COMMENT '最后登录时间',
	`login_ip` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '最后登录ip',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	`del_flag` CHAR (1) NOT NULL DEFAULT '0' COMMENT '逻辑删除（1代表已删除 0代表未删除）',
	PRIMARY KEY (`user_id`),
	UNIQUE (`username`),
	KEY `idx_username` (`username`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '用户信息表';

INSERT INTO sys_user VALUES ( 1, 103, 'admin', 'admin', '0', 'admin@qq.com', '', '11223344556', '0', '', 'admin', sysdate(), '', '0', 'admin', 'admin', sysdate(), sysdate(), sysdate(), '', '', '0' );
INSERT INTO sys_user VALUES ( 2, 105, 'staff', 'staff', '1', 'staff@qq.com', '', '11223344556', '0', '', 'staff', sysdate(), '', '0', 'admin', 'admin', sysdate(), sysdate(), sysdate(), '', '', '0' );
INSERT INTO sys_user VALUES ( 3, 0, 'user001', 'user001', '2', 'user001@qq.com', '', '11223344556', '0', '', 'user001', sysdate(), '', '0', 'admin', 'admin', sysdate(), sysdate(), sysdate(), '', '', '0' );

-- ----------------------------
-- 角色信息表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
	`role_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`role_name` VARCHAR (30) NOT NULL COMMENT '角色名称',
	`role_key` VARCHAR (100) NOT NULL COMMENT '角色权限字符串',
	`role_sort` INT (4) NOT NULL DEFAULT 0 COMMENT '显示顺序',
	`data_scope` CHAR (1) NOT NULL DEFAULT '1' COMMENT '数据范围（1全部数据权限 2自定数据权限 3：本部门数据权限 4：本部门及以下数据权限 5: 仅本人数据权限）',
	`menu_check_strictly` TINYINT (1) NOT NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
	`dept_check_strictly` TINYINT (1) NOT NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '角色状态（0正常 1停用）',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	`del_flag` CHAR (1) NOT NULL DEFAULT '0' COMMENT '逻辑删除（1代表已删除 0代表未删除）',
	PRIMARY KEY (`role_id`),
	KEY `idx_role_key` (`role_key`),
	UNIQUE (`role_key`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '用户信息表';

INSERT INTO sys_role VALUES ( 1, '超级管理员', 'admin', 1, '1', 1, 1, '0', 'admin', 'admin', sysdate(), sysdate(), '超级管理员', '0' );
INSERT INTO sys_role VALUES ( 2, '内部员工角色', 'common', 2, '2', 1, 1, '0', 'admin', 'admin', sysdate(), sysdate(), '内部员工角色', '0' );
INSERT INTO sys_role VALUES ( 3, '外部用户角色', 'external', 3, '2', 1, 1, '0', 'admin', 'admin', sysdate(), sysdate(), '外部用户角色', '0' );

-- ----------------------------
-- 菜单权限表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
	`menu_id` BIGINT (20) NOT NULL auto_increment COMMENT '菜单id',
	`menu_name` VARCHAR (50) NOT NULL COMMENT '菜单名称',
	`parent_id` BIGINT (20) NOT NULL DEFAULT 0 COMMENT '父菜单id',
	`order_num` INT (4) NOT NULL DEFAULT 0 COMMENT '显示顺序',
	`path` VARCHAR (200) NOT NULL DEFAULT '' COMMENT '路由地址',
	`component` VARCHAR (255) NOT NULL DEFAULT '' COMMENT '组件路径',
	`is_frame` CHAR (1) NOT NULL DEFAULT 'n' COMMENT '是否为外链（y是 n否）',
	`is_cache` CHAR (1) NOT NULL DEFAULT 'y' COMMENT '是否缓存（y缓存 n不缓存）',
	`menu_type` CHAR (1) NOT NULL DEFAULT '0' COMMENT '菜单类型（0目录 1菜单 2按钮）',
	`visible` CHAR (1) NOT NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
	`perms` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '权限标识',
	`icon` VARCHAR (100) NOT NULL DEFAULT '#' COMMENT '菜单图标',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`menu_id`)
) ENGINE = INNODB auto_increment = 1000 DEFAULT charset = utf8mb4 COMMENT = '菜单权限表';

INSERT INTO sys_menu VALUES ( 1, '用户列表', 0, 1, 'user', '', 'n', 'y', '1', '0', '0', 'user', '#', 'admin', 'admin', sysdate(), sysdate(), '用户列表' );
INSERT INTO sys_menu VALUES ( 2, '吧务管理', 0, 2, 'bbs', '', 'n', 'y', '1', '0', '0', 'bbs', '#', 'admin', 'admin', sysdate(), sysdate(), '吧务管理' );
INSERT INTO sys_menu VALUES ( 101, '版吧列表', 2, 1, 'system/bar/index', '', 'n', 'y', '1', '0', '0', 'system/bar/list', '#', 'admin', 'admin', sysdate(), sysdate(), '版吧列表' );
INSERT INTO sys_menu VALUES ( 102, '贴子列表', 2, 2, 'system/post/index', '', 'n', 'y', '1', '0', '0', 'system/post/list', '#', 'admin', 'admin', sysdate(), sysdate(), '贴子列表' );
INSERT INTO sys_menu VALUES ( 501, '用户查询', 1, 1, '', '', 'n', 'y', '2', '0', '0', 'system:user:query', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 502, '用户新增', 1, 2, '', '', 'n', 'y', '2', '0', '0', 'system:user:add', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 503, '用户修改', 1, 3, '', '', 'n', 'y', '2', '0', '0', 'system:user:edit', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 504, '用户删除', 1, 4, '', '', 'n', 'y', '2', '0', '0', 'system:user:remove', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 505, '用户导出', 1, 5, '', '', 'n', 'y', '2', '0', '0', 'system:user:export', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 506, '重置密码', 1, 6, '', '', 'n', 'y', '2', '0', '0', 'system:user:resetPwd', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 507, '版吧查询', 101, 1, '', '', 'n', 'y', '2', '0', '0', 'system:bar:query', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 508, '贴子查询', 102, 1, '', '', 'n', 'y', '2', '0', '0', 'system:post:query', '#', 'admin', 'admin', sysdate(), sysdate(), '' );

-- ----------------------------
-- 用户和角色关联表 用户n-1角色
-- ----------------------------
DROP TABLE
IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
	`id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`user_id` BIGINT (20) NOT NULL COMMENT '用户id',
	`role_id` BIGINT (20) NOT NULL COMMENT '角色id',
	PRIMARY KEY (`id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '用户和角色关联表';

INSERT INTO sys_user_role VALUES (1, 1, 1);
INSERT INTO sys_user_role VALUES (2, 2, 2);
INSERT INTO sys_user_role VALUES (3, 3, 3);

-- ----------------------------
-- 角色和菜单关联表  角色1-n菜单
-- ----------------------------
DROP TABLE
IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
	`id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`role_id` BIGINT (20) NOT NULL COMMENT '角色id',
	`menu_id` BIGINT (20) NOT NULL COMMENT '菜单id',
	PRIMARY KEY (`id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '角色和菜单关联表';

INSERT INTO sys_role_menu VALUES (1, 2, 2);
INSERT INTO sys_role_menu VALUES (2, 2, 101);
INSERT INTO sys_role_menu VALUES (3, 2, 102);
INSERT INTO sys_role_menu VALUES (4, 2, 507);
INSERT INTO sys_role_menu VALUES (5, 2, 508);

-- ----------------------------
-- 角色和部门关联表  角色1-N部门
-- ----------------------------
DROP TABLE
IF EXISTS sys_role_dept;

CREATE TABLE sys_role_dept (
	id BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	role_id BIGINT (20) NOT NULL COMMENT '角色ID',
	dept_id BIGINT (20) NOT NULL COMMENT '部门ID',
	PRIMARY KEY (id)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '角色和部门关联表';

INSERT INTO sys_role_dept VALUES (1, 2, 1);
INSERT INTO sys_role_dept VALUES (2, 2, 2);
INSERT INTO sys_role_dept VALUES (3, 2, 3);

-- ----------------------------
-- 用户与岗位关联表  用户1-N岗位
-- ----------------------------
DROP TABLE
IF EXISTS sys_user_position;

CREATE TABLE sys_user_position (
	id BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	user_id BIGINT (20) NOT NULL COMMENT '用户ID',
	position_id BIGINT (20) NOT NULL COMMENT '岗位ID',
	PRIMARY KEY (id)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '用户与岗位关联表';

INSERT INTO sys_user_position VALUES (1, 1, 1);
INSERT INTO sys_user_position VALUES (2, 2, 2);

-- ----------------------------
-- 字典类型表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_dict_type`;

CREATE TABLE `sys_dict_type` (
	`dict_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`dict_name` VARCHAR (100) NOT NULL COMMENT '字典名称',
	`dict_type` VARCHAR (100) NOT NULL COMMENT '字典类型',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`dict_id`),
	UNIQUE (`dict_type`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '字典类型表';

-- ----------------------------
-- 字典数据表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_dict_data`;

CREATE TABLE `sys_dict_data` (
	`dict_code` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`dict_sort` INT (4) NOT NULL DEFAULT 0 COMMENT '字典排序',
	`dict_label` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '字典标签',
	`dict_value` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '字典键值',
	`dict_type` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '字典类型',
	`css_class` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '样式属性（其他样式扩展）',
	`list_class` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '表格回显样式',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
	`default_flag` CHAR (1) NOT NULL DEFAULT '0' COMMENT '是否默认（1是 0否）',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`dict_code`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '字典数据表';

-- ----------------------------
-- 系统访问记录
-- ----------------------------
DROP TABLE
IF EXISTS `sys_login_info`;

CREATE TABLE `sys_login_info` (
	`info_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`username` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '登录账号',
	`login_ip` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '登录ip地址',
	`browser` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '浏览器类型',
	`os` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '操作系统',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
	`msg` VARCHAR (255) NOT NULL DEFAULT '' COMMENT '提示消息',
	`login_time` datetime NOT NULL COMMENT '访问时间',
	PRIMARY KEY (`info_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '系统访问记录';

-- ----------------------------
-- 操作日志记录
-- ----------------------------
DROP TABLE
IF EXISTS `sys_oper_log`;

CREATE TABLE `sys_oper_log` (
	`oper_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`title` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '模块标题',
	`oper_type` CHAR (1) NOT NULL DEFAULT '0' COMMENT '操作类型（0其它 1新增 2修改 3删除）',
	`method` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '方法名称',
	`request_method` VARCHAR (10) NOT NULL DEFAULT '' COMMENT '请求方式',
	`oper_source` CHAR (1) NOT NULL DEFAULT '0' COMMENT '操作来源（0其它 1后台用户 2手机端用户 3PC端用户）',
	`oper_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '操作人员',
	`oper_url` VARCHAR (255) NOT NULL DEFAULT '' COMMENT '请求url',
	`oper_ip` VARCHAR (128) NOT NULL DEFAULT '' COMMENT '主机地址',
	`oper_location` VARCHAR (255) NOT NULL DEFAULT '' COMMENT '操作地点',
	`oper_param` VARCHAR (2000) NOT NULL DEFAULT '' COMMENT '请求参数',
	`json_result` VARCHAR (2000) NOT NULL DEFAULT '' COMMENT '返回参数',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
	`error_msg` VARCHAR (2000) NOT NULL DEFAULT '' COMMENT '错误消息',
	`oper_time` datetime NOT NULL COMMENT '操作时间',
	PRIMARY KEY (`oper_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '操作日志记录';

-- ----------------------------
-- 参数配置表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
	`config_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`config_name` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '参数名称',
	`config_key` VARCHAR (100) NOT NULL DEFAULT '' COMMENT '参数键名',
	`config_value` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '参数键值',
	`config_type` CHAR (1) NOT NULL DEFAULT '0' COMMENT '是否系统内置（1是 0否）',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`config_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '参数配置表';

-- ----------------------------
-- 定时任务调度表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_job`;

CREATE TABLE `sys_job` (
	`job_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`job_name` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '任务名称',
	`job_group` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '任务组名',
	`invoke_target` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '调用目标字符串',
	`cron_expression` VARCHAR (255) NOT NULL DEFAULT '' COMMENT 'cron执行表达式',
	`misfire_policy` CHAR (1) NOT NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
	`concurrent` CHAR (1) NOT NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`job_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '定时任务调度表';

-- ----------------------------
-- 定时任务调度日志表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_job_log`;

CREATE TABLE `sys_job_log` (
	`job_log_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`job_name` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '任务名称',
	`job_group` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '任务组名',
	`invoke_target` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '调用目标字符串',
	`job_message` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '日志信息',
	`exception_info` VARCHAR (2000) NOT NULL DEFAULT '' COMMENT '异常信息',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	PRIMARY KEY (`job_log_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '定时任务调度日志表';

-- ----------------------------
-- 代码生成业务表
-- ----------------------------
DROP TABLE
IF EXISTS gen_table;

CREATE TABLE gen_table (
	table_id BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	table_name VARCHAR (200) NOT NULL DEFAULT '' COMMENT '表名称',
	table_comment VARCHAR (500) NOT NULL DEFAULT '' COMMENT '表描述',
	sub_table_name VARCHAR (64) NOT NULL DEFAULT '' COMMENT '关联子表的表名',
	sub_table_fk_name VARCHAR (64) NOT NULL DEFAULT '' COMMENT '子表关联的外键名',
	class_name VARCHAR (100) NOT NULL DEFAULT '' COMMENT '实体类名称',
	tpl_category VARCHAR (200) NOT NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
	package_name VARCHAR (100) NOT NULL DEFAULT '' COMMENT '生成包路径',
	module_name VARCHAR (30) NOT NULL DEFAULT '' COMMENT '生成模块名',
	business_name VARCHAR (30) NOT NULL DEFAULT '' COMMENT '生成业务名',
	function_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '生成功能名',
	function_author VARCHAR (50) NOT NULL DEFAULT '' COMMENT '生成功能作者',
	gen_type CHAR (1) NOT NULL DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
	gen_path VARCHAR (200) NOT NULL DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
	OPTIONS VARCHAR (1000) NOT NULL DEFAULT '' COMMENT '其它生成选项',
	create_by VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	update_by VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_time datetime NOT NULL COMMENT '更新时间',
	remark VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`table_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '代码生成业务表';

-- ----------------------------
-- 代码生成业务表字段
-- ----------------------------
DROP TABLE
IF EXISTS gen_table_column;

CREATE TABLE gen_table_column (
	column_id BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	table_id VARCHAR (64) NOT NULL DEFAULT '' COMMENT '归属表编号',
	column_name VARCHAR (200) NOT NULL DEFAULT '' COMMENT '列名称',
	column_comment VARCHAR (500) NOT NULL DEFAULT '' COMMENT '列描述',
	column_type VARCHAR (100) NOT NULL DEFAULT '' COMMENT '列类型',
	java_type VARCHAR (500) NOT NULL DEFAULT '' COMMENT 'java类型',
	java_field VARCHAR (200) NOT NULL DEFAULT '' COMMENT 'java字段名',
	is_pk CHAR (1) NOT NULL DEFAULT '' COMMENT '是否主键（1是）',
	is_increment CHAR (1) NOT NULL DEFAULT '' COMMENT '是否自增（1是）',
	is_required CHAR (1) NOT NULL DEFAULT '' COMMENT '是否必填（1是）',
	is_insert CHAR (1) NOT NULL DEFAULT '' COMMENT '是否为插入字段（1是）',
	is_edit CHAR (1) NOT NULL DEFAULT '' COMMENT '是否编辑字段（1是）',
	is_list CHAR (1) NOT NULL DEFAULT '' COMMENT '是否列表字段（1是）',
	is_query CHAR (1) NOT NULL DEFAULT '' COMMENT '是否查询字段（1是）',
	query_type VARCHAR (200) DEFAULT 'eq' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
	html_type VARCHAR (200) NOT NULL DEFAULT '' COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
	dict_type VARCHAR (200) NOT NULL DEFAULT '' COMMENT '字典类型',
	sort INT (4) NOT NULL DEFAULT 0 COMMENT '排序',
	create_by VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	update_by VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_time datetime NOT NULL COMMENT '更新时间',
	PRIMARY KEY (`column_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '代码生成业务表字段';

-- ----------------------------
-- 文章表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_article`;

CREATE TABLE `sys_article` (
	`article_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`article_title` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '公告标题',
	`article_type` CHAR (1) NOT NULL DEFAULT '' COMMENT '公告类型（0系统公告）',
	`article_content` LONGBLOB NOT NULL COMMENT '公告内容',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`article_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '文章表';

-- ----------------------------
-- 吧表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_bar`;

CREATE TABLE `sys_bar` (
	`bar_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`parent_id` BIGINT (20) NOT NULL COMMENT '上级id，级别是版时为0',
	`bar_type` CHAR (1) NOT NULL DEFAULT '1' COMMENT '类型（0版 1吧）',
	`bar_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '吧名称',
	`description` VARCHAR (200) NOT NULL DEFAULT '' COMMENT '吧描述',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '吧状态（0正常 1停用）',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	`del_flag` CHAR (1) NOT NULL DEFAULT '0' COMMENT '逻辑删除（1代表已删除 0代表未删除）',
	PRIMARY KEY (`bar_id`),
	UNIQUE (`bar_name`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '吧表';

-- ----------------------------
-- 贴子表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_post`;

CREATE TABLE `sys_post` (
	`post_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`bar_id` BIGINT (20) NOT NULL COMMENT '所属吧',
	`title` VARCHAR (64) NOT NULL DEFAULT '' COMMENT '贴子标题',
	`content` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '贴子内容',
	`user_id` BIGINT (20) NOT NULL COMMENT '发帖人id',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '发帖人',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`view_times` BIGINT (20) NOT NULL DEFAULT 0 COMMENT '阅读量',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '贴子状态（0正常 1停用）',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	`top_quality` CHAR (1) NOT NULL DEFAULT '0' COMMENT '是否精品（1是 0否）',
	`del_flag` CHAR (1) NOT NULL DEFAULT '0' COMMENT '逻辑删除（1代表已删除 0代表未删除）',
	PRIMARY KEY (`post_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '贴子表';

-- ----------------------------
-- 评论表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_comment`;

CREATE TABLE `sys_comment` (
	`comment_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`post_id` BIGINT (20) NOT NULL COMMENT '所属贴',
	`parent_id` BIGINT (20) NOT NULL DEFAULT 0 COMMENT '上级评论，如果是0表示主楼',
	`content` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '评论内容',
	`user_id` BIGINT (20) NOT NULL COMMENT '评论者id',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '评论者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`likes` BIGINT (20) NOT NULL DEFAULT 0 COMMENT '点赞数',
	`status` CHAR (1) NOT NULL DEFAULT '0' COMMENT '评论状态（0正常 1停用）',
	`remark` VARCHAR (500) NOT NULL DEFAULT '' COMMENT '备注',
	`del_flag` CHAR (1) NOT NULL DEFAULT '0' COMMENT '逻辑删除（1代表已删除 0代表未删除）',
	PRIMARY KEY (`comment_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '评论表';

-- ----------------------------
-- 收藏表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_favor`;

CREATE TABLE `sys_favor` (
	`favor_id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`user_id` BIGINT (20) NOT NULL COMMENT '用户id',
	`favor_target_id` BIGINT (20) NOT NULL COMMENT '收藏实体id',
	`favor_target_type` CHAR (1) NOT NULL DEFAULT '0' COMMENT '收藏实体类型（0吧 1贴子）',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`del_flag` CHAR (1) NOT NULL DEFAULT '0' COMMENT '逻辑删除（1代表已删除 0代表未删除）',
	PRIMARY KEY (`favor_id`)
) ENGINE = INNODB auto_increment = 100 DEFAULT charset = utf8mb4 COMMENT = '收藏表';

-- ----------------------------
-- 角色和吧关联表 角色1-n吧
-- ----------------------------
DROP TABLE
IF EXISTS `sys_role_bar`;

CREATE TABLE `sys_role_bar` (
	`id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`role_id` BIGINT (20) NOT NULL COMMENT '角色id',
	`bar_id` BIGINT (20) NOT NULL COMMENT '吧id',
	PRIMARY KEY (`id`)
) ENGINE = INNODB auto_increment = 1000 DEFAULT charset = utf8mb4 COMMENT = '角色和吧关联表';

-- ----------------------------
-- 用户关系表
-- ----------------------------
DROP TABLE
IF EXISTS `sys_user_rel`;

CREATE TABLE `sys_user_rel` (
	`id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`from_id` BIGINT (20) NOT NULL COMMENT '用户id',
	`to_id` BIGINT (20) NOT NULL COMMENT '目标id',
	`rel_type` CHAR (1) NOT NULL DEFAULT '0' COMMENT '关系类型（0关注 1拉黑）',
	`create_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '创建者',
	`update_by` VARCHAR (30) NOT NULL DEFAULT '' COMMENT '更新者',
	`create_time` datetime NOT NULL COMMENT '创建时间',
	`update_time` datetime NOT NULL COMMENT '更新时间',
	`del_flag` CHAR (1) NOT NULL DEFAULT '0' COMMENT '逻辑删除（1代表已删除 0代表未删除）',
	PRIMARY KEY (`id`)
) ENGINE = INNODB auto_increment = 1000 DEFAULT charset = utf8mb4 COMMENT = '用户关系表';

-- ----------------------------
-- 吧主表 吧n-1用户
-- ----------------------------
DROP TABLE
IF EXISTS `sys_bar_owner`;

CREATE TABLE `sys_bar_owner` (
	`id` BIGINT (20) NOT NULL auto_increment COMMENT '主键',
	`bar_id` BIGINT (20) NOT NULL COMMENT '吧id',
	`user_id` BIGINT (20) NOT NULL COMMENT '用户id',
	PRIMARY KEY (`id`)
) ENGINE = INNODB auto_increment = 1000 DEFAULT charset = utf8mb4 COMMENT = '吧主表';
