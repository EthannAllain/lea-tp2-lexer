/*
 * SPDX-License-Identifier: MIT
 * Author: Matthieu Perrin
 * Session: Introduction to JFlex
 */

package lea;

import java.io.*;

public class Main {

	public static final String RESET = "\u001B[0m";
	public static final String BOLD  = "\u001B[1m";
	public static final String DIM   = "\u001B[2m";

	public static final String FG_RED     = "\u001B[31m";
	public static final String FG_GREEN   = "\u001B[32m";
	public static final String FG_YELLOW  = "\u001B[33m";
	public static final String FG_BLUE    = "\u001B[34m";
	public static final String FG_MAGENTA = "\u001B[35m";
	public static final String FG_CYAN    = "\u001B[36m";
	public static final String FG_WHITE   = "\u001B[37m";
	public static final String FG_GRAY    = "\u001B[90m";

	public static final String defaultInput = """
			si vrai alors
				var_x <- -35; // un nombre
			sinon
				var_y <- "la chaine \"35\"";  // une chaîne de caractères
			fin si
			""";

	public static void main(String[] args) throws Exception {
		readString(defaultInput);
	}

	static void readString(String input) throws Exception {

		Reader reader = new StringReader(input);    // Texte à analyser
		Reporter reporter = new Reporter();         // Gestion des erreurs
		Lexer lexer = new Lexer(reader, reporter);  // Analyseur

		for(Token token = lexer.yylex(); token != null; token = lexer.yylex()) {

			String output = switch (token) {
			case Token.KeyWord t       -> BOLD + FG_BLUE + token.text() + RESET;
			case Token.Number t        -> FG_CYAN + token.text() + RESET;
			case Token.CharLiteral t   -> FG_MAGENTA + token.text() + RESET;
			default                    -> token.text();
			};
			//output=token.toString(); // décommenter si votre terminal ne supporte pas l'affichage des couleurs

			System.out.print(output);
		}
		
		reporter.reportErrors();
	}

}
