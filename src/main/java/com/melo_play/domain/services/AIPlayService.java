package com.melo_play.domain.services;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AIPlayService  {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de gestion de 
            peliculas MeloPlay, Usa menos de 120 caracteres""")
    String generateGreeting();
}
