# Criptografar senhas tomcat-user.xml

sudo gedit /etc/tomcat9/tomcat-users.xml;

<Realm className="org.apache.catalina.realm.UserDatabaseRealm" resourceName="UserDatabase">
<CredentialHandler className="org.apache.catalina.realm.MessageDigestCredentialHandler" algorithm="MD5" saltLength="16" iterations="10000"/>
</Realm>

sudo systemctl restart tomcat9
