package com.melo_play.domain.services;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AIPlayService  {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de gestion de 
            peliculas MeloPlay, Usa menos de 120 caracteres""")
    String generateGreeting();

    @SystemMessage("""
            Eres un experto en cine que recomienda peliculas personalizadas segun los 
            gustos del usuario. Debes recomendar maximo 3 peliculas. 
            No incluyas peliculas que no existan en la plataforma MeloPlay.
            """)
    public String generateMoviesSuggestions(@UserMessage String userMessage);
}
