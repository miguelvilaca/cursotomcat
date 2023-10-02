#!/bin/sh
ldapsearch -x -D "uid=fulano,ou=People,dc=4linux,dc=priv" -W -b "dc=4linux,dc=priv"
#ldapsearch -x -D "cn=Manager,dc=4linux,dc=priv" -W -b "dc=4linux,dc=priv"
