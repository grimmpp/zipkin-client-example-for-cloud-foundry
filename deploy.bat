
cf push zipkin-test -p .\build\libs\zipkin-demo-0.0.1-SNAPSHOT.jar -m 1G
cf set-env zipkin-test baseUrl "https://zipkin-test.dev.cfdev.sh"
cf rs zipkin-test1

cf logs zipkin-test