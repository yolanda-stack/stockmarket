# 基于java镜像
FROM java:8

# 为RUN、CMD、ENTRYPOINT以及COPY和AND设置工作目录
WORKDIR /app

# 统一容器与服务器时间
ENV TZ=Asia/Shanghai
# RUN用于容器内部执行命令
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 将项目放到/usr/local/project下
COPY ./target/stockmarket-eureka.jar /app/stockmarket-eureka.jar

# 声明容器运行的服务端口
EXPOSE 8761

# 启动容器时执行的Shell命令
ENTRYPOINT ["java","-jar","/app/stock-eureka.jar"]