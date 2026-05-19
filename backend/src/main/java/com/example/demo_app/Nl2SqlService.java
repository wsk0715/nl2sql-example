package com.example.demo_app;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_app.dto.QueryResult;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class Nl2SqlService {

    private final DatabaseSchemaService databaseSchemaService;

    public QueryResult ask(String question) {
        String answer;

        // Step 0: Get dynamic schema
        String schema = databaseSchemaService.getSchemaDescription();
        log.info("\nStep 0 (Schema):\n{}", schema);

        // Remove potential backticks if LLM includes them
        sql = sql.replace("```sql", "").replace("```", "").trim();
        
        System.out.println("Generated SQL: " + sql);
        
        return new QueryResult(sql, data, answer);
    }
}
