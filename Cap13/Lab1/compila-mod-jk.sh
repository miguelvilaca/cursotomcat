#!/bin/sh

tar xzf ~/Download/tomcat-connectors-*.tar.gz || exit 1
cd tomcat-connectors-*-src
cd native
./configure --with-apxs=/usr/sbin/apxs || exit 2
make || exit 3
su -c " \
	make install ;
	cd ../.. ;
	cp mod_jk.conf workers.properties /etc/httpd/conf.d 
	"
