package hello;

import org.json.JSONObject;

public class Greeting {

    private final long id;
    private final JSONObject euro;
    private final JSONObject dollar;
    private final JSONObject pound;
    private final JSONObject franc;
    private final JSONObject belarusian_ruble;
    private final JSONObject yuan;
    private final JSONObject hryvnia;


    public Greeting(long id, JSONObject euro, JSONObject dollar, JSONObject pound, JSONObject franc, JSONObject belarusian_ruble, JSONObject yuan, JSONObject hryvnia) {
        this.id = id;
        this.euro = euro;
        this.dollar = dollar;
        this.pound = pound;
        this.franc = franc;
        this.belarusian_ruble = belarusian_ruble;
        this.yuan = yuan;
        this.hryvnia = hryvnia;
    }

    public long getId() {
        return id;
    }

    public JSONObject getEuro() {return euro;}

    public JSONObject getDollar() {return dollar;}

    public JSONObject getPound() {return pound;}

    public JSONObject getFranc() {return franc;}

    public JSONObject getBelarusian_ruble() {return belarusian_ruble;}

    public JSONObject getYuan() {return yuan;}

    public JSONObject getHryvnia() {return hryvnia;}
}
