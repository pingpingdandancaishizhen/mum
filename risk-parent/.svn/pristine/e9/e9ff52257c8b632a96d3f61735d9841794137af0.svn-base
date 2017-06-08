#!/bin/bash

set -e

APP_CONF_DIR=./conf

#JDBC_URL=test12244444444
#ZOOKEEPER_ADDR=127.0.0.1:2181

# replace the jdbc by ENV
if [  -f "$APP_CONF_DIR/jdbc.properties" ]; then
    CONFIG="$APP_CONF_DIR/jdbc.properties"

    if [ $JDBC_URL ]; then    
        sed -i "/^jdbc.url=/d" "$CONFIG" 
        echo -e "\njdbc.url=$JDBC_URL" >> "$CONFIG"
    fi

    if [ $JDBC_USERNAME ]; then
        sed -i "/^jdbc.username=/d" "$CONFIG" 
        echo -e "\njdbc.username=$JDBC_USERNAME" >> "$CONFIG"
    fi

    if [ $JDBC_PASSWORD ]; then
        sed -i "/^jdbc.password=/d" "$CONFIG" 
        echo -e "\njdbc.password=$JDBC_PASSWORD" >> "$CONFIG"
    fi

    if [ $JDBC_POOL_SIZE_MAX ]; then
        sed -i "/^jdbc.pool.size.max=/d" "$CONFIG" 
        echo -e "\njdbc.pool.size.max=$JDBC_POOL_SIZE_MAX" >> "$CONFIG"
    fi
 
    if [ $JDBC1_URL ]; then
        sed -i "/^jdbc1.url=/d" "$CONFIG"
        echo -e "\njdbc1.url=$JDBC1_URL" >> "$CONFIG"
    fi

    if [ $JDBC1_USERNAME ]; then
        sed -i "/^jdbc1.username=/d" "$CONFIG"
        echo -e "\njdbc1.username=$JDBC1_USERNAME" >> "$CONFIG"
    fi

    if [ $JDBC1_PASSWORD ]; then
        sed -i "/^jdbc1.password=/d" "$CONFIG"
        echo -e "\njdbc1.password=$JDBC1_PASSWORD" >> "$CONFIG"
    fi

    if [ $JDBC1_POOL_SIZE_MAX ]; then
        sed -i "/^jdbc1.pool.size.max=/d" "$CONFIG"
        echo -e "\njdbc1.pool.size.max=$JDBC1_POOL_SIZE_MAX" >> "$CONFIG"
    fi

fi

# replace the remote config by ENV
if [  -f "$APP_CONF_DIR/remote.properties" ]; then
    CONFIG="$APP_CONF_DIR/remote.properties"
    if [ $ZOOKEEPER_ADDR ]; then 
       sed -i "/^dubbo.transport.registry=/d" "$CONFIG"
       echo -e  "\ndubbo.transport.registry=$ZOOKEEPER_ADDR" >> "$CONFIG"
    fi

fi

exec "$@"
