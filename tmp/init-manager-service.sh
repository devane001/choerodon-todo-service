#!/bin/bash
# get manager-service
git clone https://github.com/choerodon/manager-service.git manager-service
mkdir -p manager/script
cp -r ./manager-service/src/main/resources/script/db ./manager/script
rm -rf ./manager-service

# get user-service
git clone https://github.com/choerodon/iam-service.git iam-service
mkdir -p iam/script
cp -r ./iam-service/src/main/resources/script/db ./iam/script
rm -rf ./iam-service

# init manager-service
java -Dspring.datasource.url="jdbc:mysql://localhost:3306/manager_service?useUnicode=true&characterEncoding=utf-8&useSSL=false" \
 -Dspring.datasource.username=choerodon \
 -Dspring.datasource.password=123456 \
 -Ddata.drop=false -Ddata.init=init \
 -Ddata.dir=./manager \
 -jar ../bin/choerodon-tool-liquibase.jar

# init iam-service
java -Dspring.datasource.url="jdbc:mysql://localhost:3306/iam_service?useUnicode=true&characterEncoding=utf-8&useSSL=false" \
 -Dspring.datasource.username=choerodon \
 -Dspring.datasource.password=123456 \
 -Ddata.drop=false -Ddata.init=init \
 -Ddata.dir=./iam \
 -jar ../bin/choerodon-tool-liquibase.jar