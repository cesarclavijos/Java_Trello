package helper;

public class ApiVariable {

    public static final String theUrl = "https://api.trello.com/1/";
    public static final String key="78241a7c70690f009461c909e994dd6f";
    public static final String Token ="ee4b11b5e51e98b5473b193ab2184d38445d008b327b2f9626a79745b49dbc69";
    public static String BoardId;
    public static String CardId;

    //variables de sesion para que no queden estaticas

    public void SetBoardId(String BoardId){
        BoardId = BoardId;}

    public void SetCardId(String CardId){
        CardId = CardId;}

    public void SetListId(int list_id){list_id = list_id;}
    public void SetMovie(int movie){movie = movie;}


    public static String GetUrl() { return theUrl; }
    public static String GetKey() { return key; }

    public static String GetToken() { return Token; }
    public static String GetBoardId() { return BoardId; }
    public static String GetCardId() { return CardId; }


}
