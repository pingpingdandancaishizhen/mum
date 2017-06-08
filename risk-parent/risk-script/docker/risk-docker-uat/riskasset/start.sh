#!/bin/bash
docker run --net=host  -d  -p10010:10010 -v/root/risk-docker-uat/riskasset/logs:/home/deploy/risk_server/risk_asset_server/logs risk-asset-server-uat:1.5
