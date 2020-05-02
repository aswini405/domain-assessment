export LD_LIBRARY_PATH=/svc/lib/

echo "lib path"
echo LD_LIBRARY_PATH

java -Djava.library.path=/svc/lib $JAVA_OPTS -jar /svc/jar/domain-assessment-0.0.1-SNAPSHOT.jar com.ps.coding.domainassessment.DomainAssessmentApplication