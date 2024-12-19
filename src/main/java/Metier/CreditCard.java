package Metier;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.time.LocalDate;

@XmlRootElement
public class CreditCard {
    private String number;
    //@XmlTransient
    private String dateExperation;
    private String type;

    public CreditCard(String number, String date, String type) {
        this.number = number;
        this.dateExperation = date;
        this.type = type;
    }

    public CreditCard() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getDateExperation() {
        return dateExperation;
    }

    public void setDateExperation(String dateExperation) {
        this.dateExperation = dateExperation;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
