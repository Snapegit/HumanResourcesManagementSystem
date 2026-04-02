/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41)
 Source Host           : localhost:3306
 Source Schema         : cl7341662

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41)
 File Encoding         : 65001

 Date: 02/04/2026 17:24:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bumen
-- ----------------------------
DROP TABLE IF EXISTS `bumen`;
CREATE TABLE `bumen`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `bumen` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '部门',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `bumen`(`bumen` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 147 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '部门' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bumen
-- ----------------------------
INSERT INTO `bumen` VALUES (141, '2024-02-06 22:04:08', '部门1');
INSERT INTO `bumen` VALUES (142, '2024-02-06 22:04:08', '部门2');
INSERT INTO `bumen` VALUES (143, '2024-02-06 22:04:08', '部门3');
INSERT INTO `bumen` VALUES (144, '2024-02-06 22:04:08', '部门4');
INSERT INTO `bumen` VALUES (145, '2024-02-06 22:04:08', '部门5');
INSERT INTO `bumen` VALUES (146, '2024-02-06 22:04:08', '部门6');

-- ----------------------------
-- Table structure for canjiapeixun
-- ----------------------------
DROP TABLE IF EXISTS `canjiapeixun`;
CREATE TABLE `canjiapeixun`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `peixunzhuti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '培训主题',
  `peixunshijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '培训时间',
  `peixundizhi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '培训地址',
  `peixunjihua` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '培训计划',
  `peixuncailiao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '培训材料',
  `peixunneirong` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '培训内容',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 167 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '参加培训' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of canjiapeixun
-- ----------------------------
INSERT INTO `canjiapeixun` VALUES (161, '2024-02-06 22:04:08', '培训主题1', '培训时间1', '培训地址1', '培训计划1', '培训材料1', '培训内容1', '员工工号1', '员工姓名1', '专员账号1');
INSERT INTO `canjiapeixun` VALUES (162, '2024-02-06 22:04:08', '培训主题2', '培训时间2', '培训地址2', '培训计划2', '培训材料2', '培训内容2', '员工工号2', '员工姓名2', '专员账号2');
INSERT INTO `canjiapeixun` VALUES (163, '2024-02-06 22:04:08', '培训主题3', '培训时间3', '培训地址3', '培训计划3', '培训材料3', '培训内容3', '员工工号3', '员工姓名3', '专员账号3');
INSERT INTO `canjiapeixun` VALUES (164, '2024-02-06 22:04:08', '培训主题4', '培训时间4', '培训地址4', '培训计划4', '培训材料4', '培训内容4', '员工工号4', '员工姓名4', '专员账号4');
INSERT INTO `canjiapeixun` VALUES (165, '2024-02-06 22:04:08', '培训主题5', '培训时间5', '培训地址5', '培训计划5', '培训材料5', '培训内容5', '员工工号5', '员工姓名5', '专员账号5');
INSERT INTO `canjiapeixun` VALUES (166, '2024-02-06 22:04:08', '培训主题6', '培训时间6', '培训地址6', '培训计划6', '培训材料6', '培训内容6', '员工工号6', '员工姓名6', '专员账号6');

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '配置文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'swiper1', 'file/swiperPicture1.jpg');
INSERT INTO `config` VALUES (2, 'swiper2', 'file/swiperPicture2.jpg');
INSERT INTO `config` VALUES (3, 'swiper3', 'file/swiperPicture3.jpg');

-- ----------------------------
-- Table structure for dakaxinxi
-- ----------------------------
DROP TABLE IF EXISTS `dakaxinxi`;
CREATE TABLE `dakaxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '员工姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `zhiwei` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '职位',
  `bumen` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门',
  `dakashijian` datetime NULL DEFAULT NULL COMMENT '打卡时间',
  `dakaleixing` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '打卡类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 237 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '打卡信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dakaxinxi
-- ----------------------------
INSERT INTO `dakaxinxi` VALUES (231, '2024-02-06 22:04:08', '员工工号1', '员工姓名1', '性别1', '职位1', '部门1', '2024-02-06 22:04:08', '上班');
INSERT INTO `dakaxinxi` VALUES (232, '2024-02-06 22:04:08', '员工工号2', '员工姓名2', '性别2', '职位2', '部门2', '2024-02-06 22:04:08', '上班');
INSERT INTO `dakaxinxi` VALUES (233, '2024-02-06 22:04:08', '员工工号3', '员工姓名3', '性别3', '职位3', '部门3', '2024-02-06 22:04:08', '上班');
INSERT INTO `dakaxinxi` VALUES (234, '2024-02-06 22:04:08', '员工工号4', '员工姓名4', '性别4', '职位4', '部门4', '2024-02-06 22:04:08', '上班');
INSERT INTO `dakaxinxi` VALUES (235, '2024-02-06 22:04:08', '员工工号5', '员工姓名5', '性别5', '职位5', '部门5', '2024-02-06 22:04:08', '上班');
INSERT INTO `dakaxinxi` VALUES (236, '2024-02-06 22:04:08', '员工工号6', '员工姓名6', '性别6', '职位6', '部门6', '2024-02-06 22:04:08', '上班');

-- ----------------------------
-- Table structure for gangweidiaohuan
-- ----------------------------
DROP TABLE IF EXISTS `gangweidiaohuan`;
CREATE TABLE `gangweidiaohuan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `zhiwei` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '原职位',
  `diaohuanzhiwei` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '调换职位',
  `shenqingshijian` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `shenqingyuanyin` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '申请原因',
  `shhf` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  `zhuanyuanmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 217 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '岗位调换' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gangweidiaohuan
-- ----------------------------
INSERT INTO `gangweidiaohuan` VALUES (211, '2024-02-06 22:04:08', '员工工号1', '员工姓名1', '原职位1', '调换职位1', '2024-02-06 22:04:08', '申请原因1', '', '专员账号1', '专员名称1');
INSERT INTO `gangweidiaohuan` VALUES (212, '2024-02-06 22:04:08', '员工工号2', '员工姓名2', '原职位2', '调换职位2', '2024-02-06 22:04:08', '申请原因2', '', '专员账号2', '专员名称2');
INSERT INTO `gangweidiaohuan` VALUES (213, '2024-02-06 22:04:08', '员工工号3', '员工姓名3', '原职位3', '调换职位3', '2024-02-06 22:04:08', '申请原因3', '', '专员账号3', '专员名称3');
INSERT INTO `gangweidiaohuan` VALUES (214, '2024-02-06 22:04:08', '员工工号4', '员工姓名4', '原职位4', '调换职位4', '2024-02-06 22:04:08', '申请原因4', '', '专员账号4', '专员名称4');
INSERT INTO `gangweidiaohuan` VALUES (215, '2024-02-06 22:04:08', '员工工号5', '员工姓名5', '原职位5', '调换职位5', '2024-02-06 22:04:08', '申请原因5', '', '专员账号5', '专员名称5');
INSERT INTO `gangweidiaohuan` VALUES (216, '2024-02-06 22:04:08', '员工工号6', '员工姓名6', '原职位6', '调换职位6', '2024-02-06 22:04:08', '申请原因6', '', '专员账号6', '专员名称6');

-- ----------------------------
-- Table structure for gangweileixing
-- ----------------------------
DROP TABLE IF EXISTS `gangweileixing`;
CREATE TABLE `gangweileixing`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gangweileixing` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '岗位类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `gangweileixing`(`gangweileixing` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '岗位类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gangweileixing
-- ----------------------------
INSERT INTO `gangweileixing` VALUES (51, '2024-02-06 22:04:07', '岗位类型1');
INSERT INTO `gangweileixing` VALUES (52, '2024-02-06 22:04:07', '岗位类型2');
INSERT INTO `gangweileixing` VALUES (53, '2024-02-06 22:04:07', '岗位类型3');
INSERT INTO `gangweileixing` VALUES (54, '2024-02-06 22:04:07', '岗位类型4');
INSERT INTO `gangweileixing` VALUES (55, '2024-02-06 22:04:07', '岗位类型5');
INSERT INTO `gangweileixing` VALUES (56, '2024-02-06 22:04:07', '岗位类型6');

-- ----------------------------
-- Table structure for gongzixinxi
-- ----------------------------
DROP TABLE IF EXISTS `gongzixinxi`;
CREATE TABLE `gongzixinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `nianyuefen` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '年月份',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `dixin` double NOT NULL COMMENT '底薪',
  `jixiao` double NOT NULL COMMENT '绩效',
  `jiangjin` double NOT NULL COMMENT '奖金',
  `quanqinjiang` double NOT NULL COMMENT '全勤奖',
  `wuxianyijin` double NOT NULL COMMENT '五险一金',
  `koukuan` double NOT NULL COMMENT '扣款',
  `shifagongzi` double NULL DEFAULT NULL COMMENT '实发工资',
  `gongzibeizhu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工资备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 227 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '工资信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gongzixinxi
-- ----------------------------
INSERT INTO `gongzixinxi` VALUES (221, '2024-02-06 22:04:08', '年月份1', '员工工号1', '员工姓名1', 1, 1, 1, 1, 1, 1, 1, '工资备注1');
INSERT INTO `gongzixinxi` VALUES (222, '2024-02-06 22:04:08', '年月份2', '员工工号2', '员工姓名2', 2, 2, 2, 2, 2, 2, 2, '工资备注2');
INSERT INTO `gongzixinxi` VALUES (223, '2024-02-06 22:04:08', '年月份3', '员工工号3', '员工姓名3', 3, 3, 3, 3, 3, 3, 3, '工资备注3');
INSERT INTO `gongzixinxi` VALUES (224, '2024-02-06 22:04:08', '年月份4', '员工工号4', '员工姓名4', 4, 4, 4, 4, 4, 4, 4, '工资备注4');
INSERT INTO `gongzixinxi` VALUES (225, '2024-02-06 22:04:08', '年月份5', '员工工号5', '员工姓名5', 5, 5, 5, 5, 5, 5, 5, '工资备注5');
INSERT INTO `gongzixinxi` VALUES (226, '2024-02-06 22:04:08', '年月份6', '员工工号6', '员工姓名6', 6, 6, 6, 6, 6, 6, 6, '工资备注6');

-- ----------------------------
-- Table structure for gongzuojilu
-- ----------------------------
DROP TABLE IF EXISTS `gongzuojilu`;
CREATE TABLE `gongzuojilu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `riqi` date NULL DEFAULT NULL COMMENT '日期',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `gongzuojianjie` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '工作简介',
  `gongzuoxiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '工作详情',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 277 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '工作记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gongzuojilu
-- ----------------------------
INSERT INTO `gongzuojilu` VALUES (271, '2024-02-06 22:04:08', '2024-02-06', '标题1', '工作简介1', '工作详情1', '员工工号1', '员工姓名1');
INSERT INTO `gongzuojilu` VALUES (272, '2024-02-06 22:04:08', '2024-02-06', '标题2', '工作简介2', '工作详情2', '员工工号2', '员工姓名2');
INSERT INTO `gongzuojilu` VALUES (273, '2024-02-06 22:04:08', '2024-02-06', '标题3', '工作简介3', '工作详情3', '员工工号3', '员工姓名3');
INSERT INTO `gongzuojilu` VALUES (274, '2024-02-06 22:04:08', '2024-02-06', '标题4', '工作简介4', '工作详情4', '员工工号4', '员工姓名4');
INSERT INTO `gongzuojilu` VALUES (275, '2024-02-06 22:04:08', '2024-02-06', '标题5', '工作简介5', '工作详情5', '员工工号5', '员工姓名5');
INSERT INTO `gongzuojilu` VALUES (276, '2024-02-06 22:04:08', '2024-02-06', '标题6', '工作简介6', '工作详情6', '员工工号6', '员工姓名6');

-- ----------------------------
-- Table structure for jiabanshenqing
-- ----------------------------
DROP TABLE IF EXISTS `jiabanshenqing`;
CREATE TABLE `jiabanshenqing`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiabanyuanyin` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '加班原因',
  `jiabanshijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '加班时间',
  `beizhu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `shenqingshijian` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `shhf` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 207 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '加班申请' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jiabanshenqing
-- ----------------------------
INSERT INTO `jiabanshenqing` VALUES (201, '2024-02-06 22:04:08', '加班原因1', '加班时间1', '备注1', '员工工号1', '员工姓名1', '2024-02-06 22:04:08', '', '专员账号1');
INSERT INTO `jiabanshenqing` VALUES (202, '2024-02-06 22:04:08', '加班原因2', '加班时间2', '备注2', '员工工号2', '员工姓名2', '2024-02-06 22:04:08', '', '专员账号2');
INSERT INTO `jiabanshenqing` VALUES (203, '2024-02-06 22:04:08', '加班原因3', '加班时间3', '备注3', '员工工号3', '员工姓名3', '2024-02-06 22:04:08', '', '专员账号3');
INSERT INTO `jiabanshenqing` VALUES (204, '2024-02-06 22:04:08', '加班原因4', '加班时间4', '备注4', '员工工号4', '员工姓名4', '2024-02-06 22:04:08', '', '专员账号4');
INSERT INTO `jiabanshenqing` VALUES (205, '2024-02-06 22:04:08', '加班原因5', '加班时间5', '备注5', '员工工号5', '员工姓名5', '2024-02-06 22:04:08', '', '专员账号5');
INSERT INTO `jiabanshenqing` VALUES (206, '2024-02-06 22:04:08', '加班原因6', '加班时间6', '备注6', '员工工号6', '员工姓名6', '2024-02-06 22:04:08', '', '专员账号6');

-- ----------------------------
-- Table structure for jixiaobiaozhun
-- ----------------------------
DROP TABLE IF EXISTS `jixiaobiaozhun`;
CREATE TABLE `jixiaobiaozhun`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaozhunmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标准名称',
  `fengmian` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '封面',
  `yuangongkaoqin` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '员工考勤',
  `gongzuotaidu` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '工作态度',
  `yewunengli` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '业务能力',
  `gongzuojixiao` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '工作绩效',
  `beizhu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 187 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '绩效标准' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jixiaobiaozhun
-- ----------------------------
INSERT INTO `jixiaobiaozhun` VALUES (181, '2024-02-06 22:04:08', '标准名称1', 'file/jixiaobiaozhunFengmian1.jpg,file/jixiaobiaozhunFengmian2.jpg,file/jixiaobiaozhunFengmian3.jpg', '员工考勤1', '工作态度1', '业务能力1', '工作绩效1', '备注1');
INSERT INTO `jixiaobiaozhun` VALUES (182, '2024-02-06 22:04:08', '标准名称2', 'file/jixiaobiaozhunFengmian2.jpg,file/jixiaobiaozhunFengmian3.jpg,file/jixiaobiaozhunFengmian4.jpg', '员工考勤2', '工作态度2', '业务能力2', '工作绩效2', '备注2');
INSERT INTO `jixiaobiaozhun` VALUES (183, '2024-02-06 22:04:08', '标准名称3', 'file/jixiaobiaozhunFengmian3.jpg,file/jixiaobiaozhunFengmian4.jpg,file/jixiaobiaozhunFengmian5.jpg', '员工考勤3', '工作态度3', '业务能力3', '工作绩效3', '备注3');
INSERT INTO `jixiaobiaozhun` VALUES (184, '2024-02-06 22:04:08', '标准名称4', 'file/jixiaobiaozhunFengmian4.jpg,file/jixiaobiaozhunFengmian5.jpg,file/jixiaobiaozhunFengmian6.jpg', '员工考勤4', '工作态度4', '业务能力4', '工作绩效4', '备注4');
INSERT INTO `jixiaobiaozhun` VALUES (185, '2024-02-06 22:04:08', '标准名称5', 'file/jixiaobiaozhunFengmian5.jpg,file/jixiaobiaozhunFengmian6.jpg,file/jixiaobiaozhunFengmian7.jpg', '员工考勤5', '工作态度5', '业务能力5', '工作绩效5', '备注5');
INSERT INTO `jixiaobiaozhun` VALUES (186, '2024-02-06 22:04:08', '标准名称6', 'file/jixiaobiaozhunFengmian6.jpg,file/jixiaobiaozhunFengmian7.jpg,file/jixiaobiaozhunFengmian8.jpg', '员工考勤6', '工作态度6', '业务能力6', '工作绩效6', '备注6');

-- ----------------------------
-- Table structure for jixiaokaohe
-- ----------------------------
DROP TABLE IF EXISTS `jixiaokaohe`;
CREATE TABLE `jixiaokaohe`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `bumen` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门',
  `yuangongkaoqin` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工考勤',
  `gongzuotaidu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工作态度',
  `yewunengli` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '业务能力',
  `gongzuojixiao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工作绩效',
  `pingjiadengji` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '评价等级',
  `beizhu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `kaoheshijian` datetime NULL DEFAULT NULL COMMENT '考核时间',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 257 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '绩效考核' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jixiaokaohe
-- ----------------------------
INSERT INTO `jixiaokaohe` VALUES (251, '2024-02-06 22:04:08', '员工工号1', '员工姓名1', '部门1', '1', '1', '1', '1', '优秀', '备注1', '2024-02-06 22:04:08', '专员账号1');
INSERT INTO `jixiaokaohe` VALUES (252, '2024-02-06 22:04:08', '员工工号2', '员工姓名2', '部门2', '1', '1', '1', '1', '优秀', '备注2', '2024-02-06 22:04:08', '专员账号2');
INSERT INTO `jixiaokaohe` VALUES (253, '2024-02-06 22:04:08', '员工工号3', '员工姓名3', '部门3', '1', '1', '1', '1', '优秀', '备注3', '2024-02-06 22:04:08', '专员账号3');
INSERT INTO `jixiaokaohe` VALUES (254, '2024-02-06 22:04:08', '员工工号4', '员工姓名4', '部门4', '1', '1', '1', '1', '优秀', '备注4', '2024-02-06 22:04:08', '专员账号4');
INSERT INTO `jixiaokaohe` VALUES (255, '2024-02-06 22:04:08', '员工工号5', '员工姓名5', '部门5', '1', '1', '1', '1', '优秀', '备注5', '2024-02-06 22:04:08', '专员账号5');
INSERT INTO `jixiaokaohe` VALUES (256, '2024-02-06 22:04:08', '员工工号6', '员工姓名6', '部门6', '1', '1', '1', '1', '优秀', '备注6', '2024-02-06 22:04:08', '专员账号6');

-- ----------------------------
-- Table structure for kaoqinxinxi
-- ----------------------------
DROP TABLE IF EXISTS `kaoqinxinxi`;
CREATE TABLE `kaoqinxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `bumen` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门',
  `chuqintianshu` int NOT NULL COMMENT '出勤天数',
  `qingjiatianshu` int NOT NULL COMMENT '请假天数',
  `chidaotianshu` int NOT NULL COMMENT '迟到天数',
  `zaotuicishu` int NOT NULL COMMENT '早退次数',
  `queqintianshu` int NOT NULL COMMENT '缺勤天数',
  `tongjishijian` datetime NULL DEFAULT NULL COMMENT '统计时间',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 247 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '考勤信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kaoqinxinxi
-- ----------------------------
INSERT INTO `kaoqinxinxi` VALUES (241, '2024-02-06 22:04:08', '员工工号1', '员工姓名1', '部门1', 1, 1, 1, 1, 1, '2024-02-06 22:04:08', '专员账号1');
INSERT INTO `kaoqinxinxi` VALUES (242, '2024-02-06 22:04:08', '员工工号2', '员工姓名2', '部门2', 2, 2, 2, 2, 2, '2024-02-06 22:04:08', '专员账号2');
INSERT INTO `kaoqinxinxi` VALUES (243, '2024-02-06 22:04:08', '员工工号3', '员工姓名3', '部门3', 3, 3, 3, 3, 3, '2024-02-06 22:04:08', '专员账号3');
INSERT INTO `kaoqinxinxi` VALUES (244, '2024-02-06 22:04:08', '员工工号4', '员工姓名4', '部门4', 4, 4, 4, 4, 4, '2024-02-06 22:04:08', '专员账号4');
INSERT INTO `kaoqinxinxi` VALUES (245, '2024-02-06 22:04:08', '员工工号5', '员工姓名5', '部门5', 5, 5, 5, 5, 5, '2024-02-06 22:04:08', '专员账号5');
INSERT INTO `kaoqinxinxi` VALUES (246, '2024-02-06 22:04:08', '员工工号6', '员工姓名6', '部门6', 6, 6, 6, 6, 6, '2024-02-06 22:04:08', '专员账号6');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '菜单',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '2024-02-06 22:04:08', '[{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"打卡信息\",\"menuJump\":\"列表\",\"tableName\":\"dakaxinxi\"},{\"appFrontIcon\":\"cuIcon-explore\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"审核\"],\"menu\":\"请假休假\",\"menuJump\":\"列表\",\"tableName\":\"qingjiaxiujia\"},{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"审核\"],\"menu\":\"加班申请\",\"menuJump\":\"列表\",\"tableName\":\"jiabanshenqing\"},{\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"审核\"],\"menu\":\"岗位调换\",\"menuJump\":\"列表\",\"tableName\":\"gangweidiaohuan\"}],\"fontClass\":\"icon-common43\",\"menu\":\"考勤信息管理\",\"unicode\":\"&#xef27;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-similar\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"公告信息\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"fontClass\":\"icon-common42\",\"menu\":\"公告管理\",\"unicode\":\"&#xef24;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\"],\"menu\":\"人事专员\",\"menuJump\":\"列表\",\"tableName\":\"renshizhuanyuan\"},{\"appFrontIcon\":\"cuIcon-explore\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"导入\"],\"menu\":\"员工\",\"menuJump\":\"列表\",\"tableName\":\"yuangong\"},{\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"人事档案\",\"menuJump\":\"列表\",\"tableName\":\"renshidangan\"},{\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"用户\",\"menuJump\":\"列表\",\"tableName\":\"yonghu\"}],\"fontClass\":\"icon-user4\",\"menu\":\"用户管理\",\"unicode\":\"&#xef9a;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"薪酬标准\",\"menuJump\":\"列表\",\"tableName\":\"xinchoubiaozhun\"},{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"绩效标准\",\"menuJump\":\"列表\",\"tableName\":\"jixiaobiaozhun\"},{\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"工资信息\",\"menuJump\":\"列表\",\"tableName\":\"gongzixinxi\"}],\"fontClass\":\"icon-common17\",\"menu\":\"绩效薪酬\",\"unicode\":\"&#xedfe;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-newshot\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"工作记录\",\"menuJump\":\"列表\",\"tableName\":\"gongzuojilu\"}],\"fontClass\":\"icon-common47\",\"menu\":\"工作记录管理\",\"unicode\":\"&#xef63;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"查看\"],\"menu\":\"操作日志\",\"menuJump\":\"列表\",\"tableName\":\"syslog\"}],\"fontClass\":\"icon-common31\",\"menu\":\"操作日志管理\",\"unicode\":\"&#xee48;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-circle\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"}],\"fontClass\":\"icon-common14\",\"menu\":\"管理员管理\",\"unicode\":\"&#xedfb;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"部门\",\"menuJump\":\"列表\",\"tableName\":\"bumen\"}],\"fontClass\":\"icon-common15\",\"menu\":\"部门管理\",\"unicode\":\"&#xedfc;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"查看\",\"参加\"],\"menu\":\"培训信息\",\"menuJump\":\"列表\",\"tableName\":\"peixunxinxi\"}],\"menu\":\"培训信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"查看\"],\"menu\":\"绩效标准\",\"menuJump\":\"列表\",\"tableName\":\"jixiaobiaozhun\"}],\"menu\":\"绩效标准管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"投递\"],\"menu\":\"招聘信息\",\"menuJump\":\"列表\",\"tableName\":\"zhaopinxinxi\"}],\"menu\":\"招聘信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"查看\"],\"menu\":\"薪酬标准\",\"menuJump\":\"列表\",\"tableName\":\"xinchoubiaozhun\"}],\"menu\":\"薪酬标准管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\"],\"menu\":\"公告信息\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"公告信息管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"管理员\",\"tableName\":\"users\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"查看\"],\"menu\":\"投递简历\",\"menuJump\":\"列表\",\"tableName\":\"toudijianli\"},{\"appFrontIcon\":\"cuIcon-album\",\"buttons\":[\"查看\"],\"menu\":\"面试通知\",\"menuJump\":\"列表\",\"tableName\":\"mianshitongzhi\"}],\"fontClass\":\"icon-common39\",\"menu\":\"招聘信息管理\",\"unicode\":\"&#xeeba;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"查看\",\"参加\"],\"menu\":\"培训信息\",\"menuJump\":\"列表\",\"tableName\":\"peixunxinxi\"}],\"menu\":\"培训信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"查看\"],\"menu\":\"绩效标准\",\"menuJump\":\"列表\",\"tableName\":\"jixiaobiaozhun\"}],\"menu\":\"绩效标准管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"投递\"],\"menu\":\"招聘信息\",\"menuJump\":\"列表\",\"tableName\":\"zhaopinxinxi\"}],\"menu\":\"招聘信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"查看\"],\"menu\":\"薪酬标准\",\"menuJump\":\"列表\",\"tableName\":\"xinchoubiaozhun\"}],\"menu\":\"薪酬标准管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\"],\"menu\":\"公告信息\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"公告信息管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"roleName\":\"用户\",\"tableName\":\"yonghu\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"查看\",\"审核\"],\"menu\":\"加班申请\",\"menuJump\":\"列表\",\"tableName\":\"jiabanshenqing\"},{\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"查看\",\"审核\"],\"menu\":\"岗位调换\",\"menuJump\":\"列表\",\"tableName\":\"gangweidiaohuan\"},{\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"查看\"],\"menu\":\"打卡信息\",\"menuJump\":\"列表\",\"tableName\":\"dakaxinxi\"},{\"appFrontIcon\":\"cuIcon-explore\",\"buttons\":[\"查看\",\"审核\"],\"menu\":\"请假休假\",\"menuJump\":\"列表\",\"tableName\":\"qingjiaxiujia\"},{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"考勤统计\"],\"menu\":\"考勤信息\",\"menuJump\":\"列表\",\"tableName\":\"kaoqinxinxi\"}],\"fontClass\":\"icon-common43\",\"menu\":\"考勤信息管理\",\"unicode\":\"&#xef27;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-discover\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"参加培训\",\"menuJump\":\"列表\",\"tableName\":\"canjiapeixun\"},{\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"培训评价\",\"menuJump\":\"列表\",\"tableName\":\"peixunpingjia\"},{\"appFrontIcon\":\"cuIcon-shop\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"参加\"],\"menu\":\"培训信息\",\"menuJump\":\"列表\",\"tableName\":\"peixunxinxi\"}],\"fontClass\":\"icon-common44\",\"menu\":\"培训信息管理\",\"unicode\":\"&#xef28;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-album\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"面试通知\",\"menuJump\":\"列表\",\"tableName\":\"mianshitongzhi\"},{\"appFrontIcon\":\"cuIcon-circle\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"岗位类型\",\"menuJump\":\"列表\",\"tableName\":\"gangweileixing\"},{\"appFrontIcon\":\"cuIcon-circle\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"岗位类型统计\"],\"menu\":\"招聘信息\",\"menuJump\":\"列表\",\"tableName\":\"zhaopinxinxi\"},{\"appFrontIcon\":\"cuIcon-goodsnew\",\"buttons\":[\"新增\",\"查看\",\"删除\",\"通知\"],\"menu\":\"投递简历\",\"menuJump\":\"列表\",\"tableName\":\"toudijianli\"}],\"fontClass\":\"icon-common39\",\"menu\":\"招聘信息管理\",\"unicode\":\"&#xeeba;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"薪酬标准\",\"menuJump\":\"列表\",\"tableName\":\"xinchoubiaozhun\"},{\"appFrontIcon\":\"cuIcon-skin\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"绩效标准\",\"menuJump\":\"列表\",\"tableName\":\"jixiaobiaozhun\"},{\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\"],\"menu\":\"工资信息\",\"menuJump\":\"列表\",\"tableName\":\"gongzixinxi\"},{\"appFrontIcon\":\"cuIcon-wenzi\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"绩效考核\",\"menuJump\":\"列表\",\"tableName\":\"jixiaokaohe\"}],\"fontClass\":\"icon-common17\",\"menu\":\"绩效薪酬\",\"unicode\":\"&#xedfe;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"部门\",\"menuJump\":\"列表\",\"tableName\":\"bumen\"}],\"fontClass\":\"icon-common15\",\"menu\":\"部门管理\",\"unicode\":\"&#xedfc;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-explore\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"导入\"],\"menu\":\"员工\",\"menuJump\":\"列表\",\"tableName\":\"yuangong\"},{\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"人事档案\",\"menuJump\":\"列表\",\"tableName\":\"renshidangan\"}],\"fontClass\":\"icon-user4\",\"menu\":\"用户管理\",\"unicode\":\"&#xef9a;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"查看\",\"参加\"],\"menu\":\"培训信息\",\"menuJump\":\"列表\",\"tableName\":\"peixunxinxi\"}],\"menu\":\"培训信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"查看\"],\"menu\":\"绩效标准\",\"menuJump\":\"列表\",\"tableName\":\"jixiaobiaozhun\"}],\"menu\":\"绩效标准管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"投递\"],\"menu\":\"招聘信息\",\"menuJump\":\"列表\",\"tableName\":\"zhaopinxinxi\"}],\"menu\":\"招聘信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"查看\"],\"menu\":\"薪酬标准\",\"menuJump\":\"列表\",\"tableName\":\"xinchoubiaozhun\"}],\"menu\":\"薪酬标准管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\"],\"menu\":\"公告信息\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"公告信息管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"是\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"roleName\":\"人事专员\",\"tableName\":\"renshizhuanyuan\"},{\"backMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"工资信息\",\"menuJump\":\"列表\",\"tableName\":\"gongzixinxi\"},{\"appFrontIcon\":\"cuIcon-wenzi\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"绩效考核\",\"menuJump\":\"列表\",\"tableName\":\"jixiaokaohe\"}],\"fontClass\":\"icon-common5\",\"menu\":\"绩效薪酬\",\"unicode\":\"&#xedae;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-link\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"打卡信息\",\"menuJump\":\"列表\",\"tableName\":\"dakaxinxi\"},{\"appFrontIcon\":\"cuIcon-explore\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"请假休假\",\"menuJump\":\"列表\",\"tableName\":\"qingjiaxiujia\"},{\"appFrontIcon\":\"cuIcon-cardboard\",\"buttons\":[\"查看\",\"删除\"],\"menu\":\"考勤信息\",\"menuJump\":\"列表\",\"tableName\":\"kaoqinxinxi\"},{\"appFrontIcon\":\"cuIcon-vip\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"加班申请\",\"menuJump\":\"列表\",\"tableName\":\"jiabanshenqing\"},{\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"岗位调换\",\"menuJump\":\"列表\",\"tableName\":\"gangweidiaohuan\"}],\"fontClass\":\"icon-common43\",\"menu\":\"考勤信息管理\",\"unicode\":\"&#xef27;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-discover\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"评价\"],\"menu\":\"参加培训\",\"menuJump\":\"列表\",\"tableName\":\"canjiapeixun\"},{\"appFrontIcon\":\"cuIcon-keyboard\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"menu\":\"培训评价\",\"menuJump\":\"列表\",\"tableName\":\"peixunpingjia\"}],\"fontClass\":\"icon-common44\",\"menu\":\"培训信息管理\",\"unicode\":\"&#xef28;\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-newshot\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"menu\":\"工作记录\",\"menuJump\":\"列表\",\"tableName\":\"gongzuojilu\"}],\"fontClass\":\"icon-common47\",\"menu\":\"工作记录管理\",\"unicode\":\"&#xef63;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"查看\",\"参加\"],\"menu\":\"培训信息\",\"menuJump\":\"列表\",\"tableName\":\"peixunxinxi\"}],\"menu\":\"培训信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"查看\"],\"menu\":\"绩效标准\",\"menuJump\":\"列表\",\"tableName\":\"jixiaobiaozhun\"}],\"menu\":\"绩效标准管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-paint\",\"buttons\":[\"查看\",\"投递\"],\"menu\":\"招聘信息\",\"menuJump\":\"列表\",\"tableName\":\"zhaopinxinxi\"}],\"menu\":\"招聘信息管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"查看\"],\"menu\":\"薪酬标准\",\"menuJump\":\"列表\",\"tableName\":\"xinchoubiaozhun\"}],\"menu\":\"薪酬标准管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\"],\"menu\":\"公告信息\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"公告信息管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"否\",\"roleName\":\"员工\",\"tableName\":\"yuangong\"}]');

