# Criando o tomcat-user.xml completo

sudo gedit /etc/tomcat9/tomcat-users.xml;

<role rolename="tomcat"/>
<role rolename="admin-script"/>
<role rolename="manager-script"/>
<role rolename="manager-gui"/>
<role rolename="manager-jmx"/>
<role rolename="manager-status"/>
<role rolename="manager"/>
<role rolename="admin"/>

<user username="admin" password="admin" roles="administrador"/>
<user username="usuario" password="usuario" roles="usuario"/>

<user username="tomcat" password="tomcat" roles="admin,admin-gui,manager,manager-gui,manager-script"/>


sudo systemctl restart tomcat9;
