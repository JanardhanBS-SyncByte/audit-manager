cd target
./graalvm-springboot-example -verbose --debug -Dspring.profiles.active=default -Dspring.cloud.config.uri=http://localhost:51000/config -Dspring.cloud.config.label=master -Dspring.cloud.config.enabled=true -Dspring.cloud.config.name=kernel  -Xmx512m -Xms256m --gc=serial
cd ..
