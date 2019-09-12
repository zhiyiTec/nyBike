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