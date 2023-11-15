create database citic;

use citic;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`                 BIGINT     NOT NULL COMMENT '主键',
    `username`           VARCHAR(255) COMMENT '用户名',
    `email`              VARCHAR(255) COMMENT '邮箱',
    `phone`              VARCHAR(255) COMMENT '手机号',
    `id_card`             VARCHAR(18) COMMENT '身份证号',
    `password`           VARCHAR(255) COMMENT '密码',
    `admission`          TINYINT(1)          DEFAULT true COMMENT '准入权限',
    `revision`           INT        NOT NULL DEFAULT 0 COMMENT '乐观锁',
    `deleted`            TINYINT(1) NOT NULL DEFAULT false COMMENT '逻辑删除',
    `create_time`        DATETIME   NOT NULL COMMENT '创建时间',
    `update_time`        DATETIME   NOT NULL COMMENT '更新时间',
    `created_by` VARCHAR(255)    NOT NULL COMMENT '创建人',
    `updated_by` VARCHAR(255)    NOT NULL COMMENT '更新人',
    PRIMARY KEY (id),
    UNIQUE INDEX `idx_username` (username),
    UNIQUE INDEX `idx_email` (email),
    UNIQUE INDEX `idx_phone` (phone)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '用户信息';