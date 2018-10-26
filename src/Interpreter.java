import Parser.Parser;

public class Interpreter {
    public static void main(String[] args) {

        // Objects
        String filename;
        String extension;
        String input_path, output_path;
        Parser parser_instance;

        // Object initialization
        filename = "program2";
        extension = ".txt";
        input_path = "src/Input/";
        output_path = "src/Output/";
        parser_instance = new Parser(input_path+filename+extension);

        parser_instance.parse();
        parser_instance.build_parse_tree();
        parser_instance.print_parsed_program();
        parser_instance.print_parsed_program_to_file(output_path+filename+extension);
    }
}
