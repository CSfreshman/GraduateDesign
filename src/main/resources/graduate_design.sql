/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : graduate_design

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 25/06/2023 08:49:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '123456' COMMENT '管理员密码',
  `role` int(2) NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for defense
-- ----------------------------
DROP TABLE IF EXISTS `defense`;
CREATE TABLE `defense`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `selected_topic_id` bigint(20) NULL DEFAULT NULL COMMENT '选题编号',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '答辩日期',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '答辩地点',
  `record` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '答辩记录',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '答辩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of defense
-- ----------------------------
INSERT INTO `defense` VALUES (1, 31, '2023-07-01 00:00:00', '新安317', '不错');
INSERT INTO `defense` VALUES (2, 35, '2023-06-20 23:00:00', '新安317', '1');
INSERT INTO `defense` VALUES (3, 33, '2023-06-22 02:18:12', '新安317', '良好');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `id` int(11) NOT NULL COMMENT '主键，专业id（高三位表示学院，低三位表示专业）',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '专业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (100001, '计算机科学与技术');
INSERT INTO `major` VALUES (100002, '软件工程');
INSERT INTO `major` VALUES (100003, '电子信息科学与技术');
INSERT INTO `major` VALUES (100004, '物联网工程');
INSERT INTO `major` VALUES (101001, '土木工程');
INSERT INTO `major` VALUES (102001, '机械工程');
INSERT INTO `major` VALUES (103001, '外语专业');

-- ----------------------------
-- Table structure for midterm_check
-- ----------------------------
DROP TABLE IF EXISTS `midterm_check`;
CREATE TABLE `midterm_check`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `selected_topic_id` bigint(20) NULL DEFAULT NULL COMMENT '选题编号',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '中期检查日期',
  `opinion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '中期检查意见',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '中期检查地点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '中期检查表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of midterm_check
-- ----------------------------
INSERT INTO `midterm_check` VALUES (2, 31, '2023-06-30 00:00:00', '不错', '新安317');
INSERT INTO `midterm_check` VALUES (3, 35, '2023-06-19 23:00:00', '挺好', '新安317');
INSERT INTO `midterm_check` VALUES (4, 33, '2023-06-20 16:00:00', '良好', '敬亭317');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色（1=学生，2=老师，3=管理员）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `selected_topic_id` bigint(20) NULL DEFAULT NULL COMMENT '学生id',
  `advisor_score` double(255, 2) NULL DEFAULT NULL COMMENT '指导教师',
  `reviewer_score` double(255, 2) NULL DEFAULT NULL COMMENT '评阅教师成绩',
  `committee_score` double(255, 2) NULL DEFAULT NULL COMMENT '答辩小组成绩',
  `final_score` double(255, 2) NULL DEFAULT NULL COMMENT '最终成绩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '成绩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (3, 31, 100.00, 100.00, 100.00, 100.00);
INSERT INTO `score` VALUES (4, 35, 1.00, 1.00, 1.00, 1.00);
INSERT INTO `score` VALUES (5, 33, 100.00, 100.00, 100.00, 100.00);

-- ----------------------------
-- Table structure for selected_topic
-- ----------------------------
DROP TABLE IF EXISTS `selected_topic`;
CREATE TABLE `selected_topic`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键（选题信息）',
  `stu_id` bigint(20) NULL DEFAULT NULL COMMENT '学生信息',
  `topic_id` bigint(20) NULL DEFAULT NULL COMMENT '课题信息',
  `teacher_id` bigint(20) NULL DEFAULT NULL COMMENT '指导教师信息',
  `progress` tinyint(255) NULL DEFAULT NULL COMMENT '进度',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_stu`(`stu_id`) USING BTREE COMMENT '学生id的唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '选题信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of selected_topic
