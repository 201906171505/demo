-- 模拟用户表  (组织架构暂时没建)
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` varchar(255)   NOT NULL,
  `user_name` varchar(40)   NOT NULL,
  `user_password` varchar(40)   NOT NULL,
  `user_email` varchar(60)   NOT NULL,
  `register_time` datetime(0) NULL DEFAULT NULL,
  `valid` int(1) NOT NULL,
  PRIMARY KEY (`user_id`)
);

-- 计划表
DROP TABLE IF EXISTS `t_plan`;
CREATE TABLE `t_plan`  (
  `plan_id` varchar(255)   NOT NULL,
  `name` varchar(255)   NOT NULL COMMENT '计划名称',
  `begin_date` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_date` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `state` int(1) NULL DEFAULT 1 COMMENT '状态（1 未安排 2 已安排）',
  `school_semester` varchar(255)   NULL DEFAULT NULL COMMENT '学年学期',
  `attachment_url` varchar(255)   NULL DEFAULT NULL COMMENT '附件URL',
  PRIMARY KEY (`plan_id`)
);

-- 任务表
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task`  (
  `task_id` varchar(255)   NOT NULL,
  `task_p_id` varchar(255)   NULL DEFAULT '0' COMMENT '父任务id',
  `plan_id` varchar(255)   NOT NULL COMMENT '所属计划',
  `name` varchar(255)   NOT NULL COMMENT '任务名称',
  `assign_id` varchar(255)   NULL DEFAULT NULL COMMENT '分配人',
  `leader_id` varchar(255)   NULL DEFAULT NULL COMMENT '负责人',
  `attachment_url` varchar(255)   NULL DEFAULT NULL COMMENT '附件URL',
  `state` int(1) NULL DEFAULT NULL COMMENT '1待接收，2进行中、3已超期、4待验收',
  `begin_date` datetime DEFAULT NULL COMMENT '开始时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  `desc` text null,
  PRIMARY KEY (`task_id`)
);
-- 任务参与人关系表
DROP TABLE IF EXISTS `t_task_play`;
CREATE TABLE `t_task_play`  (
  `task_id` varchar(255)   NULL DEFAULT NULL,
  `play_id` varchar(255) NULL DEFAULT NULL
);
