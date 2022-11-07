package delhomvi;

public class AddArticle {
    public static void addArticle(){
        String[] articles = {"Pomme","Poire","Mandarinnes","Orange","Tomates","Kebab","lool"};
        double[] prix = {1.50,1.20,18.2,2.5,4.0,12,1};
        double[] qtes = {0.52,0.88,0.60,0.5,0.8,1,1};
        for(int i=0;i<articles.length;i++){
            Tickets.articlesArr.add(articles[i]);
            Tickets.prixArr.add(prix[i]);
            Tickets.qtesArr.add(qtes[i]);
        }
    }
}
