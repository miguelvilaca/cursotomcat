# passo a passo cluster

# baixar novo tomcat.
sudo wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.80/bin/apache-tomcat-9.0.80.zip

# alterar o server.xml

# linha 69
<Connector port="8180" protocol="HTTP/1.1"  connectionTimeout="20000"
               redirectPort="8443"  maxParameterCount="1000"/>

# adicionar na linha 130
 <Connector protocol="AJP/1.3" port="8109" secretRequired="false" address="0.0.0.0" redirectPort="8143" /> 

# adicionar na linha 142
<Engine name="Catalina" defaultHost="localhost" jvmRoute="worker2">

sudo chmod 777 /apache-tomcat-9.0.80 -R
sudo -su tomcat 
cd apache-tomcat-9.0.80/bin   
sh catalina.sh start

sudo gedit /etc/apache2/workers.properties
# Adicionar/modificar as linhas abaixo

# conf geral do cluster
worker.list=cluster,jk-status
worker.cluster.type=lb
worker.cluster.balance_workers=worker1,worker2
worker.cluster.sticky_session=true

worker.jk-status.type=status

# portas worker1 - 8005, 8080 e 8009
worker.worker1.type=ajp13
worker.worker1.host=localhost
worker.worker1.port=8009
worker.worker1.lbfactor=1

# portas worker2 - 8105(SHUTDOWN), 8180(HTTP) e 8109(AJP)
#worker.worker2.type=ajp13
#worker.worker2.host=localhost
#worker.worker2.port=8109
#worker.worker2.lbfactor=1


sudo gedit /etc/apache2/sites-enabled/000-default.conf 
# modificando e adicionando as linhas abaixo
JkMount /jk jk-status
JkMount /* cluster

sudo systemctl restart apache2;
# restart tomcat instalado pelo APT
sudo systemctl restart tomcat9;
# start tomcat instalado na mão
cd apache-tomcat-9.0.80/bin   
sh catalina.sh start

#teste a pagina: http://localhost/jk

