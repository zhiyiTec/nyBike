-- 建库
create database nybikedb;

-- 使用库
use nybikedb;

-- 创建tb_status
create table tb_status(
id int primary key auto_increment,
sid int comment '站点ID',
nba int comment '可用车数',
nbd int comment '损坏车数',
nda int comment '可用桩数',
ndd int comment '损坏桩数'
)default charset utf8;

-- hiveQL
-- 建库
create database nybikedb;

-- 使用库
use nybikedb;

-- 创建表tb_trip_1
create table tb_trip_1(
tripduration int,
starttime string,
stoptime string,
start_station_id int,
start_station_name string,
start_station_latitude double,
start_station_longitude double,
end_station_id int,
end_station_name string,
end_station_latitude double,
end_station_longitude double,
bikeid int,
usertype string,
birth_year int,
gender int
)ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';

-- 导入csv数据
load data inpath 'hdfs://master:8020/20190601-3.csv' overwrite into table tb_trip_1;

-- 创建表tb_gender_count
create table tb_gender_count(
start_date date,
gender int,
num int
);

insert into tb_gender_count select substr(starttime,0,10),gender,count(*) from tb_trip_1 group by substr(starttime,0,10),gender;

--配置hive的hive-site.xml文件
<property>
         <name>hive.server2.thrift.port</name>
         <value>10000</value>
</property>
<property>
        <name>hive.server2.thrift.client.user</name>
        <value>root</value>
        <description>Username to use against thrift client</description>
</property>
<property>
        <name>hive.server2.thrift.client.password</name>
        <value>root</value>
        <description>Password to use against thrift client</description>
</property>	

--配置hadoop的core-site.xml文件
<property>
        <name>hadoop.proxyuser.root.hosts</name>
        <value>*</value>
</property>
<property>
        <name>hadoop.proxyuser.root.groups</name>
        <value>*</value>
</property>

--启动hiveserver2
hive --service hiveserver2 &



create table tb_agestage_count(
starttime Date,
birth_year  int,
num int
);

--将查到的数据插入到结果表tb_agestage_count
insert into tb_agestage_count
select substr(starttime,0,10),birth_year,count(*)
from tb_trip
group by substr(starttime,0,10),birth_year;

-- 用于统计各个年龄段的数量
create table tb_agestage_num(

age int,
num int
);
insert into tb_agestage_num(age,nukm,userPassword,gender,address,phone)




create table tb_usertype_count(
type string,
num int
);
--将查到的数据插入到结果表tb_usertype_count
insert into tb_usertype_count
select usertype ,count(*)
from tb_trip
group by usertype;

drop table if exists tb_usertype_count;

create table tb_duration_count(
startime date,
time int,
num int
);
--将查到的数据插入到结果表tb_agestage_count
insert into tb_duration_count
select substr(starttime,0,10),tripduration,count(*)
from tb_trip
group by substr(starttime,0,10),tripduration;
drop table if exists tb_duration_count;