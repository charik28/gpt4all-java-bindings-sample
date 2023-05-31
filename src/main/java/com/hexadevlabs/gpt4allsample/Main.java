package com.hexadevlabs.gpt4allsample;

import com.hexadevlabs.gpt4all.GPTJModel;
import com.hexadevlabs.gpt4all.LLModel;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        // Optionally in case extra search path are necessary.
        LLModel.LIBRARY_SEARCH_PATH = "C:\\Users\\felix\\gpt4all\\lib\\";

        try ( GPTJModel gptjModel = new GPTJModel(Path.of("C:\\Users\\felix\\AppData\\Local\\nomic.ai\\GPT4All\\ggml-gpt4all-j-v1.3-groovy.bin")) ){

            LLModel.GenerationConfig config = LLModel.config()
                    .withNPredict(4096).build();

            gptjModel.chatCompletion(
                    List.of(Map.of("role", "user", "content", "Add 2+2"),
                            Map.of("role", "assistant", "content", "4"),
                            Map.of("role", "user", "content", "Multiply 4 * 5")), config, true, true);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