-- ----------------------------
-- Table structure for mianshitongzhi
-- ----------------------------
DROP TABLE IF EXISTS `mianshitongzhi`;
CREATE TABLE `mianshitongzhi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gangweimingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '岗位名称',
  `bangonghuanjing` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '办公环境',
  `gangweileixing` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '岗位类型',
  `xueliyaoqiu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '学历要求',
  `xinzidaiyu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '薪资待遇',
  `gongzuoshijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工作时间',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  `zhuanyuanmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员名称',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `mianshishijian` datetime NULL DEFAULT NULL COMMENT '面试时间',
  `mianshididian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '面试地点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '面试通知' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mianshitongzhi
-- ----------------------------
INSERT INTO `mianshitongzhi` VALUES (91, '2024-02-06 22:04:07', '岗位名称1', '办公环境1', '岗位类型1', '学历要求1', '薪资待遇1', '工作时间1', '专员账号1', '专员名称1', '用户账号1', '用户姓名1', '2024-02-06 22:04:07', '面试地点1');
INSERT INTO `mianshitongzhi` VALUES (92, '2024-02-06 22:04:07', '岗位名称2', '办公环境2', '岗位类型2', '学历要求2', '薪资待遇2', '工作时间2', '专员账号2', '专员名称2', '用户账号2', '用户姓名2', '2024-02-06 22:04:07', '面试地点2');
INSERT INTO `mianshitongzhi` VALUES (93, '2024-02-06 22:04:07', '岗位名称3', '办公环境3', '岗位类型3', '学历要求3', '薪资待遇3', '工作时间3', '专员账号3', '专员名称3', '用户账号3', '用户姓名3', '2024-02-06 22:04:07', '面试地点3');
INSERT INTO `mianshitongzhi` VALUES (94, '2024-02-06 22:04:07', '岗位名称4', '办公环境4', '岗位类型4', '学历要求4', '薪资待遇4', '工作时间4', '专员账号4', '专员名称4', '用户账号4', '用户姓名4', '2024-02-06 22:04:07', '面试地点4');
INSERT INTO `mianshitongzhi` VALUES (95, '2024-02-06 22:04:07', '岗位名称5', '办公环境5', '岗位类型5', '学历要求5', '薪资待遇5', '工作时间5', '专员账号5', '专员名称5', '用户账号5', '用户姓名5', '2024-02-06 22:04:07', '面试地点5');
INSERT INTO `mianshitongzhi` VALUES (96, '2024-02-06 22:04:07', '岗位名称6', '办公环境6', '岗位类型6', '学历要求6', '薪资待遇6', '工作时间6', '专员账号6', '专员名称6', '用户账号6', '用户姓名6', '2024-02-06 22:04:07', '面试地点6');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '标题',
  `introduction` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '简介',
  `picture` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '图片',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '公告信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (101, '2024-02-06 22:04:07', '青花瓷', '素胚勾勒出青花笔锋浓转淡，瓶身描绘的牡丹一如你初妆，冉冉檀香透过窗心事我了然，宣上走笔至此搁一半，釉色渲染仕女图韵味被私藏，而你嫣然的一笑如含苞待放，你的美缕飘散，去到我去不了的地方，天青色等烟雨 而我在等你，炊烟袅袅升起', 'file/newsPicture1.jpg', '素胚勾勒出青花笔锋浓转淡，瓶身描绘的牡丹一如你初妆，冉冉檀香透过窗心事我了然，宣上走笔至此搁一半，釉色渲染仕女图韵味被私藏，而你嫣然的一笑如含苞待放，你的美缕飘散，去到我去不了的地方，天青色等烟雨 而我在等你，炊烟袅袅升起， 隔江千万里，在瓶底书前朝的飘逸，就当我为遇见你伏笔，天青色等烟雨， 而我在等你，月色被打捞起， 晕开了局，如传世的青花瓷自顾自美丽，你眼带笑意，色白花青的锦鲤跃然于碗底，临摹宋体落款时却惦记着你，你隐藏在窑烧里千年的秘密，极细腻犹如绣花针落地，帘外芭蕉惹骤雨门环惹铜绿，而我路过那江南小镇惹了你，在泼墨山水画里，你从墨色深处被隐去，天青色等烟雨 ，而我在等你，炊烟袅袅升起 ，隔江千万里，在瓶底书汉隶仿前朝的飘逸，就当我为遇见你伏笔，天色等烟雨 ，而我在等你，月色被打捞起， 晕开了结局，如传世的青花瓷自顾自美丽，你眼带笑意，天青色等烟雨 ，而我在等你，炊烟袅袅升起 ，隔江千万里，在瓶底书汉隶仿前朝的飘逸，就当我为遇见你伏笔，天青色等烟雨， 而我在等你，月色被打捞起 ，晕开了结局，如传世的青花瓷自顾自美丽，你眼带笑意。');
INSERT INTO `news` VALUES (102, '2024-02-06 22:04:07', '理想三旬', '雨后有车驶来，驶过暮色苍白，旧铁皮往南开，恋人已不在，收听浓烟下的，诗歌电台，不动情的咳嗽，至少看起来，归途也还可爱，琴弦少了姿态，再不见那夜里，听歌的小孩，时光匆匆独白，将颠沛磨成卡带，已枯倦的情怀，踏碎成年代，就老去吧，孤独别醒来，你渴望的离开，只是无处停摆，就歌唱吧，眼睛眯起来，而热泪的崩坏，只是没抵达的存在', 'file/newsPicture2.jpg', '雨后有车驶来，驶过暮色苍白，旧铁皮往南开，恋人已不在，收听浓烟下的，诗歌电台，不动情的咳嗽，至少看起来，归途也还可爱，琴弦少了姿态，再不见那夜里，听歌的小孩，时光匆匆独白，将颠沛磨成卡带，已枯倦的情怀，踏碎成年代，就老去吧，孤独别醒来，你渴望的离开，只是无处停摆，就歌唱吧，眼睛眯起来，而热泪的崩坏，只是没抵达的存在，青春又醉倒在，籍籍无名的怀，靠嬉笑来虚度，聚散得慷慨，辗转却去不到，对的站台，如果漂泊是成长，必经的路牌，你迷醒岁月中，那贫瘠的未来，像遗憾季节里，未结果的爱，弄脏了每一页诗，吻最疼痛的告白，而风声吹到这，已不需要释怀，就老去吧，孤独别醒来，渴望的离开只是无处停摆就歌唱吧，眼睛眯起来而热泪的崩坏，只是没抵达的存在，就甜蜜地忍耐，繁星润湿窗台，光影跳动着像在，困倦里说爱，再无谓的感慨，以为明白，梦倒塌的地方，今已爬满青苔。');
INSERT INTO `news` VALUES (103, '2024-02-06 22:04:07', '七里香', '窗外的麻雀在电线杆上多嘴，你说这一句很有夏天的感觉，手中的铅笔在纸上来来回回，我用几行字形容你是我的谁，秋刀鱼的滋味猫跟你都想了解，初恋的香味就这样被我们寻回，那温暖的阳光像刚摘的鲜艳草莓，你说你舍不得吃掉这一种感觉，雨下整夜我的爱溢出就像雨水，院子落叶跟我的思念厚厚一叠', 'file/newsPicture3.jpg', '窗外的麻雀在电线杆上多嘴，你说这一句很有夏天的感觉，手中的铅笔在纸上来来回回，我用几行字形容你是我的谁，秋刀鱼的滋味猫跟你都想了解，初恋的香味就这样被我们寻回，那温暖的阳光像刚摘的鲜艳草莓，你说你舍不得吃掉这一种感觉，雨下整夜我的爱溢出就像雨水，院子落叶跟我的思念厚厚一叠，几句是非也无法将我的热情冷却，你出现在我诗的每一页，雨下整夜我的爱溢出就像雨水，窗台蝴蝶像诗里纷飞的美丽章节，我接着写，把永远爱你写进诗的结尾，你是我唯一想要的了解，雨下整夜我的爱溢出就像雨水，院子落叶跟我的思念厚厚一叠，几句是非也无法将我的热情冷却，你出现在我诗的每一页，那饱满的稻穗幸福了这个季节，而你的脸颊像田里熟透的番茄，你突然对我说七里香的名字很美，我此刻却只想亲吻你倔强的嘴，雨下整夜我的爱溢出就像雨水，院子落叶跟我的思念厚厚一叠，几句是非也无法将我的热情冷却，你出现在我诗的每一页，整夜我的爱溢出就像雨水，窗台蝴蝶像诗里纷飞的美丽章节，我接着写，把永远爱你写进诗的结尾，是我唯一想要的了解。');
INSERT INTO `news` VALUES (104, '2024-02-06 22:04:07', '江南', '风到这里就是粘，粘住过客的思念，雨到了这里缠成线，缠着我们流连人世间，你在身边就是缘，缘分写在三生石上面，爱有万分之一甜，宁愿我就葬在这一点，圈圈圆圆圈圈，天天年年天天的我，深深看你的脸，生气的温柔，埋怨的温柔的脸', 'file/newsPicture4.jpg', '风到这里就是粘，粘住过客的思念，雨到了这里缠成线，缠着我们流连人世间，你在身边就是缘，缘分写在三生石上面，爱有万分之一甜，宁愿我就葬在这一点，圈圈圆圆圈圈，天天年年天天的我，深深看你的脸，生气的温柔，埋怨的温柔的脸，不懂爱恨情愁煎熬的我们，都以为相爱就像风云的善变，相信爱一天抵过永远，在这一刹那冻结了时间，不懂怎么表现温柔的我们，还以为殉情只是古老的传言，离愁能有多痛痛有多浓，当梦被埋在江南烟雨中，心碎了才懂，圈圈圆圆圈圈，天天年年天天的我，深深看你的脸，生气的温柔，埋怨的温柔的脸，不懂爱恨情愁煎熬的我们，都以为相爱就像风云的善变，相信爱一天 抵过永远，在这一刹那冻结了时间，不懂怎么表现温柔的我们，还以为殉情只是古老的传言，离愁能有多痛 痛有多浓，当梦被埋在江南烟雨中，心碎了才懂，相信爱一天抵过永远。在这一刹那冻结了时间，不懂怎么表现温柔的我们，还以为殉情只是古老的传言，离愁能有多痛 痛有多浓，当梦被埋在江南烟雨中，心碎了才懂。');
INSERT INTO `news` VALUES (105, '2024-02-06 22:04:07', '那些你很冒险的梦', '当两颗心开始震动，当你瞳孔学会闪躲，当爱慢慢被遮住只剩下黑，距离像影子被拉拖，当爱的故事剩听说，我找不到你单纯的面孔，当生命每分每秒都为你转动，心多执着就加倍心痛，那些你很冒险的梦， 我陪你去疯，折纸飞机碰到雨天终究会坠落', 'file/newsPicture5.jpg', '当两颗心开始震动，当你瞳孔学会闪躲，当爱慢慢被遮住只剩下黑，距离像影子被拉拖，当爱的故事剩听说，我找不到你单纯的面孔，当生命每分每秒都为你转动，心多执着就加倍心痛，那些你很冒险的梦， 我陪你去疯，折纸飞机碰到雨天终究会坠落，太残忍的话我直说 因为爱很重，你却不想懂 只往反方向走，当爱的故事剩听说，我找不到你单纯的面孔，当生命每分每秒都为你转动，心有多执着就加倍心痛，那些你很冒险的梦 我陪你去疯，折纸飞机 碰到雨天 终究会坠落，太残忍的话我直说 因为爱很重，你却不想懂 只往反方向走，我不想放手 你松开的左手，你爱的放纵 我白不回天空，我输了 累了，但你再也 不回头，那些你很冒险的梦 我陪你去疯，折纸飞机 碰到雨天 终究会坠落，太残忍的话我直说 因为爱很重，你却不想懂 只往反方向走，你真的不懂 我的爱已降落。');
INSERT INTO `news` VALUES (106, '2024-02-06 22:04:07', '孤勇者', '都，是勇敢的，你额头的伤口 你的 不同 你犯的错，都 不必隐藏，你破旧的玩偶 你的 面具 你的自我，他们说 要带着光 驯服每一头怪兽，他们说 要缝好你的伤，没有人爱小丑 为何孤独 不可 光荣，人只有不完美 值得歌颂，谁说污泥满身的不算英雄，爱你孤身走暗巷，爱你不跪的模样，爱你对峙过绝望', 'file/newsPicture6.jpg', '都，是勇敢的，你额头的伤口 你的 不同 你犯的错，都 不必隐藏，你破旧的玩偶 你的 面具 你的自我，他们说 要带着光 驯服每一头怪兽，他们说 要缝好你的伤，没有人爱小丑 为何孤独 不可 光荣，人只有不完美 值得歌颂，谁说污泥满身的不算英雄，爱你孤身走暗巷，爱你不跪的模样，爱你对峙过绝望，不肯哭一场，爱你破烂的衣裳，却敢堵命运的枪，爱你和我那么像，缺口都一样，去吗 配吗 这褴褛的披风，战吗 战啊 以最卑微的梦，致那黑夜中的呜咽与怒吼，谁说站在光里的才算英雄，他们说 要戒了你的狂，就像擦掉了污垢，他们说 要顺台阶而上，而代价是低头，那就让我 不可 乘风，你一样骄傲着 那种孤勇，谁说对弈平凡的不算英雄，爱你孤身走暗巷 爱你不跪的模样，爱你对峙过绝望 不肯哭一场，爱你破烂的衣裳 却敢堵命运的枪，爱你和我那么像 缺口都一样，去吗 配吗 这褴褛的披风，战吗 战啊 以最卑微的梦，致那黑夜中的呜咽与怒吼，谁说站在光里的才算英雄，你的斑驳 与众不同 与众不同，你的沉默 震耳欲聋 震耳欲聋，You Are The Hero，爱你孤身走暗巷 爱你不跪的模样，爱你对峙过绝望 不肯哭一场，爱你来自于蛮荒 一生不借谁的光，你将造你的城邦 在废墟之上，去吗 去啊 以最卑微的梦，战吗 战啊 以最孤高的梦，致那黑夜中的呜咽与怒吼，谁说站在光里的才算英雄。');

-- ----------------------------
-- Table structure for peixunpingjia
-- ----------------------------
DROP TABLE IF EXISTS `peixunpingjia`;
CREATE TABLE `peixunpingjia`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `peixunzhuti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '培训主题',
  `peixunjihua` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '培训计划',
  `peixuncailiao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '培训材料',
  `peixunneirong` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '培训内容',
  `peixunpingjia` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '培训评价',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 177 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '培训评价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of peixunpingjia
-- ----------------------------
INSERT INTO `peixunpingjia` VALUES (171, '2024-02-06 22:04:08', '培训主题1', '培训计划1', '培训材料1', '培训内容1', '培训评价1', '员工工号1', '员工姓名1', '专员账号1');
INSERT INTO `peixunpingjia` VALUES (172, '2024-02-06 22:04:08', '培训主题2', '培训计划2', '培训材料2', '培训内容2', '培训评价2', '员工工号2', '员工姓名2', '专员账号2');
INSERT INTO `peixunpingjia` VALUES (173, '2024-02-06 22:04:08', '培训主题3', '培训计划3', '培训材料3', '培训内容3', '培训评价3', '员工工号3', '员工姓名3', '专员账号3');
INSERT INTO `peixunpingjia` VALUES (174, '2024-02-06 22:04:08', '培训主题4', '培训计划4', '培训材料4', '培训内容4', '培训评价4', '员工工号4', '员工姓名4', '专员账号4');
INSERT INTO `peixunpingjia` VALUES (175, '2024-02-06 22:04:08', '培训主题5', '培训计划5', '培训材料5', '培训内容5', '培训评价5', '员工工号5', '员工姓名5', '专员账号5');
INSERT INTO `peixunpingjia` VALUES (176, '2024-02-06 22:04:08', '培训主题6', '培训计划6', '培训材料6', '培训内容6', '培训评价6', '员工工号6', '员工姓名6', '专员账号6');

-- ----------------------------
-- Table structure for peixunxinxi
-- ----------------------------
DROP TABLE IF EXISTS `peixunxinxi`;
CREATE TABLE `peixunxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `peixunzhuti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '培训主题',
  `peixunshijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '培训时间',
  `peixundizhi` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '培训地址',
  `tupian` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '图片',
  `peixunjihua` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '培训计划',
  `peixuncailiao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '培训材料',
  `peixunneirong` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '培训内容',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 157 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '培训信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of peixunxinxi
-- ----------------------------
INSERT INTO `peixunxinxi` VALUES (151, '2024-02-06 22:04:08', '培训主题1', '培训时间1', '培训地址1', 'file/peixunxinxiTupian1.jpg,file/peixunxinxiTupian2.jpg,file/peixunxinxiTupian3.jpg', '培训计划1', '培训材料1', '培训内容1', '专员账号1');
INSERT INTO `peixunxinxi` VALUES (152, '2024-02-06 22:04:08', '培训主题2', '培训时间2', '培训地址2', 'file/peixunxinxiTupian2.jpg,file/peixunxinxiTupian3.jpg,file/peixunxinxiTupian4.jpg', '培训计划2', '培训材料2', '培训内容2', '专员账号2');
INSERT INTO `peixunxinxi` VALUES (153, '2024-02-06 22:04:08', '培训主题3', '培训时间3', '培训地址3', 'file/peixunxinxiTupian3.jpg,file/peixunxinxiTupian4.jpg,file/peixunxinxiTupian5.jpg', '培训计划3', '培训材料3', '培训内容3', '专员账号3');
INSERT INTO `peixunxinxi` VALUES (154, '2024-02-06 22:04:08', '培训主题4', '培训时间4', '培训地址4', 'file/peixunxinxiTupian4.jpg,file/peixunxinxiTupian5.jpg,file/peixunxinxiTupian6.jpg', '培训计划4', '培训材料4', '培训内容4', '专员账号4');
INSERT INTO `peixunxinxi` VALUES (155, '2024-02-06 22:04:08', '培训主题5', '培训时间5', '培训地址5', 'file/peixunxinxiTupian5.jpg,file/peixunxinxiTupian6.jpg,file/peixunxinxiTupian7.jpg', '培训计划5', '培训材料5', '培训内容5', '专员账号5');
INSERT INTO `peixunxinxi` VALUES (156, '2024-02-06 22:04:08', '培训主题6', '培训时间6', '培训地址6', 'file/peixunxinxiTupian6.jpg,file/peixunxinxiTupian7.jpg,file/peixunxinxiTupian8.jpg', '培训计划6', '培训材料6', '培训内容6', '专员账号6');

-- ----------------------------
-- Table structure for qingjiaxiujia
-- ----------------------------
DROP TABLE IF EXISTS `qingjiaxiujia`;
CREATE TABLE `qingjiaxiujia`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `qingjiayuanyin` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请假原因',
  `qingjiatianshu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请假天数',
  `kaishishijian` date NULL DEFAULT NULL COMMENT '开始时间',
  `qingjialeixing` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请假类型',
  `beizhu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `shenqingshijian` datetime NULL DEFAULT NULL COMMENT '申请时间',
  `shhf` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 197 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '请假休假' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qingjiaxiujia
-- ----------------------------
INSERT INTO `qingjiaxiujia` VALUES (191, '2024-02-06 22:04:08', '标题1', '请假原因1', '请假天数1', '2024-02-06', '事假', '备注1', '员工工号1', '员工姓名1', '2024-02-06 22:04:08', '', '专员账号1');
INSERT INTO `qingjiaxiujia` VALUES (192, '2024-02-06 22:04:08', '标题2', '请假原因2', '请假天数2', '2024-02-06', '事假', '备注2', '员工工号2', '员工姓名2', '2024-02-06 22:04:08', '', '专员账号2');
INSERT INTO `qingjiaxiujia` VALUES (193, '2024-02-06 22:04:08', '标题3', '请假原因3', '请假天数3', '2024-02-06', '事假', '备注3', '员工工号3', '员工姓名3', '2024-02-06 22:04:08', '', '专员账号3');
INSERT INTO `qingjiaxiujia` VALUES (194, '2024-02-06 22:04:08', '标题4', '请假原因4', '请假天数4', '2024-02-06', '事假', '备注4', '员工工号4', '员工姓名4', '2024-02-06 22:04:08', '', '专员账号4');
INSERT INTO `qingjiaxiujia` VALUES (195, '2024-02-06 22:04:08', '标题5', '请假原因5', '请假天数5', '2024-02-06', '事假', '备注5', '员工工号5', '员工姓名5', '2024-02-06 22:04:08', '', '专员账号5');
INSERT INTO `qingjiaxiujia` VALUES (196, '2024-02-06 22:04:08', '标题6', '请假原因6', '请假天数6', '2024-02-06', '事假', '备注6', '员工工号6', '员工姓名6', '2024-02-06 22:04:08', '', '专员账号6');

-- ----------------------------
-- Table structure for renshidangan
-- ----------------------------
DROP TABLE IF EXISTS `renshidangan`;
CREATE TABLE `renshidangan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `danganbianhao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '档案编号',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '员工工号',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `xingbie` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `lianxidianhua` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `shenfenzhenghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `bumen` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '部门',
  `zhiwei` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '职位',
  `lvli` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '履历',
  `ruzhiriqi` date NOT NULL COMMENT '入职日期',
  `danganwenjian` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '档案文件',
  `beizhu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `hetong` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '合同',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `danganbianhao`(`danganbianhao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '人事档案' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of renshidangan
