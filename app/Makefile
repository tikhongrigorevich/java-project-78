.PHONY: build

build:
	./gradlew clean build

build-dist:
	./gradlew clean installDist

clean:
	./gradlew clean

lint:
	./gradlew spotlessCheck

lint-fix:
	./gradlew spotlessApply

run-dist: build-dist
	./build/install/app/bin/app

test:
	./gradlew test
