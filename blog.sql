/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 30/03/2022 09:40:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_account
-- ----------------------------
DROP TABLE IF EXISTS `blog_account`;
CREATE TABLE `blog_account`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号(用户名)',
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码(MD5加密)',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `qq_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ号',
  `we_chat` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  `last_time` datetime(0) NULL DEFAULT NULL COMMENT '上次登录时间',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户账号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_account
-- ----------------------------
INSERT INTO `blog_account` VALUES ('1644990311581db451e800cd4467da863636762c32b40', 'gcp', '16461197675823dd75f2233194189adcb468855b5c343', 'E10ADC3949BA59ABBE56E057F20F883E', '15216240480', '2046039989', '2046039989gcp', '2022-02-16 13:43:34', '2022-03-28 13:35:24', 1, '2022-03-30 09:38:46');
INSERT INTO `blog_account` VALUES ('164514931305503dff866281e433f9535075e746b9593', 'ddd11', '', 'E10ADC3949BA59ABBE56E057F20F883E', '12345', '1234', '2312312', '2022-02-18 09:02:59', '2022-02-18 09:02:59', 9, NULL);
INSERT INTO `blog_account` VALUES ('164514931346499e17bfb487042979579d1025de33d48', 'ddd', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '12345', '1234', '2312312', '2022-02-18 09:02:59', '2022-02-28 17:51:03', 1, NULL);
INSERT INTO `blog_account` VALUES ('164514945555943ee2246302c4a5cb7157447dd0225e2', 'asasd', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1123123123', '12312312', '1312312', '2022-02-18 09:02:59', '2022-02-28 17:51:03', 1, NULL);
INSERT INTO `blog_account` VALUES ('1645149483735bef9fa0183d240e08ee1011149914a91', 'qqqq', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '123123', '123123', '123123', '2022-02-18 09:02:59', '2022-02-28 17:51:03', 1, NULL);
INSERT INTO `blog_account` VALUES ('164515137796358831a4e29554c70ae29516c27f9f145', '郭长平', '16461197675823dd75f2233194189adcb468855b5c343', 'E10ADC3949BA59ABBE56E057F20F883E', '15216240480', '2046039989', 'gcp2046039989', '2022-02-18 10:27:11', '2022-03-25 13:04:37', 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518491977bccb7474b104b5395fae28132617766', '测试0', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521620', '20202300', 'gcp0', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518492122b117bde1da547f0ae80cfa1a1c8a81f', '测试1', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521621', '20202301', 'gcp1', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849220d7f2e0e1e3544abb9d7ab952aa32fc9c', '测试2', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521622', '20202302', 'gcp2', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL);
INSERT INTO `blog_account` VALUES ('164515184922653621070fbac4ceca997a0171d6ac724', '测试3', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521623', '20202303', 'gcp3', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL);
INSERT INTO `blog_account` VALUES ('164515184923202e0690dbf244425a900bc9e874730ae', '测试4', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521624', '20202304', 'gcp4', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518492382cdbb318ad164e8f921e37207d80a7b2', '测试5', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '1521625', '20202305', 'gcp5', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518492468a386461b51a4c33824d9d8d5543d4d0', '测试6', '16461197675823dd75f2233194189adcb468855b5c343', '123456', '1521626', '20202306', 'gcp6', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 9, NULL);
INSERT INTO `blog_account` VALUES ('164515184925459a612b4d3864c77bd0acbd073e3b36a', '测试712', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521627', '20202307', 'gcp7', '2022-02-18 10:37:26', '2022-03-03 13:35:39', 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849263c493d77c36c54f3e8335afcea0200ac4', '测试8', '164603784790470d04240e3c245c4b240ef81cc6c47f3', 'E10ADC3949BA59ABBE56E057F20F883E', '1521628', '20202308', 'gcp8', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518492704f51d5d7045b47b3a92c2533143a274d', '测试9', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '1521629', '20202309', 'gcp9', '2022-02-18 10:37:26', NULL, 9, NULL);
INSERT INTO `blog_account` VALUES ('164515184927611915d8956954dffb682f98fe54f3333', '测试10', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216210', '202023010', 'gcp10', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518492821cb4497aa7224dbdbef3da963865ce64', '测试11', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216211', '202023011', 'gcp11', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849288131a7f617a9e4a2799fb651707ed0a5d', '测试12', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216212', '202023012', 'gcp12', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849294041b74c1509045ed995c0743ba33cf9b', '测试13', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216213', '202023013', 'gcp13', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849299a850ecab22e04e2fa3c7f44029cb18c8', '测试14', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216214', '202023014', 'gcp14', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518493070511a0a4ff024b288c636727f3d076ad', '测试15', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216215', '202023015', 'gcp15', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849314a0805aa8d55a443d87816dfbdd7934a7', '测试16', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216216', '202023016', 'gcp16', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849319fa6521cac5634782b8f6edc96282e339', '测试17', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216217', '202023017', 'gcp17', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849324b4b8df9d7563496f9192eb1706708b88', '测试18', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216218', '202023018', 'gcp18', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518493297bf8f244139c4d4e9075c0907e01a966', '测试19', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216219', '202023019', 'gcp19', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518493347e792fabbc7a401f8894d1c93197e167', '测试20', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216220', '202023020', 'gcp20', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('164515184934019bb7add082a424a8b052c3ee05d341e', '测试21', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216221', '202023021', 'gcp21', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('164515184934677cb290cd0bc44d0a0313fd5027ad985', '测试22', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216222', '202023022', 'gcp22', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849352e8e8476085564ffcb71fcf19c7136571', '测试23', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216223', '202023023', 'gcp23', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518493585d33e31de7954a89898cafeb6b5d0221', '测试24', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216224', '202023024', 'gcp24', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518493646af8a8eb4eae46b2ab3612a8699154f7', '测试25', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216225', '202023025', 'gcp25', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849369f7445f4013564199abf98ec9da9ed5d5', '测试26', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216226', '202023026', 'gcp26', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849376ec968176b0214b62b79ed114971473fd', '测试27', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216227', '202023027', 'gcp27', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849382516ccf88777d4118a7040b970beebc64', '测试28', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216228', '202023028', 'gcp28', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849387ee54fa2540eb477a8170b9696ad58e09', '测试29', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216229', '202023029', 'gcp29', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518493961612c354d67045e38fd92ad88a50f4d4', '测试30', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216230', '202023030', 'gcp30', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849404abdee8755c87417ba65133497889c2e9', '测试31', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216231', '202023031', 'gcp31', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('164515184941156fc8e8ed2404ffdb22629b86ee8575f', '测试32', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216232', '202023032', 'gcp32', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849417742eb2f267c742ae836e8fdd68b48ca9', '测试33', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216233', '202023033', 'gcp33', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849423c13d228dedd84a48a342768c0b8227f5', '测试34', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216234', '202023034', 'gcp34', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849429929c7799b8f041a4a123238799da3bad', '测试35', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216235', '202023035', 'gcp35', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849436bf7c8565ca1a4d7ea37f8dac399cb66e', '测试36', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216236', '202023036', 'gcp36', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849441ae36ed00dceb442ca0ac51762568f2b7', '测试37', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216237', '202023037', 'gcp37', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849447587101bb4bd0406dbdc4a3377d0ec900', '测试38', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216238', '202023038', 'gcp38', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849453eb83d177603f413da88d5bf08bfc00fb', '测试39', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216239', '202023039', 'gcp39', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849458b76e07a260544b7181824d40e91c497d', '测试40', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216240', '202023040', 'gcp40', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518494638a10de5c97ba457a8c835d5d2137dc74', '测试41', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216241', '202023041', 'gcp41', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849468aed854c4542d4b228623bec333020af4', '测试42', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216242', '202023042', 'gcp42', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16451518494736ebbfe2b37a04cf49d4cc0e193ac1d89', '测试43', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216243', '202023043', 'gcp43', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('164515184947870a8602637ce41ec9a6c4bd689751d2a', '测试44', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216244', '202023044', 'gcp44', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849483815bcb250dca4f0a80fdea2a00884ee7', '测试45', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216245', '202023045', 'gcp45', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849488064a94086adb44bc9fa5e345d39d3fe1', '测试46', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216246', '202023046', 'gcp46', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849492a7dfc4fea44f4f3dbdaec9618737dc4c', '测试47', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216247', '202023047', 'gcp47', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849497daba6f441f8f4aae8d385176eaf583bb', '测试48', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216248', '202023048', 'gcp48', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1645151849503eae718ab84df47829d0e1927d9f51a15', '测试49', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '15216249', '202023049', 'gcp49', '2022-02-18 10:37:26', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('16460422002348d1876f0b86749c0ac4f5de154503ba6', 'g12', '16460363464182cc72629e1394bedad56480dce5d5acd', '21232F297A57A5A743894A0E4A801FC3', '123456464', '123156465412', 'dasda44156454', '2022-02-28 17:51:03', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('1646042393731d009bacb3edf487182236390b7030d26', 'g13', '1646036368847d63f771d21d14af09d01a0099fa9269e', '0DF01AE7DD51CEC48FED56952F40842B', '151651', '1561561', 'dasdasd', '2022-02-28 17:59:11', NULL, 1, NULL);
INSERT INTO `blog_account` VALUES ('164629748514786248644676f41a6ac6ad8108a170ddf', 'g1111', '16460363464182cc72629e1394bedad56480dce5d5acd', '89DEFAE676ABD3E3A42B41DF17C40096', '4532453', '453453', '543453', '2022-03-03 13:35:39', NULL, 1, NULL);

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '类目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES ('1646126454111812ac03dd9524f07b892c24fa247e3e9', 'Java', '2022-03-01 17:20:54', NULL, 1, 1);
INSERT INTO `blog_category` VALUES ('16461264646723922b084bfd24cb5b364a3b6315ba8fe', 'C++', '2022-03-01 17:21:05', '2022-03-01 17:39:11', 4, 1);
INSERT INTO `blog_category` VALUES ('164612749780438c1e25179c34171a38b5d6e5b7b8232', 'python', '2022-03-01 17:38:18', '2022-03-01 17:38:27', 3, 1);
INSERT INTO `blog_category` VALUES ('16461276435137aaa457eae7b4778bf492ed41d3c33fe', '测试', '2022-03-01 17:40:44', '2022-03-01 17:41:12', 2, 0);
INSERT INTO `blog_category` VALUES ('1646127731359d92e450a93a74732a67c7234bf811f79', '测试2', '2022-03-01 17:42:11', NULL, 6, 0);
INSERT INTO `blog_category` VALUES ('164621303722303882159373c4b328af9739f94e3f9c3', '日常', '2022-03-02 17:23:57', NULL, 5, 1);

-- ----------------------------
-- Table structure for blog_channel
-- ----------------------------
DROP TABLE IF EXISTS `blog_channel`;
CREATE TABLE `blog_channel`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '轮播图id',
  `blog_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '链接地址',
  `blog_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '轮播图图url',
  `blog_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客标题',
  `blog_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客描述',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '状态，0隐藏、1显示、9删除',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '频道表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_channel
-- ----------------------------
INSERT INTO `blog_channel` VALUES ('164636027844512d4f6c93488464d98e528e16595f8ec', 'www.baidu.com', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '代码', '代码没写完', 0, '2022-03-04 10:17:58', '2022-03-04 10:23:58', 1);

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `blog_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客id',
  `reply_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复用户id',
  `comment` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回复内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  `reply_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复评论id',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for blog_essay
-- ----------------------------
DROP TABLE IF EXISTS `blog_essay`;
CREATE TABLE `blog_essay`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主id',
  `pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片url',
  `category_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类目id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客标题',
  `synopsis` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博客摘要',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '博客内容',
  `publish_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `label` tinyint(0) NOT NULL COMMENT '文章标签（1、发布 2、草稿）',
  `comment_number` int(0) NULL DEFAULT NULL COMMENT '评论数',
  `good_number` int(0) NULL DEFAULT NULL COMMENT '点赞数',
  `collect_number` int(0) NULL DEFAULT NULL COMMENT '收藏数',
  `view_number` int(0) NULL DEFAULT NULL COMMENT '浏览数',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `blog_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客链接地址',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_essay
-- ----------------------------
INSERT INTO `blog_essay` VALUES ('1646212546298812b8c14d95b441cbc235c9c33cc79fc', '164515137796358831a4e29554c70ae29516c27f9f145', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '1646126454111812ac03dd9524f07b892c24fa247e3e9', '第一篇', 'code', '快乐code', '2022-03-04 09:44:59', 1, 0, 200, 50, 600, 1, '2022-03-02 17:15:46', '2022-03-04 09:44:59', NULL);
INSERT INTO `blog_essay` VALUES ('164621300855478c22f6d7a3d49e6bda38ba0edbbde84', '1644990311581db451e800cd4467da863636762c32b40', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '164621303722303882159373c4b328af9739f94e3f9c3', '第二篇', '上班', '上班上班上班', '2022-03-16 16:16:34', 1, 0, 200, 20, 500, 1, '2022-03-02 17:23:29', '2022-03-16 16:16:34', NULL);
INSERT INTO `blog_essay` VALUES ('1646214100949b02e547bd42a4d31a4775944d26041cf', '1644990311581db451e800cd4467da863636762c32b40', NULL, '1646126454111812ac03dd9524f07b892c24fa247e3e9', '飞飞飞', '坎坎坷坷', '大叔大叔的', '2022-03-02 17:41:41', 1, 0, 300, 21, 1000, 9, '2022-03-02 17:41:41', '2022-03-02 17:41:53', NULL);
INSERT INTO `blog_essay` VALUES ('1646286407173df53d799502f4454a76418aa72e4a37f', '164515137796358831a4e29554c70ae29516c27f9f145', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '1646126454111812ac03dd9524f07b892c24fa247e3e9', 'art', 'progrem', 'progremming is an art form', '2022-03-03 13:46:47', 1, 0, 100, 60, 2000, 1, '2022-03-03 13:46:47', NULL, NULL);

-- ----------------------------
-- Table structure for blog_history
-- ----------------------------
DROP TABLE IF EXISTS `blog_history`;
CREATE TABLE `blog_history`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '搜索历史id',
  `keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '搜索历史关键词',
  `blog_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '搜索历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_history
-- ----------------------------
INSERT INTO `blog_history` VALUES ('1647498654631b087b3c88c464e3896591c6dfb345889', 'uu', '1644990311581db451e800cd4467da863636762c32b40', '2022-03-17 14:30:55', 1);

-- ----------------------------
-- Table structure for blog_operate
-- ----------------------------
DROP TABLE IF EXISTS `blog_operate`;
CREATE TABLE `blog_operate`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作名称',
  `operate_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_operate
-- ----------------------------
INSERT INTO `blog_operate` VALUES ('164612190088101984565ee9747c3264156545', '收藏', '博客收藏', '2022-03-01 16:05:00', NULL, 1);
INSERT INTO `blog_operate` VALUES ('16461226068127f9d520cec38485a916a7ccc24c7965d', '收藏', '收藏博客', '2022-03-01 16:16:47', NULL, 1);
INSERT INTO `blog_operate` VALUES ('1646124324998e4f76eb74d544fa59644b0657d4530a4', '点赞', '给博客点赞', '2022-03-01 16:45:25', NULL, 1);

-- ----------------------------
-- Table structure for blog_operate_history
-- ----------------------------
DROP TABLE IF EXISTS `blog_operate_history`;
CREATE TABLE `blog_operate_history`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作历史id',
  `blog_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `operate_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '状态，0隐藏、1显示、9删除',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_operate_history
-- ----------------------------

-- ----------------------------
-- Table structure for blog_recommend
-- ----------------------------
DROP TABLE IF EXISTS `blog_recommend`;
CREATE TABLE `blog_recommend`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '热门博客推荐id',
  `blog_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客id',
  `blog_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客列表图url',
  `blog_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客标题',
  `blog_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主id',
  `blog_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主昵称',
  `blog_user_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主头像',
  `blog_time` datetime(0) NOT NULL COMMENT '博客发布时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `day` datetime(0) NOT NULL COMMENT '展示日期',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '热门博客表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_recommend
-- ----------------------------
INSERT INTO `blog_recommend` VALUES ('16473967541452b11ad58c99a402ca014c6ad96dbda05', '1646286407173df53d799502f4454a76418aa72e4a37f', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', 'art', '164515137796358831a4e29554c70ae29516c27f9f145', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '2022-03-03 13:46:47', '2022-03-16 10:12:34', '2022-03-18 14:38:14', 0, 1, '2022-03-17 00:00:00');
INSERT INTO `blog_recommend` VALUES ('16473972714616ef8223f7fcc461fb23dc42f8c5521b4', '1646286407173df53d799502f4454a76418aa72e4a37f', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', 'art', '164515137796358831a4e29554c70ae29516c27f9f145', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '2022-03-03 13:46:47', '2022-03-16 10:21:11', '2022-03-16 10:49:37', 9, 2, '2022-03-24 12:00:00');
INSERT INTO `blog_recommend` VALUES ('164739900059850bf9922407c4e1fa3ec07331a55c0b6', '1646286407173df53d799502f4454a76418aa72e4a37f', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', 'art', '164515137796358831a4e29554c70ae29516c27f9f145', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '2022-03-03 13:46:47', '2022-03-16 10:50:01', NULL, 1, 3, '2022-03-30 12:00:00');
INSERT INTO `blog_recommend` VALUES ('16474186483384225865a1af947d5a1d7d1e17a7dd2a8', '164621300855478c22f6d7a3d49e6bda38ba0edbbde84', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '第二篇', '1644990311581db451e800cd4467da863636762c32b40', 'gcp', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/213123.jpg', '2022-03-16 16:16:34', '2022-03-16 16:17:28', NULL, 1, 3, '2022-03-22 12:00:00');
INSERT INTO `blog_recommend` VALUES ('1647585562578a98b4e83f631425a835fcfa298a5129b', '1646212546298812b8c14d95b441cbc235c9c33cc79fc', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '第一篇', '164515137796358831a4e29554c70ae29516c27f9f145', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '2022-03-04 09:44:59', '2022-03-18 14:39:23', '2022-03-18 14:40:33', 1, 5, '2022-03-07 00:00:00');

-- ----------------------------
-- Table structure for blog_role
-- ----------------------------
DROP TABLE IF EXISTS `blog_role`;
CREATE TABLE `blog_role`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `role_dec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_role
-- ----------------------------
INSERT INTO `blog_role` VALUES ('16460363464182cc72629e1394bedad56480dce5d5acd', '最高权限管理者', '2022-02-28 16:19:06', NULL, 1, '管理员');
INSERT INTO `blog_role` VALUES ('1646036368847d63f771d21d14af09d01a0099fa9269e', '普通用户', '2022-02-28 16:19:29', NULL, 1, '普通用户');
INSERT INTO `blog_role` VALUES ('1646037723155074a3aaa35b948e3a3673cdc8e4f3aa7', '', '2022-02-28 16:42:03', '2022-02-28 16:43:41', 9, '');
INSERT INTO `blog_role` VALUES ('164603784790470d04240e3c245c4b240ef81cc6c47f3', '负责博客相关模块', '2022-02-28 16:44:08', '2022-02-28 18:01:23', 1, '博客管理员');
INSERT INTO `blog_role` VALUES ('16461197675823dd75f2233194189adcb468855b5c343', '权限最大', '2022-03-01 15:29:28', '2022-03-22 11:27:07', 1, '最高管理员');

-- ----------------------------
-- Table structure for blog_search
-- ----------------------------
DROP TABLE IF EXISTS `blog_search`;
CREATE TABLE `blog_search`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '热门搜索id',
  `keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '热搜关键词',
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '热搜关键词表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_search
-- ----------------------------
INSERT INTO `blog_search` VALUES ('164636297754363895e7d19994f4b89e04c1b34a552c2', 'Java', 0, '2022-03-04 11:02:58', NULL, 1);

-- ----------------------------
-- Table structure for blog_thing
-- ----------------------------
DROP TABLE IF EXISTS `blog_thing`;
CREATE TABLE `blog_thing`  (
  `_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `thing` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '事件描述',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '状态，0禁用1启用9删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_thing
-- ----------------------------
INSERT INTO `blog_thing` VALUES ('1', '1212', 9, '2022-03-28 17:37:00');
INSERT INTO `blog_thing` VALUES ('164846170131153e513cfbfff4e75a8cb1042bdd23449', '测试待办', 9, '2022-03-28 18:01:41');
INSERT INTO `blog_thing` VALUES ('164853750786119b02e27c636467da72bcc516ad60b94', '写毕设', 1, '2022-03-29 15:05:08');
INSERT INTO `blog_thing` VALUES ('1648539232490ab85adc25d184202a4268877629168a7', '博客系统', 9, '2022-03-29 15:33:52');
INSERT INTO `blog_thing` VALUES ('164853924068301de55350e1e45539c08df94f4a2b994', '博客系统123', 9, '2022-03-29 15:34:01');
INSERT INTO `blog_thing` VALUES ('2', '123', 9, '2022-03-22 17:37:11');
INSERT INTO `blog_thing` VALUES ('3', '456', 9, '2022-03-17 17:37:22');
INSERT INTO `blog_thing` VALUES ('4', '23', 9, '2022-03-16 17:37:33');
INSERT INTO `blog_thing` VALUES ('5', 'fasf', 9, '2022-03-01 17:37:47');
INSERT INTO `blog_thing` VALUES ('6', 'sssd', 9, '2022-02-24 17:37:58');
INSERT INTO `blog_thing` VALUES ('7', 'jhjhj', 9, '2022-02-16 17:38:11');

-- ----------------------------
-- Table structure for blog_url
-- ----------------------------
DROP TABLE IF EXISTS `blog_url`;
CREATE TABLE `blog_url`  (
  `_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口地址',
  `role_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(0) NOT NULL COMMENT '状态，0禁用1启用9删除',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_url
-- ----------------------------
INSERT INTO `blog_url` VALUES ('164784506664727a0a1b9c8b746b891d9656cdcfff2ef', 'http://127.0.0.1:8089/userRecommend/addUserRecommend', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 14:44:27', 1);
INSERT INTO `blog_url` VALUES ('1647845924587e61acc1696f24a9eb09b7e8f86e11b9c', 'http://127.0.0.1:8089//user/getUserPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 14:58:45', 1);
INSERT INTO `blog_url` VALUES ('1647846413214cd908e0a928842c6a341d2fa17291868', 'http://127.0.0.1:8089 /essay/addEssay', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:06:53', 1);
INSERT INTO `blog_url` VALUES ('16478464259792287073e09e447909d1c132b69473aca', 'http://127.0.0.1:8089/essay/deleteEssay', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:07:06', 1);
INSERT INTO `blog_url` VALUES ('1647846456219e5fbc9e6f0234693bde122dbcd76cff4', 'http://127.0.0.1:8089 /essay/getEssay', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:07:36', 1);
INSERT INTO `blog_url` VALUES ('1647846476853d9df47ae84ad48b9a325bdf0627533be', 'http://127.0.0.1:8089/essay/getEssayData', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:07:57', 1);
INSERT INTO `blog_url` VALUES ('1647846509298ad3e02b653264dd28053255ed6471a90', 'http://127.0.0.1:8089/essay/getEssayPage', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:08:29', 1);
INSERT INTO `blog_url` VALUES ('16478465214229d3f6a0ef2e0426ba5de9ecb33532d1c', 'http://127.0.0.1:8089/essay/updateEssay', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:08:41', 1);
INSERT INTO `blog_url` VALUES ('16478465332299bd9d091e48f44eea5a95d16fad562bd', 'http://127.0.0.1:8089/history/addHistory', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:08:53', 1);
INSERT INTO `blog_url` VALUES ('1647846543021e20d42d160064323bf0c02217349a29c', 'http://127.0.0.1:8089/history/deleteHistory', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:09:03', 1);
INSERT INTO `blog_url` VALUES ('1647846575290da1bffa8088049538163db07409c48e8', 'http://127.0.0.1:8089 /history/getHistory', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:09:35', 1);
INSERT INTO `blog_url` VALUES ('16478466091632ba60f1f7b864d42b350357993ae3c87', 'http://127.0.0.1:8089/history/getHistoryPage', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:10:09', 1);
INSERT INTO `blog_url` VALUES ('1647846628925b7d71bfeafe44036aa24cf2e7e8e6e68', 'http://127.0.0.1:8089 /history/updateHistory', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:10:29', 1);
INSERT INTO `blog_url` VALUES ('1647846648989648b05866fef46658b21025895602e06', 'http://127.0.0.1:8089/search/addSearch', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:10:49', 1);
INSERT INTO `blog_url` VALUES ('16478466713236b36cc2d3df8428783d18d3642d84ce7', 'http://127.0.0.1:8089/search/deleteSearch', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:11:11', 1);
INSERT INTO `blog_url` VALUES ('164784667965366ddcef3ab274132bfddaa87f88a1726', 'http://127.0.0.1:8089 /search/getSearch', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:11:20', 1);
INSERT INTO `blog_url` VALUES ('164784668711226de704cee1c4d2da57363bf02864a59', 'http://127.0.0.1:8089 /search/getSearchPage', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:11:27', 1);
INSERT INTO `blog_url` VALUES ('164784669479134da3a2b926d4e339ac2a40505c4c7ac', 'http://127.0.0.1:8089/search/updateSearch', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:11:35', 1);
INSERT INTO `blog_url` VALUES ('16478467120576d12ea1f4e02424a8b87e4b056b91417', 'http://127.0.0.1:8089/operate/addOperate', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:11:52', 1);
INSERT INTO `blog_url` VALUES ('16478467201983dd98435d2be40dcb2e5b7242ff87f98', 'http://127.0.0.1:8089/operate/deleteOperate', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:12:00', 1);
INSERT INTO `blog_url` VALUES ('1647846730552fde119c8eada4018a19a074beb0b7abb', 'http://127.0.0.1:8089/operate/getOperatePage', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:12:11', 1);
INSERT INTO `blog_url` VALUES ('16478467417919593de3b3d90462792e6f6a37212ffeb', 'http://127.0.0.1:8089/operate/updateOperate', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:12:22', 1);
INSERT INTO `blog_url` VALUES ('164784677040985e1a2a825644749a87df760d7c40477', 'http://127.0.0.1:8089/userRecommend/deleteUserRecommend', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:12:50', 1);
INSERT INTO `blog_url` VALUES ('16478467822919d51e275e8cf43aa897449fbe0171ee0', 'http://127.0.0.1:8089/userRecommend/getUserRecommend', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:13:02', 1);
INSERT INTO `blog_url` VALUES ('1647846953216b11b9b30188940a492cbae78b55f6f9b', 'http://127.0.0.1:8089/userRecommend/getUserRecommendPage', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:15:53', 1);
INSERT INTO `blog_url` VALUES ('164784703623189e24f8e1a3c434c81d2b06ac71e7917', 'http://127.0.0.1:8089/userRecommend/getUserRecommendPage', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:17:16', 1);
INSERT INTO `blog_url` VALUES ('164784704378607eb2f970e8642f6ae4e4613a949e8d9', 'http://127.0.0.1:8089/userRecommend/getUserRecommendPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:17:24', 1);
INSERT INTO `blog_url` VALUES ('1647847108562f93da47bcb634fc1a4a4c8a8735e3250', 'http://127.0.0.1:8089/userRecommend/updateUserRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:18:29', 1);
INSERT INTO `blog_url` VALUES ('16478471129532fe486d279f74b1d818c04f01d3545d5', 'http://127.0.0.1:8089/userRecommend/updateUserRecommend', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:18:33', 1);
INSERT INTO `blog_url` VALUES ('1647847125504f652a8f0aa5c4b95a7feb4f852a601aa', 'http://127.0.0.1:8089/category/addCategory', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:18:46', 1);
INSERT INTO `blog_url` VALUES ('164784713024117690040e01e4d7ab70019ed0869cc6f', 'http://127.0.0.1:8089/category/addCategory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:18:50', 1);
INSERT INTO `blog_url` VALUES ('1647847139020ccfc1c26aa3145698bac9fa322479879', 'http://127.0.0.1:8089/category/deleteCategory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:18:59', 1);
INSERT INTO `blog_url` VALUES ('16478471421744e4ac4a1cf634fccb022461f3853cdd2', 'http://127.0.0.1:8089/category/deleteCategory', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:19:02', 1);
INSERT INTO `blog_url` VALUES ('16478471535060020cff6aea44f8a9360235b630639a8', 'http://127.0.0.1:8089 /category/getCategoryData', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:19:14', 1);
INSERT INTO `blog_url` VALUES ('16478471633634c20abd421474733b359982ebf50359d', 'http://127.0.0.1:8089 /category/getCategoryData', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:19:23', 1);
INSERT INTO `blog_url` VALUES ('1647847167908f79e97eead454bc4924cb8076151d73b', 'http://127.0.0.1:8089 /category/getCategoryData', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:19:28', 1);
INSERT INTO `blog_url` VALUES ('1647847178083dae364fdc212457a9574e3c1b713a525', 'http://127.0.0.1:8089/category/getCategoryPage', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:19:38', 1);
INSERT INTO `blog_url` VALUES ('16478471813131720f0f007be48709d9f7a77ab9e7650', 'http://127.0.0.1:8089/category/getCategoryPage', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-03-21 15:19:41', 1);
INSERT INTO `blog_url` VALUES ('164784718483610c563bd155f4281abfc8d28eb4137d9', 'http://127.0.0.1:8089/category/getCategoryPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:19:45', 1);
INSERT INTO `blog_url` VALUES ('16478471996465f564549f74e412d88af96a22545864c', 'http://127.0.0.1:8089/category/updateCategory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:20:00', 1);
INSERT INTO `blog_url` VALUES ('164784720333456fb308b21a342ae917be17003eae989', 'http://127.0.0.1:8089/category/updateCategory', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:20:03', 1);
INSERT INTO `blog_url` VALUES ('164784722160306403b5ee9dc4f2fa3e40bfb6f3627f6', 'http://127.0.0.1:8089/url/addUrl', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:20:22', 1);
INSERT INTO `blog_url` VALUES ('164784722985896d98fb4985849b28604adf7b7e2b37c', 'http://127.0.0.1:8089/role/deleteRole', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:20:30', 1);
INSERT INTO `blog_url` VALUES ('16478472701797dc7f55e54a941cbadccc3e1b61773bc', 'http://127.0.0.1:8089/role/getRoleData', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:21:10', 1);
INSERT INTO `blog_url` VALUES ('16478472830010a386e0b45f24ef19c2b7c3f49187433', 'http://127.0.0.1:8089/url/getUrlPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:21:23', 1);
INSERT INTO `blog_url` VALUES ('16478472887528d896044487d4f309161ac05c671bf3b', 'http://127.0.0.1:8089/role/getRolePage', '16460363464182cc72629e1394bedad56480dce5d5acd', '2022-03-21 15:21:29', 1);
INSERT INTO `blog_url` VALUES ('1647847298601d4657c06e3084b08bb336645cc1f26d5', 'http://127.0.0.1:8089 /role/updateRole', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:21:39', 1);
INSERT INTO `blog_url` VALUES ('164791954189800f52e29fef04fcc98b2daa21ba9174b', 'http://127.0.0.1:8089/role/getRolePage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 11:25:42', 1);
INSERT INTO `blog_url` VALUES ('1647919557476445f369b05a04331a2961b2e6fc736f8', 'http://127.0.0.1:8089/role/addRole', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 11:25:57', 1);
INSERT INTO `blog_url` VALUES ('164791957372905f40d901e174a22bf97cd17b1c3cdd7', 'http://127.0.0.1:8089/role/updateRole', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 11:26:14', 1);
INSERT INTO `blog_url` VALUES ('1647932084778c43884f3ff4a431eb9b5aaa7ab131f7a', 'http://127.0.0.1:8089/account/getAccount', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 14:54:45', 1);
INSERT INTO `blog_url` VALUES ('16479358603329196d60168dd48348f04bf0216378681', 'http://127.0.0.1:8089/user/getUserRecommendByUserId', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 15:57:40', 1);
INSERT INTO `blog_url` VALUES ('164793647074957e5ce106a8742249c3f294c4fbcddd6', 'http://127.0.0.1:8089/user/getUserPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 16:07:51', 1);
INSERT INTO `blog_url` VALUES ('164801702330944765a42855246aa93d308bff6a9bc01', 'http://127.0.0.1:8089/essaygetEssayPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:30:23', 9);
INSERT INTO `blog_url` VALUES ('1648017071103c570fa9be3bb4a25a6ae880a8cbc19bf', 'http://127.0.0.1:8089/category/getCategoryData', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:31:11', 1);
INSERT INTO `blog_url` VALUES ('1648017087414a00ccf9376734b8e8916ae9e0c16af81', 'http://127.0.0.1:8089/account/getAccountData', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:31:27', 1);
INSERT INTO `blog_url` VALUES ('1648017190197ff97b3f224704021a90bc2c851a82efd', 'http://127.0.0.1:8089/essay/getEssayPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:33:10', 1);
INSERT INTO `blog_url` VALUES ('16480172233514fd553bcd9ab4e3fb5ef1cab7e64d56c', 'http://127.0.0.1:8089/url/updateUrl', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:33:43', 1);
INSERT INTO `blog_url` VALUES ('1648017236846e02a374d09964e84b4ceb559616db57d', 'http://127.0.0.1:8089/url/deleteUrl', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:33:57', 1);
INSERT INTO `blog_url` VALUES ('16481079849762c213f33d5eb4622b894448ec21241d8', ' http://127.0.0.1:8089/user/updateUser', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-24 15:46:25', 9);
INSERT INTO `blog_url` VALUES ('16481080604552b455c45c2b045b2bac7e70c0f3f0d50', 'http://127.0.0.1:8089/user/updateUser', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-24 15:47:40', 1);
INSERT INTO `blog_url` VALUES ('164817045667920f0790a813c4d72ba1bf1cd8212a8cc', 'http://127.0.0.1:8089/account/getAccountPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-25 09:07:37', 1);
INSERT INTO `blog_url` VALUES ('16481782787971ef1ab1d371d4876946b576faf8a539e', 'http://127.0.0.1:8089/role/getRoleDate', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-25 11:17:59', 1);
INSERT INTO `blog_url` VALUES ('1648184662683de8a2ec1b25743e485ab66f915acb48f', 'http://127.0.0.1:8089/account/updateAccount', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-25 13:04:23', 1);
INSERT INTO `blog_url` VALUES ('16482000717882b16cc2c4b5f4252ab314ad14a93bf91', 'http://127.0.0.1:8089/user/getUser', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-25 17:21:12', 1);
INSERT INTO `blog_url` VALUES ('164845004342628ea748120bc42aa88b7552b4404cdaf', 'http://127.0.0.1:8089/user/addUser', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-28 14:47:23', 1);
INSERT INTO `blog_url` VALUES ('1648461550151846e0a06d3b64a1bb38fddd9af7967e9', 'http://127.0.0.1:8089/thing/addThing', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-28 17:59:10', 1);
INSERT INTO `blog_url` VALUES ('1648519578728c78024ea0e61498f9ebb1830fabbd7b4', 'http://127.0.0.1:8089/thing/getThingList', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-29 10:06:19', 1);
INSERT INTO `blog_url` VALUES ('1648533378128f820f1f66de14532af5301c8bb2a51af', 'http://127.0.0.1:8089/thing/updateThing', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-29 13:56:18', 1);
INSERT INTO `blog_url` VALUES ('1648602985717d392a7ac573047a2b1d292353f289594', 'http://127.0.0.1:8089/essay/addEssay', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:16:26', 1);
INSERT INTO `blog_url` VALUES ('16486029945267e9b2ff18a3b4eaa8b63e7af8af09725', 'http://127.0.0.1:8089/essay/updateEssay', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:16:35', 1);
INSERT INTO `blog_url` VALUES ('16486030113483bdecf8567874e9b9ad7d6308a089c2d', 'http://127.0.0.1:8089/essay/deleteEssay', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:16:51', 1);
INSERT INTO `blog_url` VALUES ('16486030369742cb15d090a614f0ca6ecbd2be317b472', 'http://127.0.0.1:8089/essay/getEssay', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:17:17', 1);
INSERT INTO `blog_url` VALUES ('16486030828452a90f28be6574240b4a6a123cddf0b66', 'http://127.0.0.1:8089/channel/addChannel', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:18:03', 1);
INSERT INTO `blog_url` VALUES ('1648603096127665442a7810245dc8618d11bcd37c82f', 'http://127.0.0.1:8089/channel/updateChannel', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:18:16', 1);
INSERT INTO `blog_url` VALUES ('164860310908472cfdd43f4194c85baec043d9723da53', 'http://127.0.0.1:8089/channel/deleteChannel', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:18:29', 1);
INSERT INTO `blog_url` VALUES ('16486031227608b132d5f1106499c9e67b05103b3c23b', 'http://127.0.0.1:8089/channel/getChannelPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:18:43', 1);
INSERT INTO `blog_url` VALUES ('1648603134169f3e389b50ada4a2f89d60f07ea5d0dad', 'http://127.0.0.1:8089/channel/getChannel', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:18:54', 1);
INSERT INTO `blog_url` VALUES ('164860316149753c6330cdfc3477ba9444011e2c1f9bd', 'http://127.0.0.1:8089/history/addHistory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:19:21', 1);
INSERT INTO `blog_url` VALUES ('16486031716494126583b28b941dba2cdaa8abd3878be', 'http://127.0.0.1:8089/history/updateHistory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:19:32', 1);
INSERT INTO `blog_url` VALUES ('16486031828219d3c97ac51eb4afc8a40416a3e2c5d7d', 'http://127.0.0.1:8089/history/deleteHistory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:19:43', 1);
INSERT INTO `blog_url` VALUES ('1648603195656194d1fd155bb452e89f24eb917f1f2dd', 'http://127.0.0.1:8089/history/getHistoryPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:19:56', 1);
INSERT INTO `blog_url` VALUES ('164860320591569514353b1ab45b0b0c19c8568052234', 'http://127.0.0.1:8089/history/getHistory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:20:06', 1);
INSERT INTO `blog_url` VALUES ('1648603232350498f9c485f2e4d4f82b710a8e7500cf8', 'http://127.0.0.1:8089/recommend/addRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:20:32', 1);
INSERT INTO `blog_url` VALUES ('16486032423876a362d2cc20d4e3cb8fe08571e25098f', 'http://127.0.0.1:8089/recommend/updateRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:20:42', 1);
INSERT INTO `blog_url` VALUES ('16486032561925a74af0e03d24c57a457bbae386b0ca7', 'http://127.0.0.1:8089/recommend/deleteRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:20:56', 1);
INSERT INTO `blog_url` VALUES ('16486032678185fc894e908704e45af2fd58fa1fa5211', 'http://127.0.0.1:8089/recommend/getRecommendPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:21:08', 1);
INSERT INTO `blog_url` VALUES ('1648603279589a53ba7f39ec1468e8f7135c86963a9bc', 'http://127.0.0.1:8089/recommend/getRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:21:20', 1);
INSERT INTO `blog_url` VALUES ('1648603300508f4de41218f9e44599f1935a879c14b6b', 'http://127.0.0.1:8089/search/addSearch', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:21:41', 1);
INSERT INTO `blog_url` VALUES ('16486033103201456f683418f4bf1b0e057bb0dbf3c84', 'http://127.0.0.1:8089/search/updateSearch', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:21:50', 1);
INSERT INTO `blog_url` VALUES ('1648603319739e4f35a0cd83d46e5a1c74b1de7e546c7', 'http://127.0.0.1:8089/search/deleteSearch', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:22:00', 1);
INSERT INTO `blog_url` VALUES ('164860333202610e49d6fb31843a680dc00c323fa364e', 'http://127.0.0.1:8089/search/getSearchPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:22:12', 1);
INSERT INTO `blog_url` VALUES ('16486033425165a1df586117440a7b2182f770cea3d16', 'http://127.0.0.1:8089/search/getSearch', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:22:23', 1);
INSERT INTO `blog_url` VALUES ('16486033669147f687d279b30470fb2608ac0ff27bc37', 'http://127.0.0.1:8089/userRecommend/addUserRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:22:47', 1);
INSERT INTO `blog_url` VALUES ('1648603387396ba752d04676b46f5bb79d7869c624397', 'http://127.0.0.1:8089/userRecommend/deleteUserRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:23:07', 1);
INSERT INTO `blog_url` VALUES ('164860341331303a1c130cac04d768dee1d17a1d211c5', 'http://127.0.0.1:8089/userRecommend/getUserRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:23:33', 1);
INSERT INTO `blog_url` VALUES ('1648603436032277aca79758d4203a57acc02dcd46c0a', 'http://127.0.0.1:8089/account/addAccount', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:23:56', 1);
INSERT INTO `blog_url` VALUES ('16486034631641f9ab91b2c6f4c0a87d4146ed7f9e6f3', 'http://127.0.0.1:8089/account/deleteAccount', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:24:23', 1);
INSERT INTO `blog_url` VALUES ('1648603504467509bcf6773fe48bb8e719b406e4e814f', 'http://127.0.0.1:8089/operate/addOperate', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:25:04', 1);
INSERT INTO `blog_url` VALUES ('16486035133744ff0e553ab924266b2de5fe222472897', 'http://127.0.0.1:8089/operate/updateOperate', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:25:13', 1);
INSERT INTO `blog_url` VALUES ('16486035224395093c6b0318840138ce7fa39e4e5a0c8', 'http://127.0.0.1:8089/operate/deleteOperate', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:25:22', 1);
INSERT INTO `blog_url` VALUES ('16486035312494d4227746acb482b91e102eb29765dd9', 'http://127.0.0.1:8089/operate/getOperatePage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:25:31', 1);
INSERT INTO `blog_url` VALUES ('1648603621960b9be8a716ffb423f8a463c233d0c2e5d', 'http://127.0.0.1:8089/url/addUrlRoleToRedis', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:27:02', 1);
INSERT INTO `blog_url` VALUES ('1648603662320f74b451108c641b092cac8f79cc947c9', 'http://127.0.0.1:8089/user/deleteUser', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:27:42', 1);
INSERT INTO `blog_url` VALUES ('1648603735581ac7c44de63454910981dffebc8d19df4', 'http://127.0.0.1:8089/essay/getEssayRatio', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:28:56', 1);

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像url',
  `sex` tinyint(0) NOT NULL COMMENT '性别：1男2女3未知',
  `synopsis` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '用户简介',
  `area_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在地区',
  `province_code` int(0) NULL DEFAULT NULL COMMENT '省代码',
  `city_code` int(0) NULL DEFAULT NULL COMMENT '市代码',
  `area_code` int(0) NULL DEFAULT NULL COMMENT '区、县代码',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
  `categories` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '分类id集，用逗号分隔',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  `native_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES ('1644990311581db451e800cd4467da863636762c32b40', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', 1, '快乐coding123', '山西省/阳泉市/城区', 140000, 140300, 140302, '2022-03-01 00:00:00', '[\"164612749780438c1e25179c34171a38b5d6e5b7b8232\",\"1646126454111812ac03dd9524f07b892c24fa247e3e9\"]', '2022-03-18 15:27:32', '2022-03-28 15:39:35', 1, '汉族');
INSERT INTO `blog_user` VALUES ('164515137796358831a4e29554c70ae29516c27f9f145', '11', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/213123.jpg', 1, '11', '北京市/市辖区/西城区', 110000, 110100, 110102, '2022-03-07 00:00:00', '[\"16461264646723922b084bfd24cb5b364a3b6315ba8fe\"]', '2022-03-21 09:12:46', '2022-03-28 15:17:04', 0, '11');
INSERT INTO `blog_user` VALUES ('16451518491977bccb7474b104b5395fae28132617766', '测试测试测试0', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', 1, '测试多选下拉', '山西省/太原市/迎泽区', 140000, 140100, 140106, '2022-03-07 00:00:00', '[\"1646126454111812ac03dd9524f07b892c24fa247e3e9\"]', '2022-03-28 14:50:44', '2022-03-28 15:17:00', 1, '汉');
INSERT INTO `blog_user` VALUES ('1645151849220d7f2e0e1e3544abb9d7ab952aa32fc9c', '测试测试2', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', 1, 'Java，c++', '辽宁省/鞍山市/铁西区', 210000, 210300, 210303, '2022-03-12 00:00:00', '[\"16461264646723922b084bfd24cb5b364a3b6315ba8fe\",\"164621303722303882159373c4b328af9739f94e3f9c3\"]', '2022-03-28 14:58:43', '2022-03-28 15:16:50', 1, '汉');
INSERT INTO `blog_user` VALUES ('1645151849263c493d77c36c54f3e8335afcea0200ac4', '测试88', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', 1, '123456', '河北省/唐山市/古冶区', 130000, 130200, 130204, '2022-03-02 00:00:00', '[\"16461264646723922b084bfd24cb5b364a3b6315ba8fe\",\"164612749780438c1e25179c34171a38b5d6e5b7b8232\"]', '2022-03-28 15:02:14', NULL, 1, '汉');

-- ----------------------------
-- Table structure for blog_user_recommend
-- ----------------------------
DROP TABLE IF EXISTS `blog_user_recommend`;
CREATE TABLE `blog_user_recommend`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '热门博主推荐id',
  `blog_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主id',
  `blog_user_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主头像url',
  `blog_user_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博主描述',
  `page_views` int(0) NULL DEFAULT NULL COMMENT '博客总浏览量',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(0) NOT NULL COMMENT '状态，0隐藏、1显示、9删除',
  `blog_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主名称',
  `day` datetime(0) NOT NULL COMMENT '展示日期',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '热门博主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_user_recommend
-- ----------------------------
INSERT INTO `blog_user_recommend` VALUES ('16478293126835f976d0d96b14af4982aac8663326977', '164515137796358831a4e29554c70ae29516c27f9f145', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '11', 2600, '2022-03-21 10:21:53', '2022-03-21 10:23:25', 1, '郭长平', '2022-03-01 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('16478293698765a9e293e856844318c511b2cf7890853', '1644990311581db451e800cd4467da863636762c32b40', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', 'coding', 500, '2022-03-21 10:22:50', '2022-03-21 10:23:45', 9, 'gcp', '2022-03-03 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('164782943483508cafce99c214a7dbb2dd8e113bc7d5e', '1644990311581db451e800cd4467da863636762c32b40', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', 'coding', 500, '2022-03-21 10:23:55', NULL, 1, 'gcp', '2022-03-04 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
