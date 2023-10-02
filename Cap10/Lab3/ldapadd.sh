#!/bin/sh
ldapadd -x -D "cn=Manager,dc=4linux,dc=priv" -W -c -f usuarios.ldif 