-- ----------------------------
INSERT INTO `selected_topic` VALUES (31, 1, 27, 57, 15);
INSERT INTO `selected_topic` VALUES (33, 18, 28, 57, 15);
INSERT INTO `selected_topic` VALUES (35, 25, 29, 57, 15);

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `stu_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学号',
  `stu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '123456' COMMENT '登录密码',
  `major` int(255) NULL DEFAULT NULL COMMENT '专业',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '学生信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES (1, '2020218000', '吴子文', '123456', 100001);
INSERT INTO `student_info` VALUES (18, '2020218088', '叶文杰', '123456', 100001);
INSERT INTO `student_info` VALUES (25, '2020218001', '张伟', '123456', 100003);
INSERT INTO `student_info` VALUES (26, '2020219007', '程智敏', '123456', 100003);
INSERT INTO `student_info` VALUES (27, '2020219011', '孟泰平', '123456', 100003);
INSERT INTO `student_info` VALUES (28, '2020219015', '毛阳平', '123456', 100003);
INSERT INTO `student_info` VALUES (29, '2020219019', '韩康盛', '123456', 100003);
INSERT INTO `student_info` VALUES (30, '2020219023', '贾正祥', '123456', 100003);
INSERT INTO `student_info` VALUES (31, '2020219027', '孟乐生', '123456', 100003);
INSERT INTO `student_info` VALUES (32, '2020219031', '张兴贤', '123456', 100003);
INSERT INTO `student_info` VALUES (33, '2020219035', '黎玉书', '123456', 100003);
INSERT INTO `student_info` VALUES (34, '2020219039', '熊乐山', '123456', 100003);
INSERT INTO `student_info` VALUES (35, '2020219043', '宋丰羽', '123456', 100003);
INSERT INTO `student_info` VALUES (36, '2020219047', '任向阳', '123456', 100003);
INSERT INTO `student_info` VALUES (37, '2020219051', '唐睿达', '123456', 100003);
INSERT INTO `student_info` VALUES (40, '2020219008', '毛茂典', '123456', 100001);
INSERT INTO `student_info` VALUES (41, '2020219012', '金越彬', '123456', 100001);
INSERT INTO `student_info` VALUES (42, '2020219016', '唐明诚', '123456', 100001);
INSERT INTO `student_info` VALUES (43, '2020219020', '方天逸', '123456', 100001);
INSERT INTO `student_info` VALUES (44, '2020219024', '石光霁', '123456', 100001);
INSERT INTO `student_info` VALUES (45, '2020219028', '刘俊郎', '123456', 100001);
INSERT INTO `student_info` VALUES (46, '2020219032', '方和洽', '123456', 100001);
INSERT INTO `student_info` VALUES (47, '2020219036', '吴德寿', '123456', 100001);
INSERT INTO `student_info` VALUES (48, '2020219040', '吴明珠', '123456', 100001);
INSERT INTO `student_info` VALUES (49, '2020219044', '梁永逸', '123456', 100001);
INSERT INTO `student_info` VALUES (50, '2020219048', '常安顺', '123456', 100001);
INSERT INTO `student_info` VALUES (51, '2020219052', '曾高昂', '123456', 100001);
INSERT INTO `student_info` VALUES (52, '2020219000', '张三', '123456', 100002);
INSERT INTO `student_info` VALUES (53, '2020219009', '谭宏阔', '123456', 100002);
INSERT INTO `student_info` VALUES (54, '2020219013', '罗正德', '123456', 100002);
INSERT INTO `student_info` VALUES (55, '2020219017', '贺鸿振', '123456', 100002);
INSERT INTO `student_info` VALUES (56, '2020219021', '邱睿广', '123456', 100002);
INSERT INTO `student_info` VALUES (57, '2020219025', '梁永安', '123456', 100002);
INSERT INTO `student_info` VALUES (58, '2020219029', '顾元青', '123456', 100002);
INSERT INTO `student_info` VALUES (59, '2020219033', '田祺福', '123456', 100002);
INSERT INTO `student_info` VALUES (60, '2020219037', '沈良奥', '123456', 100002);
INSERT INTO `student_info` VALUES (61, '2020219041', '崔新翰', '123456', 100002);
INSERT INTO `student_info` VALUES (62, '2020219045', '吴良弼', '123456', 100002);
INSERT INTO `student_info` VALUES (63, '2020219049', '薛弘新', '123456', 100002);
INSERT INTO `student_info` VALUES (64, '2020219053', '邓锦程', '123456', 100002);
INSERT INTO `student_info` VALUES (65, '2020219001', '张宾白', '123456', 100004);
INSERT INTO `student_info` VALUES (66, '2020219002', '易同方', '123456', 100004);
INSERT INTO `student_info` VALUES (67, '2020219003', '阎学林', '123456', 100004);
INSERT INTO `student_info` VALUES (68, '2020219004', '彭星纬', '123456', 100004);
INSERT INTO `student_info` VALUES (69, '2020219005', '王翰翮', '123456', 100004);
INSERT INTO `student_info` VALUES (70, '2020219006', '胡高杰', '123456', 100004);
INSERT INTO `student_info` VALUES (71, '2020219010', '傅昊空', '123456', 100004);
INSERT INTO `student_info` VALUES (72, '2020219014', '吴鸿波', '123456', 100004);
INSERT INTO `student_info` VALUES (73, '2020219018', '武鸿福', '123456', 100004);
INSERT INTO `student_info` VALUES (74, '2020219022', '秦鸿风', '123456', 100004);
INSERT INTO `student_info` VALUES (75, '2020219026', '郭智鑫', '123456', 100004);
INSERT INTO `student_info` VALUES (76, '2020219030', '常晟睿', '123456', 100004);
INSERT INTO `student_info` VALUES (77, '2020219034', '彭睿达', '123456', 100004);
INSERT INTO `student_info` VALUES (78, '2020219038', '文高歌', '123456', 100004);
INSERT INTO `student_info` VALUES (79, '2020219042', '张宇达', '123456', 100004);
INSERT INTO `student_info` VALUES (80, '2020219046', '吕冠玉', '123456', 100004);
INSERT INTO `student_info` VALUES (81, '2020219050', '郝开宇', '123456', 100004);
INSERT INTO `student_info` VALUES (82, '2020219054', '谢飞翼', '123456', 100004);
INSERT INTO `student_info` VALUES (83, '2020219055', '高原', '123456', 100004);

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '老师姓名',
  `teacher_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '老师工号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '123456' COMMENT '登录密码',
  `type` tinyint(255) NULL DEFAULT NULL COMMENT '课题类型',
  `stock` int(255) NULL DEFAULT NULL COMMENT '剩余可指导学生的数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '教师信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO `teacher_info` VALUES (57, '陈进', '100001', '123456', 1, 0);
INSERT INTO `teacher_info` VALUES (58, '刘季', '100002', '123456', 1, 4);
INSERT INTO `teacher_info` VALUES (59, '孙长武', '100008', '123456', 1, 4);
INSERT INTO `teacher_info` VALUES (60, '陈军', '100014', '123456', 1, 5);
INSERT INTO `teacher_info` VALUES (61, '郑军', '100005', '123456', 2, 3);
INSERT INTO `teacher_info` VALUES (62, '牛方玉', '100011', '123456', 2, 5);
INSERT INTO `teacher_info` VALUES (63, '张宇', '100017', '123456', 2, 4);
INSERT INTO `teacher_info` VALUES (64, '高国强', '100003', '123456', 6, 3);
INSERT INTO `teacher_info` VALUES (65, '岳晓梅', '100009', '123456', 6, 3);
INSERT INTO `teacher_info` VALUES (66, '汤家凤', '100015', '123456', 6, 4);
INSERT INTO `teacher_info` VALUES (67, '王艳丽', '100007', '123456', 3, 4);
INSERT INTO `teacher_info` VALUES (68, '岳文顺', '100013', '123456', 3, 3);
INSERT INTO `teacher_info` VALUES (69, '马国签', '100018', '123456', 3, 4);
INSERT INTO `teacher_info` VALUES (70, '吕宏伟', '100004', '123456', 4, 3);
INSERT INTO `teacher_info` VALUES (71, '丁一轩', '100010', '123456', 4, 5);
INSERT INTO `teacher_info` VALUES (72, '武忠祥', '100016', '123456', 4, 3);
INSERT INTO `teacher_info` VALUES (73, '陈冠俊', '100006', '123456', 5, 4);
INSERT INTO `teacher_info` VALUES (74, '苏旭', '100012', '123456', 5, 4);
INSERT INTO `teacher_info` VALUES (75, '郭顶', '100019', '123456', 5, 3);

-- ----------------------------
-- Table structure for topic_info
-- ----------------------------
DROP TABLE IF EXISTS `topic_info`;
CREATE TABLE `topic_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键（课题信息）',
  `topic_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课题描述',
  `topic_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课题名字',
  `type` tinyint(255) NULL DEFAULT NULL COMMENT '选题类型',
  `stock` int(255) NULL DEFAULT NULL COMMENT '选题剩余',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '课题信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of topic_info
