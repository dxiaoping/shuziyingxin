 create database yingxin;
 use yingxin;


 create table `wxinfo` (
   `openid` varchar(50) not null ,
   `nick_name` varchar(20) not null comment '用户昵称',
   `avatar_url` varchar(200) not null comment '头像地址',
   `city` varchar(20) comment '城市',
   `country` varchar(20) comment '国家',
   `gender` int not null comment '性别',
   `language` varchar(20) comment '语言',
   `province` varchar(10) comment '省份',
   primary key (openid)
 )
   engine = MyISAM;

 CREATE TABLE `jxjh`
 (
   `start_year` int COMMENT '开设年度',
   `speciality_name` varchar(20) COMMENT '专业名称',
   `speciality_direction` varchar(20) COMMENT '开课方向',
   `start_term` int COMMENT '开课学期',
   `course_no` varchar(10) COMMENT '课程编号',
   `course_name` varchar(20) COMMENT '课程名称',
   `course_nature` varchar(20) COMMENT '课程性质',
   `course_attr` varchar(6) COMMENT '课程属性',
   `check_mode` varchar(6) COMMENT '考核方式',
   `credit` float COMMENT '学分',
   `time_class` int COMMENT '总学时',
   `time_week` int COMMENT '周学时',
   `time_class_theory` int COMMENT '理论学时',
   `time_class_practice` int COMMENT '实践学时',
   `time_class_lecture` int COMMENT '讲座学时',
   `unit` varchar(20) COMMENT '开课单位',
   `course_class` varchar(20) COMMENT '课程类别'
 );
 ALTER TABLE jxjh COMMENT = '教学计划';


 create table `business`(
   `busi_id` int auto_increment comment '业务id',
   `busi_name` varchar(20) unique comment '业务名',
   `busi_class_id` int comment '业务类别id',
   `solution` text comment '业务解决方案',
   primary key (busi_id)
 );
 ALTER TABLE business COMMENT = '业务对象';
 ALTER TABLE business change `busi_class_id` `busi_class_id` varchar(20) COMMENT '业务类别id';
 ALTER TABLE business modify `busi_class_id` int COMMENT '业务类别id';

 create table `busi_relation`(
   `busi_id1` int comment '业务对象id',
   `busi_id2` int comment '关联对象id',
   foreign key (`busi_id1`) references business(busi_id),
   foreign key (`busi_id2`) references business(busi_id),
   primary key (busi_id1,busi_id2)
 );
 ALTER TABLE busi_relation COMMENT = '业务对象关联';#业务解决方案
 create table `address`(
  `addr_id` int auto_increment comment '地点id',
  `addr_name` varchar(20) unique comment '地点名',
  `latitude` double comment '纬度',
  `longitude` double comment '精度',
  `description` text comment '地标介绍',
   primary key (addr_id)
 );
 alter table address comment = '地标对象';
alter table address add column `description` text comment '地点介绍';

 create table `addr_relation`(
   `busi_id` int comment '业务对象id',
   `addr_id` int comment '关联地点id',
   foreign key (`busi_id`) references business(busi_id),
   foreign key (`addr_id`) references address(addr_id),
   primary key (busi_id,addr_id)
 );

 create table `busi_class`(
   `busi_class_id` int auto_increment comment '业务类别id',
   `busi_class_name` varchar(10) unique comment '业务类别名称',
   primary key (busi_class_id)
 )comment '业务类别';
 alter table busi_class add column `description` text comment '分类描述';
# 2020/03/29
 drop table `student`;
 create table `student`(
   `openid` varchar(155) comment 'openid',
   `student_no` varchar(20) comment '学号',
   `password` varchar(20) comment '密码',
   `student_name` varchar(20) comment '姓名',
   `college` varchar(20) comment '学院',
   `speciality` varchar(20) comment '专业',
   `class1` varchar(20) comment '班级',
   `dormitory` varchar(20) comment '宿舍',
   primary key (student_no)
 ) comment '学生信息';
 create table `college`(
   `college_id` int auto_increment comment '学院id',
   `college_name` varchar(20) comment '学院名称',
   `description` text comment '学院描述',
   primary key (college_id)
 ) comment '学院';

#  通过管理员界面
 drop table speciality;
 create table `speciality`(
   `speciality_id` int auto_increment comment '专业id',
   `college_id` int comment '学院id',
   `speciality_name` varchar(25) comment '专业名称',
   `description` text comment '专业描述',
   `major_class` varchar(255) comment '主修课程',
   primary key (speciality_id),
   foreign key (college_id) references college(college_id)
 ) comment '专业介绍';

 drop table association;
 create table `association`(
   `id` int auto_increment comment '社团id',
   `name` varchar(20) comment '社团名称',
   `organization` varchar(20) comment '所属组织',
   `related_person` text comment '相关人物',
   `contact_info` text comment '联系信息',
   `description` text comment '社团描述',
   primary key (id)
 )comment '社团/协会/学生会组织';
alter table association add column `organization` varchar(20) comment '所属组织';
 create table `laboratory`(
   `id` int auto_increment comment '实验室id',
   `name` varchar(20) comment '实验室名称',
   `organization` varchar(20) comment '所属组织',
   `related_person` text comment '相关人物',
   `contact_info` text comment '联系信息',
   `description` text comment '实验室描述',
   `address` varchar(45) comment '实验室详细地址',
   primary key (id)
 ) comment '实验室';

#  搜索库（仅针对普通用户使用）
#  drop table search;
 create table `search`(
  `key_word` varchar(20) comment '其他表中的关键字',
   `class1` varchar(20) comment '业务类型'
 ) comment '搜索库';

 create table `config`(
   `class1` varchar(20) comment '配置类别',
   `key` varchar(45) comment '属性',
   `value` varchar(45) comment '值',
   `description` text comment '描述'
 )comment '配置表';
alter table config change column `class1` `class1` varchar(45) comment '配置类别';

#  =======================在创建表后修改表结构================================
alter table jxjh change `credit` `credit` float COMMENT '学分';
alter table business change `solution` `solution` text comment '解决方案';
alter table business_relation rename to busi_relation;

 show variables like '%max_connections%'; #查看最大连接数
 show variables;
 select bu.* from business bu
                 right join (select (case when busi_id1 = 3 then busi_id2 else busi_id1 end) as a
                             from busi_relation
                            where busi_id1 = 3 or busi_id2 = 3) bure
     on (bu.busi_id=bure.a);
 SELECT LAST_INSERT_ID() from business;

 select place.* from place right join place_relation r on place.place_id = r.place_id
 where r.busi_id = 42;

 select * from jxjh limit 5,6

use yingxin_online;

select * from users where department like '%计算机%' and jwcAccount like 'B2016%'
select start_term, count(*) from jxjh where speciality_name='数学与应用数学' group by start_term