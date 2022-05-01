# QueryDsl

### Backend
OpenJDK 11, SpringBoot 2.5.7, JPA, ElasticSearch 7.1

### ElasticSearch Run && AWS OpenSearch Test Sample
```
$ docker pull docker.elastic.co/elasticsearch/elasticsearch:7.10.0
$ docker run -d -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.10.0
```
