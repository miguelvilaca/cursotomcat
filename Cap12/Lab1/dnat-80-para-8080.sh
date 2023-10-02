#!/bin/sh

iptables -F
iptables -F -t nat
iptables -t nat -I PREROUTING -p tcp --dport 80 -j REDIRECT --to-ports 8080

