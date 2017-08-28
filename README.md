# spring4_springmvc_mybatis
环境：
win7
tomcat8
jdk8
spring4
##maven搭建的spring4+springmvc+mybatis框架

并进行简单测试
创建test数据库并导入sql文件夹下的sql语句建表

在浏览器输入http://localhost:8080/ssm/selectByPrimaryKey?id=1

可得到：User{id=1, username='zk', password='123'}

## redis 集群配置 

配置文件为： shardredis.properties、applicationContext-redis-cluster.xml

用到的工具类为 ： JedisClusterFactory.java、UtilJedis.java

在浏览器输入http://localhost:8080/ssm/redis/getRedis

可得到：zhangsan
