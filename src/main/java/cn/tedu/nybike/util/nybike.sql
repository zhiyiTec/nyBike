--建库
create database nybike;

--使用库
use nybike;

-- 创建tb_status
create table tb_status(
id int auto_increament,
sid int comment '站点id',
nba int commment '可用车数',
nbd commment '损坏车数',
nda commment '可用桩数',
ndd commment '损坏桩数桩数',
primary key (id)
)default charset utf8

--hivSQL
--1.创建数据库
create  database nybike;
--2.使用这个数据库
use nybike;
--3.建表
create table tb_trip_1(
tripduration int,
starttime String,
stoptime String,
start_station_id int,
start_station_name String,
start_station_latitude DOUBLE ,
start_station_longitude DOUBLE ,
end_station_id int,
end_station_name String,
end_station_latitude DOUBLE,
end_station_longitude DOUBLE,
bikeid int,
usertype String,
birth_year int,
gender int

)ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
-- 表示hive关联的原始数据字段的分隔符使用逗号

-- hive导入hdfs上的csv数据
load data  inpath 'hdfs://master:8020/20190601.csv' overwrite into table tb_trip_1;

--创建 性别比例的结果表

create table tb_gender_count(
starttime Date,
gender int,
num int
);
--将查到的数据插入到结果表
insert into tb_gender_count
select substr(starttime,0,10),gender,count(*)
from tb_trip_1
group by substr(starttime,0,10),gender;