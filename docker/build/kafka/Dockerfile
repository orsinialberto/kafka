FROM openjdk:8u111-jre

ADD https://archive.apache.org/dist/kafka/2.1.0/kafka_2.11-2.1.0.tgz /opt/
RUN tar xf /opt/kafka_2.11-2.1.0.tgz -C /opt
RUN rm /opt/kafka_2.11-2.1.0.tgz

WORKDIR /opt/kafka_2.11-2.1.0

ENV ZOOKEEPER_HOST=zookeeper
ENV ZOOKEEPER_PORT=2181

EXPOSE 9092
VOLUME /tmp/kafka-logs

CMD ./bin/kafka-server-start.sh \
    config/server.properties \
    --override zookeeper.connect=${ZOOKEEPER_HOST}:${ZOOKEEPER_PORT} \
    --override advertised.host.name=localhost \
    --override advertised.port=9092 \
    --override listeners=PLAINTEXT://0.0.0.0:9092