-- ----------------------------
INSERT INTO `topic_info` VALUES (27, '用户可以在平台上浏览商品、购买商品，并与其他用户分享自己的购物心得。', '社交电商平台', 1, 0);
INSERT INTO `topic_info` VALUES (28, '包括学生和教师两个角色，学生可以在线观看课程视频、提交作业，教师可以上传课程视频、批改作业。', '在线教育系统', 1, 0);
INSERT INTO `topic_info` VALUES (29, '展示全球各地的旅游景点信息和旅游线路推荐，让用户可以在网站上预订旅游线路。', '旅游信息网站', 1, 0);
INSERT INTO `topic_info` VALUES (30, '用户记录自己的运动数据并制定健身计划，系统会根据数据分析用户的运动情况并给出建议。', '健身管理系统', 1, 1);
INSERT INTO `topic_info` VALUES (31, '用户可以在线咨询医生，医生可以通过视频或文字为用户提供咨询服务。', '在线医疗咨询平台', 1, 1);
INSERT INTO `topic_info` VALUES (32, '用户可以上传和收听自己喜欢的音乐，并与其他用户互动交流。', '音乐分享平台', 1, 1);
INSERT INTO `topic_info` VALUES (33, '用户可以提出问题并得到其他用户的回答，也可以为其他用户解答问题。', '知识问答社区', 1, 1);
INSERT INTO `topic_info` VALUES (34, '用户可以分享和借用各种物品和设备，包括工具、家电等。', '资源共享平台', 1, 1);
INSERT INTO `topic_info` VALUES (35, '用户可以买卖二手商品，包括家具、衣物、电子设备等。', '二手交易平台', 1, 1);
INSERT INTO `topic_info` VALUES (36, '用户输入自己的个人信息和职业目标，系统会根据信息分析用户的职业潜力和发展方向，并给出建议和指导。', '职业发展规划系统', 1, 1);
INSERT INTO `topic_info` VALUES (37, '用户可以预订酒店、机票、火车票、门票等各种服务。', '在线预订系统', 1, 1);
INSERT INTO `topic_info` VALUES (38, '用户可以通过手机或其他设备远程控制家中的灯光、空调、电视等设备。', '智能家居控制系统', 1, 1);
INSERT INTO `topic_info` VALUES (39, '用户输入自己所在的地区和垃圾种类，系统会根据信息分析垃圾分类规则并给出指导。', '垃圾分类管理系统', 1, 1);
INSERT INTO `topic_info` VALUES (40, '用户可以在线购买各种商品，包括食品、服装、化妆品等。', '网上商城', 1, 1);
INSERT INTO `topic_info` VALUES (41, '用户记录自己的身体数据和健康状况，并制定健康计划和目标。', '个人健康管理系统', 1, 1);
INSERT INTO `topic_info` VALUES (42, '用户创建个人资料、发布内容、关注其他用户，以及与其他人交流。该平台可以包括一系列功能，如实时聊天、点赞、评论和分享等。', '社交媒体平台', 1, 1);
INSERT INTO `topic_info` VALUES (43, '患者在线上预约医生、挂号、查看诊断结果等。同时，医生也可以在平台上管理自己的排班以及患者的历史记录。', '在线医疗预约平台', 1, 1);
INSERT INTO `topic_info` VALUES (44, '平台可以提供在线课程，教授各种知识和技能。它可以让学生通过登录账户来获取视频、音频和文本材料，并进行自我评估测试等。', '在线学习平台', 1, 1);
INSERT INTO `topic_info` VALUES (45, '该项目旨在设计一个跨多个物理设备或节点分布的文件系统。它可以支持高容错性、高可扩展性和高性能，并提供类似于本地文件系统的接口。', '分布式文件存储系统', 2, 1);
INSERT INTO `topic_info` VALUES (46, '实时操作系统内核的设计将关注处理来自实时应用程序的数据。这个项目要求在保证高性能和高实时响应性的同时，满足实时应用程序对时间要求的严格要求。', '实时操作系统内核', 2, 1);
INSERT INTO `topic_info` VALUES (47, '这个项目将涉及到使用微内核的操作系统设计。微内核架构使得系统非常灵活，更加安全。同时也可以便于开发人员进行模块化的设计和开发，降低整体系统的复杂性。', '基于微内核的操作系统', 2, 1);
INSERT INTO `topic_info` VALUES (48, '该项目需要设计一个基于虚拟化技术的操作系统平台，可以为用户提供多种操作系统环境，同时保证资源共享和安全隔离。', '操作系统虚拟化平台', 2, 1);
INSERT INTO `topic_info` VALUES (49, '嵌入式操作系统可以运行在嵌入式设备上，并管理硬件资源。该项目将专注于设计具有实时性、高效性、可靠性和安全性的嵌入式操作系统。', '嵌入式操作系统', 2, 1);
INSERT INTO `topic_info` VALUES (50, '这个项目需要设计一个专门用于物联网设备的操作系统。该操作系统必须支持低功耗、小型化和安全性等特性，并提供适应不同硬件平台的灵活性。', 'IoT操作系统', 2, 1);
INSERT INTO `topic_info` VALUES (51, '安全操作系统的设计需要考虑如何保护系统免受恶意软件和攻击者的攻击。它需要提供强大的安全功能，如访问控制、数据加密和鉴别等。', '安全操作系统', 2, 1);
INSERT INTO `topic_info` VALUES (52, '云计算操作系统的设计需要解决在云环境下如何管理和调度资源的问题。其目标是提高云计算系统的效率、性能和可扩展性。', '云计算操作系统', 2, 1);
INSERT INTO `topic_info` VALUES (53, '分布式操作系统的设计需要解决多台计算机之间如何进行通信和协作的问题。其主要目标是提高整个系统的并发性、可靠性和容错性。', '分布式操作系统', 2, 1);
INSERT INTO `topic_info` VALUES (54, '这个项目涉及到开发一个用于机器人控制的嵌入式系统。它可以使机器人实现自主导航、视觉识别、语音交互等功能。', '机器人控制系统', 6, 1);
INSERT INTO `topic_info` VALUES (55, '物流货运跟踪系统是一个基于 GPS 技术的嵌入式系统。它可以帮助企业对货物的运输进行实时跟踪、防盗防失等。', '物流货运跟踪系统', 6, 1);
INSERT INTO `topic_info` VALUES (56, '该项目需要设计一个基于数字信号处理器(DSP)的音频播放器。它可以采集、处理和播放高品质的音频数据。', '基于数字信号处理的音频播放器', 6, 1);
INSERT INTO `topic_info` VALUES (57, '这个项目需要设计一个汽车公里数计算器。它可以监测汽车的行驶情况，显示行驶的里程数，以及其他相关信息。', '汽车公里数计算器', 6, 1);
INSERT INTO `topic_info` VALUES (58, '定位手表是一款智能手表，可以提供定位、通讯和健康监测等功能。该项目需要设计嵌入式系统来实现这些功能，并保证低功耗、高精度和稳定性。', '定位手表', 6, 1);
INSERT INTO `topic_info` VALUES (59, '该项目将使用 ZigBee 技术设计一个智能家居系统。该系统可以通过网关来控制各种家电设备，如灯光、电视、窗帘等。', '基于 ZigBee 的智能家居系统', 6, 1);
INSERT INTO `topic_info` VALUES (60, '车牌识别系统是一个嵌入式系统，可以通过摄像头自动识别汽车的车牌号码。它可以用于停车场管理、交通违法监测等应用场景。', '车牌识别系统', 6, 1);
INSERT INTO `topic_info` VALUES (61, '这个项目需要设计一款智能安防门锁系统。用户可以通过手机远程控制门锁的开启和关闭，并且系统还可以提供多种安全保护机制。', '智能安防门锁系统', 6, 1);
INSERT INTO `topic_info` VALUES (62, '医疗监护器是一种用于监测病人生命体征的设备。该项目需要设计一个嵌入式系统，可以实时采集心率、呼吸、血压等数据，并进行报警提示。', '医疗监护器', 6, 1);
INSERT INTO `topic_info` VALUES (63, '这个项目需要设计一个无人机控制系统。它可以使无人机具备自主起飞、降落、返航和避障等功能，以实现多种应用场景。', '无人机控制系统', 6, 1);
INSERT INTO `topic_info` VALUES (64, '智能农业系统是一种嵌入式系统，可以帮助农民实现高效的农业生产。它可以提供土壤温度、湿度、光照等信息，并根据这些信息进行自动控制。', '智能农业系统', 6, 1);
INSERT INTO `topic_info` VALUES (65, '要求学生深入研究深度学习算法在图像分类和识别中的应用，通过对模型结构、参数优化等方面的改进，提升分类和识别的准确性和效率。', '基于深度学习的图像分类与识别优化', 3, 1);
INSERT INTO `topic_info` VALUES (66, '要求学生掌握深度强化学习算法的原理和实现技巧，通过设计和实现一个智能游戏AI，提升其游戏水平和适应能力。', '基于深度强化学习的智能游戏AI开发', 3, 1);
INSERT INTO `topic_info` VALUES (67, '要求学生深入研究深度学习在自然语言处理中的应用，包括情感分析、机器翻译、文本分类等方面的应用开发。', '基于深度学习的自然语言处理应用开发', 3, 1);
INSERT INTO `topic_info` VALUES (68, '要求学生深入研究深度学习在图像生成和重建中的应用，包括GAN、VAE等常见模型的原理和实现，以及对图像质量和多样性的评估和提升。', '基于深度学习的图像生成与重建技术研究', 3, 1);
INSERT INTO `topic_info` VALUES (69, '要求学生深入研究深度学习在医学影像诊断中的应用，包括肿瘤检测、疾病分类等方面的应用开发和效果评估。', '深度学习在医学影像诊断中的应用研究', 3, 1);
INSERT INTO `topic_info` VALUES (70, '要求学生深入研究深度学习在风险预测中的应用，通过对数据预处理、模型训练和优化等方面的探索，提升预测准确率和稳定性。', '基于深度学习的风险预测模型设计与实现', 3, 1);
INSERT INTO `topic_info` VALUES (71, '要求学生深入研究深度学习模型压缩和加速技术，包括剪枝、量化、蒸馏等方面的研究和实现，以提高模型的运行效率和节省计算资源。', '深度学习模型压缩和加速技术研究', 3, 1);
INSERT INTO `topic_info` VALUES (72, '要求学生深入研究深度学习在视频分析和处理中的应用，包括视频目标检测、行为识别等方面的研究和实现。', '基于深度学习的视频分析与处理应用研究', 3, 1);
INSERT INTO `topic_info` VALUES (73, '要求学生深入研究深度学习在推荐系统中的应用，包括基于多模态数据的推荐、增量学习等方面的研究和实现。', '深度学习在推荐系统中的应用研究', 3, 1);
INSERT INTO `topic_info` VALUES (74, '要求学生深入研究深度学习在人脸识别中的应用，包括特征提取、模型训练和应用开发等方面的研究和实现。', '基于深度学习的人脸识别技术研究与应用开发', 3, 1);
INSERT INTO `topic_info` VALUES (75, '要求学生深入研究遗传算法的原理和实现技巧，通过对路径规划问题中的目标函数、选择操作等方面的改进，提升路径规划的效率和可行性。', '基于遗传算法的路径规划优化', 4, 1);
INSERT INTO `topic_info` VALUES (76, '要求学生掌握模拟退火算法的原理和实现方法，通过对图像处理中的噪声去除、边缘检测等问题的优化，提升图像处理的质量和准确度。', '基于模拟退火算法的图像处理优化', 4, 1);
INSERT INTO `topic_info` VALUES (77, '要求学生了解人工神经网络的原理和应用场景，在此基础上通过对金融市场数据的分析和建模，实现对金融风险的预测和管理。', '基于人工神经网络的金融风险预测研究', 4, 1);
INSERT INTO `topic_info` VALUES (78, '要求学生深入研究贝叶斯网络的原理和实现方法，通过对知识表示、学习和推理等方面的探索，实现对决策过程的支持和优化。', '基于贝叶斯网络的知识推理和决策支持', 4, 1);
INSERT INTO `topic_info` VALUES (79, '要求学生掌握线性规划的原理和应用场景，在此基础上通过对生产过程中的任务调度、资源分配等问题的建模和求解，提升生产效率和质量。', '基于线性规划的生产调度优化', 4, 1);
INSERT INTO `topic_info` VALUES (80, '要求学生了解机器学习算法的原理和应用，以及电子商务推荐系统的设计和实现，通过对用户行为数据的分析和建模，提升推荐准确度和用户满意度。', '机器学习算法在电子商务推荐系统中的应用', 4, 1);
INSERT INTO `topic_info` VALUES (81, '要求学生深入研究蚁群算法的原理和实现方法，通过对优化问题中的目标函数、选择操作等方面的改进，提升解决方案的效率和可行性。', '基于蚁群算法的优化问题解决', 4, 1);
INSERT INTO `topic_info` VALUES (82, '要求学生了解K近邻算法的原理和应用，以及图像分类和识别的技术和方法，通过对图像特征的提取和匹配，实现图像分类和识别的自动化和精准度提升。', '基于K近邻算法的图像分类和识别', 4, 1);
INSERT INTO `topic_info` VALUES (83, '要求学生掌握朴素贝叶斯分类算法的原理和应用，以及文本处理技术的相关知识，通过对文本特征的提取和分类，实现自然语言处理中的情感分析、垃圾邮件过滤等问题的解决。', '基于朴素贝叶斯分类算法的文本处理技术应用', 4, 1);
INSERT INTO `topic_info` VALUES (84, '要求学生深入研究熵权TOPSIS法的原理和应用场景，在此基础上通过对多属性决策问题的建模和求解，实现对决策的支持和优化。', '基于熵权TOPSIS法的多属性决策分析', 4, 1);
INSERT INTO `topic_info` VALUES (85, '要求学生掌握分布式算法的原理和实现技巧，在此基础上通过对大规模数据的分布式处理和计算，实现数据挖掘、机器学习等问题的解决。', '基于分布式算法的大规模数据处理', 4, 1);
INSERT INTO `topic_info` VALUES (86, '要求学生深入研究软件定义网络技术，设计和实现一个高可用性、高性能的数据中心网络，提升数据中心的安全性和运行效率。', '基于软件定义网络的数据中心网络设计与实现', 5, 1);
INSERT INTO `topic_info` VALUES (87, '要求学生掌握区块链技术的原理和应用场景，在此基础上通过对分布式存储系统的架构和算法进行优化，提升运行效率和数据安全性。', '基于区块链的分布式存储系统设计与优化', 5, 1);
INSERT INTO `topic_info` VALUES (88, '要求学生深入研究云计算平台的原理和应用，通过对虚拟化环境的部署、管理和维护等方面的优化，提升云计算资源的利用效率和灵活性。', '基于云计算平台的虚拟化环境部署和管理', 5, 1);
INSERT INTO `topic_info` VALUES (89, '要求学生了解车联网技术的特点和应用场景，通过对通信协议的设计和优化，提升车联网的通信效率和稳定性。', '车联网中的通信协议设计和优化', 5, 1);
INSERT INTO `topic_info` VALUES (90, '要求学生深入研究物联网技术，设计和实现一个智能家居系统，包括传感器设备、数据采集、云端分析等方面的内容，提升家居生活的便捷性和智能化水平。', '基于物联网的智能家居系统设计和开发', 5, 1);
INSERT INTO `topic_info` VALUES (91, '要求学生了解网络安全的相关知识和技术，通过对网络安全风险的评估和分析，制定相应的应对策略和措施，提升网络安全的保障水平。', '网络安全风险评估与应对策略研究', 5, 1);
INSERT INTO `topic_info` VALUES (92, '要求学生深入研究无线传感器网络技术，通过对能源管理和优化算法的设计和实现，延长无线传感器网络的运行时间和寿命。', '无线传感器网络中的能源管理和优化', 5, 1);
INSERT INTO `topic_info` VALUES (93, '要求学生了解IPv6技术的特点和应用场景，通过对网络环境的部署和管理等方面的优化，提升网络的稳定性和可靠性。', '基于IPv6的网络环境部署和管理', 5, 1);
INSERT INTO `topic_info` VALUES (94, '要求学生深入研究5G通信技术，以及工业互联网的相关知识，通过对通信协议和网络架构的设计和优化，提升工业互联网的数据传输效率和延时性。', '5G通信技术在工业互联网中的应用研究', 5, 1);
INSERT INTO `topic_info` VALUES (95, '要求学生深入研究软件定义无线电技术，设计和实现一个智能终端系统，包括硬件和软件方面的内容，提升终端设备的功能和性能。', '基于软件定义无线电技术的智能终端设计与开发', 5, 1);
INSERT INTO `topic_info` VALUES (96, '要求学生深入研究SDN技术，通过对大规模网络的管理和优化等方面的实现和探索，提升网络的可扩展性和稳定性。', '基于SDN的大规模网络管理和优化', 5, 1);

