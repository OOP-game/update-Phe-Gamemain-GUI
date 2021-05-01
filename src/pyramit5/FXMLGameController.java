/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramit5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author peera
 */
public class FXMLGameController implements Initializable {

    private Text playername;

    private String name = "";
    private int score;

//    private boolean isSame;
//
//    private String deckPath[][] = {
//        {"AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD"},
//        {"AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC"},
//        {"AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH"},
//        {"AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS"},};
//
//    private int[][] usedCard = new int[4][13];     //Check card already creaated or not
//
//    private int cardValue[] = new int[52];          //Track each card Value(cardNum)
//
//    private int cardSuit[] = new int[52];           //Track each card Suit
//
//    private int cardPoint[] = new int[52];          //Track each card POINTS!!!
//
//    private int playDeck[] = new int[24];
//
//    private int playPosPoint[][] = new int[7][7];        //Check position of cards in play area can click or not 
//
//    private int playPosSuit[][] = new int[7][7];
    private int posX = 0;
    private int posY = 0;

    private int count = 0;

    int currentCardPlaySuit;
    int currentCardPlayCardNum;
    int currentCardPlayValue;

    @FXML
    private ImageView pos00;
    @FXML
    private ImageView pos10;
    @FXML
    private ImageView pos11;
    @FXML
    private ImageView pos20;
    @FXML
    private ImageView pos21;
    @FXML
    private ImageView pos22;
    @FXML
    private ImageView pos30;
    @FXML
    private ImageView pos31;
    @FXML
    private ImageView pos32;
    @FXML
    private ImageView pos33;
    @FXML
    private ImageView pos40;
    @FXML
    private ImageView pos41;
    @FXML
    private ImageView pos42;
    @FXML
    private ImageView pos43;
    @FXML
    private ImageView pos44;
    @FXML
    private ImageView pos50;
    @FXML
    private ImageView pos51;
    @FXML
    private ImageView pos52;
    @FXML
    private ImageView pos53;
    @FXML
    private ImageView pos54;
    @FXML
    private ImageView pos55;
    @FXML
    private ImageView pos60;
    @FXML
    private ImageView pos61;
    @FXML
    private ImageView pos62;
    @FXML
    private ImageView pos63;
    @FXML
    private ImageView pos64;
    @FXML
    private ImageView pos65;
    @FXML
    private ImageView pos66;
    @FXML
    private ImageView setCardImage;
    @FXML
    private ImageView flipedCardImage;
    @FXML
    private Button drawButton;

    private ArrayList<Card> deck = new ArrayList<>();

    private Card[][] playCardPos = new Card[7][7];

    private boolean isExist[][] = new boolean[7][7];

    private boolean clickable[][] = new boolean[7][7];

    List<String> suits = Card.getValidSuit();
    List<String> cardNumbers = Card.getValidCardNumber();

    private ArrayList<ImageView> imageViews = new ArrayList<>();

    private void addImageViewToArrayList() {
        imageViews.add(pos00);
        imageViews.add(pos10);
        imageViews.add(pos11);
        imageViews.add(pos20);
        imageViews.add(pos21);
        imageViews.add(pos22);
        imageViews.add(pos30);
        imageViews.add(pos31);
        imageViews.add(pos32);
        imageViews.add(pos33);
        imageViews.add(pos40);
        imageViews.add(pos41);
        imageViews.add(pos42);
        imageViews.add(pos43);
        imageViews.add(pos44);
        imageViews.add(pos50);
        imageViews.add(pos51);
        imageViews.add(pos52);
        imageViews.add(pos53);
        imageViews.add(pos54);
        imageViews.add(pos55);
        imageViews.add(pos60);
        imageViews.add(pos61);
        imageViews.add(pos62);
        imageViews.add(pos63);
        imageViews.add(pos64);
        imageViews.add(pos65);
        imageViews.add(pos66);
    }

    private int cardInDeckCounter;

    private Card[] valueOfSelectedCard = new Card[2];

