java -jar sablecc-3.2/lib/sablecc.jar sablecc-3.2/grammar_draw.txt
cd sablecc-3.2
javac assignlang/Compiler.java
java assignlang.Compiler input_draw.txt
cd ..