-- ----------------------------
-- Triggers structure for table selected_topic
-- ----------------------------
DROP TRIGGER IF EXISTS `reduce__topic_stock`;
delimiter ;;
CREATE TRIGGER `reduce__topic_stock` BEFORE INSERT ON `selected_topic` FOR EACH ROW update topic_info set topic_info.stock = topic_info.stock - 1 where topic_info.id = NEW.topic_id
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table selected_topic
-- ----------------------------
DROP TRIGGER IF EXISTS `reduce_teacher_stock`;
delimiter ;;
CREATE TRIGGER `reduce_teacher_stock` BEFORE INSERT ON `selected_topic` FOR EACH ROW update teacher_info set teacher_info.stock = teacher_info.stock - 1 where teacher_info.id = NEW.teacher_id
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table selected_topic
-- ----------------------------
DROP TRIGGER IF EXISTS `add_topic_topck`;
delimiter ;;
CREATE TRIGGER `add_topic_topck` AFTER DELETE ON `selected_topic` FOR EACH ROW update topic_info set topic_info.stock = topic_info.stock + 1 where topic_info.id = OLD.topic_id
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table selected_topic
-- ----------------------------
DROP TRIGGER IF EXISTS `add_teacher_topck`;
delimiter ;;
CREATE TRIGGER `add_teacher_topck` AFTER DELETE ON `selected_topic` FOR EACH ROW update teacher_info set teacher_info.stock = teacher_info.stock + 1 where teacher_info.id = OLD.teacher_id
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