-- ----------------------------
INSERT INTO `renshidangan` VALUES (131, '2024-02-06 22:04:08', '1111111111', '员工工号1', '员工姓名1', '性别1', '联系电话1', '身份证号1', '部门1', '职位1', '履历1', '2024-02-06', '', '备注1', '');
INSERT INTO `renshidangan` VALUES (132, '2024-02-06 22:04:08', '2222222222', '员工工号2', '员工姓名2', '性别2', '联系电话2', '身份证号2', '部门2', '职位2', '履历2', '2024-02-06', '', '备注2', '');
INSERT INTO `renshidangan` VALUES (133, '2024-02-06 22:04:08', '3333333333', '员工工号3', '员工姓名3', '性别3', '联系电话3', '身份证号3', '部门3', '职位3', '履历3', '2024-02-06', '', '备注3', '');
INSERT INTO `renshidangan` VALUES (134, '2024-02-06 22:04:08', '4444444444', '员工工号4', '员工姓名4', '性别4', '联系电话4', '身份证号4', '部门4', '职位4', '履历4', '2024-02-06', '', '备注4', '');
INSERT INTO `renshidangan` VALUES (135, '2024-02-06 22:04:08', '5555555555', '员工工号5', '员工姓名5', '性别5', '联系电话5', '身份证号5', '部门5', '职位5', '履历5', '2024-02-06', '', '备注5', '');
INSERT INTO `renshidangan` VALUES (136, '2024-02-06 22:04:08', '6666666666', '员工工号6', '员工姓名6', '性别6', '联系电话6', '身份证号6', '部门6', '职位6', '履历6', '2024-02-06', '', '备注6', '');

