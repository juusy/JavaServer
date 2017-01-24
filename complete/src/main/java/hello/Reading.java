package hello;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Пользователь on 22.01.2017.
 */
public class Reading {

    public static Greeting readFile(String filename) throws IOException {
        File file = new File(filename);
        StringBuilder stringJSON = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                stringJSON.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String json1 = stringJSON.toString().substring(1,stringJSON.length());


        JSONObject file_json = new JSONObject(stringJSON.toString());
        System.out.println(file_json);
       // System.out.println(file_json.getJSONArray("евро"));
        System.out.println(file_json.getJSONObject("евро"));
        if (file_json.has("id") && file_json.has("евро")) {
            Greeting money = new Greeting(file_json.getLong("id"),
                    file_json.getJSONObject("евро"),
                    file_json.getJSONObject("доллар"),
                    file_json.getJSONObject("фунт"),
                    file_json.getJSONObject("франк"),
                    file_json.getJSONObject("белорусский рубль"),
                    file_json.getJSONObject("юань"),
                    file_json.getJSONObject("гривен"));
            //System.out.println(file_json.getLong("id")+" "+file_json.getString("currency"));
            return money;
        } else {
            return null;
        }
    }
    public static List<String> getCurrency(){
         List<String> currency = new ArrayList<String>();
        currency.add("евро");
        currency.add("доллар");
        currency.add("франк");
        currency.add("гривен");
        currency.add("белорусский рубль");
        currency.add("юань");
        currency.add("фунт");
        return currency;
        }
    public static JSONObject JsonObj(String name){
        File file = new File(name);
        StringBuilder stringJSON = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                stringJSON.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        JSONObject file_json = new JSONObject(stringJSON.toString());
        return file_json;
    }
    public static void main(String[] args) throws IOException {
        Greeting t = readFile("cash1.json");
        System.out.println(t.getEuro()+" "+t.getFranc()+" "+t.getPound());
    }
}
