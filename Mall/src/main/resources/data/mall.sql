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
	contact text comment "其他联系方式，json格式",
	totallimit int not null comment "信用额度" default 0,
	uselimit int not null comment "使用额度" default 0,
	headimg int default 0 comment "用户头像",
	headimgurl varchar(10000) DEFAULT "",
) charset=utf8;


#商品类型表
create table wljxc_goodtype(
	id int not null primary key auto_increment,
	name varchar(255) not null,
	number int not null,
	level int not null default 0 comment '商品类型级别',
	parent int not null default 0 comment '父类型的id',
	tpyeimg int not null default 0 comment '类图首页图'
) charset=utf8;

#图片表
create table wljxc_img(
	id int not null primary key auto_increment,
	path varchar(255) not null comment '路径',
	url varchar(255) not null,
	name varchar(255) not null
)charset=utf8;

#店铺表
create table wljxc_store(
	id int not null primary key auto_increment,
	number int unique not null comment '商品id，可根据id生成',
	userid int not null default 0 comment '用户id',
	name varchar(255) not null comment '店铺名称',
	contact varchar(255) comment '店铺联系人名称',
	phone varchar(255) comment "店铺联系人电话",
	level tinyint not null default 0 comment '店铺级别',
	headimg int comment '店铺头像',
	isgood tinyint default 0 comment '是否为优选好店',
	hascut tinyint default 0 comment '是否有折扣',
	hastip tinyint default 0 comment '是否有减免卷',
	score tinyint default 0 comment '评分 0-5',
	total int comment '销量',
	locationX double,
	locationY double,
	other text comment '其他信息，json格式',
	keyword text comment '关键词 json格式',
	isdelete tinyint not null default 0
) charset=utf8;

#商品表
create table wljxc_good(
	id int not null primary key auto_increment,
	number int not null comment '商品编号，根据id生成',
	name varchar(255) not null,
	goodtype int not null comment '商品类型',
	store int not null default 0 comment '库存',
	guige varchar(255) ,
	txm varchar(255),
	viewprice int not null,
	inprice int not null,
	other text comment '其他信息',
	userid int not null comment '用户id',
	storeid int not null comment '店铺id',
	content text comment '商品介绍',
	typelist text comment '商品分类 json格式',
	monthnumber int default 0,
	totalnumber int default 0,
	commentnumber int default 0,
	good int default 0,
	meddile int default 0,
	bad int default 0,
	cpbh varchar(255),
	cpxlh varchar(255),
	xsdw varchar(255),
	package varchar(255),
	color varchar(255),
	uptime timestamp,
	lrl double default 0.0,
	aveprice double default 0.0 comment '平均价格',
	comprice double default 0.0 comment '统计价格',
	instore int comment '进货量',
	outstore int comment '出货量',
	request int comment '预期需求量'
) charset=utf8;


#商品图片表
create table wljxc_googimg(
	id int not null primary key auto_increment,
	goodid int not null,
	imgid int not null
) charset=utf8;

#购物车表
create table wljxc_shoppingcar(
	id int not null primary key auto_increment,
	goodid int not null comment '商品编号',
	price int not null,
	number int not null default 0,
	userid int not null,
	name varchar(255) not null,
	goodtype text ,
	viewprice int not null,
	addtime timestamp default now(),
	ispaid tinyint not null default 0
) charset=utf8;

#订单表
create table wljxc_order(
	id int not null primary key auto_increment,
	number int ,
	addtime timestamp not null default now(),
	userid int not null,
	shopid int not null,
	goodnumber int not null,
	viewprice int not null,
	price int not null,
	state tinyint not null default 0
) charset=utf8;

create table wljxc_record(
	id int not null primary key auto_increment,
	userid int not null,
	goodid int not null,
	orderid int not null,
	state tinyint not null default 0,
	goodname varchar(255),
	goodtype text,
	addtime text
) charset=utf8;

create table wljxc_comment(
	id int not null primary key auto_increment,
	userid int not null,
	goodid int not null,
	comment text,
	score int not null default 0,
	response text,
	type tinyint default 0 comment '0 中评，1 好评 -1 差评',
	other text
) charset=utf8;
