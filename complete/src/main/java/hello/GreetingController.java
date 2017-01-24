package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("money", new Money());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Money money) {
        List<String> words = Reading.getCurrency();
        money.setId(money.getId().toLowerCase());
        if (money.getId().startsWith("курс")){
            money.setId(money.getId().substring(5,money.getId().length()));
        }

        String year = "";
        if (money.getId().contains("этом") || money.getId().contains("этот")) {
            year = "этот год";
            money.removeSubstring("этот");
            money.removeSubstring("этом");
        }
        else if (money.getId().contains("позапрошлом") || money.getId().contains("позапрошлый")) {
            year = "позапрошлый год";
            money.removeSubstring("позапрошлом");
            money.removeSubstring("позапрошлый");
        }
        else if (money.getId().contains("прошлом") || money.getId().contains("прошлый")) {
            year = "прошлый год";
            money.removeSubstring("прошлом");
            money.removeSubstring("прошлый");
        }
        else year = "этот год";

        money.removeSubstring("в");
        money.removeSubstring("году");
        money.removeSubstring("год");


        System.out.println(money.getId());
        String query = WithoutNGrammy.editdist(money.getId(),words).get(0);
        //System.out.println(query);

        if (WithoutNGrammy.distance(query, money.getId())<5 && !query.equals("евро"))
            money.setId(query);
        else {
            if (query.equals("евро"))
                if (WithoutNGrammy.distance(query, money.getId()) < 3)
                    money.setId(query);
        }
        if (Reading.getCurrency().contains(money.getId())) {
            String value = Reading.JsonObj("cash1.json").getJSONObject(money.getId()).getString(year);
            System.out.println(money.getId());
            System.out.println(value);
            money.setContent(value);
        }
        else money.setId("такой валюты нет в списке");

        return "result";
    }

}
