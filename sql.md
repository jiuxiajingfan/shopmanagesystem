
CREATE TABLE tb_user(
`uid` BIGINT NOT NULL auto_increment comment '用户id',
`username` VARCHAR(20) NOT NULL comment '用户登录名',
`password` char(64) NOT NULL comment '用户密码',
`email` VARCHAR(255) NOT NULL comment '用户邮箱',
`gmt_create` datetime NOT NULL comment '创建时间',
`gmt_modified` datetime NOT NULL comment '修改时间',
PRIMARY key(`uid`)
);

CREATE TABLE tb_shop(
`id` BIGINT auto_increment PRIMARY key comment '店铺id',
`name` VARCHAR(30) NOT NULL comment '店铺名',
`introduce` text comment '店铺简介'
)

CREATE TABLE tb_role(
`id` BIGINT NOT NULL auto_increment PRIMARY key comment 'id',
`uid` BIGINT NOT NULL comment '用户uid',
`suid` BIGINT NOT NULL comment '店铺uid',
`role` CHAR(1)  DEFAULT '0' comment '用户角色'
)


CREATE TABLE tb_goods(
`id` BIGINT NOT NULL auto_increment PRIMARY key comment 'id',
`name` VARCHAR(40) NOT NULL comment '商品名称',
`gid` VARCHAR(20) NOT NULL comment '商品条形码',
`suid` BIGINT NOT NULL comment '店铺uid',
`in_price` DOUBLE  DEFAULT 0 comment '商品进价',
`out_price` DOUBLE DEFAULT 0 comment '商品售价',
`profit` DOUBLE  DEFAULT 0 comment '单件利润',
`number` BIGINT DEFAULT 0 comment '商品数量',
`gmt_create` datetime NOT NULL comment '创建时间',
`gmt_make` datetime NOT NULL comment '生产时间',
`gmt_overdue` datetime NOT NULL comment '过期时间'
)


CREATE TABLE tb_logs(
`id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY comment '操作id',
`type` VARCHAR(10) NOT NULL comment '操作类型',
`gmt_create` DATETIME NOT NULL comment '创建时间',
`opretate` TEXT NOT NULL comment '操作',
`uid` BIGINT NOT NULL comment '操作人'
);



## 日志触发器

### 用户账户日志
create trigger tb_user_insert_trigger
after insert on tb_user for each row
begin
insert into tb_logs(id, type, gmt_create, opretate, uid) values
(null,'insert',now(),concat('新增用户:',new.uid,' 时间',new.gmt_create),new.uid);
end;

create trigger tb_user_delete_trigger
after delete on tb_user for each row
begin
insert into tb_logs(id, type, gmt_create, opretate, uid) values
(null,'delete',now(),concat('删除用户:',old.uid,' 时间:',now(),'用户名：',OLD.username,'密码:',old.password,'邮箱',old.email),old.uid);
end;

create trigger tb_user_update_trigger
after update on tb_user for each row
begin
insert into tb_logs(id, type, gmt_create, opretate, uid) values
(null,'update',now(),concat('更改用户:',old.uid,' 时间:',now(),' 用户名：',OLD.username,' 密码:',old.password,' 邮箱',old.email,'\n更新后：  用户名：',NEW.username,' 密码',new.password,' 邮箱',new.email),new.uid);
end


### 权限日志
create trigger tb_role_delete_trigger
after delete on tb_role for each row
begin
insert into tb_logs(id, type, gmt_create, opretate, uid) values
(null,'delete',now(),concat('删除用户权限:',old.uid, ' 店铺：',old.suid),old.uid);
end;


create trigger tb_role_update_trigger
after update on tb_role for each row
begin
insert into tb_logs(id, type, gmt_create, opretate, uid) values
(null,'update',now(),concat('更新用户权限:',old.uid,' ',old.role,'---->',new.role, ' 店铺：',old.suid),old.uid);
end;

create trigger tb_role_insert_trigger
after insert on tb_role for each row
begin
insert into tb_logs(id, type, gmt_create, opretate, uid) values
(null,'insert',now(),concat('新增用户权限:',new.uid, ' 店铺：',new.suid,'权限：',new.role),new.uid);
end;

##店铺日志
create trigger tb_shop_insert_trigger
after insert on tb_shop for each row
begin
insert into tb_logs(id, type, gmt_create, opretate, uid) values
(null,'insert',now(),concat('新增店铺:',new.id, ' 店铺名：',new.name,' 介绍：',new.introduce),new.id);
end;

create trigger tb_shop_delete_trigger
after delete on tb_shop for each row
begin
insert into tb_logs(id, type, gmt_create, opretate, uid) values
(null,'insert',now(),concat('删除店铺:',old.id, ' 店铺名：',old.name,' 介绍：',old.introduce),old.id);
end;

create trigger tb_shop_update_trigger
after update on tb_shop for each row
begin
insert into tb_logs(id, type, gmt_create, opretate, uid) values
(null,'update',now(),concat('修改店铺:',old.id, ' 店铺名：',old.name,' 介绍：',old.introduce,'\n新信息：    店铺名：',new.name,' 介绍：',new.introduce),old.id);
end;