FROM  centos:7
MAINTAINER "sunfit.cn"

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime

RUN yum -y install kde-l10n-Chinese && yum -y reinstall glibc-common #安装中文支持 
RUN localedef -c -f UTF-8 -i zh_CN zh_CN.utf8 #配置显示中文 
ENV LC_ALL zh_CN.utf8 #设置环境变量 

RUN yum update -y && \
yum install -y wget && \
yum install -y unzip && \
yum install -y java-1.7.0-openjdk java-1.7.0-openjdk-devel && \
yum clean all 

RUN mkdir /home/deploy

WORKDIR /

COPY entrypoint.sh ./
RUN chmod  777 /entrypoint.sh

RUN wget http://mirrors.cnnic.cn/apache/tomcat/tomcat-7/v7.0.77/bin/apache-tomcat-7.0.77.tar.gz  && \
    tar -xzf apache-tomcat-7.0.77.tar.gz && \
    cp -r apache-tomcat-7.0.77 /home/deploy/apache-tomcat && \
    rm -rf /home/deploy/apache-tomcat/webapps/ROOT/*
    



ARG RISK_VER 

RUN wget http://build.rjs.com:8080/view/%E9%A3%8E%E6%8E%A7SAAS/job/RISK/${RISK_VER}/artifact/risk-ui/risk-p2p-web/target/risk-p2p-web.war 

RUN unzip risk-p2p-web.war -d risk-p2p-web  

WORKDIR /risk-p2p-web/WEB-INF/classes


ENTRYPOINT ["/entrypoint.sh"]

RUN cp  -r /risk-p2p-web/* /home/deploy/apache-tomcat/webapps/ROOT/

WORKDIR /home/deploy/apache-tomcat/bin

EXPOSE 8080 

CMD ["./catalina.sh", "run"]
#CMD ["./startup.sh"]



