package Parser;

import Parse_Tree.Node_Program;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {

    // Objects
    private Node_Program program_node;
    private String filename;
    private String program;

    // Constructor
    public Parser(String filename){
        this.filename = filename;
    }

    // Methods
    public void parse(){
        try{ program = new String(Files.readAllBytes(Paths.get(filename)));}
        catch (IOException e){ System.out.println(e.toString()); }
    }
    public void build_parse_tree(){
        program_node = new Node_Program(program);
    }
    public void print_parsed_program(){
        System.out.println("#######################");
        System.out.printf("The program \"%s\" parsed is:\n", filename);
        System.out.println(program);
        System.out.println("#######################");
        program_node.display_node();
        System.out.print("*#*#End of the Parse Tree#*#*");
    }
    public void print_parsed_program_to_file(String output_file){
        String output_string = "#######################\n" +
                "The program \""+ filename +"\" parsed is:\n" +
                program + "#######################\n" +
                // stringfy the tree here
                "*#*#End of the Parse Tree#*#*";
        try (PrintWriter out = new PrintWriter(output_file)) {
            out.println(output_string);
        } catch (IOException e){ System.out.println(e.toString()); }

    }
    public void print_errors(){}
}
