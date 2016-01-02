. ./conf.sh

curl -XPUT "http://localhost:9200/$index/"
echo
echo "$index created."
echo

curl -XPOST 'http://localhost:9200/_aliases' -d '
{
    "actions" : [
        { "add" : { "index" : "meroelasticsearch", "alias" : "g" } }
    ]
}'

echo "alias 'g' created"
echo