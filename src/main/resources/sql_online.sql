use yingxin_online;
create table address
(
  addr_id int auto_increment
  comment '地点id'
    primary key,
  addr_name varchar(20) null
  comment '地点名',
  latitude double null
  comment '纬度',
  longitude double null
  comment '精度',
  description text null
  comment '地点介绍',
  constraint addr_name
  unique (addr_name)
);

create table association
(
  id int auto_increment
  comment '社团id'
    primary key,
  name varchar(20) null
  comment '社团名称',
  related_person text null
  comment '相关人物',
  contact_info text null
  comment '联系信息',
  description text null
  comment '社团描述',
  organization varchar(20) null
  comment '所属组织'
)
  comment '社团/协会/学生会组织';

create table busi_class
(
  busi_class_id int auto_increment
  comment '业务类别id'
    primary key,
  busi_class_name varchar(10) null
  comment '业务类别名称',
  description text null
  comment '分类描述',
  constraint busi_class_name
  unique (busi_class_name)
)
  comment '业务类别';

create table business
(
  busi_id int auto_increment
  comment '业务id'
    primary key,
  busi_name varchar(20) null
  comment '业务名',
  busi_class_id int null
  comment '业务类别id',
  solution text null
  comment '业务解决方案',
  constraint busi_name
  unique (busi_name)
);

create table addr_relation
(
  busi_id int not null
  comment '业务对象id',
  addr_id int not null
  comment '关联地点id',
  primary key (busi_id, addr_id),
  constraint addr_relation_ibfk_1
  foreign key (busi_id) references business (busi_id),
  constraint addr_relation_ibfk_2
  foreign key (addr_id) references address (addr_id)
);

create index addr_id
  on addr_relation (addr_id);

create table busi_relation
(
  busi_id1 int not null
  comment '业务对象id',
  busi_id2 int not null
  comment '关联对象id',
  primary key (busi_id1, busi_id2),
  constraint busi_relation_ibfk_1
  foreign key (busi_id1) references business (busi_id),
  constraint busi_relation_ibfk_2
  foreign key (busi_id2) references business (busi_id)
);

create index busi_id2
  on busi_relation (busi_id2);

create table college
(
  college_id int auto_increment
  comment '学院id'
    primary key,
  college_name varchar(20) null
  comment '学院名称',
  description text null
  comment '学院描述'
)
  comment '学院';

create table config
(
  `key` varchar(45) null
  comment '社团名称',
  value varchar(45) null
  comment '联系信息',
  description text null
  comment '社团描述',
  class1 varchar(45) null
  comment '配置类别'
)
  comment '配置表';

create table jxjh
(
  start_year int null
  comment '开设年度',
  speciality_name varchar(20) null
  comment '专业名称',
  speciality_direction varchar(20) null
  comment '开课方向',
  start_term int null
  comment '开课学期',
  course_no varchar(10) null
  comment '课程编号',
  course_name varchar(20) null
  comment '课程名称',
  course_nature varchar(20) null
  comment '课程性质',
  course_attr varchar(6) null
  comment '课程属性',
  check_mode varchar(6) null
  comment '考核方式',
  credit float null
  comment '学分',
  time_class int null
  comment '总学时',
  time_week int null
  comment '周学时',
  time_class_theory int null
  comment '理论学时',
  time_class_practice int null
  comment '实践学时',
  time_class_lecture int null
  comment '讲座学时',
  unit varchar(20) null
  comment '开课单位',
  course_class varchar(20) null
  comment '课程类别'
)
  comment '教学计划';

create table laboratory
(
  id int auto_increment
  comment '实验室id'
    primary key,
  name varchar(20) null
  comment '实验室名称',
  organization varchar(20) null
  comment '所属组织',
  related_person text null
  comment '相关人物',
  contact_info text null
  comment '联系信息',
  description text null
  comment '实验室描述',
  address varchar(45) null
  comment '实验室详细地址'
)
  comment '实验室';

create table search
(
  key_word varchar(20) null
  comment '其他表中的关键字',
  class1 varchar(20) null
  comment '业务类型'
)
  comment '搜索库';

create table speciality
(
  speciality_id int auto_increment
  comment '专业id'
    primary key,
  college_id int null
  comment '学院id',
  speciality_name varchar(25) null
  comment '专业名称',
  description text null
  comment '专业描述',
  major_class varchar(255) null
  comment '主修课程',
  constraint speciality_ibfk_1
  foreign key (college_id) references college (college_id)
)
  comment '专业介绍';

create index college_id
  on speciality (college_id);

create table student
(
  openid varchar(155) null
  comment 'openid',
  student_no varchar(20) not null
  comment '学号'
    primary key,
  password varchar(20) null
  comment '密码',
  student_name varchar(20) null
  comment '姓名',
  college varchar(20) null
  comment '学院',
  speciality varchar(20) null
  comment '专业',
  class1 varchar(20) null
  comment '班级',
  dormitory varchar(20) null
  comment '宿舍'
)
  comment '学生信息';

create table wxinfo
(
  openid varchar(50) not null
    primary key,
  nick_name varchar(20) not null
  comment '用户昵称',
  avatar_url varchar(200) not null
  comment '头像地址',
  city varchar(20) null
  comment '城市',
  country varchar(20) null
  comment '国家',
  gender int not null
  comment '性别',
  language varchar(20) null
  comment '语言',
  province varchar(10) null
  comment '省份'
)
  engine = MyISAM;

