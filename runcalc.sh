# # Compile Java files
mkdir -p bin
javac -d bin src/main/java/Calculator/*.java
java -cp bin Calculator.Driver