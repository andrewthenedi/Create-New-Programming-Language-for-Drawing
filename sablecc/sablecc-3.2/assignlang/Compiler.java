package assignlang;
import assignlang.parser.*;
import assignlang.lexer.*;
import assignlang.node.*;
import java.io.*;

public class Compiler
{
public static void main(String[] args)
  {
    try {
    
    // Create a Parser instance.
    Parser p = new Parser(
      new Lexer (
      new PushbackReader(
      new BufferedReader(
      new FileReader(args[0])), 1024)));
                               
      // Parse the input.
      Start tree = p.parse();

      tree.apply(new SemanticAnalyzer());
      }
      catch(Exception e) { System.out.println(e.getMessage()); }
   }
}
