INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES (1, '定时任务', 'quartz/schedule/index', NULL, 0, 0, 'icon-reloadtime', 0, 0, 0, 10000, now(), 10000, now());

SET @menuId = @@identity;
INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '查看', '', 'schedule:page', 1, 0, '', 0, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '新增', '', 'schedule:save', 1, 0, '', 1, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '修改', '', 'schedule:update,schedule:info', 1, 0, '', 2, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '删除', '', 'schedule:delete', 1, 0, '', 3, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '立即运行', '', 'schedule:run', 1, 0, '', 2, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '日志', '', 'schedule:log', 1, 0, '', 4, 0, 0, 10000, now(), 10000, now());

INSERT INTO sys_dict_type (dict_type, dict_name, remark, sort, version, deleted, creator, create_time, updater, update_time) VALUES ('schedule_group', '定时任务', '任务组名', 0, 0, 0, 10000, now(), 10000, now());

SET @typeId = @@identity;
INSERT INTO sys_dict_data (dict_type_id, dict_label, dict_value, remark, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @typeId), '默认', 'default', '', 0, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_dict_data (dict_type_id, dict_label, dict_value, remark, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @typeId), '系统', 'system', '', 1, 0, 0, 10000, now(), 10000, now());

INSERT INTO sys_dict_type (dict_type, dict_name, remark, sort, version, deleted, creator, create_time, updater, update_time) VALUES ('schedule_status', '定时任务', '状态', 0, 0, 0, 10000, now(), 10000, now());

SET @typeId = @@identity;
INSERT INTO sys_dict_data (dict_type_id, dict_label, dict_value, remark, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @typeId), '暂停', '0', '', 0, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_dict_data (dict_type_id, dict_label, dict_value, remark, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @typeId), '正常', '1', '', 1, 0, 0, 10000, now(), 10000, now());
