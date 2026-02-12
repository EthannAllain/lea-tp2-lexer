/*
 * SPDX-License-Identifier: MIT
 * Author: Matthieu Perrin
 * Session: Introduction to JFlex
 */

package lea;


/**
 * Représente une unité lexicale (token) extraite par le Lexer.
 */
public sealed interface Token {

	   /** @return le texte original (lexème) correspondant au token. */
	 	String text();
    
	public record KeyWord	(String text)	implements Token {}
	public record Operator	(String text)	implements Token {}
	public record Number	(String text)	implements Token {}
	public record Identifier(String text) implements Token {}
	public record CharLiteral(String text) implements Token {}
	public record StringLiteral(String text) implements Token {}
}