package utils.commons;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class CommonsGenerator {
    private static Random random = new Random();

    private CommonsGenerator() {
        throw new IllegalStateException("CommonsGenerator class cannot be instantiated");
    }

    public static Iterator<String> generateFormInfo() {
        List<String> formDataInfo = new CopyOnWriteArrayList<>();
        formDataInfo.add("Teste Sicredi");
        formDataInfo.add("Teste");
        formDataInfo.add("Mateus Pasqualini");
        formDataInfo.add("(51) 9999-9999");
        formDataInfo.add("Av Assis Brasil, 3970");
        formDataInfo.add("Torre D");
        formDataInfo.add("Porto Alegre");
        formDataInfo.add("RS");
        formDataInfo.add("91000-000");
        formDataInfo.add("Brasil");
        return formDataInfo.iterator();
    }


}