-- ----------------------------
-- Table structure for renshizhuanyuan
-- ----------------------------
DROP TABLE IF EXISTS `renshizhuanyuan`;
CREATE TABLE `renshizhuanyuan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '专员账号',
  `mima` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `zhuanyuanmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '专员名称',
  `fengmian` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '封面',
  `lianxidianhua` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `sfsh` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '回复内容',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `zhuanyuanzhanghao`(`zhuanyuanzhanghao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '人事专员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of renshizhuanyuan
-- ----------------------------
INSERT INTO `renshizhuanyuan` VALUES (41, '2024-02-06 22:04:07', '专员账号1', '123456', '专员名称1', 'file/renshizhuanyuanFengmian1.jpg', '19819881111', '是', '');
INSERT INTO `renshizhuanyuan` VALUES (42, '2024-02-06 22:04:07', '专员账号2', '123456', '专员名称2', 'file/renshizhuanyuanFengmian2.jpg', '19819881112', '是', '');
INSERT INTO `renshizhuanyuan` VALUES (43, '2024-02-06 22:04:07', '专员账号3', '123456', '专员名称3', 'file/renshizhuanyuanFengmian3.jpg', '19819881113', '是', '');
INSERT INTO `renshizhuanyuan` VALUES (44, '2024-02-06 22:04:07', '专员账号4', '123456', '专员名称4', 'file/renshizhuanyuanFengmian4.jpg', '19819881114', '是', '');
INSERT INTO `renshizhuanyuan` VALUES (45, '2024-02-06 22:04:07', '专员账号5', '123456', '专员名称5', 'file/renshizhuanyuanFengmian5.jpg', '19819881115', '是', '');
INSERT INTO `renshizhuanyuan` VALUES (46, '2024-02-06 22:04:07', '专员账号6', '123456', '专员名称6', 'file/renshizhuanyuanFengmian6.jpg', '19819881116', '是', '');

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint NULL DEFAULT NULL COMMENT 'refid',
  `tablename` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '名称',
  `picture` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '图片',
  `type` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  `userid` bigint NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '我的收藏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of storeup
-- ----------------------------

-- ----------------------------
-- Table structure for syslog
-- ----------------------------
DROP TABLE IF EXISTS `syslog`;
CREATE TABLE `syslog`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `operation` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户操作',
  `method` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '请求参数',
  `time` bigint NULL DEFAULT NULL COMMENT '请求时长(毫秒)',
  `ip` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '操作日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of syslog
-- ----------------------------

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'admin', 'users', '管理员', '0vi9ys959siin3izpi4sl0nszcj4prp0', '2026-04-02 15:20:56', '2026-04-02 18:00:51');

-- ----------------------------
-- Table structure for toudijianli
-- ----------------------------
DROP TABLE IF EXISTS `toudijianli`;
CREATE TABLE `toudijianli`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gangweimingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '岗位名称',
  `bangonghuanjing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '办公环境',
  `gangweileixing` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '岗位类型',
  `xueliyaoqiu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '学历要求',
  `xinzidaiyu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '薪资待遇',
  `gongzuoshijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工作时间',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  `zhuanyuanmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员名称',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `gerenjianli` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '个人简历',
  `toudishijian` datetime NULL DEFAULT NULL COMMENT '投递时间',
  `mianshizhuangtai` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '面试状态',
  `crossuserid` bigint NULL DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint NULL DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '投递简历' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of toudijianli
-- ----------------------------
INSERT INTO `toudijianli` VALUES (81, '2024-02-06 22:04:07', '岗位名称1', 'file/toudijianliBangonghuanjing1.jpg,file/toudijianliBangonghuanjing2.jpg,file/toudijianliBangonghuanjing3.jpg', '岗位类型1', '学历要求1', '薪资待遇1', '工作时间1', '专员账号1', '专员名称1', '用户账号1', '用户姓名1', '', '2024-02-06 22:04:07', '已面试', 1, 1);
INSERT INTO `toudijianli` VALUES (82, '2024-02-06 22:04:07', '岗位名称2', 'file/toudijianliBangonghuanjing2.jpg,file/toudijianliBangonghuanjing3.jpg,file/toudijianliBangonghuanjing4.jpg', '岗位类型2', '学历要求2', '薪资待遇2', '工作时间2', '专员账号2', '专员名称2', '用户账号2', '用户姓名2', '', '2024-02-06 22:04:07', '已面试', 2, 2);
INSERT INTO `toudijianli` VALUES (83, '2024-02-06 22:04:07', '岗位名称3', 'file/toudijianliBangonghuanjing3.jpg,file/toudijianliBangonghuanjing4.jpg,file/toudijianliBangonghuanjing5.jpg', '岗位类型3', '学历要求3', '薪资待遇3', '工作时间3', '专员账号3', '专员名称3', '用户账号3', '用户姓名3', '', '2024-02-06 22:04:07', '已面试', 3, 3);
INSERT INTO `toudijianli` VALUES (84, '2024-02-06 22:04:07', '岗位名称4', 'file/toudijianliBangonghuanjing4.jpg,file/toudijianliBangonghuanjing5.jpg,file/toudijianliBangonghuanjing6.jpg', '岗位类型4', '学历要求4', '薪资待遇4', '工作时间4', '专员账号4', '专员名称4', '用户账号4', '用户姓名4', '', '2024-02-06 22:04:07', '已面试', 4, 4);
INSERT INTO `toudijianli` VALUES (85, '2024-02-06 22:04:07', '岗位名称5', 'file/toudijianliBangonghuanjing5.jpg,file/toudijianliBangonghuanjing6.jpg,file/toudijianliBangonghuanjing7.jpg', '岗位类型5', '学历要求5', '薪资待遇5', '工作时间5', '专员账号5', '专员名称5', '用户账号5', '用户姓名5', '', '2024-02-06 22:04:07', '已面试', 5, 5);
INSERT INTO `toudijianli` VALUES (86, '2024-02-06 22:04:07', '岗位名称6', 'file/toudijianliBangonghuanjing6.jpg,file/toudijianliBangonghuanjing7.jpg,file/toudijianliBangonghuanjing8.jpg', '岗位类型6', '学历要求6', '薪资待遇6', '工作时间6', '专员账号6', '专员名称6', '用户账号6', '用户姓名6', '', '2024-02-06 22:04:07', '已面试', 6, 6);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `role` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '2024-02-06 22:04:08', 'admin', 'admin', '管理员');

