FROM java:8
WORKDIR /smczuul
#ENV 格式为  ENV <key> <value> 指定一个环境变量，会被后续  RUN  指令使用，并在容器运行时保持。
ENV PROJECT_ARTIFACTID="smczuul" PROJECT_VERSION="0.0.1-SNAPSHOT"
#COPY 格式为 COPY <src> <dest>
#复制本地主机的 <src>（为 Dockerfile 所在目录的相对路径）到容器中的 <dest>
#当使用本地目录为源目录时，推荐使用 COPY
COPY target/$PROJECT_ARTIFACTID-$PROJECT_VERSION.jar /smczuul/zuul.jar
EXPOSE 8888
# ENTRYPOINT ["java", "-jar", "/smczuul/zuul.jar"]
ENTRYPOINT ["java","-Xms400m","-Xmx500m","-jar","/smczuul/zuul.jar"]



FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8      //下载maven与java的镜像
 # 指定当前操作目录
WORKDIR /stockmarketzuul                                          
#指定对外端口号
 EXPOSE 8040          
#启动java程序
#--spring.profiles.active=dev 多环境下指定环境 。 -c为清除以前启动的数据
ENTRYPOINT ["java","-jar","ms_backend.jar","--spring.profiles.active=dev","-c"]