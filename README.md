## 简介
- FastCloud是采用Spring Cloud Alibaba、SpringSecurity Oauth2.0、Spring Cloud Gateway、SpringBoot、Nacos、Redis、Mybatis-Plus等框架，开发的一套微服务脚手架系统，使用门槛极低，且采用MIT开源协议，完全免费开源，可免费用于**商业项目**等场景。
- 前端：[https://gitee.com/makunet/fast-admin](https://gitee.com/makunet/fast-admin)
- 代码生成器：[https://gitee.com/makunet/fast-generator](https://gitee.com/makunet/fast-generator)

## 使命
致力于打造成一套高质量、低BUG、易于上手、可维护性强的低代码开发脚手架系统。

## 环境搭建
- 下载项目源码，一般通过git clone命令
- 下载安装nacos2.1.0，并启动
- idea、eclipse需安装lombok插件，不然会提示找不到get set方法
- 创建数据库fast_cloud，数据库编码为utf8mb4
- 执行db/mysql.sql文件，初始化数据库脚本
- 修改bootstrap.yml文件，配置MySQL、Redis账号信息
- 在fast-cloud目录下，执行mvn clean install

## 本地启动
- 在fast-cloud-gateway工程里面，运行GatewayApplication.java，则可启动网关
- 在fast-cloud-system工程里面，运行SystemApplication.java，则可启动权限服务
- 接口文档路径：http://localhost:8080/doc.html
- 再启动前端项目：https://gitee.com/makunet/fast-admin
- 账号密码：admin/admin

## 支持
如果觉得框架还不错，或者已经在使用了，希望你可以去 [Gitee](https://gitee.com/makunet/fast-cloud) 帮作者点个 ⭐ Star，这将是对作者极大的鼓励与支持。