-- ----------------------------
-- Table structure for xinchoubiaozhun
-- ----------------------------
DROP TABLE IF EXISTS `xinchoubiaozhun`;
CREATE TABLE `xinchoubiaozhun`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '标题',
  `fengmian` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '封面',
  `dixin` double NOT NULL COMMENT '底薪',
  `jixiao` double NOT NULL COMMENT '绩效',
  `jiangjin` double NOT NULL COMMENT '奖金',
  `quanqinjiang` double NOT NULL COMMENT '全勤奖',
  `wuxianyijin` double NOT NULL COMMENT '五险一金',
  `koukuan` double NOT NULL COMMENT '扣款',
  `beizhu` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 267 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '薪酬标准' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xinchoubiaozhun
-- ----------------------------
INSERT INTO `xinchoubiaozhun` VALUES (261, '2024-02-06 22:04:08', '标题1', 'file/xinchoubiaozhunFengmian1.jpg,file/xinchoubiaozhunFengmian2.jpg,file/xinchoubiaozhunFengmian3.jpg', 1, 1, 1, 1, 1, 1, '备注1');
INSERT INTO `xinchoubiaozhun` VALUES (262, '2024-02-06 22:04:08', '标题2', 'file/xinchoubiaozhunFengmian2.jpg,file/xinchoubiaozhunFengmian3.jpg,file/xinchoubiaozhunFengmian4.jpg', 2, 2, 2, 2, 2, 2, '备注2');
INSERT INTO `xinchoubiaozhun` VALUES (263, '2024-02-06 22:04:08', '标题3', 'file/xinchoubiaozhunFengmian3.jpg,file/xinchoubiaozhunFengmian4.jpg,file/xinchoubiaozhunFengmian5.jpg', 3, 3, 3, 3, 3, 3, '备注3');
INSERT INTO `xinchoubiaozhun` VALUES (264, '2024-02-06 22:04:08', '标题4', 'file/xinchoubiaozhunFengmian4.jpg,file/xinchoubiaozhunFengmian5.jpg,file/xinchoubiaozhunFengmian6.jpg', 4, 4, 4, 4, 4, 4, '备注4');
INSERT INTO `xinchoubiaozhun` VALUES (265, '2024-02-06 22:04:08', '标题5', 'file/xinchoubiaozhunFengmian5.jpg,file/xinchoubiaozhunFengmian6.jpg,file/xinchoubiaozhunFengmian7.jpg', 5, 5, 5, 5, 5, 5, '备注5');
INSERT INTO `xinchoubiaozhun` VALUES (266, '2024-02-06 22:04:08', '标题6', 'file/xinchoubiaozhunFengmian6.jpg,file/xinchoubiaozhunFengmian7.jpg,file/xinchoubiaozhunFengmian8.jpg', 6, 6, 6, 6, 6, 6, '备注6');

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yonghuzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户账号',
  `yonghumima` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户密码',
  `yonghuxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户姓名',
  `touxiang` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '头像',
  `xingbie` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `shoujihaoma` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `xueli` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '学历',
  `zhuanye` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专业',
  `gongzuojingli` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '工作经历',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yonghuzhanghao`(`yonghuzhanghao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (31, '2024-02-06 22:04:07', '用户账号1', '123456', '用户姓名1', 'file/yonghuTouxiang1.jpg', '男', '19819881111', '学历1', '专业1', '工作经历1');
INSERT INTO `yonghu` VALUES (32, '2024-02-06 22:04:07', '用户账号2', '123456', '用户姓名2', 'file/yonghuTouxiang2.jpg', '男', '19819881112', '学历2', '专业2', '工作经历2');
INSERT INTO `yonghu` VALUES (33, '2024-02-06 22:04:07', '用户账号3', '123456', '用户姓名3', 'file/yonghuTouxiang3.jpg', '男', '19819881113', '学历3', '专业3', '工作经历3');
INSERT INTO `yonghu` VALUES (34, '2024-02-06 22:04:07', '用户账号4', '123456', '用户姓名4', 'file/yonghuTouxiang4.jpg', '男', '19819881114', '学历4', '专业4', '工作经历4');
INSERT INTO `yonghu` VALUES (35, '2024-02-06 22:04:07', '用户账号5', '123456', '用户姓名5', 'file/yonghuTouxiang5.jpg', '男', '19819881115', '学历5', '专业5', '工作经历5');
INSERT INTO `yonghu` VALUES (36, '2024-02-06 22:04:07', '用户账号6', '123456', '用户姓名6', 'file/yonghuTouxiang6.jpg', '男', '19819881116', '学历6', '专业6', '工作经历6');

-- ----------------------------
-- Table structure for yuangong
-- ----------------------------
DROP TABLE IF EXISTS `yuangong`;
CREATE TABLE `yuangong`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `yuangonggonghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '员工工号',
  `yuangongmima` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '员工密码',
  `yuangongxingming` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '员工姓名',
  `touxiang` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '头像',
  `xingbie` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `lianxidianhua` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `shenfenzhenghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `bumen` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门',
  `zhiwei` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `yuangonggonghao`(`yuangonggonghao` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 127 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '员工' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuangong
-- ----------------------------
INSERT INTO `yuangong` VALUES (121, '2024-02-06 22:04:08', '员工工号1', '123456', '员工姓名1', 'file/yuangongTouxiang1.jpg', '男', '19819881111', '441622200101010001', '部门1', '职位1');
INSERT INTO `yuangong` VALUES (122, '2024-02-06 22:04:08', '员工工号2', '123456', '员工姓名2', 'file/yuangongTouxiang2.jpg', '男', '19819881112', '441622200202020002', '部门2', '职位2');
INSERT INTO `yuangong` VALUES (123, '2024-02-06 22:04:08', '员工工号3', '123456', '员工姓名3', 'file/yuangongTouxiang3.jpg', '男', '19819881113', '441622200303030003', '部门3', '职位3');
INSERT INTO `yuangong` VALUES (124, '2024-02-06 22:04:08', '员工工号4', '123456', '员工姓名4', 'file/yuangongTouxiang4.jpg', '男', '19819881114', '441622200404040004', '部门4', '职位4');
INSERT INTO `yuangong` VALUES (125, '2024-02-06 22:04:08', '员工工号5', '123456', '员工姓名5', 'file/yuangongTouxiang5.jpg', '男', '19819881115', '441622200505050005', '部门5', '职位5');
INSERT INTO `yuangong` VALUES (126, '2024-02-06 22:04:08', '员工工号6', '123456', '员工姓名6', 'file/yuangongTouxiang6.jpg', '男', '19819881116', '441622200606060006', '部门6', '职位6');

-- ----------------------------
-- Table structure for zhaopinxinxi
-- ----------------------------
DROP TABLE IF EXISTS `zhaopinxinxi`;
CREATE TABLE `zhaopinxinxi`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gangweimingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '岗位名称',
  `bangonghuanjing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '办公环境',
  `gangweileixing` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '岗位类型',
  `zhaopinrenshu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '招聘人数',
  `zhuanyeyaoqiu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专业要求',
  `xueliyaoqiu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '学历要求',
  `gongzuonianxian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工作年限',
  `xinzidaiyu` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '薪资待遇',
  `gongzuoshijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '工作时间',
  `gangweixiangqing` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '岗位详情',
  `zhuanyuanzhanghao` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员账号',
  `zhuanyuanmingcheng` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专员名称',
  `lianxidianhua` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `clicktime` datetime NULL DEFAULT NULL COMMENT '最近点击时间',
  `storeupnum` int NULL DEFAULT NULL COMMENT '收藏数量',
  `clicknum` int NULL DEFAULT NULL COMMENT '点击次数',
  `fabushijian` varchar(200) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '招聘信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhaopinxinxi
-- ----------------------------
INSERT INTO `zhaopinxinxi` VALUES (61, '2024-02-06 22:04:07', '岗位名称1', 'file/zhaopinxinxiBangonghuanjing1.jpg,file/zhaopinxinxiBangonghuanjing2.jpg,file/zhaopinxinxiBangonghuanjing3.jpg', '岗位类型1', '招聘人数1', '专业要求1', '学历要求1', '工作年限1', '薪资待遇1', '工作时间1', '岗位详情1', '专员账号1', '专员名称1', '联系电话1', '2024-02-06 22:04:07', 1, 1, '发布时间1');
INSERT INTO `zhaopinxinxi` VALUES (62, '2024-02-06 22:04:07', '岗位名称2', 'file/zhaopinxinxiBangonghuanjing2.jpg,file/zhaopinxinxiBangonghuanjing3.jpg,file/zhaopinxinxiBangonghuanjing4.jpg', '岗位类型2', '招聘人数2', '专业要求2', '学历要求2', '工作年限2', '薪资待遇2', '工作时间2', '岗位详情2', '专员账号2', '专员名称2', '联系电话2', '2024-02-06 22:04:07', 2, 2, '发布时间2');
INSERT INTO `zhaopinxinxi` VALUES (63, '2024-02-06 22:04:07', '岗位名称3', 'file/zhaopinxinxiBangonghuanjing3.jpg,file/zhaopinxinxiBangonghuanjing4.jpg,file/zhaopinxinxiBangonghuanjing5.jpg', '岗位类型3', '招聘人数3', '专业要求3', '学历要求3', '工作年限3', '薪资待遇3', '工作时间3', '岗位详情3', '专员账号3', '专员名称3', '联系电话3', '2026-04-02 15:02:16', 3, 4, '发布时间3');
INSERT INTO `zhaopinxinxi` VALUES (64, '2024-02-06 22:04:07', '岗位名称4', 'file/zhaopinxinxiBangonghuanjing4.jpg,file/zhaopinxinxiBangonghuanjing5.jpg,file/zhaopinxinxiBangonghuanjing6.jpg', '岗位类型4', '招聘人数4', '专业要求4', '学历要求4', '工作年限4', '薪资待遇4', '工作时间4', '岗位详情4', '专员账号4', '专员名称4', '联系电话4', '2024-02-06 22:04:07', 4, 4, '发布时间4');
INSERT INTO `zhaopinxinxi` VALUES (65, '2024-02-06 22:04:07', '岗位名称5', 'file/zhaopinxinxiBangonghuanjing5.jpg,file/zhaopinxinxiBangonghuanjing6.jpg,file/zhaopinxinxiBangonghuanjing7.jpg', '岗位类型5', '招聘人数5', '专业要求5', '学历要求5', '工作年限5', '薪资待遇5', '工作时间5', '岗位详情5', '专员账号5', '专员名称5', '联系电话5', '2024-02-06 22:04:07', 5, 5, '发布时间5');
INSERT INTO `zhaopinxinxi` VALUES (66, '2024-02-06 22:04:07', '岗位名称6', 'file/zhaopinxinxiBangonghuanjing6.jpg,file/zhaopinxinxiBangonghuanjing7.jpg,file/zhaopinxinxiBangonghuanjing8.jpg', '岗位类型6', '招聘人数6', '专业要求6', '学历要求6', '工作年限6', '薪资待遇6', '工作时间6', '岗位详情6', '专员账号6', '专员名称6', '联系电话6', '2024-02-06 22:04:07', 6, 6, '发布时间6');

SET FOREIGN_KEY_CHECKS = 1;
