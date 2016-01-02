#!/bin/bash
. ./conf.sh


curl -XPOST "http://localhost:9200/_bulk" --data-binary @customers.json; echo

echo
echo "$typeCustomer document indexed"
echo