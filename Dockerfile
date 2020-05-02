FROM openjdk:8-jdk

ENV SVC_ROOT /svc

RUN mkdir -p $SVC_ROOT/jar/; mkdir -p $SVC_ROOT/lib/; mkdir -p $SVC_ROOT/resources/;

ADD target/domain-assessment-0.0.1-SNAPSHOT.jar $SVC_ROOT/jar/
ADD target/classes/* $SVC_ROOT/classes/
ADD entry_point.sh $SVC_ROOT/resources/entry_point.sh

RUN chmod 777 $SVC_ROOT/resources/entry_point.sh

ENV LD_LIBRARY_PATH $SVC_ROOT/lib

WORKDIR $SVC_ROOT/resources

ENTRYPOINT ("sh"."-c","/svc/resources/entry_point.sh")