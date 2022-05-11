/*
 Navicat Premium Data Transfer

 Source Server         : gcp
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 121.43.235.88:3306
 Source Schema         : gcp

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 11/05/2022 14:32:00
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
  `type` tinyint(0) NOT NULL COMMENT '用户类型，1前台用户2后台用户',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户账号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_account
-- ----------------------------
INSERT INTO `blog_account` VALUES ('1644990311581db451e800cd4467da863636762c32b40', 'gcp', '16461197675823dd75f2233194189adcb468855b5c343', 'E10ADC3949BA59ABBE56E057F20F883E', '15216240480', '2046039989', '2046039989gcp', '2022-02-16 13:43:34', '2022-05-11 14:15:03', 1, '2022-04-23 10:21:11', 2);
INSERT INTO `blog_account` VALUES ('164514931305503dff866281e433f9535075e746b9593', 'ddd11', '', 'E10ADC3949BA59ABBE56E057F20F883E', '12345', '1234', '2312312', '2022-02-18 09:02:59', '2022-02-18 09:02:59', 9, NULL, 2);
INSERT INTO `blog_account` VALUES ('164514931346499e17bfb487042979579d1025de33d48', 'ddd', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '12345', '1234', '2312312', '2022-02-18 09:02:59', '2022-02-28 17:51:03', 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('164514945555943ee2246302c4a5cb7157447dd0225e2', 'asasd', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1123123123', '12312312', '1312312', '2022-02-18 09:02:59', '2022-02-28 17:51:03', 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('1645149483735bef9fa0183d240e08ee1011149914a91', 'qqqq', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '123123', '123123', '123123', '2022-02-18 09:02:59', '2022-02-28 17:51:03', 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('164515137796358831a4e29554c70ae29516c27f9f145', '郭长平', '16461197675823dd75f2233194189adcb468855b5c343', 'E10ADC3949BA59ABBE56E057F20F883E', '15216240480', '2046039989', 'gcp2046039989', '2022-02-18 10:27:11', '2022-03-25 13:04:37', 1, '2022-03-30 15:47:06', 2);
INSERT INTO `blog_account` VALUES ('16451518491977bccb7474b104b5395fae28132617766', '测试0', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521620', '20202300', 'gcp0', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('16451518492122b117bde1da547f0ae80cfa1a1c8a81f', '测试1', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521621', '20202301', 'gcp1', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('1645151849220d7f2e0e1e3544abb9d7ab952aa32fc9c', '测试2', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521622', '20202302', 'gcp2', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('164515184922653621070fbac4ceca997a0171d6ac724', '测试3', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521623', '20202303', 'gcp3', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('164515184923202e0690dbf244425a900bc9e874730ae', '测试4', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521624', '20202304', 'gcp4', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('16451518492382cdbb318ad164e8f921e37207d80a7b2', '测试5', '12315646', 'E10ADC3949BA59ABBE56E057F20F883E', '1521625', '20202305', 'gcp5', '2022-02-18 10:37:26', NULL, 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('16451518492468a386461b51a4c33824d9d8d5543d4d0', '测试6', '16461197675823dd75f2233194189adcb468855b5c343', '123456', '1521626', '20202306', 'gcp6', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 9, NULL, 2);
INSERT INTO `blog_account` VALUES ('164515184925459a612b4d3864c77bd0acbd073e3b36a', '测试712', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '1521627', '20202307', 'gcp7', '2022-02-18 10:37:26', '2022-03-03 13:35:39', 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('1645151849263c493d77c36c54f3e8335afcea0200ac4', '测试8', '164603784790470d04240e3c245c4b240ef81cc6c47f3', 'E10ADC3949BA59ABBE56E057F20F883E', '1521628', '20202308', 'gcp8', '2022-02-18 10:37:26', '2022-03-01 15:08:25', 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('16460422002348d1876f0b86749c0ac4f5de154503ba6', 'g12', '16460363464182cc72629e1394bedad56480dce5d5acd', '21232F297A57A5A743894A0E4A801FC3', '123456464', '123156465412', 'dasda44156454', '2022-02-28 17:51:03', NULL, 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('1646042393731d009bacb3edf487182236390b7030d26', 'g13', '1646036368847d63f771d21d14af09d01a0099fa9269e', '0DF01AE7DD51CEC48FED56952F40842B', '151651', '1561561', 'dasdasd', '2022-02-28 17:59:11', NULL, 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('164629748514786248644676f41a6ac6ad8108a170ddf', 'g1111', '16460363464182cc72629e1394bedad56480dce5d5acd', '89DEFAE676ABD3E3A42B41DF17C40096', '4532453', '453453', '543453', '2022-03-03 13:35:39', NULL, 1, NULL, 2);
INSERT INTO `blog_account` VALUES ('1648794678683f8c9f1c414dd4c049faa7fa9b336930a', 'fff', '16460363464182cc72629e1394bedad56480dce5d5acd', 'E10ADC3949BA59ABBE56E057F20F883E', '1521616', '46541651651', '165165', '2022-04-01 14:31:19', NULL, 1, NULL, 1);
INSERT INTO `blog_account` VALUES ('1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'gcp123', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'CFEEAD64866422FB8D498EFD36F20589', '15216240480', '2046039989', '2046039989gcp', '2022-04-13 14:41:07', '2022-04-23 11:39:12', 1, '2022-04-23 10:06:40', 1);
INSERT INTO `blog_account` VALUES ('16503322063506805f102b97649639ac37b9cd6eb78c8', 'reception', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'CFEEAD64866422FB8D498EFD36F20589', '15216240480', '2046039989', '2046039989', '2022-04-19 09:36:46', '2022-04-19 09:36:54', 1, NULL, 1);
INSERT INTO `blog_account` VALUES ('1650606833987d9646dc759c04b9f8847636605f6ddaf', 'gcpcscs', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '15216240480', '2046039989', '15216240480', '2022-04-22 13:53:54', '2022-04-22 14:11:10', 1, '2022-04-22 14:11:01', 1);
INSERT INTO `blog_account` VALUES ('1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', 'gcptest', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'E10ADC3949BA59ABBE56E057F20F883E', '15216240480', '2046039989', '2046039989gcp', '2022-04-22 15:52:16', '2022-04-22 16:34:21', 1, '2022-04-22 16:01:40', 1);
INSERT INTO `blog_account` VALUES ('165062944916701ee31f15a1f42ccade57000c3b67fb7', 'test', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'DF10EF8509DC176D733D59549E7DBFAF', '15216240480', '2046039989', '15216240480gcp', '2022-04-22 20:10:49', '2022-04-22 20:10:59', 1, NULL, 1);
INSERT INTO `blog_account` VALUES ('1650631375448c693205cb44947a6bce6b9c431f89486', 'test123', '1646036368847d63f771d21d14af09d01a0099fa9269e', 'CC03E747A6AFBBCBF8BE7668ACFEBEE5', '15216264048', '2046039989', '2046039989gcp', '2022-04-22 20:42:55', '2022-04-22 20:43:08', 1, NULL, 1);

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
INSERT INTO `blog_category` VALUES ('16502708280909cc3021412a844ae9340804ec3d02117', 'MySQL', '2022-04-18 16:33:48', NULL, 7, 1);
INSERT INTO `blog_category` VALUES ('16506144067323996fae42bb44ac8ab4cfd2aed272673', 'spring', '2022-04-22 16:00:07', NULL, 8, 1);

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
INSERT INTO `blog_channel` VALUES ('164636027844512d4f6c93488464d98e528e16595f8ec', '164621300855478c22f6d7a3d49e6bda38ba0edbbde84', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '代码', '代码没写完', 0, '2022-03-04 10:17:58', '2022-03-04 10:23:58', 1);
INSERT INTO `blog_channel` VALUES ('165001076669316c47b330f0444ae82575ee64916a1ed', '1646212546298812b8c14d95b441cbc235c9c33cc79fc', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '轮播图2', '这里是轮播图2', 2, '2022-04-15 16:19:27', NULL, 1);
INSERT INTO `blog_channel` VALUES ('165001081274579aa6a7c1a3443a19e3b2dc562935344', '165000687598761ae7d2309444c11b806f2d86597bb52', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/blog-login.png', '轮播图3', '这里是轮播图3', 3, '2022-04-15 16:20:13', NULL, 1);
INSERT INTO `blog_channel` VALUES ('16506142357176225615afdaf4786bc7267d69c5c2992', '16505187985548d90337a9dba475dbcf914c05d080d17', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/博客首页.png', '毕业答辩', '准备毕业答辩', 1, '2022-04-22 15:57:16', '2022-04-22 20:38:13', 0);
INSERT INTO `blog_channel` VALUES ('165063042106460737a4287f64e6f923fd7e5f47058b0', '16505187985548d90337a9dba475dbcf914c05d080d17', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/ic.webp', '测试轮播图', '这是一张轮播图', 1, '2022-04-22 20:27:01', NULL, 1);

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
INSERT INTO `blog_comment` VALUES ('16492388498763823981013884005a578c6bcbb03c513', '164515137796358831a4e29554c70ae29516c27f9f145', '1646286407173df53d799502f4454a76418aa72e4a37f', NULL, '好文章', '2022-04-06 17:54:10', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('16492389029994d5d1e064e3840b3a59d2948e5e1e17c', '1644990311581db451e800cd4467da863636762c32b40', '1646286407173df53d799502f4454a76418aa72e4a37f', '164515137796358831a4e29554c70ae29516c27f9f145', '我也觉得是好文章', '2022-04-06 17:55:03', NULL, 1, '16492388498763823981013884005a578c6bcbb03c513');
INSERT INTO `blog_comment` VALUES ('16492988932240b79410c669247ad866740fa59c1cbcc', '164515137796358831a4e29554c70ae29516c27f9f145', '1646286407173df53d799502f4454a76418aa72e4a37f', '1644990311581db451e800cd4467da863636762c32b40', '击掌', '2022-04-07 10:34:53', NULL, 1, '16492389029994d5d1e064e3840b3a59d2948e5e1e17c');
INSERT INTO `blog_comment` VALUES ('164930170225347a79b4263a84cffb37e0001371da3b6', '1644990311581db451e800cd4467da863636762c32b40', '1646286407173df53d799502f4454a76418aa72e4a37f', '164515137796358831a4e29554c70ae29516c27f9f145', '击掌*2', '2022-04-07 11:21:42', NULL, 1, '16492988932240b79410c669247ad866740fa59c1cbcc');
INSERT INTO `blog_comment` VALUES ('1650596546554e1a9504ca17f4d828c046bcc9a318548', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', NULL, '学到了，大佬', '2022-04-22 11:02:27', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('165059668988876b679c83bb443b3b2b836626faf6255', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', NULL, '学到了，大佬', '2022-04-22 11:04:50', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('16506008542723e728903d5ae488fa93520a240dbeb7e', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', NULL, '互关', '2022-04-22 12:14:14', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('165060151463331b8d00329644513b1e4dd3302dd0e7f', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', NULL, '感谢博主 帮了我这菜鸟老鼻子忙了 也从代码中学到了新知识', '2022-04-22 12:25:15', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('16506016113518499e167d4964e7ebd89791889d0f1a7', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', NULL, '为什么做出来一刷新就没有了？', '2022-04-22 12:26:51', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('16506016318356933b8c3d3204ce6bb16384c5bc1db44', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', NULL, '为什么做出来一刷新就没有了？11111', '2022-04-22 12:27:12', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('16506016777551162e389e0ef433ea6859ad9c95036da', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', NULL, '111', '2022-04-22 12:27:58', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('16506082797348e2f0397ad88472aa59b626c163ffe01', '1650606833987d9646dc759c04b9f8847636605f6ddaf', '16506079732858cf822f53d0e4349a75936be3c0f9153', NULL, '讲解的很精辟，赞', '2022-04-22 14:18:00', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('1650614607769bb46c124928f407b92bd02389dbdb1e7', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '165061455526901230caef1854e23b839b47e26e7bb0d', NULL, '测试评论', '2022-04-22 16:03:28', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('16506146241259f9ae00a7e5c405aa312625d1beac8d6', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '165061455526901230caef1854e23b839b47e26e7bb0d', NULL, '测试测试测试', '2022-04-22 16:03:44', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('1650627786771b6c4047e82d4436abe084ab47e87e7b2', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1650627753402943cf27b0b7e43f2a5f4b9bb463e80df', NULL, '这图片', '2022-04-22 19:43:07', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('1650631420506d22e6c7b78254abcb4e0d545763e4f49', '1650631375448c693205cb44947a6bce6b9c431f89486', '16505187985548d90337a9dba475dbcf914c05d080d17', NULL, '好文章', '2022-04-22 20:43:41', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('1650631560846e4b630016e33426285ee3e9bd6f9882b', '1650631375448c693205cb44947a6bce6b9c431f89486', '165063154228567fbd4c77afb49b7b4ce5f8e4363b264', NULL, '好文章', '2022-04-22 20:46:01', NULL, 1, NULL);
INSERT INTO `blog_comment` VALUES ('1650678440926b12ab34253034ae7bab7f5989ee86999', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1646286407173df53d799502f4454a76418aa72e4a37f', NULL, '艺术人生', '2022-04-23 09:47:21', NULL, 1, NULL);

-- ----------------------------
-- Table structure for blog_essay
-- ----------------------------
DROP TABLE IF EXISTS `blog_essay`;
CREATE TABLE `blog_essay`  (
  `_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博主id',
  `pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片url',
  `category_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类目id',
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
INSERT INTO `blog_essay` VALUES ('1646212546298812b8c14d95b441cbc235c9c33cc79fc', '164515137796358831a4e29554c70ae29516c27f9f145', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '1646126454111812ac03dd9524f07b892c24fa247e3e9', '第一篇', 'code', '快乐code', '2022-03-04 09:44:59', 1, 0, 200, 50, 603, 1, '2022-03-02 17:15:46', '2022-03-04 09:44:59', NULL);
INSERT INTO `blog_essay` VALUES ('164621300855478c22f6d7a3d49e6bda38ba0edbbde84', '1644990311581db451e800cd4467da863636762c32b40', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '164621303722303882159373c4b328af9739f94e3f9c3', '第二篇', '上班', '上班上班上班', '2022-03-16 16:16:34', 1, 0, 200, 20, 503, 1, '2022-03-02 17:23:29', '2022-03-16 16:16:34', NULL);
INSERT INTO `blog_essay` VALUES ('1646214100949b02e547bd42a4d31a4775944d26041cf', '1644990311581db451e800cd4467da863636762c32b40', NULL, '1646126454111812ac03dd9524f07b892c24fa247e3e9', '飞飞飞', '坎坎坷坷', '大叔大叔的', '2022-03-02 17:41:41', 1, 0, 300, 21, 1000, 9, '2022-03-02 17:41:41', '2022-03-02 17:41:53', NULL);
INSERT INTO `blog_essay` VALUES ('1646286407173df53d799502f4454a76418aa72e4a37f', '164515137796358831a4e29554c70ae29516c27f9f145', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '16461264646723922b084bfd24cb5b364a3b6315ba8fe', 'art', 'progrem', 'progremming is an art form', '2022-04-18 16:15:12', 1, 1, 101, 60, 2002, 1, '2022-03-03 13:46:47', '2022-04-18 16:15:12', NULL);
INSERT INTO `blog_essay` VALUES ('165000687598761ae7d2309444c11b806f2d86597bb52', '1644990311581db451e800cd4467da863636762c32b40', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '164612749780438c1e25179c34171a38b5d6e5b7b8232', '第三篇', 'code', '第三篇博客', '2022-04-15 15:14:36', 1, 0, 0, 0, 1, 1, '2022-04-15 15:14:36', NULL, NULL);
INSERT INTO `blog_essay` VALUES ('16500071566515b6f0e2583ea4178b7ee71796f5705d5', '1644990311581db451e800cd4467da863636762c32b40', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '164621303722303882159373c4b328af9739f94e3f9c3', '第四篇', '日常生活', '第四篇博客', '2022-04-15 15:19:17', 1, 0, 0, 0, 0, 1, '2022-04-15 15:19:17', NULL, NULL);
INSERT INTO `blog_essay` VALUES ('16500071859566d30ca80aca844c8a1a7c002264a34f9', '1644990311581db451e800cd4467da863636762c32b40', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '164621303722303882159373c4b328af9739f94e3f9c3', '第五篇', '日常生活', '第五篇博客', '2022-04-15 15:19:46', 1, 0, 0, 0, 0, 1, '2022-04-15 15:19:46', NULL, NULL);
INSERT INTO `blog_essay` VALUES ('1650007210672be8e029237274223a2ae27176accdeac', '1644990311581db451e800cd4467da863636762c32b40', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '1646126454111812ac03dd9524f07b892c24fa247e3e9', '第六篇', 'java语言', '第六篇博客', '2022-04-15 15:20:11', 1, 0, 0, 0, 0, 1, '2022-04-15 15:20:11', NULL, NULL);
INSERT INTO `blog_essay` VALUES ('16505167177213ba3b467d65d4190b98625907a78f043', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '', '', 'wangEditor编辑器', '', '<p><b>wangEditor编辑器写的第一篇博客</b></p><p><img src=\"https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"30%\"/></p>', NULL, 2, 0, 0, 0, 1, 1, '2022-04-21 12:51:58', NULL, NULL);
INSERT INTO `blog_essay` VALUES ('16505183359290ad5e778c4834e39b54e681ce9cd263d', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', NULL, NULL, '测试草稿测试测试测试再次', NULL, '<p><b>测试草稿测试测试测试再次</b></p>', NULL, 2, 0, 0, 0, 0, 1, '2022-04-21 13:18:56', '2022-04-21 13:19:16', NULL);
INSERT INTO `blog_essay` VALUES ('165051846745408d39543332d4a4cbc16aa13bf82e749', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', NULL, NULL, '测试一下下', NULL, '<p><b>测试一下先休息休息休息</b></p>', NULL, 2, 0, 0, 0, 0, 1, '2022-04-21 13:21:07', NULL, NULL);
INSERT INTO `blog_essay` VALUES ('16505187985548d90337a9dba475dbcf914c05d080d17', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '1646126454111812ac03dd9524f07b892c24fa247e3e9', '接口权限控制', '这是一篇关于接口权限控制的文章', '<h3>1、简介</h3><p>之前写了一篇关于接口权限控制的文章，那篇文章主要是对用户进行管理，针对用户是否登录来判断是否可以调用接口，这种方式的局限性太大了，无法精确地进行接口控制，本文是在原来的方法上进一步的优化，做到了对每个接口进行权限管理，只有相应的角色才能调用该接口。</p>', '2022-04-21 13:27:19', 1, 2, 102, 100, 6, 1, '2022-04-21 13:26:39', '2022-04-21 13:27:19', NULL);
INSERT INTO `blog_essay` VALUES ('1650519139397a8c3450bf70a4b758550984ceaeac8b5', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '1646126454111812ac03dd9524f07b892c24fa247e3e9', 'GIT的相关命令', 'GIT相关命令', '<p>git clone -b 分支名 URL //clone分支<br/>git add * //保存到暂存区<br/>git commit -m “提交的描述” //提交并描述<br/>git push //上传<br/>git pull //拉取<br/>git merge origin/分支名 //合并分支<br/>git config --global user.name “用户名” //配置用户名<br/>git config --global user.email “用户邮箱” //配置邮箱<br/></p>', '2022-04-21 13:32:49', 1, 1, 0, 0, 6, 1, '2022-04-21 13:32:19', '2022-04-21 13:32:49', NULL);
INSERT INTO `blog_essay` VALUES ('16506079732858cf822f53d0e4349a75936be3c0f9153', '1650606833987d9646dc759c04b9f8847636605f6ddaf', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/blog-login.png', '16502708280909cc3021412a844ae9340804ec3d02117', '数据库中的三种时间类型', 'Date：显示年月日，范围是1000-01-01到9999-12-31', '<p>Date：显示年月日，范围是1000-01-01到9999-12-31<br/><br/>DateTime：显示年月日时分秒，范围是1000-01-01 00:00:01到9999-12-31 23:59:59<br/><br/>TimeStamp：显示年月日时分秒，范围是1970-01-01 00:00:00到2038-01-19 03:14:07<br/><br/>TimeStamp，它把客户端插入的时间从当前时区转化为UTC(世界标准时间)进行存储。底层表示是时间戳。什么是时间戳？<br/><br/>时间戳是指时间1970年01月01日00时00分00秒起至某一时间点的总秒数。<br/><br/>例如时间2018-12-08 00:00:00的时间戳是1544198400，就是指从时间1970-01-01 00:00:00到2018-12-08 00:00:00已经过去了1544198400秒，这样计算。<br/><br/>MySQL的timestamp类型是4个字节，最大值是2的31次方减1，也就是2147483647，转换成2038-01-19 03:14:07<br/></p>', '2022-04-22 14:13:31', 1, 1, 1, 0, 2, 1, '2022-04-22 14:12:53', '2022-04-22 14:13:31', NULL);
INSERT INTO `blog_essay` VALUES ('165061455526901230caef1854e23b839b47e26e7bb0d', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/博客中心.png', '16506144067323996fae42bb44ac8ab4cfd2aed272673', '毕业答辩做准备', '这篇博客是为了毕业答辩写的', '<h2 id=\"h9736\">1、毕业答辩</h2><p>答辩准备</p>', '2022-04-22 16:03:06', 1, 0, 1, 0, 4, 1, '2022-04-22 16:02:35', '2022-04-22 16:03:06', NULL);
INSERT INTO `blog_essay` VALUES ('16506173872097039e40679e34124868a53f3ce7587c1', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', NULL, NULL, '草稿', NULL, '<p>这是草稿</p>', NULL, 2, 0, 0, 0, 1, 9, '2022-04-22 16:49:47', '2022-04-22 17:22:31', NULL);
INSERT INTO `blog_essay` VALUES ('165061781055394cc0d1c241341358fe0d9f0027d4255', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', NULL, NULL, '测试跳转', NULL, '<div><p>111111213213123123</p></div>', NULL, 2, 0, 0, 0, 1, 9, '2022-04-22 16:56:51', '2022-04-22 17:22:57', NULL);
INSERT INTO `blog_essay` VALUES ('1650627304918e9b8cc22f72a4e8aa79cbb2490bffc96', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', NULL, NULL, '博客园系统设计与实现', NULL, '<div><div></div><p>网络时代的变迁，博客也得到了迅速的发展。博客，从用户层面来说，可以让用户发表和分享一些自己的观点或收获，也可以让用户从他人发表的博客中获取自己需要的内容等；从博客系统的功能来说，有发表博客、浏览博客、搜索博客等功能。博客具有很强的自由性质，可以让用户发表自己任何想发表的东西，不受约束。在生活中，人们经常会遇到许多不懂的问题，也可以通过博客搜索栏查找问题的各种解决方法。</p><p>鉴于此，本论文设计并且开发了一个博客园系统，该系统采用SSM的框架，前后端分离，后端使用Java开发语言编写，数据使用MySql和Redis进行存储，与数据库进行交互使用的是持久层框架MyBatis-plus，前端使用VUE3构建和开发。该系统分为前台和后台，前台是给普通用户使用的，后台是管理员才能使用的，前台具有的功能是：登录注册、搜索博客、浏览博客、博客评论、编辑个人信息、编辑并发布博客等等；后台主要是对前台进行管理，后台具有的功能是：管理用户信息、管理账号、管理博客类目、管理博客、角色权限控制、前台首页轮播图设置、前台首页各榜单内容设置等等。</p><p><img src=\"https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"435.59\" height=\"272.24\"/></p></div>', NULL, 2, 0, 0, 0, 0, 9, '2022-04-22 19:35:05', '2022-04-22 19:41:19', NULL);
INSERT INTO `blog_essay` VALUES ('1650627456400339144bfcbae44e685a3df2c17891901', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/ic.webp', '16506144067323996fae42bb44ac8ab4cfd2aed272673', '博客园系统设计与实现', '网络时代的变迁，博客也得到了迅速的发展。博客，从用户层面来说，可以让用户发表和分享一些自己的观点或收获，也可以让用户从他人发表的博客中获取自己需要的内容等；', '<div><div><div></div><p>网络时代的变迁，博客也得到了迅速的发展。博客，从用户层面来说，可以让用户发表和分享一些自己的观点或收获，也可以让用户从他人发表的博客中获取自己需要的内容等；从博客系统的功能来说，有发表博客、浏览博客、搜索博客等功能。博客具有很强的自由性质，可以让用户发表自己任何想发表的东西，不受约束。在生活中，人们经常会遇到许多不懂的问题，也可以通过博客搜索栏查找问题的各种解决方法。</p><p>鉴于此，本论文设计并且开发了一个博客园系统，该系统采用SSM的框架，前后端分离，后端使用Java开发语言编写，数据使用MySql和Redis进行存储，与数据库进行交互使用的是持久层框架MyBatis-plus，前端使用VUE3构建和开发。该系统分为前台和后台，前台是给普通用户使用的，后台是管理员才能使用的，前台具有的功能是：登录注册、搜索博客、浏览博客、博客评论、编辑个人信息、编辑并发布博客等等；后台主要是对前台进行管理，后台具有的功能是：管理用户信息、管理账号、管理博客类目、管理博客、角色权限控制、前台首页轮播图设置、前台首页各榜单内容设置等等。</p><p><img src=\"https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"435.59\" height=\"272.24\"/></p></div></div>', '2022-04-22 19:37:36', 1, 0, 0, 0, 0, 9, '2022-04-22 19:37:36', '2022-04-22 19:40:58', NULL);
INSERT INTO `blog_essay` VALUES ('1650627653070b4c6c41108054591bb82dc648245e4fa', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/sun.webp', '1646126454111812ac03dd9524f07b892c24fa247e3e9', '博客园系统设计与实现', '大撒大撒', '<div><div><div><div></div><p>网络时代的变迁，博客也得到了迅速的发展。博客，从用户层面来说，可以让用户发表和分享一些自己的观点或收获，也可以让用户从他人发表的博客中获取自己需要的内容等；从博客系统的功能来说，有发表博客、浏览博客、搜索博客等功能。博客具有很强的自由性质，可以让用户发表自己任何想发表的东西，不受约束。在生活中，人们经常会遇到许多不懂的问题，也可以通过博客搜索栏查找问题的各种解决方法。</p><p>鉴于此，本论文设计并且开发了一个博客园系统，该系统采用SSM的框架，前后端分离，后端使用Java开发语言编写，数据使用MySql和Redis进行存储，与数据库进行交互使用的是持久层框架MyBatis-plus，前端使用VUE3构建和开发。该系统分为前台和后台，前台是给普通用户使用的，后台是管理员才能使用的，前台具有的功能是：登录注册、搜索博客、浏览博客、博客评论、编辑个人信息、编辑并发布博客等等；后台主要是对前台进行管理，后台具有的功能是：管理用户信息、管理账号、管理博客类目、管理博客、角色权限控制、前台首页轮播图设置、前台首页各榜单内容设置等等。</p><p><img src=\"https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"435.59\" height=\"272.24\"/></p></div></div></div>', '2022-04-22 19:40:53', 1, 0, 0, 0, 0, 9, '2022-04-22 19:40:53', '2022-04-22 19:41:35', NULL);
INSERT INTO `blog_essay` VALUES ('1650627753402943cf27b0b7e43f2a5f4b9bb463e80df', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/ic.webp', '16461264646723922b084bfd24cb5b364a3b6315ba8fe', '测试一下下', '嗡嗡嗡嗡嗡嗡', '<div><p><b>测试一下先休息休息休息</b></p></div><p><img src=\"https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png\" alt=\"12\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"339.59\" height=\"212.24\"/></p>', '2022-04-22 19:42:33', 1, 1, 1, 0, 2, 1, '2022-04-22 19:42:33', NULL, NULL);
INSERT INTO `blog_essay` VALUES ('16506315097638b14bd87799342a18a11890410fc4b0e', '1650631375448c693205cb44947a6bce6b9c431f89486', NULL, NULL, '博客园系统设计与实现', NULL, '<div></div><p>网络时代的变迁，博客也得到了迅速的发展。博客，从用户层面来说，可以让用户发表和分享一些自己的观点或收获，也可以让用户从他人发表的博客中获取自己需要的内容等；从博客系统的功能来说，有发表博客、浏览博客、搜索博客等功能。博客具有很强的自由性质，可以让用户发表自己任何想发表的东西，不受约束。在生活中，人们经常会遇到许多不懂的问题，也可以通过博客搜索栏查找问题的各种解决方法。</p><p>鉴于此，本论文设计并且开发了一个博客园系统，该系统采用SSM的框架，前后端分离，后端使用Java开发语言编写，数据使用MySql和Redis进行存储，与数据库进行交互使用的是持久层框架MyBatis-plus，前端使用VUE3构建和开发。该系统分为前台和后台，前台是给普通用户使用的，后台是管理员才能使用的，前台具有的功能是：登录注册、搜索博客、浏览博客、博客评论、编辑个人信息、编辑并发布博客等等；后台主要是对前台进行管理，后台具有的功能是：管理用户信息、管理账号、管理博客类目、管理博客、角色权限控制、前台首页轮播图设置、前台首页各榜单内容设置等等。</p>', NULL, 2, 0, 0, 0, 0, 1, '2022-04-22 20:45:10', NULL, NULL);
INSERT INTO `blog_essay` VALUES ('165063154228567fbd4c77afb49b7b4ce5f8e4363b264', '1650631375448c693205cb44947a6bce6b9c431f89486', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/sun.webp', '1646126454111812ac03dd9524f07b892c24fa247e3e9', '博客园系统设计与实现', '网络时代的变迁，博客也得到了迅速的发展。博客，从用户层面来说，可以让用户发表和分享一些自己的观点或收获，也可以让用户从他人发表的博客中获取自己需要的内容等；从博客系统的功能来说，有发表博客、浏览博客、搜索博客等功能。博客具有很强的自由性质，可以让用户发表自己任何想发表的东西，不受约束。在生活中，人们经常会遇到许多不懂的问题，也可以通过博客搜索栏查找问题的各种解决方法。', '<div><div></div><p>网络时代的变迁，博客也得到了迅速的发展。博客，从用户层面来说，可以让用户发表和分享一些自己的观点或收获，也可以让用户从他人发表的博客中获取自己需要的内容等；从博客系统的功能来说，有发表博客、浏览博客、搜索博客等功能。博客具有很强的自由性质，可以让用户发表自己任何想发表的东西，不受约束。在生活中，人们经常会遇到许多不懂的问题，也可以通过博客搜索栏查找问题的各种解决方法。</p><p>鉴于此，本论文设计并且开发了一个博客园系统，该系统采用SSM的框架，前后端分离，后端使用Java开发语言编写，数据使用MySql和Redis进行存储，与数据库进行交互使用的是持久层框架MyBatis-plus，前端使用VUE3构建和开发。该系统分为前台和后台，前台是给普通用户使用的，后台是管理员才能使用的，前台具有的功能是：登录注册、搜索博客、浏览博客、博客评论、编辑个人信息、编辑并发布博客等等；后台主要是对前台进行管理，后台具有的功能是：管理用户信息、管理账号、管理博客类目、管理博客、角色权限控制、前台首页轮播图设置、前台首页各榜单内容设置等等。</p></div>', '2022-04-22 20:45:42', 1, 1, 0, 0, 1, 1, '2022-04-22 20:45:42', NULL, NULL);
INSERT INTO `blog_essay` VALUES ('16506779808357f6289e865b44ad2a8ff0d696219f643', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/ic.webp', '164621303722303882159373c4b328af9739f94e3f9c3', 'art life', 'The concept of life imitating art is all about reality not being what it seems, just something that artists have tempted us with. Who knows, but it\'s just possibl...', '<div></div><p>The concept of&nbsp;<em>life</em>&nbsp;imitating&nbsp;<em>art</em>&nbsp;is all about reality not being what it seems, just something that artists have tempted us with. Who knows, but it\'s just possibl...<br/></p>', '2022-04-23 09:39:41', 1, 0, 0, 0, 1, 1, '2022-04-23 09:39:41', NULL, NULL);

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
INSERT INTO `blog_history` VALUES ('16502730345503f878784d5b547b8a524a7a7b29942ab', '测试', '1644990311581db451e800cd4467da863636762c32b40', '2022-04-18 17:10:35', 1);
INSERT INTO `blog_history` VALUES ('165033062694526651b9dd40d41ee8a48964151fe91ae', '测试搜索历史', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '2022-04-19 09:10:27', 1);
INSERT INTO `blog_history` VALUES ('1650330632254d0468f843cf841438ce779782680e525', '测试搜索历史1', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '2022-04-19 09:10:32', 1);
INSERT INTO `blog_history` VALUES ('165033063668291aa753634164a1ab5afeac187821ebd', '测试搜索历史3', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '2022-04-19 09:10:37', 1);
INSERT INTO `blog_history` VALUES ('165033064062561fcc4354b004f879f6a2c4d5197bca9', '测试搜索历史2', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '2022-04-19 09:10:41', 1);
INSERT INTO `blog_history` VALUES ('165033064460712e6a850232e42e989b3d7a75f2ba3d8', '测试搜索历史1', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '2022-04-19 09:10:45', 1);
INSERT INTO `blog_history` VALUES ('16503306573302af65f9451e04c579a5b717b1ddf91ba', '测试搜索历史dasd', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '2022-04-19 09:10:57', 9);
INSERT INTO `blog_history` VALUES ('1650611741796137910dbee394d34b0f12df732b65b0c', '第', '1650606833987d9646dc759c04b9f8847636605f6ddaf', '2022-04-22 15:15:42', 1);
INSERT INTO `blog_history` VALUES ('165061178459217b438d77ae9449e926f7fe65fbe4b9d', 'java', '1650606833987d9646dc759c04b9f8847636605f6ddaf', '2022-04-22 15:16:25', 1);
INSERT INTO `blog_history` VALUES ('16506146422964dff2ead4ea740d3a6fdce49eb384b02', '答辩', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '2022-04-22 16:04:02', 1);
INSERT INTO `blog_history` VALUES ('165061466149018cb94963a11487c8ad99b42822f7331', '接口', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '2022-04-22 16:04:21', 1);
INSERT INTO `blog_history` VALUES ('1650627816374b0754b6e2ef64118ad7f8b7885d71c28', '测试', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '2022-04-22 19:43:36', 1);
INSERT INTO `blog_history` VALUES ('165063157938120b68214bdd94a19950135aa466ecc8d', '博客', '1650631375448c693205cb44947a6bce6b9c431f89486', '2022-04-22 20:46:19', 1);
INSERT INTO `blog_history` VALUES ('1650678470694a9a19714e8a440e3b5b1cc869e00f943', 'Java', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '2022-04-23 09:47:51', 1);

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
  `operate_no` tinyint(0) NOT NULL DEFAULT 0 COMMENT '操作编号',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_operate
-- ----------------------------
INSERT INTO `blog_operate` VALUES ('164612190088101984565ee9747c3264156545', '收藏', '博客收藏', '2022-03-01 16:05:00', '2022-04-11 09:42:59', 9, 2);
INSERT INTO `blog_operate` VALUES ('16461226068127f9d520cec38485a916a7ccc24c7965d', '收藏', '收藏博客', '2022-03-01 16:16:47', NULL, 1, 2);
INSERT INTO `blog_operate` VALUES ('1646124324998e4f76eb74d544fa59644b0657d4530a4', '点赞', '点赞博客', '2022-03-01 16:45:25', '2022-04-11 09:43:28', 1, 1);
INSERT INTO `blog_operate` VALUES ('1649641395207ba279040edc7452c9ada083eac91df08', '浏览', '浏览博客', '2022-04-11 09:43:15', NULL, 1, 0);
INSERT INTO `blog_operate` VALUES ('1649646784590ca69db204ef4473a964480ad53e88cde', '评论', '评论博客', '2022-04-11 11:13:05', NULL, 1, 3);
INSERT INTO `blog_operate` VALUES ('1650614126141b8bd21399aba49bea6ab879370b9ec89', '搜索', '搜索博客', '2022-04-22 15:55:26', '2022-04-22 15:55:44', 9, 4);

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
  `operate_no` tinyint(0) NOT NULL DEFAULT 0 COMMENT '操作编号',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_operate_history
-- ----------------------------
INSERT INTO `blog_operate_history` VALUES ('1650532328432f8e88ceb9c7e4d54ae91608d4c13c133', '16505187985548d90337a9dba475dbcf914c05d080d17', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1646124324998e4f76eb74d544fa59644b0657d4530a4', '2022-04-21 17:12:08', 9, 1, '2022-04-21 17:31:48');
INSERT INTO `blog_operate_history` VALUES ('1650532569167c7e2ec6a31304504a602039ea2362af4', '16505187985548d90337a9dba475dbcf914c05d080d17', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-21 17:16:09', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650532685849638e8e4bf8d24a4fb439492be555e34e', '16505187985548d90337a9dba475dbcf914c05d080d17', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-21 17:18:06', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650596098500424dc8d7c31642829b5db8e270e2f814', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 10:54:59', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650596528592cbabe9ed959e4c549629e83c6e8879a0', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 11:02:09', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650596546588b44828ab5d304ab0b2fe2242cef732c4', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649646784590ca69db204ef4473a964480ad53e88cde', '2022-04-22 11:02:27', 9, 3, '2022-04-22 11:04:50');
INSERT INTO `blog_operate_history` VALUES ('165060011538295aea78a4a364cb1b499f7b5bd4061dc', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 12:01:55', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650600854308394c9d1cf3434dd98394db4aabcfecdb', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649646784590ca69db204ef4473a964480ad53e88cde', '2022-04-22 12:14:14', 9, 3, '2022-04-22 12:25:15');
INSERT INTO `blog_operate_history` VALUES ('165060161138634a86e1048754c19a6bf15b70be7be5e', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649646784590ca69db204ef4473a964480ad53e88cde', '2022-04-22 12:26:51', 9, 3, '2022-04-22 12:27:12');
INSERT INTO `blog_operate_history` VALUES ('1650601677776fdc32445d8534728813b09fc8a797b38', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649646784590ca69db204ef4473a964480ad53e88cde', '2022-04-22 12:27:58', 1, 3, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650602197506245148502bfa460bb8cc0a2eab721126', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 12:36:38', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165060326600641d78b1af98f43f8a7c83142e6c218b9', '1646286407173df53d799502f4454a76418aa72e4a37f', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 12:54:26', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('16506033704951664c418de974b189d325c797ebf8db7', '1646286407173df53d799502f4454a76418aa72e4a37f', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1646124324998e4f76eb74d544fa59644b0657d4530a4', '2022-04-22 12:56:10', 1, 1, NULL);
INSERT INTO `blog_operate_history` VALUES ('165060404232938a7a01dd6604bfeb6f5b0bad940ef84', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 13:07:22', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650608040629c945592a7e06407385eece354e87031e', '16506079732858cf822f53d0e4349a75936be3c0f9153', '1650606833987d9646dc759c04b9f8847636605f6ddaf', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 14:14:01', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165060804417205aa8d417cfb494598d55708f16a9c2b', '16506079732858cf822f53d0e4349a75936be3c0f9153', '1650606833987d9646dc759c04b9f8847636605f6ddaf', '1646124324998e4f76eb74d544fa59644b0657d4530a4', '2022-04-22 14:14:04', 1, 1, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650608279774331e03b0cb91487f9cdea8c0d008a11e', '16506079732858cf822f53d0e4349a75936be3c0f9153', '1650606833987d9646dc759c04b9f8847636605f6ddaf', '1649646784590ca69db204ef4473a964480ad53e88cde', '2022-04-22 14:18:00', 1, 3, NULL);
INSERT INTO `blog_operate_history` VALUES ('16506105674447d0ff9e55ca24e8e8d80c5fe991de447', '165000687598761ae7d2309444c11b806f2d86597bb52', '1650606833987d9646dc759c04b9f8847636605f6ddaf', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 14:56:07', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165061254499347c8f84d6ddf4dd39dff5efcb8b9b55c', '164621300855478c22f6d7a3d49e6bda38ba0edbbde84', '1650606833987d9646dc759c04b9f8847636605f6ddaf', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 15:29:05', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('16506125736093b696e9ab4f841ca92cad6d601b0004f', '16506079732858cf822f53d0e4349a75936be3c0f9153', '1650606833987d9646dc759c04b9f8847636605f6ddaf', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 15:29:34', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('16506143332820588c1624f2c4b0eba7a85f71b163a7f', '16505187985548d90337a9dba475dbcf914c05d080d17', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 15:58:53', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('16506145964818be23ea87729411fa4af775348df416a', '165061455526901230caef1854e23b839b47e26e7bb0d', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 16:03:16', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165061459995943a71f929b824234900281799f943a0b', '165061455526901230caef1854e23b839b47e26e7bb0d', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '1646124324998e4f76eb74d544fa59644b0657d4530a4', '2022-04-22 16:03:20', 1, 1, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650614607790f3e302887af5439781ef64ad191be41e', '165061455526901230caef1854e23b839b47e26e7bb0d', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '1649646784590ca69db204ef4473a964480ad53e88cde', '2022-04-22 16:03:28', 9, 3, '2022-04-22 16:03:44');
INSERT INTO `blog_operate_history` VALUES ('16506177131021ed721c15f0b41e0a4e86cd78db9feb2', '165061455526901230caef1854e23b839b47e26e7bb0d', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 16:55:13', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165061911753593d6cafd1f984258bc293fe1a4a7996b', '16506173872097039e40679e34124868a53f3ce7587c1', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 17:18:38', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165061912067428401d4ff9d84edb9fa6bf141ee0524c', '165061781055394cc0d1c241341358fe0d9f0027d4255', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 17:18:41', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650626619227461bdfac00e04c1a8024693622a93fa1', '1646212546298812b8c14d95b441cbc235c9c33cc79fc', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 19:23:39', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650627771135517ab17224fd4271bad7cebb3d7d8ceb', '1650627753402943cf27b0b7e43f2a5f4b9bb463e80df', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 19:42:51', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('16506277868146d3957fd403849808768429a087dbaf4', '1650627753402943cf27b0b7e43f2a5f4b9bb463e80df', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649646784590ca69db204ef4473a964480ad53e88cde', '2022-04-22 19:43:07', 1, 3, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650627790618f60b0f7988d44f549404e1cf22746c60', '1650627753402943cf27b0b7e43f2a5f4b9bb463e80df', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1646124324998e4f76eb74d544fa59644b0657d4530a4', '2022-04-22 19:43:11', 1, 1, NULL);
INSERT INTO `blog_operate_history` VALUES ('16506278545117910df6b76b04b30a8bea38a54b5e864', '164621300855478c22f6d7a3d49e6bda38ba0edbbde84', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 19:44:15', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650630539782722a07b6b1484c37b07b50b1e5d8c02f', '16505187985548d90337a9dba475dbcf914c05d080d17', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 20:29:00', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165063056808165692232df39423884e3f0777c586984', '1650519139397a8c3450bf70a4b758550984ceaeac8b5', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 20:29:28', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('16506307058223ce4c1c401a84f12bf1137cd54e28928', '1650627753402943cf27b0b7e43f2a5f4b9bb463e80df', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 20:31:46', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650631201539fe78b4e49bf74781a2fc9eee46c4f753', '1646212546298812b8c14d95b441cbc235c9c33cc79fc', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 20:40:02', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('16506314011345f048304b32543beabad5858ca0f2ca3', '16505187985548d90337a9dba475dbcf914c05d080d17', '1650631375448c693205cb44947a6bce6b9c431f89486', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 20:43:21', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650631406536028d84e39b3e4812a2f759ebe6286c39', '16505187985548d90337a9dba475dbcf914c05d080d17', '1650631375448c693205cb44947a6bce6b9c431f89486', '1646124324998e4f76eb74d544fa59644b0657d4530a4', '2022-04-22 20:43:27', 1, 1, NULL);
INSERT INTO `blog_operate_history` VALUES ('165063142056639e0e122936f4a38b59e47c680d020c3', '16505187985548d90337a9dba475dbcf914c05d080d17', '1650631375448c693205cb44947a6bce6b9c431f89486', '1649646784590ca69db204ef4473a964480ad53e88cde', '2022-04-22 20:43:41', 1, 3, NULL);
INSERT INTO `blog_operate_history` VALUES ('16506315501599a0f7a0991f440aeb547041bdc4da840', '165063154228567fbd4c77afb49b7b4ce5f8e4363b264', '1650631375448c693205cb44947a6bce6b9c431f89486', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 20:45:50', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650631560905c3b6816c11ed4bf2a8789eff0c2370f3', '165063154228567fbd4c77afb49b7b4ce5f8e4363b264', '1650631375448c693205cb44947a6bce6b9c431f89486', '1649646784590ca69db204ef4473a964480ad53e88cde', '2022-04-22 20:46:01', 1, 3, NULL);
INSERT INTO `blog_operate_history` VALUES ('165063156694321b172f0287a491c9ce18655a7fe6026', '165063154228567fbd4c77afb49b7b4ce5f8e4363b264', '1650631375448c693205cb44947a6bce6b9c431f89486', '1646124324998e4f76eb74d544fa59644b0657d4530a4', '2022-04-22 20:46:07', 9, 1, '2022-04-22 21:08:51');
INSERT INTO `blog_operate_history` VALUES ('165063158336841317da1915c4ca583052c4958fd463b', '165061455526901230caef1854e23b839b47e26e7bb0d', '1650631375448c693205cb44947a6bce6b9c431f89486', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-22 20:46:23', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650677882490c30f4a84b48a40ce9eb3736e961ecebe', '165061455526901230caef1854e23b839b47e26e7bb0d', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-23 09:38:02', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165067799501862b8b11abce940f1ba9df24e143f4e0e', '1646286407173df53d799502f4454a76418aa72e4a37f', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-23 09:39:55', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165067844099052b9d301cd884a8fa788aad5130f7029', '1646286407173df53d799502f4454a76418aa72e4a37f', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649646784590ca69db204ef4473a964480ad53e88cde', '2022-04-23 09:47:21', 1, 3, NULL);
INSERT INTO `blog_operate_history` VALUES ('165067844786030783e8a7ec14e12b898d676cb514ea2', '16506779808357f6289e865b44ad2a8ff0d696219f643', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-23 09:47:28', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('1650679514260e0dabc57ddc4495e9205027ae2a925ed', '16505167177213ba3b467d65d4190b98625907a78f043', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-23 10:05:14', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165067958020648257f949e444badb8228206da2b2071', '1646212546298812b8c14d95b441cbc235c9c33cc79fc', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-23 10:06:20', 1, 0, NULL);
INSERT INTO `blog_operate_history` VALUES ('165068435939434648bb124f847ebb944fc41f89aeb5b', '164621300855478c22f6d7a3d49e6bda38ba0edbbde84', 'null', '1649641395207ba279040edc7452c9ada083eac91df08', '2022-04-23 11:25:59', 1, 0, NULL);

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
INSERT INTO `blog_recommend` VALUES ('16473967541452b11ad58c99a402ca014c6ad96dbda05', '1646286407173df53d799502f4454a76418aa72e4a37f', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', 'art', '164515137796358831a4e29554c70ae29516c27f9f145', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '2022-03-03 13:46:47', '2022-03-16 10:12:34', '2022-04-23 11:27:00', 1, 1, '2022-04-23 00:00:00');
INSERT INTO `blog_recommend` VALUES ('16473972714616ef8223f7fcc461fb23dc42f8c5521b4', '1646286407173df53d799502f4454a76418aa72e4a37f', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', 'art', '164515137796358831a4e29554c70ae29516c27f9f145', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '2022-03-03 13:46:47', '2022-03-16 10:21:11', '2022-03-16 10:49:37', 9, 2, '2022-03-24 12:00:00');
INSERT INTO `blog_recommend` VALUES ('164739900059850bf9922407c4e1fa3ec07331a55c0b6', '1646286407173df53d799502f4454a76418aa72e4a37f', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', 'art', '164515137796358831a4e29554c70ae29516c27f9f145', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '2022-03-03 13:46:47', '2022-03-16 10:50:01', '2022-04-18 12:19:14', 9, 3, '2022-03-30 00:00:00');
INSERT INTO `blog_recommend` VALUES ('16474186483384225865a1af947d5a1d7d1e17a7dd2a8', '164621300855478c22f6d7a3d49e6bda38ba0edbbde84', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '第二篇', '1644990311581db451e800cd4467da863636762c32b40', 'gcp', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/213123.jpg', '2022-03-16 16:16:34', '2022-03-16 16:17:28', '2022-04-23 11:27:05', 1, 4, '2022-04-23 00:00:00');
INSERT INTO `blog_recommend` VALUES ('1647585562578a98b4e83f631425a835fcfa298a5129b', '1646212546298812b8c14d95b441cbc235c9c33cc79fc', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '第一篇', '164515137796358831a4e29554c70ae29516c27f9f145', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '2022-03-04 09:44:59', '2022-03-18 14:39:23', '2022-04-18 12:19:28', 1, 1, '2022-04-18 00:00:00');
INSERT INTO `blog_recommend` VALUES ('1650255513682782b5c7e13fa4d15a153eb0495749959', '165000687598761ae7d2309444c11b806f2d86597bb52', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '第三篇', '1644990311581db451e800cd4467da863636762c32b40', 'gcp', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '2022-04-15 15:14:36', '2022-04-18 12:18:34', NULL, 1, 3, '2022-04-18 00:00:00');
INSERT INTO `blog_recommend` VALUES ('1650255599189f3d91f0225d94d38aea916ba44e89acc', '164621300855478c22f6d7a3d49e6bda38ba0edbbde84', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '第二篇', '1644990311581db451e800cd4467da863636762c32b40', 'gcp', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '2022-03-16 16:16:34', '2022-04-18 12:19:59', '2022-04-18 12:20:20', 9, 5, '2022-04-18 00:00:00');
INSERT INTO `blog_recommend` VALUES ('16502556307886038b08b1dbd4d6aa43f7dab19cb08a0', '16500071859566d30ca80aca844c8a1a7c002264a34f9', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '第五篇', '1644990311581db451e800cd4467da863636762c32b40', 'gcp', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '2022-04-15 15:19:46', '2022-04-18 12:20:31', NULL, 1, 6, '2022-04-18 00:00:00');
INSERT INTO `blog_recommend` VALUES ('165025564001144bed2af27894df3b81ebd3be1cbce83', '1650007210672be8e029237274223a2ae27176accdeac', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '第六篇', '1644990311581db451e800cd4467da863636762c32b40', 'gcp', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '2022-04-15 15:20:11', '2022-04-18 12:20:40', NULL, 1, 7, '2022-04-18 00:00:00');
INSERT INTO `blog_recommend` VALUES ('1650255661296f0e4ad1e678e4d0a815c0372933d991f', '16500071566515b6f0e2583ea4178b7ee71796f5705d5', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '第四篇', '1644990311581db451e800cd4467da863636762c32b40', 'gcp', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '2022-04-15 15:19:17', '2022-04-18 12:21:01', NULL, 1, 9, '2022-04-18 00:00:00');
INSERT INTO `blog_recommend` VALUES ('1650255674845b38d334e830f4b3cb6d45c4d115d738f', '16500071566515b6f0e2583ea4178b7ee71796f5705d5', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '第四篇', '1644990311581db451e800cd4467da863636762c32b40', 'gcp', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '2022-04-15 15:19:17', '2022-04-18 12:21:15', NULL, 1, 1, '2022-04-19 00:00:00');
INSERT INTO `blog_recommend` VALUES ('165061185056421a3b48caf4946fca2b84a5fe42c3a0f', '164621300855478c22f6d7a3d49e6bda38ba0edbbde84', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '第二篇', '1644990311581db451e800cd4467da863636762c32b40', 'gcp', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '2022-03-16 16:16:34', '2022-04-22 15:17:31', NULL, 1, 0, '2022-04-22 00:00:00');
INSERT INTO `blog_recommend` VALUES ('165061185955559016c70255f4311a8b9d5027a29fbe2', '164621300855478c22f6d7a3d49e6bda38ba0edbbde84', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '第二篇', '1644990311581db451e800cd4467da863636762c32b40', 'gcp', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/art form.jpg', '2022-03-16 16:16:34', '2022-04-22 15:17:40', NULL, 1, 1, '2022-04-22 00:00:00');
INSERT INTO `blog_recommend` VALUES ('16506143264144565c145b0d742e7bda20b9dd7e8ae4a', '16505187985548d90337a9dba475dbcf914c05d080d17', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '接口权限控制', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'gcp123', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '2022-04-21 13:27:19', '2022-04-22 15:58:46', '2022-04-23 11:27:20', 1, 1, '2022-04-23 00:00:00');
INSERT INTO `blog_recommend` VALUES ('1650630476546f3b49e39a98f4505bd5014052f779486', '165061455526901230caef1854e23b839b47e26e7bb0d', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/博客中心.png', '毕业答辩做准备', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', 'gcptest', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '2022-04-22 16:03:06', '2022-04-22 20:27:57', '2022-04-22 20:38:58', 0, 1, '2022-04-22 00:00:00');

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
INSERT INTO `blog_role` VALUES ('16506140856276708535cf65b4c08bcb28beed4b53fa6', '测试权限控制', '2022-04-22 15:54:46', '2022-04-22 15:54:59', 9, '测试权限');

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
INSERT INTO `blog_search` VALUES ('1650273049008a7054655bd3a45a99858c9b093559a11', 'spring', 1, '2022-04-18 17:10:49', NULL, 1);
INSERT INTO `blog_search` VALUES ('1650273055922dee52b6c3cc54fcba790fb54c24f8971', 'spring boot', 2, '2022-04-18 17:10:56', NULL, 1);
INSERT INTO `blog_search` VALUES ('16502730639152a81bd4e1a7f40e9b64f802550cd0e60', 'spring cloud', 3, '2022-04-18 17:11:04', NULL, 1);
INSERT INTO `blog_search` VALUES ('165027308654298c0846b2a29422ba3de8ccd61c2342c', 'spring全家桶', 4, '2022-04-18 17:11:27', NULL, 1);
INSERT INTO `blog_search` VALUES ('165027309619098e745fc09ec4abe99fb2aed365a0f26', 'MySQL', 5, '2022-04-18 17:11:36', NULL, 1);
INSERT INTO `blog_search` VALUES ('16502731113418998740085ec4e52bf78dee5a40e8d29', 'MyBatis', 6, '2022-04-18 17:11:51', NULL, 1);
INSERT INTO `blog_search` VALUES ('1650273120264dfb5ae804d7642d1a5e47f582ccd61a9', 'MyBatis plus', 7, '2022-04-18 17:12:00', NULL, 1);
INSERT INTO `blog_search` VALUES ('1650273130581e99677ee6c484040b443dd636072e453', 'redis', 8, '2022-04-18 17:12:11', NULL, 1);
INSERT INTO `blog_search` VALUES ('16502731371421455c2ac6d2e4daba2e0e3bddeb43299', 'vue', 9, '2022-04-18 17:12:17', NULL, 1);
INSERT INTO `blog_search` VALUES ('165027314542554d2bce5a01c4333a9f96f0e4389e6c3', 'vue3', 10, '2022-04-18 17:12:25', NULL, 1);
INSERT INTO `blog_search` VALUES ('16506142807082ecb47ad63494dbfb03f9bc0a23a1e50', '答辩', 1, '2022-04-22 15:58:01', NULL, 1);

-- ----------------------------
-- Table structure for blog_thing
-- ----------------------------
DROP TABLE IF EXISTS `blog_thing`;
CREATE TABLE `blog_thing`  (
  `_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `thing` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '事件描述',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '状态，0禁用1启用9删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_thing
-- ----------------------------
INSERT INTO `blog_thing` VALUES ('1', '1212', 9, '2022-03-28 17:37:00', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('164846170131153e513cfbfff4e75a8cb1042bdd23449', '测试待办', 9, '2022-03-28 18:01:41', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('164853750786119b02e27c636467da72bcc516ad60b94', '写毕设', 1, '2022-03-29 15:05:08', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('1648539232490ab85adc25d184202a4268877629168a7', '博客系统', 9, '2022-03-29 15:33:52', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('164853924068301de55350e1e45539c08df94f4a2b994', '博客系统123', 9, '2022-03-29 15:34:01', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('1650613883887237211ae20bc47c68dc61ceadb8295ca', '毕设项目演示', 9, '2022-04-22 15:51:24', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('1650629975115e657e2c2d43d4b00bf3c912ae09201c8', '毕业答辩', 9, '2022-04-22 20:19:35', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('165063026273705b8b6624b1d43e7bcce7266d44679f3', '毕业答辩2.0', 9, '2022-04-22 20:24:23', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('16506308360412cf654b2ca94439f810f7a16c4922760', '毕设答辩', 9, '2022-04-22 20:33:56', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('2', '123', 9, '2022-03-22 17:37:11', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('3', '456', 9, '2022-03-17 17:37:22', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('4', '23', 9, '2022-03-16 17:37:33', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('5', 'fasf', 9, '2022-03-01 17:37:47', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('6', 'sssd', 9, '2022-02-24 17:37:58', '1644990311581db451e800cd4467da863636762c32b40');
INSERT INTO `blog_thing` VALUES ('7', 'jhjhj', 9, '2022-02-16 17:38:11', '1644990311581db451e800cd4467da863636762c32b40');

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
INSERT INTO `blog_url` VALUES ('1647845924587e61acc1696f24a9eb09b7e8f86e11b9c', '/web-admin/user/getUserPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 14:58:45', 1);
INSERT INTO `blog_url` VALUES ('164784704378607eb2f970e8642f6ae4e4613a949e8d9', '/web-admin/userRecommend/getUserRecommendPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:17:24', 1);
INSERT INTO `blog_url` VALUES ('1647847108562f93da47bcb634fc1a4a4c8a8735e3250', '/web-admin/userRecommend/updateUserRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:18:29', 1);
INSERT INTO `blog_url` VALUES ('164784713024117690040e01e4d7ab70019ed0869cc6f', '/web-admin/category/addCategory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:18:50', 1);
INSERT INTO `blog_url` VALUES ('1647847139020ccfc1c26aa3145698bac9fa322479879', '/web-admin/category/deleteCategory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:18:59', 1);
INSERT INTO `blog_url` VALUES ('1647847167908f79e97eead454bc4924cb8076151d73b', '/web-admin/category/getCategoryData', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:19:28', 1);
INSERT INTO `blog_url` VALUES ('164784718483610c563bd155f4281abfc8d28eb4137d9', '/web-admin/category/getCategoryPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:19:45', 1);
INSERT INTO `blog_url` VALUES ('16478471996465f564549f74e412d88af96a22545864c', '/web-admin/category/updateCategory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:20:00', 1);
INSERT INTO `blog_url` VALUES ('164784722160306403b5ee9dc4f2fa3e40bfb6f3627f6', '/web-admin/url/addUrl', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:20:22', 1);
INSERT INTO `blog_url` VALUES ('164784722985896d98fb4985849b28604adf7b7e2b37c', '/web-admin/role/deleteRole', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:20:30', 1);
INSERT INTO `blog_url` VALUES ('16478472701797dc7f55e54a941cbadccc3e1b61773bc', '/web-admin/role/getRoleData', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:21:10', 1);
INSERT INTO `blog_url` VALUES ('16478472830010a386e0b45f24ef19c2b7c3f49187433', '/web-admin/url/getUrlPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:21:23', 1);
INSERT INTO `blog_url` VALUES ('1647847298601d4657c06e3084b08bb336645cc1f26d5', '/web-admin/role/updateRole', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-21 15:21:39', 1);
INSERT INTO `blog_url` VALUES ('164791954189800f52e29fef04fcc98b2daa21ba9174b', '/web-admin/role/getRolePage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 11:25:42', 1);
INSERT INTO `blog_url` VALUES ('1647919557476445f369b05a04331a2961b2e6fc736f8', '/web-admin/role/addRole', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 11:25:57', 1);
INSERT INTO `blog_url` VALUES ('164791957372905f40d901e174a22bf97cd17b1c3cdd7', '/web-admin/role/updateRole', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 11:26:14', 1);
INSERT INTO `blog_url` VALUES ('1647932084778c43884f3ff4a431eb9b5aaa7ab131f7a', '/web-admin/account/getAccount', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 14:54:45', 1);
INSERT INTO `blog_url` VALUES ('16479358603329196d60168dd48348f04bf0216378681', '/web-admin/user/getUserRecommendByUserId', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 15:57:40', 1);
INSERT INTO `blog_url` VALUES ('164793647074957e5ce106a8742249c3f294c4fbcddd6', '/web-admin/user/getUserPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-22 16:07:51', 1);
INSERT INTO `blog_url` VALUES ('164801702330944765a42855246aa93d308bff6a9bc01', '/web-admin/essaygetEssayPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:30:23', 9);
INSERT INTO `blog_url` VALUES ('1648017071103c570fa9be3bb4a25a6ae880a8cbc19bf', '/web-admin/category/getCategoryData', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:31:11', 1);
INSERT INTO `blog_url` VALUES ('1648017087414a00ccf9376734b8e8916ae9e0c16af81', '/web-admin/account/getAccountData', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:31:27', 1);
INSERT INTO `blog_url` VALUES ('1648017190197ff97b3f224704021a90bc2c851a82efd', '/web-admin/essay/getEssayPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:33:10', 1);
INSERT INTO `blog_url` VALUES ('16480172233514fd553bcd9ab4e3fb5ef1cab7e64d56c', '/web-admin/url/updateUrl', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:33:43', 1);
INSERT INTO `blog_url` VALUES ('1648017236846e02a374d09964e84b4ceb559616db57d', '/web-admin/url/deleteUrl', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-23 14:33:57', 1);
INSERT INTO `blog_url` VALUES ('16481079849762c213f33d5eb4622b894448ec21241d8', '/web-admin/user/updateUser', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-24 15:46:25', 9);
INSERT INTO `blog_url` VALUES ('16481080604552b455c45c2b045b2bac7e70c0f3f0d50', '/web-admin/user/updateUser', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-24 15:47:40', 1);
INSERT INTO `blog_url` VALUES ('164817045667920f0790a813c4d72ba1bf1cd8212a8cc', '/web-admin/account/getAccountPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-25 09:07:37', 1);
INSERT INTO `blog_url` VALUES ('16481782787971ef1ab1d371d4876946b576faf8a539e', '/web-admin/role/getRoleDate', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-25 11:17:59', 1);
INSERT INTO `blog_url` VALUES ('1648184662683de8a2ec1b25743e485ab66f915acb48f', '/web-admin/account/updateAccount', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-25 13:04:23', 1);
INSERT INTO `blog_url` VALUES ('16482000717882b16cc2c4b5f4252ab314ad14a93bf91', '/web-admin/user/getUser', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-25 17:21:12', 1);
INSERT INTO `blog_url` VALUES ('164845004342628ea748120bc42aa88b7552b4404cdaf', '/web-admin/user/addUser', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-28 14:47:23', 1);
INSERT INTO `blog_url` VALUES ('1648461550151846e0a06d3b64a1bb38fddd9af7967e9', '/web-admin/thing/addThing', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-28 17:59:10', 1);
INSERT INTO `blog_url` VALUES ('1648519578728c78024ea0e61498f9ebb1830fabbd7b4', '/web-admin/thing/getThingList', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-29 10:06:19', 1);
INSERT INTO `blog_url` VALUES ('1648533378128f820f1f66de14532af5301c8bb2a51af', '/web-admin/thing/updateThing', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-29 13:56:18', 1);
INSERT INTO `blog_url` VALUES ('1648602985717d392a7ac573047a2b1d292353f289594', '/web-admin/essay/addEssay', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:16:26', 1);
INSERT INTO `blog_url` VALUES ('16486029945267e9b2ff18a3b4eaa8b63e7af8af09725', '/web-admin/essay/updateEssay', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:16:35', 1);
INSERT INTO `blog_url` VALUES ('16486030113483bdecf8567874e9b9ad7d6308a089c2d', '/web-admin/essay/deleteEssay', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:16:51', 1);
INSERT INTO `blog_url` VALUES ('16486030369742cb15d090a614f0ca6ecbd2be317b472', '/web-admin/essay/getEssay', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:17:17', 1);
INSERT INTO `blog_url` VALUES ('16486030828452a90f28be6574240b4a6a123cddf0b66', '/web-admin/channel/addChannel', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:18:03', 1);
INSERT INTO `blog_url` VALUES ('1648603096127665442a7810245dc8618d11bcd37c82f', '/web-admin/channel/updateChannel', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:18:16', 1);
INSERT INTO `blog_url` VALUES ('164860310908472cfdd43f4194c85baec043d9723da53', '/web-admin/channel/deleteChannel', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:18:29', 1);
INSERT INTO `blog_url` VALUES ('16486031227608b132d5f1106499c9e67b05103b3c23b', '/web-admin/channel/getChannelPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:18:43', 1);
INSERT INTO `blog_url` VALUES ('1648603134169f3e389b50ada4a2f89d60f07ea5d0dad', '/web-admin/channel/getChannel', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:18:54', 1);
INSERT INTO `blog_url` VALUES ('164860316149753c6330cdfc3477ba9444011e2c1f9bd', '/web-admin/history/addHistory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:19:21', 1);
INSERT INTO `blog_url` VALUES ('16486031716494126583b28b941dba2cdaa8abd3878be', '/web-admin/history/updateHistory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:19:32', 1);
INSERT INTO `blog_url` VALUES ('16486031828219d3c97ac51eb4afc8a40416a3e2c5d7d', '/web-admin/history/deleteHistory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:19:43', 1);
INSERT INTO `blog_url` VALUES ('1648603195656194d1fd155bb452e89f24eb917f1f2dd', '/web-admin/history/getHistoryPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:19:56', 1);
INSERT INTO `blog_url` VALUES ('164860320591569514353b1ab45b0b0c19c8568052234', '/web-admin/history/getHistory', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:20:06', 1);
INSERT INTO `blog_url` VALUES ('1648603232350498f9c485f2e4d4f82b710a8e7500cf8', '/web-admin/recommend/addRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:20:32', 1);
INSERT INTO `blog_url` VALUES ('16486032423876a362d2cc20d4e3cb8fe08571e25098f', '/web-admin/recommend/updateRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:20:42', 1);
INSERT INTO `blog_url` VALUES ('16486032561925a74af0e03d24c57a457bbae386b0ca7', '/web-admin/recommend/deleteRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:20:56', 1);
INSERT INTO `blog_url` VALUES ('16486032678185fc894e908704e45af2fd58fa1fa5211', '/web-admin/recommend/getRecommendPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:21:08', 1);
INSERT INTO `blog_url` VALUES ('1648603279589a53ba7f39ec1468e8f7135c86963a9bc', '/web-admin/recommend/getRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:21:20', 1);
INSERT INTO `blog_url` VALUES ('1648603300508f4de41218f9e44599f1935a879c14b6b', '/web-admin/search/addSearch', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:21:41', 1);
INSERT INTO `blog_url` VALUES ('16486033103201456f683418f4bf1b0e057bb0dbf3c84', '/web-admin/search/updateSearch', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:21:50', 1);
INSERT INTO `blog_url` VALUES ('1648603319739e4f35a0cd83d46e5a1c74b1de7e546c7', '/web-admin/search/deleteSearch', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:22:00', 1);
INSERT INTO `blog_url` VALUES ('164860333202610e49d6fb31843a680dc00c323fa364e', '/web-admin/search/getSearchPage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:22:12', 1);
INSERT INTO `blog_url` VALUES ('16486033425165a1df586117440a7b2182f770cea3d16', '/web-admin/search/getSearch', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:22:23', 1);
INSERT INTO `blog_url` VALUES ('16486033669147f687d279b30470fb2608ac0ff27bc37', '/web-admin/userRecommend/addUserRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:22:47', 1);
INSERT INTO `blog_url` VALUES ('1648603387396ba752d04676b46f5bb79d7869c624397', '/web-admin/userRecommend/deleteUserRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:23:07', 1);
INSERT INTO `blog_url` VALUES ('164860341331303a1c130cac04d768dee1d17a1d211c5', '/web-admin/userRecommend/getUserRecommend', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:23:33', 1);
INSERT INTO `blog_url` VALUES ('1648603436032277aca79758d4203a57acc02dcd46c0a', '/web-admin/account/addAccount', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:23:56', 1);
INSERT INTO `blog_url` VALUES ('16486034631641f9ab91b2c6f4c0a87d4146ed7f9e6f3', '/web-admin/account/deleteAccount', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:24:23', 1);
INSERT INTO `blog_url` VALUES ('1648603504467509bcf6773fe48bb8e719b406e4e814f', '/web-admin/operate/addOperate', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:25:04', 1);
INSERT INTO `blog_url` VALUES ('16486035133744ff0e553ab924266b2de5fe222472897', '/web-admin/operate/updateOperate', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:25:13', 1);
INSERT INTO `blog_url` VALUES ('16486035224395093c6b0318840138ce7fa39e4e5a0c8', '/web-admin/operate/deleteOperate', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:25:22', 1);
INSERT INTO `blog_url` VALUES ('16486035312494d4227746acb482b91e102eb29765dd9', '/web-admin/operate/getOperatePage', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:25:31', 1);
INSERT INTO `blog_url` VALUES ('1648603621960b9be8a716ffb423f8a463c233d0c2e5d', '/web-admin/url/addUrlRoleToRedis', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:27:02', 1);
INSERT INTO `blog_url` VALUES ('1648603662320f74b451108c641b092cac8f79cc947c9', '/web-admin/user/deleteUser', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:27:42', 1);
INSERT INTO `blog_url` VALUES ('1648603735581ac7c44de63454910981dffebc8d19df4', '/web-admin/essay/getEssayRatio', '16461197675823dd75f2233194189adcb468855b5c343', '2022-03-30 09:28:56', 1);
INSERT INTO `blog_url` VALUES ('16499854116038420682404f847dc92d99ef5dd7af1b3', '/web-admin/user/getUserRecommendByUserId', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-15 09:16:52', 1);
INSERT INTO `blog_url` VALUES ('1649985799079465eaa14f65d447c9a19ce7ef5d1a490', '/web-admin/account/getAccount', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-15 09:23:19', 1);
INSERT INTO `blog_url` VALUES ('16502554615988f6619eb5db641149c8078c32003b9b4', '/web-admin/essay/getEssayData', '16461197675823dd75f2233194189adcb468855b5c343', '2022-04-18 12:17:42', 1);
INSERT INTO `blog_url` VALUES ('1650331743152126542289a494fecb29a885bb75bcf94', '/web-reception/user/getHistoryList', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-19 09:29:03', 1);
INSERT INTO `blog_url` VALUES ('165051602071199785f3509a348618f83bab53ce710d0', '/web-admin/essay/addEssay', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-21 12:40:21', 1);
INSERT INTO `blog_url` VALUES ('1650518247436758c080533614789a31dabbedcd02404', '/web-admin/category/getCategoryData', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-21 13:17:27', 1);
INSERT INTO `blog_url` VALUES ('16505966669255514fcf514f34d73a87cbbbad734c716', '/web-reception/blog/addComment', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-22 11:04:27', 1);
INSERT INTO `blog_url` VALUES ('1650606924501d4792f3104184d3ca54dbfe809f82962', '/web-admin/user/getUser', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-22 13:55:25', 1);
INSERT INTO `blog_url` VALUES ('165060780966585cc7819a3c645bb85726ef096dd6f1e', '/web-admin/user/updateUser', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-22 14:10:10', 1);
INSERT INTO `blog_url` VALUES ('165060784364347df46eaa27243ae8c8973d0a95b9be2', '/web-admin/account/updateAccount', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-22 14:10:44', 1);
INSERT INTO `blog_url` VALUES ('165061146007364b54f58d4c54f1f8369e7f4d8e37c96', '/web-admin/history/addHistory', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-22 15:11:00', 1);
INSERT INTO `blog_url` VALUES ('165061866444027f76f1d225d4b2ba534874525939eaf', '/web-admin/essay/getEssay', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-22 17:11:04', 1);
INSERT INTO `blog_url` VALUES ('165061934640352eb053709bf42068af25231a66d32b8', '/web-admin/essay/deleteEssay', '1646036368847d63f771d21d14af09d01a0099fa9269e', '2022-04-22 17:22:26', 1);

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
INSERT INTO `blog_user` VALUES ('1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', 1, '本人是一名JAVA开发工程师。', '河北省/石家庄市/长安区', 130000, 130100, 130102, '2022-04-13 00:00:00', '[\"16461264646723922b084bfd24cb5b364a3b6315ba8fe\",\"164621303722303882159373c4b328af9739f94e3f9c3\",\"16502708280909cc3021412a844ae9340804ec3d02117\",\"16506144067323996fae42bb44ac8ab4cfd2aed272673\"]', '2022-04-13 14:41:07', '2022-04-22 19:31:09', 1, '汉');
INSERT INTO `blog_user` VALUES ('16503322063506805f102b97649639ac37b9cd6eb78c8', '未知', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/blog-login.png', 3, '还没有填写简介哦~', '未知地点', NULL, NULL, NULL, '2022-04-19 00:00:00', NULL, '2022-04-19 09:36:46', '2022-04-21 11:16:53', 1, NULL);
INSERT INTO `blog_user` VALUES ('1650606833987d9646dc759c04b9f8847636605f6ddaf', '测试账号', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', 1, '这是测试账号', '北京市/市辖区/东城区', 110000, 110100, 110101, '2022-04-18 00:00:00', '[\"164612749780438c1e25179c34171a38b5d6e5b7b8232\",\"164621303722303882159373c4b328af9739f94e3f9c3\",\"16502708280909cc3021412a844ae9340804ec3d02117\"]', '2022-04-22 13:53:54', '2022-04-22 14:12:01', 1, '汉');
INSERT INTO `blog_user` VALUES ('1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', '未知', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', 3, '毕业答辩', '浙江省/杭州市/拱墅区', 330000, 330100, 330105, '2022-04-22 00:00:00', '[\"1646126454111812ac03dd9524f07b892c24fa247e3e9\",\"164612749780438c1e25179c34171a38b5d6e5b7b8232\",\"16461264646723922b084bfd24cb5b364a3b6315ba8fe\",\"16502708280909cc3021412a844ae9340804ec3d02117\"]', '2022-04-22 15:52:16', '2022-04-22 15:53:20', 1, '汉');
INSERT INTO `blog_user` VALUES ('165062944916701ee31f15a1f42ccade57000c3b67fb7', '未知', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', 3, '还没有填写简介哦~', '未知地点', NULL, NULL, NULL, '2022-04-22 00:00:00', NULL, '2022-04-22 20:10:49', NULL, 1, NULL);
INSERT INTO `blog_user` VALUES ('1650631375448c693205cb44947a6bce6b9c431f89486', '郭长平', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', 1, '还没有填写简介哦~', '江苏省/徐州市/云龙区', 320000, 320300, 320303, '2022-04-22 00:00:00', '[\"164612749780438c1e25179c34171a38b5d6e5b7b8232\",\"16461264646723922b084bfd24cb5b364a3b6315ba8fe\",\"1646126454111812ac03dd9524f07b892c24fa247e3e9\"]', '2022-04-22 20:42:55', '2022-04-22 20:44:22', 1, '汉');

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
INSERT INTO `blog_user_recommend` VALUES ('16478293126835f976d0d96b14af4982aac8663326977', '164515137796358831a4e29554c70ae29516c27f9f145', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '11', 2600, '2022-03-21 10:21:53', '2022-04-18 13:41:49', 1, '郭长平', '2022-04-18 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('16478293698765a9e293e856844318c511b2cf7890853', '1644990311581db451e800cd4467da863636762c32b40', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', 'coding', 500, '2022-03-21 10:22:50', '2022-03-21 10:23:45', 9, 'gcp', '2022-03-03 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('164782943483508cafce99c214a7dbb2dd8e113bc7d5e', '1644990311581db451e800cd4467da863636762c32b40', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', 'coding', 500, '2022-03-21 10:23:55', '2022-04-18 13:41:57', 1, 'gcp', '2022-04-18 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('16502605258949a31f3857059488e9d0b9e6565df375f', '16451518491977bccb7474b104b5395fae28132617766', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '测试多选下拉', 0, '2022-04-18 13:42:06', NULL, 1, '测试0', '2022-04-18 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('16502605326440b97733b80274cb29ed02b51fe5997a7', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '还没有填写简介哦~', 0, '2022-04-18 13:42:13', NULL, 1, 'gcp123', '2022-04-18 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('1650611876354879a6d658f0742bdb14e8c19e54f236b', '1650606833987d9646dc759c04b9f8847636605f6ddaf', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '这是测试账号', 1, '2022-04-22 15:17:56', NULL, 1, 'gcpcscs', '2022-04-22 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('1650611891270a638475550aa4504874f899053234291', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '还没有填写简介哦~', 8, '2022-04-22 15:18:11', NULL, 1, 'gcp123', '2022-04-22 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('16506118993306e1a70f9c3894ecabed61f4a22bbeab8', '164515137796358831a4e29554c70ae29516c27f9f145', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/213123.jpg', '11', 2601, '2022-04-22 15:18:19', NULL, 1, '郭长平', '2022-04-22 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('165061436496457bd03cfeae6483b8e149b3ff0ef5ae3', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '毕业答辩', 0, '2022-04-22 15:59:25', '2022-04-22 20:39:24', 0, 'gcptest', '2022-04-22 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('165068445466413bc2178767f4431b8f4b4c5b39e485c', '1650631375448c693205cb44947a6bce6b9c431f89486', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '还没有填写简介哦~', 1, '2022-04-23 11:27:35', NULL, 1, 'test123', '2022-04-23 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('16506844602530a0fd513bf1948e99b86554a2d77e549', '1650613936092aab5d196ff3c4e7bb4ab4feb7da2bda5', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '毕业答辩', 4, '2022-04-23 11:27:40', NULL, 1, 'gcptest', '2022-04-23 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('1650684468601d2d23989ac844e8a91df5c732aba87f0', '1650606833987d9646dc759c04b9f8847636605f6ddaf', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '这是测试账号', 2, '2022-04-23 11:27:49', NULL, 1, 'gcpcscs', '2022-04-23 00:00:00');
INSERT INTO `blog_user_recommend` VALUES ('1650684473331dc217a1dda104934a53cb57b4035662a', '1649832066958a8337e3d00fc44a3b0f187d8bfe56c54', 'https://gcp-1307568514.cos.ap-nanjing.myqcloud.com/img/program.png', '本人是一名JAVA开发工程师。', 15, '2022-04-23 11:27:53', NULL, 1, 'gcp123', '2022-04-23 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
