import java.util.HashMap;

public class Model {
    private Adapter adapter;
    private HashMap<String,Double> exchangeList = new HashMap<String,Double>();

    public Model() {
        exchangeList.put("USD", 1.0);
        exchangeList.put("EUR", 1.13);
        exchangeList.put("JPY", 0.0070);
        exchangeList.put("GBP", 1.33);
        exchangeList.put("DZD", 0.0076);
        exchangeList.put("blackMarker DZD", 0.0041);
    }
    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
    }
    public double exchange(String coverted_from,String converted_to, double amount) {
        return amount * exchangeList.get(coverted_from) / exchangeList.get(converted_to);
    }
    public String[] getCurrencies(){
        try {
            return exchangeList.keySet().toArray(String[]::new);
        } catch (Exception e) {
            System.out.println(e);
            return new String[0];
        }
    }

    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Adapter adapter = new Adapter(view, model);
        model.setAdapter(adapter);
    }
}
