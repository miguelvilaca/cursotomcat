# Acesso externo alterar 

/webapps/host-manager/WEB-INF/manager.xml

  <Context privileged="true" antiResourceLocking="false" 
     docBase="${catalina.home}/webapps/manager">
        <Valve className="org.apache.catalina.valves.RemoteAddrValve" allow="^.*$" />
  </Context>

  allow="\d+\.\d+\.\d+\.\d+" />
