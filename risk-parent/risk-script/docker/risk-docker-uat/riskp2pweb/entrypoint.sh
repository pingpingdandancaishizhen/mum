#!/bin/bash

set -e

APP_CONF_DIR=/home/deploy/apache-tomcat/webapps/ROOT/WEB-INF/classes


# replace the remote config by ENV
if [  -f "$APP_CONF_DIR/application.properties" ]; then
    CONFIG="$APP_CONF_DIR/application.properties"
    if [ $ZOOKEEPER_ADDR ]; then 
       sed -i "/^dubbo.transport.registry=/d" "$CONFIG"
       echo -e  "\ndubbo.transport.registry=$ZOOKEEPER_ADDR" >> "$CONFIG"
    fi

fi

exec "$@"
