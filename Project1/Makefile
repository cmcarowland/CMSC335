all: clean tests

main:
	javac src/main/*.java -d bin/

tests: main
	javac -cp "../test-lib/*:bin/" src/tests/*.java -d bin/

clean:
	rm -rf bin/*

executeTests:
	java -cp "bin/:../test-lib/*" org.junit.runner.JUnitCore tests.CLITests
	java -cp "bin/:../test-lib/*" org.junit.runner.JUnitCore tests.Project1Tests
