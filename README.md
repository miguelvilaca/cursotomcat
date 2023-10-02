# cursotomcat
# passo a passo cluster

sudo systemctl stop ufw;
sudo systemctl status ufw;

hostnamectl set-hostname curso.tomcat.in;
cat /etc/hosts;

apt update;
sudo apt-get install tomcat9 tomcat9-docs tomcat9-examples tomcat9-admin;

java -version;
 
sudo gedit /etc/tomcat9/tomcat-users.xml;

# Adicione
 <tomcat-users . . .>
   <user username="tomcat" password="tomcat" roles="manager-gui,admin-gui,manager-script"/>
 </tomcat-users>

sudo systemctl restart tomcat9;

sudo apt install apache2 libapache2-mod-jk;

sudo apache2ctl -M | grep jk;
#  JK_module (shared)

# editar
sudo gedit /etc/tomcat9/server.xml;

#procurar e colocar
<Connector protocol="AJP/1.3" port="8009" secretRequired="false" address="0.0.0.0" redirectPort="8443" /> 

# adicionar o jvmRoute
<Engine name="Catalina" defaultHost="localhost" jvmRoute="worker1">
sudo systemctl restart tomcat9;

sudo apt install net-tools;
sudo apt install openssh-server;

netstat -tulpn;
# deve apresentar as porta 8080,8009,22,80

sudo gedit /etc/apache2/workers.properties;
# Adicionar as linhas abaixo

worker.list=worker1
worker.worker1.type=ajp13
worker.worker1.host=localhost
worker.worker1.port=8009

sudo gedit /etc/apache2/apache2.conf;
#adicionar no final do arquivo

JkWorkersFile /etc/apache2/workers.properties
JkShmFile /var/log/apache2/mod_jk.shm
JkLogFile /var/log/apache2/mod_jk.log
JkLogLevel info
JkLogStampFormat "[ %a %b %d %H:%M:%S %Y ]"

sudo gedit /etc/apache2/sites-enabled/000-default.conf ;
#adicionar abaixo do DocumentRoot
JkMount /* worker1

sudo systemctl restart apache2;
sudo systemctl restart tomcat9

#teste a pagina: http://localhost/examples/


# Adicionando JK_status
sudo gedit /etc/apache2/workers.properties

# modificando e adicionando as linhas abaixo
worker.list=worker1,jk-status
#define jk-status worker type
worker.jk-status.type=status

sudo gedit /etc/apache2/sites-enabled/000-default.conf 
# modificando e adicionando as linhas abaixo
JkMount /* worker1
JkMount /jk-status jk-status

#teste a pagina: http://localhost/jk-status/
