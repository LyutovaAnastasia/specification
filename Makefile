.DEFAULT_GOAL:=start

compile:
	mvnw clean package
start:compile
	docker-compose up -d