    private int selectedCounter = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setupGame();
        gameSetUp();
        //imageViews.get(0).setImage(new Card("10","C").getCardImage());
    }

    @FXML
    private void drawCardButtonClicked(ActionEvent event) {
        drawDeckCard();
        //flipedCardImage.setImage(deck.drawCard().getCardImage());
    }

    private void gameSetUp() {

        setCardImage.setVisible(true);
        flipedCardImage.setDisable(true);
        for (String suit : suits) {
            for (String cardNumber : cardNumbers) {
                deck.add(new Card(cardNumber, suit));
                //deck.get(i).setImageView(imageViews.get(i));
            }
        }
        shuffle();
        addImageViewToArrayList();
        transferToPlayCardPos();
        cardInDeckCounter = deck.size();
        for (int a = 0; a < 7; a++) {
            for (int b = 0; b <= a; b++) {
                isExist[a][b] = true;
                clickable[a][b] = false;
            }
        }
        checkClickable();
    }

//    private void setupGame() {
//        setCardImage.setVisible(true);
//        Random rand = new Random();
//        int suit = 0;
//        int cardNum = 0;
//        for (int k = 0; k < 28; k++) {
//            do {
//                //Random card Suit & cardNum
//                suit = rand.nextInt(4);
//                cardNum = rand.nextInt(13);
//
//            } while (checkSameSetup(suit, cardNum) == 1); //Check same card to random again until not same
//
//            //Track Value and Suit of each cards
//            cardValue[k] = cardNum;
//            cardSuit[k] = suit;
//
//            //Add point to each cards1;
//            cardPoint[k] = cardNum + 1;
//        }
//
//        //place card in gameplay
//        // add fliped card 
//        for (int i = 0; i < 28; i++) {
//            switch (i) {
//                case 0 -> {
//                    createdCard(pos00, cardSuit[i], cardValue[i]);
//                    playPosPoint[0][0] = cardPoint[i];
//                    playPosSuit[0][0] = cardSuit[i];
//                    posY = 0;
//                    posX = 0;
//                }
//                case 1 -> {
//                    createdCard(pos10, cardSuit[i], cardValue[i]);
//                    playPosPoint[1][0] = cardPoint[i];
//                    playPosSuit[1][0] = cardSuit[i];
//                    posY = 1;
//                    posX = 0;
//                }
//                case 2 -> {
//                    createdCard(pos11, cardSuit[i], cardValue[i]);
//                    playPosPoint[1][1] = cardPoint[i];
//                    playPosSuit[1][1] = cardSuit[i];
//                    posY = 1;
//                    posX = 1;
//                }
//                case 3 -> {
//                    createdCard(pos20, cardSuit[i], cardValue[i]);
//                    playPosPoint[2][0] = cardPoint[i];
//                    playPosSuit[2][0] = cardSuit[i];
//                    posY = 2;
//                    posX = 0;
//                }
//                case 4 -> {
//                    createdCard(pos21, cardSuit[i], cardValue[i]);
//                    playPosPoint[2][1] = cardPoint[i];
//                    playPosSuit[2][1] = cardSuit[i];
//                    posY = 2;
//                    posX = 1;
//                }
//                case 5 -> {
//                    createdCard(pos22, cardSuit[i], cardValue[i]);
//                    playPosPoint[2][2] = cardPoint[i];
//                    playPosSuit[2][2] = cardSuit[i];
//                    posY = 2;
//                    posX = 2;
//                }
//                case 6 -> {
//                    createdCard(pos30, cardSuit[i], cardValue[i]);
//                    playPosPoint[3][0] = cardPoint[i];
//                    playPosSuit[3][0] = cardSuit[i];
//                    posY = 3;
//                    posX = 0;
//                }
//                case 7 -> {
//                    createdCard(pos31, cardSuit[i], cardValue[i]);
//                    playPosPoint[3][1] = cardPoint[i];
//                    playPosSuit[3][1] = cardSuit[i];
//                    posY = 3;
//                    posX = 1;
//                }
//                case 8 -> {
//                    createdCard(pos32, cardSuit[i], cardValue[i]);
//                    playPosPoint[3][2] = cardPoint[i];
//                    playPosSuit[3][2] = cardSuit[i];
//                    posY = 3;
//                    posX = 2;
//                }
//                case 9 -> {
//                    createdCard(pos33, cardSuit[i], cardValue[i]);
//                    playPosPoint[3][3] = cardPoint[i];
//                    playPosSuit[3][3] = cardSuit[i];
//                    posY = 3;
//                    posX = 3;
//                }
//                case 10 -> {
//                    createdCard(pos40, cardSuit[i], cardValue[i]);
//                    playPosPoint[4][0] = cardPoint[i];
//                    playPosSuit[4][0] = cardSuit[i];
//                    posY = 4;
//                    posX = 0;
//                }
//                case 11 -> {
//                    createdCard(pos41, cardSuit[i], cardValue[i]);
//                    playPosPoint[4][1] = cardPoint[i];
//                    playPosSuit[4][1] = cardSuit[i];
//                    posY = 4;
//                    posX = 1;
//                }
//                case 12 -> {
//                    createdCard(pos42, cardSuit[i], cardValue[i]);
//                    playPosPoint[4][2] = cardPoint[i];
//                    playPosSuit[4][2] = cardSuit[i];
//                    posY = 4;
//                    posX = 2;
//                }
//                case 13 -> {
//                    createdCard(pos43, cardSuit[i], cardValue[i]);
//                    playPosPoint[4][3] = cardPoint[i];
//                    playPosSuit[4][3] = cardSuit[i];
//                    posY = 4;
//                    posX = 3;
//                }
//                case 14 -> {
//                    createdCard(pos44, cardSuit[i], cardValue[i]);
//                    playPosPoint[4][4] = cardPoint[i];
//                    playPosSuit[4][4] = cardSuit[i];
//                    posY = 4;
//                    posX = 4;
//                }
//                case 15 -> {
//                    createdCard(pos50, cardSuit[i], cardValue[i]);
//                    playPosPoint[5][0] = cardPoint[i];
//                    playPosSuit[5][0] = cardSuit[i];
//                    posY = 5;
//                    posX = 0;
//                }
//                case 16 -> {
//                    createdCard(pos51, cardSuit[i], cardValue[i]);
//                    playPosPoint[5][1] = cardPoint[i];
//                    playPosSuit[5][1] = cardSuit[i];
//                    posY = 5;
//                    posX = 1;
//                }
//                case 17 -> {
//                    createdCard(pos52, cardSuit[i], cardValue[i]);
//                    playPosPoint[5][2] = cardPoint[i];
//                    playPosSuit[5][2] = cardSuit[i];
//                    posY = 5;
//                    posX = 2;
//                }
//                case 18 -> {
//                    createdCard(pos53, cardSuit[i], cardValue[i]);
//                    playPosPoint[5][3] = cardPoint[i];
//                    playPosSuit[5][3] = cardSuit[i];
//                    posY = 5;
//                    posX = 3;
//                }
//                case 19 -> {
//                    createdCard(pos54, cardSuit[i], cardValue[i]);
//                    playPosPoint[5][4] = cardPoint[i];
//                    playPosSuit[5][4] = cardSuit[i];
//                    posY = 5;
//                    posX = 4;
//                }
//                case 20 -> {
//                    createdCard(pos55, cardSuit[i], cardValue[i]);
//                    playPosPoint[5][5] = cardPoint[i];
//                    playPosSuit[5][5] = cardSuit[i];
//                    posY = 5;
//                    posX = 5;
//                }
//                case 21 -> {
//                    createdCard(pos60, cardSuit[i], cardValue[i]);
//                    playPosPoint[6][0] = cardPoint[i];
//                    playPosSuit[6][0] = cardSuit[i];
//                    posY = 6;
//                    posX = 0;
//                }
//                case 22 -> {
//                    createdCard(pos61, cardSuit[i], cardValue[i]);
//                    playPosPoint[6][1] = cardPoint[i];
//                    playPosSuit[6][1] = cardSuit[i];
//                    posY = 6;
//                    posX = 1;
//                }
//                case 23 -> {
//                    createdCard(pos62, cardSuit[i], cardValue[i]);
//                    playPosPoint[6][2] = cardPoint[i];
//                    playPosSuit[6][2] = cardSuit[i];
//                    posY = 6;
//                    posX = 2;
//                }
//                case 24 -> {
//                    createdCard(pos63, cardSuit[i], cardValue[i]);
//                    playPosPoint[6][3] = cardPoint[i];
//                    playPosSuit[6][3] = cardSuit[i];
//                    posY = 6;
//                    posX = 3;
//                }
//                case 25 -> {
//                    createdCard(pos64, cardSuit[i], cardValue[i]);
//                    playPosPoint[6][4] = cardPoint[i];
//                    playPosSuit[6][4] = cardSuit[i];
//                    posY = 6;
//                    posX = 4;
//                }
//                case 26 -> {
//                    createdCard(pos65, cardSuit[i], cardValue[i]);
//                    playPosPoint[6][5] = cardPoint[i];
//                    playPosSuit[6][5] = cardSuit[i];
//                    posY = 6;
//                    posX = 5;
//                }
//                case 27 -> {
//                    createdCard(pos66, cardSuit[i], cardValue[i]);
//                    playPosPoint[6][6] = cardPoint[i];
//                    playPosSuit[6][6] = cardSuit[i];
//                    posY = 6;
//                    posX = 6;
//                }
//                // fliped card 
//
//                default ->
//                    System.out.println("ERROR !! NO CASE in set up");
//            }
//        }
//        for (int a = 0; a < 7; a++) {
//            for (int b = 0; b <= a; b++) {
//                isExist[a][b] = true;
//                clickable[a][b] = true;
//            }
//        }
//        checkClickable();
//
//    }
//    private int checkSameSetup(int suit, int cardNum) {
//        if (usedCard[suit][cardNum] == 0) {
//            usedCard[suit][cardNum] = 1;
//            return 0;
//        }
//        return 1;
//
//    }
//    private int checkSameDraw(int suit, int cardNum) {
//        if (usedCard[suit][cardNum] == 0) {
//            usedCard[suit][cardNum] = 1;
//            return 0;
//        }
//        return 1;
//
//    }
//    private void createdCard(ImageView imageView, int suit, int cardNum) {
//        Image image = new Image("./CardPicture/" + deckPath[suit][cardNum] + ".png");
//        imageView.setImage(image);
//    }
//    private void drawCard() {
//        //Set count > 23 to 0
//        if (count > 23) {
//            count = 0;
//            setCardImage.setVisible(true);
//            for (int i = 0; i < 4; i++) {
//                for (int j = 0; j < 13; j++) {
//                    if (usedCard[i][j] == 1) {
//                        usedCard[i][j] = 0;
//                    }
//                }
//            }
//        }
//
//        System.out.println(count);
//        System.out.println();
//        Random rand = new Random();
//        int suit = 0;
//        int cardNum = 0;
//
//        do {
//            //Random card Suit & cardNum
//            suit = rand.nextInt(4);
//            cardNum = rand.nextInt(13);
//
//        } while (checkSameDraw(suit, cardNum) == 1); //Check same card to random again until not same
//
//        createdCard(flipedCardImage, suit, cardNum);
//        //Track Value and Suit of each cards
//        cardValue[count + 28] = cardNum;
//        cardSuit[count + 28] = suit;
//
//        //Add point to each cards
//        cardPoint[count + 28] = cardNum + 1;
//
//        int currentCardPlaySuit = suit;
//        int currentCardPlayCardNum = cardNum;
//        int currentCardPlayValue = cardNum + 1;
//
//        if (count == 23) {
//            setCardImage.setVisible(false);
//
//        }
//        count++;
//    }
    private void checkClickable() {

        for (int temp1 = 0; temp1 < 7; temp1++) {
            if (temp1 == 6) {
                for (int temp2 = 0; temp2 <= temp1; temp2++) {
                    clickable[temp1][temp2] = true;
                }
            } else if (temp1 < 6) {
                for (int temp3 = 0; temp3 <= temp1; temp3++) {
                    if (isExist[temp1 + 1][temp3] == false && isExist[temp1 + 1][temp3 + 1] == false) {
                        clickable[temp1][temp3] = true;
                    }
                }
            }
        }
    }

    private int result = 0;

    @FXML
    private Card chooseCard(MouseEvent event) {

        if (event.getSource() == pos00 && clickable[0][0]) {
            return (playCardPos[0][0]);
        } else if (event.getSource() == pos10 && clickable[1][0]) {
            return (playCardPos[1][0]);
        } else if (event.getSource() == pos11 && clickable[1][1]) {
            return (playCardPos[1][1]);
        } else if (event.getSource() == pos20 && clickable[2][0]) {
            return (playCardPos[2][0]);
        } else if (event.getSource() == pos21 && clickable[2][1]) {
            return (playCardPos[2][1]);
        } else if (event.getSource() == pos22 && clickable[2][2]) {
            return (playCardPos[2][2]);
        } else if (event.getSource() == pos30 && clickable[3][0]) {
            return (playCardPos[3][0]);
        } else if (event.getSource() == pos31 && clickable[3][1]) {
            return (playCardPos[3][1]);
        } else if (event.getSource() == pos32 && clickable[3][2]) {
            return (playCardPos[3][2]);
        } else if (event.getSource() == pos33 && clickable[3][3]) {
            return (playCardPos[3][3]);
        } else if (event.getSource() == pos40 && clickable[4][0]) {
            return (playCardPos[4][0]);
        } else if (event.getSource() == pos41 && clickable[4][1]) {
            return (playCardPos[4][1]);
        } else if (event.getSource() == pos42 && clickable[4][2]) {
            return (playCardPos[4][2]);
        } else if (event.getSource() == pos43 && clickable[4][3]) {
            return (playCardPos[4][3]);
        } else if (event.getSource() == pos44 && clickable[4][4]) {
            return (playCardPos[4][4]);
        } else if (event.getSource() == pos50 && clickable[5][0]) {
            return (playCardPos[5][0]);
        } else if (event.getSource() == pos51 && clickable[5][1]) {
            return (playCardPos[5][1]);
        } else if (event.getSource() == pos52 && clickable[5][2]) {
            return (playCardPos[5][2]);
        } else if (event.getSource() == pos53 && clickable[5][3]) {
            return (playCardPos[5][3]);
        } else if (event.getSource() == pos54 && clickable[5][4]) {
            return (playCardPos[5][4]);
        } else if (event.getSource() == pos55 && clickable[5][5]) {
            return (playCardPos[5][5]);
        } else if (event.getSource() == pos60 && clickable[6][0]) {
            return (playCardPos[6][0]);
        } else if (event.getSource() == pos61 && clickable[6][1]) {
            return (playCardPos[6][1]);
        } else if (event.getSource() == pos62 && clickable[6][2]) {
            return (playCardPos[6][2]);
        } else if (event.getSource() == pos63 && clickable[6][3]) {
            return (playCardPos[6][3]);
        } else if (event.getSource() == pos64 && clickable[6][4]) {
            return (playCardPos[6][4]);
        } else if (event.getSource() == pos65 && clickable[6][5]) {
            valueOfSelectedCard[selectedCounter] = playCardPos[6][5];
            System.out.println(selectedCounter + " Card =" + valueOfSelectedCard[selectedCounter].getCardNumber());
            System.out.println("result " + result);
            if (selectedCounter > 1) {
                selectedCounter = 0;
            } else if (selectedCounter == 1) {
                result += valueOfSelectedCard[selectedCounter].getCardNumber();
                if (result == 13) {

                } else {
                    selectedCounter = 0;
                }
            }
            selectedCounter++;
            return (playCardPos[6][5]);
        } else if (event.getSource() == pos66 && clickable[6][6]) {
            valueOfSelectedCard[selectedCounter] = playCardPos[6][6];
            System.out.println(selectedCounter + " Card =" + valueOfSelectedCard[selectedCounter].getCardNumber());
            System.out.println("result " + result);
            if (selectedCounter > 1) {
                selectedCounter = 0;
            } else if (selectedCounter == 1) {
                result += valueOfSelectedCard[selectedCounter].getCardNumber();
                if (result == 13) {
                    
                } else {
                    selectedCounter = 0;
                }
            }
            selectedCounter++;
            return (playCardPos[6][6]);
        } else if (event.getSource() == flipedCardImage) {
            return deck.get(0);
        } else {
            return null;
        }
    }

    private void calculate(ImageView imageview1, ImageView imageview2) {

    }

    private void shuffle() {
        Collections.shuffle(deck);
    }

    private void transferToPlayCardPos() {
        int transferCounter = 0;
        Card[] tempCard = new Card[52];
        for (int a = 0; a < 52; a++) {
            tempCard[a] = deck.get(a);
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                playCardPos[i][j] = tempCard[transferCounter];
                imageViews.get(transferCounter).setImage((playCardPos[i][j].getCardImage()));
                deck.remove(0);
                transferCounter++;
            }
        }
    }

    private void drawDeckCard() {
        flipedCardImage.setDisable(false);
        if (deck.size() > 0) {
            Card tempCard = deck.get(0);
            deck.remove(0);
            flipedCardImage.setImage(deck.get(0).getCardImage());
            deck.add(tempCard);
        }
        playCardPos[0][6] = deck.get(0);
    }

    private void selectCardInPair(MouseEvent event) {

    }
}
