/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramit5;

/**
 *
 * @author Fikaew
 */
import java.util.Arrays;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Card {

    private String cardNumber;
    private String suit;
    private Image cardImage;
    private ImageView imageView;
    private int posY, posX;
    //private ImageView imageView;
    
    public Card()
    {
        setCardNumber("0") ;
        setSuit("G");
    }
    
    public Card(String cardNumber, String suit , ImageView imageView) {
        setCardNumber(cardNumber);
        setSuit(suit);
        String fileName = cardNumber + suit + ".png";
        cardImage = new Image("./CardPicture/" + fileName);
        setCardImage(cardImage);
        
        imageView = new ImageView();
        setImageView(imageView);
        setPosY(posY);
        setPosX(posX);
        //imageView = new ImageView();
    }

    public int getCardNumber() {
        if ("J".equals(cardNumber)) {
            return 11;
        } else if ("A".equals(cardNumber)) {
            return 1;
        } else if ("Q".equals(cardNumber)) {
            return 12;
        } else if ("K".equals(cardNumber)) {
            return 13;
        } else {
            return Integer.parseInt(cardNumber);
        }
    }

    public static List<String> getValidCardNumber() {
        return Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
    }

    public static List<String> getValidSuit() {
        return Arrays.asList("S", "H", "C", "D");
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Image getImage() {
        return cardImage;
    }

    public Image getCardImage() {
        return cardImage;
    }

    public void setCardImage(Image cardImage) {
        this.cardImage = cardImage;
    }

   public ImageView getImageView() {
       return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
}
