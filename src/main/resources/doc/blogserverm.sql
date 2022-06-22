/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : blogserverm

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 14/05/2020 10:08:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `commentsize` int(0) NULL DEFAULT NULL,
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createtime` datetime(6) NULL DEFAULT NULL,
  `readsize` int(0) NULL DEFAULT NULL,
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `updatetime` datetime(6) NULL DEFAULT NULL,
  `votesize` int(0) NULL DEFAULT NULL,
  `category_id` int(0) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKy5kkohbk00g0w88fi05k2hcw`(`category_id`) USING BTREE,
  INDEX `FKbc2qerk3l47javnl2yvn51uoi`(`user_id`) USING BTREE,
  CONSTRAINT `FKbc2qerk3l47javnl2yvn51uoi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKy5kkohbk00g0w88fi05k2hcw` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (11, 8, 'Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式框架。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，当与现代化的工具链以及各种支持类库结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。', '2020-04-19 13:53:43.862000', 9, '介绍', 'Vue.js 是什么', '2020-04-29 16:29:48.813000', NULL, 1, 3);
INSERT INTO `article` VALUES (12, 0, '每个 Vue 应用都是通过用 Vue 函数创建一个新的 Vue 实例开始的：\n\nvar vm = new Vue({\n  // 选项\n})\n虽然没有完全遵循 MVVM 模型，但是 Vue 的设计也受到了它的启发。因此在文档中经常会使用 vm (ViewModel 的缩写) 这个变量名表示 Vue 实例。\n\n当创建一个 Vue 实例时，你可以传入一个选项对象。这篇教程主要描述的就是如何使用这些选项来创建你想要的行为。作为参考，你也可以在 API 文档中浏览完整的选项列表。\n\n一个 Vue 应用由一个通过 new Vue 创建的根 Vue 实例，以及可选的嵌套的、可复用的组件树组成。', '2020-04-19 13:55:52.245000', 0, '创建一个 Vue 实例', '创建一个 Vue 实例', NULL, NULL, 1, 3);
INSERT INTO `article` VALUES (13, 0, 'Vue.js 使用了基于 HTML 的模板语法，允许开发者声明式地将 DOM 绑定至底层 Vue 实例的数据。所有 Vue.js 的模板都是合法的 HTML，所以能被遵循规范的浏览器和 HTML 解析器解析。\n\n在底层的实现上，Vue 将模板编译成虚拟 DOM 渲染函数。结合响应系统，Vue 能够智能地计算出最少需要重新渲染多少组件，并把 DOM 操作次数减到最少。\n\n如果你熟悉虚拟 DOM 并且偏爱 JavaScript 的原始力量，你也可以不用模板，直接写渲染 (render) 函数，使用可选的 JSX 语法。', '2020-04-19 13:56:30.493000', 0, '模板语法', '模板语法', NULL, NULL, 1, 3);
INSERT INTO `article` VALUES (14, 0, 'Java是由Sun Microsystems公司于1995年5月推出的Java面向对象程序设计语言和Java平台的总称。由James Gosling和同事们共同研发，并在1995年正式推出。\n\nJava分为三个体系：\n\nJavaSE（J2SE）（Java2 Platform Standard Edition，java平台标准版）\nJavaEE(J2EE)(Java 2 Platform,Enterprise Edition，java平台企业版)\nJavaME(J2ME)(Java 2 Platform Micro Edition，java平台微型版)。\n2005年6月，JavaOne大会召开，SUN公司公开Java SE 6。此时，Java的各种版本已经更名以取消其中的数字\"2\"：J2EE更名为Java EE, J2SE更名为Java SE，J2ME更名为Java ME。', '2020-04-19 13:59:51.502000', 0, '简介', 'Java', '2020-04-19 14:04:46.225000', NULL, 3, 3);
INSERT INTO `article` VALUES (15, 0, 'Java语言是简单的：\nJava语言的语法与C语言和C++语言很接近，使得大多数程序员很容易学习和使用。另一方面，Java丢弃了C++中很少使用的、很难理解的、令人迷惑的那些特性，如操作符重载、多继承、自动的强制类型转换。特别地，Java语言不使用指针，而是引用。并提供了自动的废料收集，使得程序员不必为内存管理而担忧。\n\nJava语言是面向对象的：\nJava语言提供类、接口和继承等面向对象的特性，为了简单起见，只支持类之间的单继承，但支持接口之间的多继承，并支持类与接口之间的实现机制（关键字为implements）。Java语言全面支持动态绑定，而C++语言只对虚函数使用动态绑定。总之，Java语言是一个纯的面向对象程序设计语言。\n\nJava语言是分布式的：\nJava语言支持Internet应用的开发，在基本的Java应用编程接口中有一个网络应用编程接口（java net），它提供了用于网络应用编程的类库，包括URL、URLConnection、Socket、ServerSocket等。Java的RMI（远程方法激活）机制也是开发分布式应用的重要手段。', '2020-04-19 14:00:32.337000', 0, '主要特性', 'Java', NULL, NULL, 3, 3);
INSERT INTO `article` VALUES (16, 0, 'Java语言是健壮的：\nJava的强类型机制、异常处理、垃圾的自动收集等是Java程序健壮性的重要保证。对指针的丢弃是Java的明智选择。Java的安全检查机制使得Java更具健壮性。\n\nJava语言是安全的：\nJava通常被用在网络环境中，为此，Java提供了一个安全机制以防恶意代码的攻击。除了Java语言具有的许多安全特性以外，Java对通过网络下载的类具有一个安全防范机制（类ClassLoader），如分配不同的名字空间以防替代本地的同名类、字节代码检查，并提供安全管理机制（类SecurityManager）让Java应用设置安全哨兵。\n\nJava语言是体系结构中立的：\nJava程序（后缀为java的文件）在Java平台上被编译为体系结构中立的字节码格式（后缀为class的文件），然后可以在实现这个Java平台的任何系统中运行。这种途径适合于异构的网络环境和软件的分发。\n\nJava语言是可移植的：\n这种可移植性来源于体系结构中立性，另外，Java还严格规定了各个基本数据类型的长度。Java系统本身也具有很强的可移植性，Java编译器是用Java实现的，Java的运行环境是用ANSI C实现的。', '2020-04-19 14:00:55.476000', 0, '主要特性', 'Java', NULL, NULL, 3, 3);
INSERT INTO `article` VALUES (17, 0, 'Java语言是解释型的：\n如前所述，Java程序在Java平台上被编译为字节码格式，然后可以在实现这个Java平台的任何系统中运行。在运行时，Java平台中的Java解释器对这些字节码进行解释执行，执行过程中需要的类在联接阶段被载入到运行环境中。\n\nJava是高性能的：\n与那些解释型的高级脚本语言相比，Java的确是高性能的。事实上，Java的运行速度随着JIT(Just-In-Time）编译器技术的发展越来越接近于C++。\n\nJava语言是多线程的：\n在Java语言中，线程是一种特殊的对象，它必须由Thread类或其子（孙）类来创建。通常有两种方法来创建线程：其一，使用型构为Thread(Runnable)的构造子类将一个实现了Runnable接口的对象包装成一个线程，其二，从Thread类派生出子类并重写run方法，使用该子类创建的对象即为线程。值得注意的是Thread类已经实现了Runnable接口，因此，任何一个线程均有它的run方法，而run方法中包含了线程所要运行的代码。线程的活动由一组方法来控制。Java语言支持多个线程的同时执行，并提供多线程之间的同步机制（关键字为synchronized）。\n\nJava语言是动态的：\nJava语言的设计目标之一是适应于动态变化的环境。Java程序需要的类能够动态地被载入到运行环境，也可以通过网络来载入所需要的类。这也有利于软件的升级。另外，Java中的类有一个运行时刻的表示，能进行运行时刻的类型检查。', '2020-04-19 14:01:17.471000', 0, '主要特性', 'Java', NULL, NULL, 3, 3);
INSERT INTO `article` VALUES (18, 0, '1995年5月23日，Java语言诞生\n1996年1月，第一个JDK-JDK1.0诞生\n1996年4月，10个最主要的操作系统供应商申明将在其产品中嵌入JAVA技术\n1996年9月，约8.3万个网页应用了JAVA技术来制作\n1997年2月18日，JDK1.1发布\n1997年4月2日，JavaOne会议召开，参与者逾一万人，创当时全球同类会议规模之纪录\n1997年9月，JavaDeveloperConnection社区成员超过十万\n1998年2月，JDK1.1被下载超过2,000,000次\n1998年12月8日，JAVA2企业平台J2EE发布\n1999年6月，SUN公司发布Java的三个版本：标准版（JavaSE,以前是J2SE）、企业版（JavaEE以前是J2EE）和微型版（JavaME，以前是J2ME）\n2000年5月8日，JDK1.3发布\n2000年5月29日，JDK1.4发布\n2001年6月5日，NOKIA宣布，到2003年将出售1亿部支持Java的手机\n2001年9月24日，J2EE1.3发布\n2002年2月26日，J2SE1.4发布，自此Java的计算能力有了大幅提升\n2004年9月30日18:00PM，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE1.5更名为Java SE 5.0\n2005年6月，JavaOne大会召开，SUN公司公开Java SE 6。此时，Java的各种版本已经更名，以取消其中的数字\"2\"：J2EE更名为Java EE，J2SE更名为Java SE，J2ME更名为Java ME\n2006年12月，SUN公司发布JRE6.0\n2009年04月20日，甲骨文74亿美元收购Sun。取得java的版权。\n2010年11月，由于甲骨文对于Java社区的不友善，因此Apache扬言将退出JCP[4]。\n2011年7月28日，甲骨文发布 Java7.0 的正式版。\n2014年3月18日，Oracle公司发表 Java SE 8。\n2017年9月21日，Oracle公司发表 Java SE 9\n2018年3月21日，Oracle公司发表 Java SE 10\n2018年9月25日，Java SE 11 发布\n2019年3月20日，Java SE 12 发布', '2020-04-19 14:01:51.010000', 0, '发展历史', 'Java', NULL, NULL, 3, 3);

