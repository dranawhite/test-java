-- 查看支持的存储引擎类型
SHOW ENGINES;
-- 查看支持的所有数据库
SHOW DATABASES;
-- 查看该数据库下所有表
SHOW TABLES;
-- 查看数据库信息 /*之间的值为注释信息*/
SHOW CREATE DATABASE orcl;
-- 查看表结构详细信息
SHOW CREATE TABLE T_POST;
-- 查看当前登录用户的权限
SHOW GRANTS FOR root;
-- 选择ORCL作为当前数据库
USE orcl;

-- 列出当前数据库
SELECT DATABASE();
-- 查看数据库版本
SELECT VERSION();
-- 查看当前登录数据库用户名
SELECT USER();

-- 查看表结构信息
DESCRIBE T_POST;

-- 查看表索引
EXPLAIN SELECT * FROM T_POST WHERE TOPIC_ID = 1007;