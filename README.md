# 度吧

仿百度贴吧，借鉴了ruoyi项目架构。

## 项目结构

```
com.duba     
├── duba-ui              // 前端框架 [80]
├── duba-gateway         // 网关模块 [8080]
├── duba-auth            // 认证中心 [9200]
├── duba-api             // 接口模块
│       └── duba-api-system                          // 系统接口
├── duba-common          // 通用模块
│       └── duba-common-core                         // 核心模块
│       └── duba-common-datascope                    // 权限范围
│       └── duba-common-datasource                   // 多数据源
│       └── duba-common-log                          // 日志记录
│       └── duba-common-redis                        // 缓存服务
│       └── duba-common-security                     // 安全模块
│       └── duba-common-swagger                      // 系统接口
├── duba-modules         // 业务模块
│       └── duba-system                              // 系统模块 [9201]
│       └── duba-gen                                 // 代码生成 [9202]
│       └── duba-job                                 // 定时任务 [9203]
│       └── duba-file                                // 文件服务 [9300]
├── duba-visual          // 图形化管理模块
│       └── duba-visual-monitor                      // 监控中心 [9100]
├──pom.xml                // 公共依赖
```