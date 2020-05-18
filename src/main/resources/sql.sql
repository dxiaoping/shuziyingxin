 create database yingxin;
 use yingxin;
 drop table jxjh;
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
   `busi_class` varchar(20) comment '业务类别',
   `solution` text comment '业务解决方案',
   primary key (busi_id)
 );
 ALTER TABLE business COMMENT = '业务对象';

 create table `busi_relation`(
   `busi_id1` int comment '业务对象id',
   `busi_id2` int comment '关联对象id',
   foreign key (`busi_id1`) references business(busi_id),
   foreign key (`busi_id2`) references business(busi_id),
   primary key (busi_id1,busi_id2)
 );
 ALTER TABLE busi_relation COMMENT = '业务对象关联';

 create table `place`(
  `place_id` int auto_increment comment '地点id',
  `place_name` varchar(20) unique comment '地点名',
  `latitude` double comment '纬度',
  `longitude` double comment '精度',
   primary key (place_id)
 );
 alter table place comment = '地点对象';

#  =======================在创建表后修改表结构================================
alter table jxjh change `credit` `credit` float COMMENT '学分';
alter table business change `solution` `solution` text comment '解决方案';
alter table business_relation rename to busi_relation;

 select bu.* from business bu
                 right join (select (case when busi_id1 = 3 then busi_id2 else busi_id1 end) as a
                             from busi_relation
                            where busi_id1 = 3 or busi_id2 = 3) bure
     on (bu.busi_id=bure.a)
 SELECT LAST_INSERT_ID() from business;