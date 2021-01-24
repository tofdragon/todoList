# 环境

需要安装JDK8

# 构建

进入项目根目录

cmd中输入

mvn clean package

mvn dependency:copy-dependencies -DoutputDirectory=target/lib 

# 运行

进入项目根目录

cmd中输入

java -jar target/todolist-1.0.jar

