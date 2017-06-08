FROM  centos:7
MAINTAINER "sunfit.cn"

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime

RUN yum -y install kde-l10n-Chinese && yum -y reinstall glibc-common #安装中文支持 
RUN localedef -c -f UTF-8 -i zh_CN zh_CN.utf8 #配置显示中文 
ENV LC_ALL zh_CN.utf8 #设置环境变量 

RUN yum update -y && \
yum install -y wget && \
yum install -y java-1.7.0-openjdk java-1.7.0-openjdk-devel && \
yum clean all 

RUN mkdir /home/deploy

WORKDIR /


ARG RISK_VER

RUN wget  http://build.rjs.com:8080/view/%E9%A3%8E%E6%8E%A7SAAS/job/RISK-DEV/${RISK_VER}/artifact/risk-server/risk-asset-server/target/risk-asset-server-1.0-SNAPSHOT.tar.gz
RUN  tar -xzf risk-asset-server-1.0-SNAPSHOT.tar.gz

RUN mkdir /home/deploy/risk_server && \
 cp  -r /risk-asset-server-1.0-SNAPSHOT /home/deploy/risk_server/risk_asset_server 

RUN cp  -r /home/deploy/risk_server/risk_asset_server/conf /home/deploy/risk_server/risk_asset_server/bin


WORKDIR /home/deploy/risk_server/risk_asset_server/bin


COPY entrypoint.sh ./

RUN chmod 744 ./*

ENTRYPOINT ["./entrypoint.sh"]



EXPOSE 10010 


CMD ["./Server_risk_buz.sh","start"]


