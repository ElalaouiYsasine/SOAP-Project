package WS;

import Metier.CreditCard;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


@WebService(serviceName = "CardValidaterWS")
public class CardValidater {


    @WebMethod
    public boolean validate(@WebParam(name = "card") CreditCard creditCard) {
        String nbr = creditCard.getNumber();
        System.out.println("Received CreditCard: " + creditCard.getNumber() + ", " + creditCard.getDateExperation() + ", " + creditCard.getType());

        int res = luhn(nbr);
        return res % 10 == 0;
    }

    @WebMethod
    public int luhn(@WebParam(name = "number") String nbr) {
        String StringNbr = String.valueOf(nbr);
        char[] tableauChiffres = new StringBuilder(StringNbr).reverse().toString().toCharArray();

        int sum = 0;

        for (int i = 0; i < tableauChiffres.length; i++) {
            int number = Character.getNumericValue(tableauChiffres[i]);
            if (i % 2 == 1) {
                number *= 2;

                if (number > 9) {
                    number -= 9;
                }
            }

            sum += number;
        }
        return sum;
    }


    public static void main(String[] args) {
        CardValidater cardValidator = new CardValidater();

        // Créez une instance de CreditCard avec des données réelles
        CreditCard creditCard = new CreditCard("5321962192041368","05/12/2024" , "Visa");

        // Afficher le résultat de l'algorithme de Luhn
        int l1 = cardValidator.luhn(creditCard.getNumber());
        System.out.println(l1);

        // Effectuer la validation du formulaire et afficher le résultat
        boolean res = cardValidator.validate(creditCard);
        System.out.println(res);
    }
}
