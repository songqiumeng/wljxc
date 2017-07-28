create table wljxc_userinfo(
	id int not null primary key auto_increment,
	number int not null comment "用户编号，与ID对应",
	name varchar(255) unique not null comment "账号",
	password varchar(255) not null comment "密码",
	realname varchar(255) comment "真实姓名",
	nickname varchar(255) comment "昵称",
	state tinyint not null comment "账户状态 0可用 1不可用" default 0,
	type tinyint not null comment "用户类型 0 普通用户 1 经销商 2 平台管理员" default 0,
	address text not null comment "用户地址",
	phone varchar(255) not null comment "电话",
	email varchar(255) comment "邮箱",
	comments text comment "其他联系方式，json格式",
	totallimit int not null comment "信用额度" default 0,
	uselimit int not null comment "使用额度" default 0,
	headimg int comment "用户头像"
) charset=utf8;