-- ----------------------------
-- Table structure for article_comments
-- ----------------------------
DROP TABLE IF EXISTS `article_comments`;
CREATE TABLE `article_comments`  (
  `article_id` int(0) NOT NULL,
  `comments_id` int(0) NOT NULL,
  UNIQUE INDEX `UK_3p3q8lmg108o11h9tix5mdfb3`(`comments_id`) USING BTREE,
  INDEX `FKhdo7dtp0o8cn5wo7j1cs1gokg`(`article_id`) USING BTREE,
  CONSTRAINT `FKhdo7dtp0o8cn5wo7j1cs1gokg` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKpodmjhlfsry50qirst9nv0q38` FOREIGN KEY (`comments_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article_comments
-- ----------------------------
INSERT INTO `article_comments` VALUES (11, 8);
INSERT INTO `article_comments` VALUES (11, 10);
INSERT INTO `article_comments` VALUES (11, 11);
INSERT INTO `article_comments` VALUES (11, 12);
INSERT INTO `article_comments` VALUES (11, 13);
INSERT INTO `article_comments` VALUES (11, 14);
INSERT INTO `article_comments` VALUES (11, 15);
INSERT INTO `article_comments` VALUES (11, 16);

-- ----------------------------
-- Table structure for article_tags
-- ----------------------------
DROP TABLE IF EXISTS `article_tags`;
CREATE TABLE `article_tags`  (
  `article_id` int(0) NOT NULL,
  `tags_id` int(0) NOT NULL,
  INDEX `FKp6owh2p5p9yllwwrc2hn7bnxr`(`tags_id`) USING BTREE,
  INDEX `FK85ph188kqbfc5u1gq0tme7flk`(`article_id`) USING BTREE,
  CONSTRAINT `FK85ph188kqbfc5u1gq0tme7flk` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKp6owh2p5p9yllwwrc2hn7bnxr` FOREIGN KEY (`tags_id`) REFERENCES `tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article_tags
-- ----------------------------
INSERT INTO `article_tags` VALUES (11, 1);
INSERT INTO `article_tags` VALUES (12, 1);
INSERT INTO `article_tags` VALUES (12, 1);
INSERT INTO `article_tags` VALUES (13, 1);
INSERT INTO `article_tags` VALUES (13, 1);
INSERT INTO `article_tags` VALUES (13, 1);
INSERT INTO `article_tags` VALUES (15, 3);
INSERT INTO `article_tags` VALUES (15, 3);
INSERT INTO `article_tags` VALUES (16, 3);
INSERT INTO `article_tags` VALUES (16, 3);
INSERT INTO `article_tags` VALUES (16, 3);
INSERT INTO `article_tags` VALUES (17, 3);
INSERT INTO `article_tags` VALUES (17, 3);
INSERT INTO `article_tags` VALUES (17, 3);
INSERT INTO `article_tags` VALUES (17, 3);
INSERT INTO `article_tags` VALUES (18, 3);
INSERT INTO `article_tags` VALUES (18, 3);
INSERT INTO `article_tags` VALUES (18, 3);
INSERT INTO `article_tags` VALUES (18, 3);
INSERT INTO `article_tags` VALUES (18, 3);
INSERT INTO `article_tags` VALUES (14, 3);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `createtime` datetime(6) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `updatetime` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '2020-04-18 19:14:27.804000', 'Vue', NULL);
INSERT INTO `category` VALUES (3, '2020-04-18 19:14:49.267000', 'Java', NULL);
INSERT INTO `category` VALUES (4, '2020-04-18 19:17:12.289000', 'Spring Boot', NULL);
INSERT INTO `category` VALUES (5, '2020-04-18 19:18:41.770000', 'Spring Secutiy', NULL);
INSERT INTO `category` VALUES (6, '2020-04-18 19:18:52.778000', 'MyBatis', NULL);
INSERT INTO `category` VALUES (8, '2020-05-10 12:01:35.863000', '', NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `createtime` datetime(6) NULL DEFAULT NULL,
  `updatetime` datetime(6) NULL DEFAULT NULL,
  `user_id` int(0) NULL DEFAULT NULL,
  `article_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK8kcum44fvpupyw6f5baccx25c`(`user_id`) USING BTREE,
  INDEX `article_id`(`article_id`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (8, 'ceshi', '2020-04-19 15:30:52.440000', NULL, 3, 11);
INSERT INTO `comment` VALUES (10, 'ceshi', '2020-04-19 15:30:52.705000', NULL, 3, 11);
INSERT INTO `comment` VALUES (11, 'ceshi', '2020-04-19 15:30:53.217000', NULL, 3, 11);
INSERT INTO `comment` VALUES (12, 'ceshi', '2020-04-19 15:30:53.421000', NULL, 3, 11);
INSERT INTO `comment` VALUES (13, 'ceshi', '2020-04-19 15:30:53.618000', NULL, 3, 11);
INSERT INTO `comment` VALUES (14, 'ceshi', '2020-04-19 15:30:53.816000', NULL, 3, 11);
INSERT INTO `comment` VALUES (15, 'ceshi', '2020-04-19 15:30:54.024000', NULL, 3, 11);
INSERT INTO `comment` VALUES (16, 'ceshi', '2020-04-29 15:43:34.611000', NULL, 3, 11);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `createtime` datetime(6) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `updatetime` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '2020-04-18 19:11:14.859000', 'ROLE_USER', NULL);
INSERT INTO `role` VALUES (2, '2020-04-18 19:11:25.964000', 'ROLE_MANGER', NULL);
INSERT INTO `role` VALUES (3, '2020-04-18 19:11:35.122000', 'ROLE_ADMIN', NULL);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `createtime` datetime(6) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `updatetime` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, '2020-04-18 19:15:16.747000', 'Vue', NULL);
INSERT INTO `tag` VALUES (2, '2020-04-18 19:15:26.874000', 'Spring', NULL);
INSERT INTO `tag` VALUES (3, '2020-04-18 19:15:37.350000', 'Java', NULL);
INSERT INTO `tag` VALUES (4, '2020-04-18 19:19:08.411000', 'Spring Boot', NULL);
INSERT INTO `tag` VALUES (5, '2020-04-18 19:19:17.153000', 'Spring Secutiy', NULL);
INSERT INTO `tag` VALUES (6, '2020-04-18 19:19:26.667000', 'MyBatis', NULL);
INSERT INTO `tag` VALUES (7, '2020-04-18 20:19:43.654000', 'test', '2020-04-18 20:27:40.098000');
INSERT INTO `tag` VALUES (8, '2020-05-10 12:01:40.256000', '', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `createtime` datetime(6) NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `updatetime` datetime(6) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, '2020-04-18 19:13:10.161000', 'ceshi', '$2a$10$0e9Peo8btDCpQN.NoskVOuTmoSfL8o64XW5yDengthyamOfYpGZ..', '2020-04-18 19:56:18.424000', 'ceshi');
INSERT INTO `user` VALUES (4, '2020-04-18 19:13:18.369000', 'test', '$2a$10$LG1bEYs5sKJumHhjVm1uY.xGQtQCY/cAVzcFtEUhXUVE3r8ijPmEa', '2020-04-18 19:56:29.955000', 'test');

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles`  (
  `user_id` int(0) NOT NULL,
  `roles_id` int(0) NOT NULL,
  INDEX `FKj9553ass9uctjrmh0gkqsmv0d`(`roles_id`) USING BTREE,
  INDEX `FK55itppkw3i07do3h7qoclqd4k`(`user_id`) USING BTREE,
  CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKj9553ass9uctjrmh0gkqsmv0d` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES (3, 1);
INSERT INTO `user_roles` VALUES (3, 2);
INSERT INTO `user_roles` VALUES (3, 3);
INSERT INTO `user_roles` VALUES (4, 1);

SET FOREIGN_KEY_CHECKS = 1;
