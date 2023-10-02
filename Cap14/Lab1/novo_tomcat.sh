#!/bin/sh

if [ "$1" = "" ]; then
    echo "Informe o nome do 'novo' tomcat"
    exit 1
fi

tomcat=tomcat_$1

mkdir /etc/$tomcat
mkdir /var/log/$tomcat
chgrp tomcat /var/log/$tomcat
chmod g+w /var/log/$tomcat
mkdir /var/lib/$tomcat
mkdir /var/lib/$tomcat/webapps
chgrp tomcat /var/lib/$tomcat/webapps
chmod g+w /var/lib/$tomcat/webapps
mkdir /var/cache/$tomcat
mkdir /var/cache/$tomcat/temp
chgrp tomcat /var/cache/$tomcat/temp
chmod g+w /var/cache/$tomcat/temp
mkdir /var/cache/$tomcat/work
chgrp tomcat /var/cache/$tomcat/work
chmod g+w /var/cache/$tomcat/work

cd /usr/share
mkdir $tomcat
cd $tomcat
ln -s /etc/$tomcat conf
cp -rp /etc/tomcat6/* conf
ln -s /var/log/$tomcat logs
ln -s /var/lib/$tomcat/webapps webapps
cp -rp /var/lib/tomcat6/webapps/* webapps
ln -s /var/cache/$tomcat/temp temp
ln -s /var/cache/$tomcat/work work
ln -s ../tomcat6/bin bin
ln -s ../tomcat6/lib lib

sed -i -e "1,\$ s/tomcat6/$tomcat/g" conf/tomcat6.conf

echo "#!/bin/bash
#
# $tomcat      starts and stops Tomcat instance $tomcat
#
# chkconfig: - 80 20
#

## Source function library.
#. /etc/rc.d/init.d/functions
# Source LSB function library.
if [ -r /lib/lsb/init-functions ]; then
    . /lib/lsb/init-functions
else
    exit 1
fi

# For SELinux we need to use 'runuser' not 'su'
if [ -x "/sbin/runuser" ]; then
    SU="/sbin/runuser"
else
    SU="/bin/su"
fi

\$SU - tomcat -c \"TOMCAT_CFG=/etc/$tomcat/tomcat6.conf /usr/sbin/tomcat6 \$1 \"
RETVAL=$?
echo -n \"\$1 $tomcat: \"
if [ \"\$RETVAL\" = \"0\" ]; then
    log_success_msg
else
    log_failure_msg
fi
exit $RETVAL
" > /etc/init.d/$tomcat
chmod a+x /etc/init.d/$tomcat

