DROP TABLE IF EXISTS foot_line_order;
CREATE TABLE foot_line_order(
                                id INT NOT NULL AUTO_INCREMENT  COMMENT '主键id' ,
                                status INT NOT NULL  DEFAULT 100 COMMENT '订单状态;100待测量105待发货110待收货115待送货120待安装200已完成' ,
                                customer_id INT NOT NULL  DEFAULT 0 COMMENT '客户ID' ,
                                supply_id INT NOT NULL  DEFAULT 0 COMMENT '供应商ID' ,
                                supply_name VARCHAR(255) NOT NULL  DEFAULT '' COMMENT '供应商名称' ,
                                foot_number VARCHAR(255) NOT NULL  DEFAULT '' COMMENT '脚线型号' ,
                                survey_area INT NOT NULL  DEFAULT 0 COMMENT '测量米数' ,
                                send_block INT NOT NULL  DEFAULT 0 COMMENT '发货米数' ,
                                actual_use_block INT NOT NULL  DEFAULT 0 COMMENT '实际使用米数' ,
                                create_by VARCHAR(90) NOT NULL  DEFAULT '' COMMENT '创建人' ,
                                create_time DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                                survey_name_id INT NOT NULL  DEFAULT 0 COMMENT '测量人ID' ,
                                survey_name VARCHAR(20) NOT NULL  DEFAULT '' COMMENT '测量人' ,
                                survey_time DATETIME    COMMENT '测量时间' ,
                                survey_img VARCHAR(900) NOT NULL  DEFAULT '' COMMENT '现场图片;分号分隔' ,
                                install_name_id INT NOT NULL  DEFAULT 0 COMMENT '安装工人ID' ,
                                install_name VARCHAR(90) NOT NULL   COMMENT '安装工人' ,
                                install_time DATETIME    COMMENT '安装时间' ,
                                install_img VARCHAR(900) NOT NULL  DEFAULT '' COMMENT '安装图片' ,
                                install_amount DECIMAL(8,2) NOT NULL  DEFAULT 0.00 COMMENT '安装费' ,
                                price DECIMAL(10,2) NOT NULL  DEFAULT 0.00 COMMENT '单价/米' ,
                                amount DECIMAL(10,2) NOT NULL  DEFAULT 0.0000 COMMENT '脚线金额' ,
                                update_time DATETIME    COMMENT '更新时间' ,
                                update_by VARCHAR(90) NOT NULL  DEFAULT '' COMMENT '更新人' ,
                                remark VARCHAR(200) NOT NULL  DEFAULT '' COMMENT '备注' ,
                                PRIMARY KEY (id)
)  COMMENT = '脚线订单';


insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('脚线订单查询', 2020, '1',  '#',  'F', '0', 'order:footLine:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('脚线订单新增', 2020, '2',  '#',  'F', '0', 'order:footLine:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('脚线订单修改', 2020, '3',  '#',  'F', '0', 'order:footLine:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('脚线订单删除', 2020, '4',  '#',  'F', '0', 'order:footLine:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('脚线订单导出', 2020, '5',  '#',  'F', '0', 'order:footLine:export',       '#', 'admin', sysdate(), '', null, '');