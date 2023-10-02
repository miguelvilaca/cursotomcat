#!/bin/sh

if [ "$1" = "" ]; then
    echo "Informe o nome do 'novo' tomcat"
    exit 1
fi

tomcat=tomcat_$1

rm -rf /etc/$tomcat
rm -rf /var/lib/$tomcat
rm -rf /var/log/$tomcat
rm -rf /var/cache/$tomcat
rm -rf /usr/share/$tomcat

