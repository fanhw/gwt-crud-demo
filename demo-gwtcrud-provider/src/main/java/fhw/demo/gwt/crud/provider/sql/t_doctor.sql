/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : 127.0.0.1:3306
 Source Schema         : mygwt

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : 65001

 Date: 11/05/2022 13:44:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE `t_doctor`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  `job_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_doctor
-- ----------------------------
INSERT INTO `t_doctor` VALUES (1, 18, '2022-05-18', 'lz001', 'tom');
INSERT INTO `t_doctor` VALUES (2, 25, '2022-05-25', 'lz002', 'mary');
INSERT INTO `t_doctor` VALUES (3, 18, '2022-05-10', 'lz005', '李四');
INSERT INTO `t_doctor` VALUES (4, 15, '2022-05-10', 'lz003', '张三');
INSERT INTO `t_doctor` VALUES (5, 17, '2022-05-29', 'lz004', '张四');
INSERT INTO `t_doctor` VALUES (6, 18, '2001-05-18', 'lz999', 'sakura');
INSERT INTO `t_doctor` VALUES (7, 25, '2001-05-28', 'lz998', 'sakura001');
INSERT INTO `t_doctor` VALUES (8, 55, '2024-06-13', 'lz222', 'sakura055');
INSERT INTO `t_doctor` VALUES (9, 99, '2022-05-20', 'lz666', 'sakura999');

SET FOREIGN_KEY_CHECKS = 1;
