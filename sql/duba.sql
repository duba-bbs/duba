-- ----------------------------
-- 用户信息表
-- ----------------------------
drop table
if exists `sys_user`;

create table `sys_user` (
	`user_id` bigint (20) not null auto_increment comment '主键',
	`username` varchar (30) not null default '' comment '登录账号',
	`nick_name` varchar (30) not null default '' comment '用户昵称',
	`user_type` char (1) not null default '0' comment '用户类型（0超级管理员 1普通用户）',
	`email` varchar (50) not null default '' comment '用户邮箱',
	`motto` varchar (200) not null default '' comment '座右铭',
	`phonenumber` varchar (11) not null default '' comment '手机号码',
	`sex` char (1) not null default '0' comment '用户性别（0男 1女 2未知）',
	`avatar` varchar (100) not null default '' comment '头像路径',
	`password` varchar (100) not null default '' comment '密码',
	`modify_pwd_time` datetime not null comment '最后更新密码时间',
	`salt` varchar (20) not null default '' comment '盐加密',
	`status` char (1) not null default '0' comment '帐号状态（0正常 1停用）',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`login_time` datetime not null comment '最后登录时间',
	`login_ip` varchar (50) not null default '' comment '最后登录ip',
	`remark` varchar (500) not null default '' comment '备注',
	`del_flag` char (1) not null default '0' comment '逻辑删除（1代表已删除 0代表未删除）',
	primary key (`user_id`),
	unique (`username`),
	key `idx_username` (`username`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '用户信息表';

INSERT INTO sys_user VALUES ( NULL, 'admin', 'admin', '0', '1214327383@qq.com', '', '11223344556', '0', '', 'admin', sysdate(), '', '0', 'admin', 'admin', sysdate(), sysdate(), sysdate(), '', '', '0' );
INSERT INTO sys_user VALUES ( NULL, 'duba', 'duba', '0', '1214327383@qq.com', '', '11223344556', '0', '', '123456', sysdate(), '', '0', 'admin', 'admin', sysdate(), sysdate(), sysdate(), '', '', '0' );
-- ----------------------------
-- 角色信息表
-- ----------------------------
drop table
if exists `sys_role`;

create table `sys_role` (
	`role_id` bigint (20) not null auto_increment comment '主键',
	`role_name` varchar (30) not null comment '角色名称',
	`role_key` varchar (100) not null comment '角色权限字符串',
	`role_sort` int (4) not null default 0 comment '显示顺序',
	`data_scope` char (1) not null default '1' comment '数据范围（1全部数据权限 2自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
	`status` char (1) not null default '0' comment '角色状态（0正常 1停用）',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`remark` varchar (500) not null default '' comment '备注',
	`del_flag` char (1) not null default '0' comment '逻辑删除（1代表已删除 0代表未删除）',
	primary key (`role_id`),
	key `idx_role_key` (`role_key`),
	unique (`role_key`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '用户信息表';

INSERT INTO sys_role VALUES ( NULL, '超级管理员', 'admin', 1, '1', '0', 'admin', 'admin', sysdate(), sysdate(), '超级管理员', '0' );
INSERT INTO sys_role VALUES ( NULL, '普通角色', 'common', 2, '2', '0', 'admin', 'admin', sysdate(), sysdate(), '普通角色', '0' );

-- ----------------------------
-- 用户和角色关联表 用户n-1角色
-- ----------------------------
drop table
if exists `sys_user_role`;

create table `sys_user_role` (
	`id` bigint (20) not null auto_increment comment '主键',
	`user_id` bigint (20) not null comment '用户id',
	`role_id` bigint (20) not null comment '角色id',
	primary key (`id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '用户和角色关联表';

INSERT INTO sys_user_role VALUES (null, 1000, 1000);
INSERT INTO sys_user_role VALUES (null, 1001, 1001);

-- ----------------------------
-- 菜单权限表
-- ----------------------------
drop table
if exists `sys_menu`;

create table `sys_menu` (
	`menu_id` bigint (20) not null auto_increment comment '菜单id',
	`menu_name` varchar (50) not null comment '菜单名称',
	`parent_id` bigint (20) not null default 0 comment '父菜单id',
	`order_num` int (4) not null default 0 comment '显示顺序',
	`path` varchar (200) not null default '' comment '路由地址',
	`component` varchar (255) not null default '' comment '组件路径',
	`is_frame` char (1) not null default 'n' comment '是否为外链（y是 n否）',
	`is_cache` char (1) not null default 'y' comment '是否缓存（y缓存 n不缓存）',
	`menu_type` char (1) not null default '0' comment '菜单类型（0目录 1菜单 2按钮）',
	`visible` char (1) not null default '0' comment '菜单状态（0显示 1隐藏）',
	`status` char (1) not null default '0' comment '菜单状态（0正常 1停用）',
	`perms` varchar (100) not null default '' comment '权限标识',
	`icon` varchar (100) not null default '#' comment '菜单图标',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`remark` varchar (500) not null default '' comment '备注',
	primary key (`menu_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '菜单权限表';

INSERT INTO sys_menu VALUES ( 1001, '用户管理', 0, 1, 'user', 'system/user/index', 'n', 'y', '1', '0', '0', 'system:user:list', 'user', 'admin', 'admin', sysdate(), sysdate(), '用户管理菜单' );
INSERT INTO sys_menu VALUES ( 1002, '文章管理', 0, 2, 'article', '', 'n', 'y', '1', '0', '0', '', 'article', 'admin', 'admin', sysdate(), sysdate(), '文章管理菜单' );
INSERT INTO sys_menu VALUES ( 1101, '系统公告', 1002, 1, 'notice', 'system/notice/index', 'n', 'y', '1', '0', '0', 'system:notice:list', 'message', 'admin', 'admin', sysdate(), sysdate(), '通知公告菜单' );
INSERT INTO sys_menu VALUES ( 2001, '用户查询', 1001, 1, '', '', 'n', 'y', '2', '0', '0', 'system:user:query', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 2002, '用户新增', 1001, 2, '', '', 'n', 'y', '2', '0', '0', 'system:user:add', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 2003, '用户修改', 1001, 3, '', '', 'n', 'y', '2', '0', '0', 'system:user:edit', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 2004, '用户删除', 1001, 4, '', '', 'n', 'y', '2', '0', '0', 'system:user:remove', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 2005, '用户导出', 1001, 5, '', '', 'n', 'y', '2', '0', '0', 'system:user:export', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 2006, '重置密码', 1001, 6, '', '', 'n', 'y', '2', '0', '0', 'system:user:resetPwd', '#', 'admin', 'admin', sysdate(), sysdate(), '' );
INSERT INTO sys_menu VALUES ( 2007, '公告查询', 1101, 1, '', '', 'n', 'y', '2', '0', '0', 'system:notice:query', '#', 'admin', 'admin', sysdate(), sysdate(), '' );

-- ----------------------------
-- 角色和菜单关联表  角色1-n菜单
-- ----------------------------
drop table
if exists `sys_role_menu`;

create table `sys_role_menu` (
	`id` bigint (20) not null auto_increment comment '主键',
	`role_id` bigint (20) not null comment '角色id',
	`menu_id` bigint (20) not null comment '菜单id',
	primary key (`id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '角色和菜单关联表';

insert into sys_role_menu values (null, 1001, 1002);
insert into sys_role_menu values (null, 1001, 1101);

-- ----------------------------
-- 吧表
-- ----------------------------
drop table
if exists `sys_bar`;

create table `sys_bar` (
	`bar_id` bigint (20) not null auto_increment comment '主键',
	`parent_id` bigint (20) not null comment '上级id，级别是版时为0',
	`bar_type` char (1) not null default '1' comment '类型（0版 1吧）',
	`bar_name` varchar (50) not null default '' comment '吧名称',
	`description` varchar (200) not null default '' comment '吧描述',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`status` char (1) not null default '0' comment '吧状态（0正常 1停用）',
	`remark` varchar (500) not null default '' comment '备注',
	`del_flag` char (1) not null default '0' comment '逻辑删除（1代表已删除 0代表未删除）',
	primary key (`bar_id`),
	unique (`bar_name`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '吧表';

-- ----------------------------
-- 角色和吧关联表 角色1-n吧
-- ----------------------------
drop table
if exists `sys_role_bar`;

create table `sys_role_bar` (
	`id` bigint (20) not null auto_increment comment '主键',
	`role_id` bigint (20) not null comment '角色id',
	`bar_id` bigint (20) not null comment '吧id',
	primary key (`id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '角色和吧关联表';

-- ----------------------------
-- 吧主表 吧n-1用户
-- ----------------------------
drop table
if exists `sys_bar_owner`;

create table `sys_bar_owner` (
	`id` bigint (20) not null auto_increment comment '主键',
	`bar_id` bigint (20) not null comment '吧id',
	`user_id` bigint (20) not null comment '用户id',
	primary key (`id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '吧主表';

-- ----------------------------
-- 贴子表
-- ----------------------------
drop table
if exists `sys_post`;

create table `sys_post` (
	`post_id` bigint (20) not null auto_increment comment '主键',
	`bar_id` bigint (20) not null comment '所属吧',
	`title` varchar (64) not null default '' comment '贴子标题',
	`content` varchar (500) not null default '' comment '贴子内容',
	`user_id` bigint (20) not null comment '发帖人id',
	`create_by` varchar (30) not null default '' comment '发帖人',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`view_times` bigint (20) not null default 0 comment '阅读量',
	`status` char (1) not null default '0' comment '贴子状态（0正常 1停用）',
	`remark` varchar (500) not null default '' comment '备注',
	`top_quality` char (1) not null default '0' comment '是否精品（1是 0否）',
	`del_flag` char (1) not null default '0' comment '逻辑删除（1代表已删除 0代表未删除）',
	primary key (`post_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '贴子表';

-- ----------------------------
-- 评论表
-- ----------------------------
drop table
if exists `sys_comment`;

create table `sys_comment` (
	`comment_id` bigint (20) not null auto_increment comment '主键',
	`post_id` bigint (20) not null comment '所属贴',
	`parent_id` bigint (20) not null default 0 comment '上级评论，如果是0表示主楼',
	`content` varchar (500) not null default '' comment '评论内容',
	`user_id` bigint (20) not null comment '评论者id',
	`create_by` varchar (30) not null default '' comment '评论者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`likes` bigint (20) not null default 0 comment '点赞数',
	`status` char (1) not null default '0' comment '评论状态（0正常 1停用）',
	`remark` varchar (500) not null default '' comment '备注',
	`del_flag` char (1) not null default '0' comment '逻辑删除（1代表已删除 0代表未删除）',
	primary key (`comment_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '评论表';

-- ----------------------------
-- 用户关系表
-- ----------------------------
drop table
if exists `sys_user_rel`;

create table `sys_user_rel` (
	`id` bigint (20) not null auto_increment comment '主键',
	`from_id` bigint (20) not null comment '用户id',
	`to_id` bigint (20) not null comment '目标id',
	`rel_type` char (1) not null default '0' comment '关系类型（0关注 1拉黑）',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`del_flag` char (1) not null default '0' comment '逻辑删除（1代表已删除 0代表未删除）',
	primary key (`id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '用户关系表';

-- ----------------------------
-- 收藏表
-- ----------------------------
drop table
if exists `sys_favor`;

create table `sys_favor` (
	`favor_id` bigint (20) not null auto_increment comment '主键',
	`user_id` bigint (20) not null comment '用户id',
	`favor_target_id` bigint (20) not null comment '收藏实体id',
	`favor_target_type` char (1) not null default '0' comment '收藏实体类型（0吧 1贴子）',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`del_flag` char (1) not null default '0' comment '逻辑删除（1代表已删除 0代表未删除）',
	primary key (`favor_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '收藏表';

-- ----------------------------
-- 字典类型表
-- ----------------------------
drop table
if exists `sys_dict_type`;

create table `sys_dict_type` (
	`dict_id` bigint (20) not null auto_increment comment '主键',
	`dict_name` varchar (100) not null comment '字典名称',
	`dict_type` varchar (100) not null comment '字典类型',
	`status` char (1) not null default '0' comment '状态（0正常 1停用）',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`remark` varchar (500) not null default '' comment '备注',
	primary key (`dict_id`),
	unique (`dict_type`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '字典类型表';

-- ----------------------------
-- 字典数据表
-- ----------------------------
drop table
if exists `sys_dict_data`;

create table `sys_dict_data` (
	`dict_code` bigint (20) not null auto_increment comment '主键',
	`dict_sort` int (4) not null default 0 comment '字典排序',
	`dict_label` varchar (100) not null default '' comment '字典标签',
	`dict_value` varchar (100) not null default '' comment '字典键值',
	`dict_type` varchar (100) not null default '' comment '字典类型',
	`css_class` varchar (100) not null default '' comment '样式属性（其他样式扩展）',
	`list_class` varchar (100) not null default '' comment '表格回显样式',
	`status` char (1) not null default '0' comment '状态（0正常 1停用）',
	`default_flag` char (1) not null default '0' comment '是否默认（1是 0否）',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`remark` varchar (500) not null default '' comment '备注',
	primary key (`dict_code`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '字典数据表';

-- ----------------------------
-- 系统访问记录
-- ----------------------------
drop table
if exists `sys_login_info`;

create table `sys_login_info` (
	`info_id` bigint (20) not null auto_increment comment '主键',
	`username` varchar (50) not null default '' comment '登录账号',
	`login_ip` varchar (50) not null default '' comment '登录ip地址',
	`browser` varchar (50) not null default '' comment '浏览器类型',
	`os` varchar (50) not null default '' comment '操作系统',
	`status` char (1) not null default '0' comment '登录状态（0成功 1失败）',
	`msg` varchar (255) not null default '' comment '提示消息',
	`login_time` datetime not null comment '访问时间',
	primary key (`info_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '系统访问记录';

-- ----------------------------
-- 操作日志记录
-- ----------------------------
drop table
if exists `sys_oper_log`;

create table `sys_oper_log` (
	`oper_id` bigint (20) not null auto_increment comment '主键',
	`title` varchar (50) not null default '' comment '模块标题',
	`oper_type` char (1) not null default '0' comment '操作类型（0其它 1新增 2修改 3删除）',
	`method` varchar (100) not null default '' comment '方法名称',
	`request_method` varchar (10) not null default '' comment '请求方式',
	`oper_source` char (1) not null default '0' comment '操作来源（0其它 1后台用户 2手机端用户 3PC端用户）',
	`oper_name` varchar (50) not null default '' comment '操作人员',
	`oper_url` varchar (255) not null default '' comment '请求url',
	`oper_ip` varchar (128) not null default '' comment '主机地址',
	`oper_location` varchar (255) not null default '' comment '操作地点',
	`oper_param` varchar (2000) not null default '' comment '请求参数',
	`json_result` varchar (2000) not null default '' comment '返回参数',
	`status` char (1) not null default '0' comment '操作状态（0正常 1异常）',
	`error_msg` varchar (2000) not null default '' comment '错误消息',
	`oper_time` datetime not null comment '操作时间',
	primary key (`oper_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '操作日志记录';

-- ----------------------------
-- 参数配置表
-- ----------------------------
drop table
if exists `sys_config`;

create table `sys_config` (
	`config_id` bigint (20) not null auto_increment comment '主键',
	`config_name` varchar (100) not null default '' comment '参数名称',
	`config_key` varchar (100) not null default '' comment '参数键名',
	`config_value` varchar (500) not null default '' comment '参数键值',
	`config_type` char (1) not null default '0' comment '是否系统内置（1是 0否）',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`remark` varchar (500) not null default '' comment '备注',
	primary key (`config_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '参数配置表';

-- ----------------------------
-- 定时任务调度表
-- ----------------------------
drop table
if exists `sys_job`;

create table `sys_job` (
	`job_id` bigint (20) not null auto_increment comment '主键',
	`job_name` varchar (64) not null default '' comment '任务名称',
	`job_group` varchar (64) not null default '' comment '任务组名',
	`invoke_target` varchar (500) not null default '' comment '调用目标字符串',
	`cron_expression` varchar (255) not null default '' comment 'cron执行表达式',
	`misfire_policy` char (1) not null default '3' comment '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
	`concurrent` char (1) not null default '1' comment '是否并发执行（0允许 1禁止）',
	`status` char (1) not null default '0' comment '状态（0正常 1暂停）',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`remark` varchar (500) not null default '' comment '备注',
	primary key (`job_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '定时任务调度表';

-- ----------------------------
-- 定时任务调度日志表
-- ----------------------------
drop table
if exists `sys_job_log`;

create table `sys_job_log` (
	`job_log_id` bigint (20) not null auto_increment comment '主键',
	`job_name` varchar (64) not null default '' comment '任务名称',
	`job_group` varchar (64) not null default '' comment '任务组名',
	`invoke_target` varchar (500) not null default '' comment '调用目标字符串',
	`job_message` varchar (500) not null default '' comment '日志信息',
	`exception_info` varchar (2000) not null default '' comment '异常信息',
	`status` char (1) not null default '0' comment '执行状态（0正常 1失败）',
	`create_time` datetime not null comment '创建时间',
	primary key (`job_log_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '定时任务调度日志表';

-- ----------------------------
-- 通知公告表
-- ----------------------------
drop table
if exists `sys_notice`;

create table `sys_notice` (
	`notice_id` bigint (20) not null auto_increment comment '主键',
	`notice_title` varchar (50) not null default '' comment '公告标题',
	`notice_type` char (1) not null default '' comment '公告类型（0通知 1公告）',
	`notice_content` longblob not null comment '公告内容',
	`status` char (1) not null default '0' comment '公告状态（0正常 1关闭）',
	`create_by` varchar (30) not null default '' comment '创建者',
	`update_by` varchar (30) not null default '' comment '更新者',
	`create_time` datetime not null comment '创建时间',
	`update_time` datetime not null comment '更新时间',
	`remark` varchar (500) not null default '' comment '备注',
	primary key (`notice_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '通知公告表';

-- ----------------------------
-- 代码生成业务表
-- ----------------------------
drop table
if exists gen_table;

create table gen_table (
	table_id bigint (20) not null auto_increment comment '主键',
	table_name varchar (200) not null default '' comment '表名称',
	table_comment varchar (500) not null default '' comment '表描述',
	sub_table_name varchar (64) not null default '' comment '关联子表的表名',
	sub_table_fk_name varchar (64) not null default '' comment '子表关联的外键名',
	class_name varchar (100) not null default '' comment '实体类名称',
	tpl_category varchar (200) not null default 'crud' comment '使用的模板（crud单表操作 tree树表操作）',
	package_name varchar (100) not null default '' comment '生成包路径',
	module_name varchar (30) not null default '' comment '生成模块名',
	business_name varchar (30) not null default '' comment '生成业务名',
	function_name varchar (50) not null default '' comment '生成功能名',
	function_author varchar (50) not null default '' comment '生成功能作者',
	gen_type char (1) not null default '0' comment '生成代码方式（0zip压缩包 1自定义路径）',
	gen_path varchar (200) not null default '/' comment '生成路径（不填默认项目路径）',
	options varchar (1000) not null default '' comment '其它生成选项',
	create_by varchar (30) not null default '' comment '创建者',
	update_by varchar (30) not null default '' comment '更新者',
	create_time datetime not null comment '创建时间',
	update_time datetime not null comment '更新时间',
	remark varchar (500) not null default '' comment '备注',
	primary key (`table_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '代码生成业务表';

-- ----------------------------
-- 代码生成业务表字段
-- ----------------------------
drop table
if exists gen_table_column;

create table gen_table_column (
	column_id bigint (20) not null auto_increment comment '主键',
	table_id varchar (64) not null default '' comment '归属表编号',
	column_name varchar (200) not null default '' comment '列名称',
	column_comment varchar (500) not null default '' comment '列描述',
	column_type varchar (100) not null default '' comment '列类型',
	java_type varchar (500) not null default '' comment 'java类型',
	java_field varchar (200) not null default '' comment 'java字段名',
	is_pk char (1) not null default '' comment '是否主键（1是）',
	is_increment char (1) not null default '' comment '是否自增（1是）',
	is_required char (1) not null default '' comment '是否必填（1是）',
	is_insert char (1) not null default '' comment '是否为插入字段（1是）',
	is_edit char (1) not null default '' comment '是否编辑字段（1是）',
	is_list char (1) not null default '' comment '是否列表字段（1是）',
	is_query char (1) not null default '' comment '是否查询字段（1是）',
	query_type varchar (200) default 'eq' comment '查询方式（等于、不等于、大于、小于、范围）',
	html_type varchar (200) not null default '' comment '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
	dict_type varchar (200) not null default '' comment '字典类型',
	sort int (4) not null default 0 comment '排序',
	create_by varchar (30) not null default '' comment '创建者',
	update_by varchar (30) not null default '' comment '更新者',
	create_time datetime not null comment '创建时间',
	update_time datetime not null comment '更新时间',
	primary key (`column_id`)
) engine = innodb auto_increment = 1000 default charset = utf8mb4 comment = '代码生成业务表字段';