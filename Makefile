build:
	./gradlew build

run:
	./gradlew bootRun

test:
	./gradlew test

runDocker:
	./gradlew build
	docker build -t api .
	docker run -p 9009:9009 api