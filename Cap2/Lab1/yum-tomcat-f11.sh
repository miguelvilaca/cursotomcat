#!/bin/sh

yum --disablerepo=updates  -y install \
	tomcat6 \
	tomcat6-admin-webapps \
	tomcat6-docs-webapp \
	tomcat6-javadoc \
	tomcat6-webapps

